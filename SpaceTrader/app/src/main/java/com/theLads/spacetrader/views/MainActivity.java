package com.theLads.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.theLads.spacetrader.R;


public class MainActivity extends AppCompatActivity {

//    lets create a splash screen before moving to this screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
