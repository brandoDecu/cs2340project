package com.theLads.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.model.Model;
import com.theLads.spacetrader.viewmodels.BuySellViewModel;

public class BuyDetailActivity extends AppCompatActivity {

    private BuySellViewModel viewModel;

    private TextView itemName;
    private TextView itemQuant;
    private TextView priceTag;
    private TextView creditsTag;
    private EditText quatityField;

    private ItemType item;

    private int quantity;
    private double price;
    private int supply;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_detail);

        // find text fields to set to specific item being bought
        itemName = findViewById(R.id.itemName);
        quatityField = findViewById(R.id.quatityField);
        itemQuant = findViewById(R.id.itemQuant);
        priceTag = findViewById(R.id.priceTag);
        creditsTag = findViewById(R.id.creditsTag);

        //get values from model
        item = ItemType.valueOf(getIntent().getExtras().getString("ITEM_DATA"));
        supply = Model.getInstance().getGameInteractor().getMarketQuantities().get(item.ordinal());
        price = Model.getInstance().getGameInteractor().getMarketPrices().get(item.ordinal());
        Double credits = Model.getInstance().getGameInteractor().getCredits();

        // set text fields
        itemName.setText(String.format("%s", item.toString()));
        itemQuant.setText(String.format("%d", supply));
        priceTag.setText(String.format("%.2f", price));
        creditsTag.setText(String.format("%.2f", credits));

        //grab viewModel
        viewModel = ViewModelProviders.of(this).get(BuySellViewModel.class);

    }

    public void onBuyPressed(View view) {

        quantity = Integer.parseInt(quatityField.getText().toString());
        if (quantity <= supply) {
            try {
                viewModel.buyItem(item, quantity, price);
                Toast.makeText(this, String.format("%d %s bought!", quantity, item.toString()), Toast.LENGTH_LONG).show();
                finish();
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, String.format("This store only has %d of this item", supply), Toast.LENGTH_LONG).show();
        }
    }
}