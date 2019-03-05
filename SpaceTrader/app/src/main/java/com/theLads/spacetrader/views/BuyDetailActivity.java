package com.theLads.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.itemType;

public class BuyDetailActivity extends AppCompatActivity {

    private TextView itemType;
    private TextView itemQuant;
    private EditText quatityField;

    private com.theLads.spacetrader.entity.itemType item;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_detail);

        quatityField = findViewById(R.id.nameField);
//        item = (itemType) getIntent().item();
//        Intent i = new Intent(this, NewActivity.class);
//        this.startActivity(i);
//        this.finish();
    }
}