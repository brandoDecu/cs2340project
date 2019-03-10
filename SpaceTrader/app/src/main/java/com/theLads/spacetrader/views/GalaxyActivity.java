package com.theLads.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.view.View;

import com.theLads.spacetrader.R;

public class GalaxyActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }

    public void onStartGamePressed(View view) {
        Intent i = new Intent(this, BuyActivity.class);
        this.startActivity(i);
        this.finish();
    }
}