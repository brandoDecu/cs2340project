package com.theLads.spacetrader.views;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.model.Model;
import com.theLads.spacetrader.viewmodels.BuySellViewModel;

import java.util.Objects;

public class BuyDetailActivity extends AppCompatActivity {

    private BuySellViewModel viewModel;

    private EditText quatityField;

    private ItemType item;

    private double price;
    private int supply;



    @SuppressLint("DefaultLocale")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_detail);

        // find text fields to set to specific item being bought
        TextView itemName = findViewById(R.id.itemName);
        quatityField = findViewById(R.id.quatityField);
        TextView itemQuant = findViewById(R.id.itemQuant);
        TextView priceTag = findViewById(R.id.priceTag);
        TextView creditsTag = findViewById(R.id.creditsTag);

        //get values from model
        item = ItemType.valueOf(Objects.requireNonNull(getIntent()
                .getExtras()).getString("ITEM_DATA"));
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

    @SuppressLint("DefaultLocale")
    public void onBuyPressed(View view) {

        int quantity = 0;

        try {
            quantity = Integer.parseInt(quatityField.getText().toString());
        } catch (Exception e) {
            // error text will display from else statement
        }

        if (quantity > 0) {
            if (quantity <= supply) {
                try {
                    viewModel.buyItem(item, quantity, price);
                    Toast.makeText(this, String.format("%d %s bought!",
                            quantity, item.toString()), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(BuyDetailActivity.this,
                            BuySellActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, String.format("This store only has %d %ss",
                        supply, item.toString()), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Please enter a valid quantity to buy",
                    Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, BuySellActivity.class);
        startActivity(intent);
        finish();
    }


}