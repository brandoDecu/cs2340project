package com.theLads.spacetrader.views.TravelingAndMarketplace;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.viewmodels.TravelViewModel;

/**
 * displays the police activity
 */
public class PoliceRandomActivity extends AppCompatActivity {

    private TravelViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_activity);
        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);
    }

    /**
     * starts the PoliceRandomActivity and MarketPlaceActivity activities and finishes this one
     * @param view  the current view
     */
    public void onPoliceAccept(View view) {
        viewModel.bustedByPolice();
        Intent i = new Intent(PoliceRandomActivity.this, MarketPlaceActivity.class);
        startActivity(i);
        finish();
    }
}
