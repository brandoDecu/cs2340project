package com.theLads.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.model.Model;
import com.theLads.spacetrader.viewmodels.TravelViewModel;

import java.io.File;

/**
 * displays the market
 */
public class MarketPlaceActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);
        TravelViewModel viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);
        TextView title = findViewById(R.id.welcome2planet);
        String planetTitle = "Planet " + viewModel.getPlanetName();
        title.setText(planetTitle);

    }

    /**
     * starts BuySellActivity with isBuy equal to true and finishes this intent
     * @param view the view the button is on
     */
    public void onBuyClick(View view) {
        Intent i = new Intent(this, BuySellActivity.class);
        i.putExtra("isBuy", true);
        this.startActivity(i);
        this.finish();
    }

    /**
     * starts BuySellActivity with isBuy equal to false and finishes this intent
     * @param view  the view the button is on
     */
    public void onSellClick(View view) {
        Intent i = new Intent(this, BuySellActivity.class);
        i.putExtra("isBuy", false);
        this.startActivity(i);
        this.finish();

    }

    /**
     * when travel button is clicked, the Galaxy Activity starts and this intent finishes
     * @param view  the view the button is on
     */
    public void onTravelClick(View view) {
        Intent i = new Intent(this, GalaxyActivity.class);
        this.startActivity(i);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        Model model = Model.getInstance();
        File file = new File(this.getFilesDir(), Model.DEFAULT_BINARY_FILE_NAME);
        model.saveBinaryRepository(file);
        super.onBackPressed();
    }
}
