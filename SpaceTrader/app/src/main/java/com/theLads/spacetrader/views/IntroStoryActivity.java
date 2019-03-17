package com.theLads.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.theLads.spacetrader.R;

public class IntroStoryActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("blub", "blub");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void onStartGamePressed(View view) {
        Intent i = new Intent(this, MarketPlaceActivity.class);
        this.startActivity(i);
        this.finish();
    }
}
