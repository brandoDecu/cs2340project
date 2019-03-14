package com.theLads.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.viewmodels.AddGameViewModel;
import com.theLads.spacetrader.viewmodels.TravelViewModel;

public class MarketPlaceActivity extends AppCompatActivity {

    private TravelViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);
        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);
        TextView title = (TextView)findViewById(R.id.welcome2planet);
        title.setText("Welcome To Planet: " + viewModel.getPlanetName());

    }
    public void onBuyClick(View view) {
        Intent i = new Intent(this, BuyActivity.class);
        this.startActivity(i);
        //this.finish();
    }

    public void onSellClick(View view) {
        Intent i = new Intent(this, SellActivity.class);
        this.startActivity(i);
        //this.finish();

    }

}
