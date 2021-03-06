package com.theLads.spacetrader.views.StartGame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;

import com.theLads.spacetrader.views.StartGame.NewLoadGameActivity;

/**
 * displays the splash screen
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, NewLoadGameActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}
