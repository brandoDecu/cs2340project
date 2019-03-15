package com.theLads.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.viewmodels.TravelViewModel;

public class GalaxyActivity extends AppCompatActivity {

    /** a key for passing data */
    public static final String SOLAR_SYSTEM_DATA = "SOLAR_SYSTEM_DATA";
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

        // Setup the adapter for this recycler view
        adapter = new SolarSystemAdapter();
        recyclerView.setAdapter(adapter);

        //grab our view model instance
        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);

    }

    @Override
    public void onResume() {
        super.onResume();

        adapter.setSolarSystemList(viewModel.getSolarSystems());

        adapter.setOnSolarSystemClickListener(new SolarSystemAdapter.OnSolarSystemClickListener() {
            @Override
            public void onSolarSystemClicked(SolarSystem solarSystem) {
                viewModel.travelTo(solarSystem);
                Intent intent = new Intent(GalaxyActivity.this, MarketPlaceActivity.class);
                startActivityForResult(intent, EDIT_REQUEST);
            }
        });
    }
}