package com.theLads.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.model.Model;
import com.theLads.spacetrader.viewmodels.BuySellViewModel;

public class BuyDetailActivity extends AppCompatActivity {

    private BuySellViewModel viewModel;

    private TextView itemType;
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

        quatityField = findViewById(R.id.quatityField);
        itemQuant = findViewById(R.id.itemQuant);
        priceTag = findViewById(R.id.priceTag);
        creditsTag = findViewById(R.id.creditsTag);;


        supply = Model.getInstance().getGameInteractor().getMarketQuantities().get(0);
        price = Model.getInstance().getGameInteractor().getMarketPrices().get(0);
        Double credits = Model.getInstance().getGameInteractor().getCredits();

        itemQuant.setText(supply);
        priceTag.setText(String.format("%.2f", price));
        creditsTag.setText(String.format("%.2f", credits));

        viewModel = ViewModelProviders.of(this).get(BuySellViewModel.class);

    }

    public void onAddPressed(View view) {

        quantity = Integer.parseInt(quatityField.getText().toString());
        if (quantity <= supply) {
            viewModel.buyItem(ItemType.WATER, quantity, price);
            Toast.makeText(this, String.format("%f items baught", quantity), Toast.LENGTH_LONG).show();

            Intent i = new Intent(this, BuyActivity.class);
            this.startActivity(i);
            this.finish();
        } else {
            Toast.makeText(this, String.format("This store only has %f of this item", supply), Toast.LENGTH_LONG).show();
        }
    }
}