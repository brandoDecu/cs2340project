package com.theLads.spacetrader.views.TravelingAndMarketplace;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.viewmodels.TravelViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * displays a list of galaxies to travel to
 */
public class GalaxyActivity extends AppCompatActivity {

// --Commented out by Inspection START (4/5/2019 4:28 PM):
//    /** a key for passing data */
//    public static final String SOLAR_SYSTEM_DATA = "SOLAR_SYSTEM_DATA";
// --Commented out by Inspection STOP (4/5/2019 4:28 PM)
    /** an int for the request code */
    private static final int EDIT_REQUEST = 5;
    /** our data model */
    private TravelViewModel viewModel;
    /** an adapter for the recycler view */
    private SolarSystemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galaxy);


        /*
         Set up our recycler view by grabbing the layout for a single solar system
         */
        RecyclerView recyclerView = findViewById(R.id.solar_system_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        //grab our view model instance
        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);

        // Setup the adapter for this recycler view
        adapter = new SolarSystemAdapter();
        adapter.setCurrAct(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onResume() {
        super.onResume();
        List<SolarSystem> solarSystems = new ArrayList<>(viewModel.getSolarSystems());
        solarSystems.remove(viewModel.getCurrentSolarSystem());
        adapter.setSolarSystemList(solarSystems);

        adapter.setOnSolarSystemClickListener(new SolarSystemAdapter.OnSolarSystemClickListener() {
            @Override
            public void onSolarSystemClicked(SolarSystem solarSystem) {
                try {
                    viewModel.travelTo(solarSystem);
                    Random r = new Random();
                    int highRandom = r.nextInt(100);
                    if (highRandom <= 5) {
                        Intent i = new Intent(GalaxyActivity.this, PoliceRandomActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Intent intent = new Intent(GalaxyActivity.this, MarketPlaceActivity.class);
                        startActivityForResult(intent, EDIT_REQUEST);
                        finish();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GalaxyActivity.this, MarketPlaceActivity.class);
        startActivity(intent);
        finish();
    }
}