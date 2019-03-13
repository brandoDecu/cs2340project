package com.theLads.spacetrader.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.theLads.spacetrader.R;

public class MarketPlaceActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);
    }
    public void onBuyClick(View view) {
        Intent i = new Intent(this, BuyActivity.class);
        this.startActivity(i);
        this.finish();
    }

    public void onSellClick(View view) {


        Intent i = new Intent(this, SellActivity.class);
        this.startActivity(i);
        this.finish();
    }
}
