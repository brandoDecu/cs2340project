package com.theLads.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.model.Model;
import com.theLads.spacetrader.viewmodels.SaveGameViewModel;

/**
 * displays the new game/load screen
 */
public class NewLoadGameActivity extends AppCompatActivity{

    private MediaPlayer music;
    private Boolean binaryExists;
    private SaveGameViewModel viewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        music = MediaPlayer.create(NewLoadGameActivity.this, R.raw.music_intro);
        music.start();
        music.setLooping(true);
        setTitle("");
        Model model = Model.getInstance();
        //File file = new File(this.getFilesDir(), Model.DEFAULT_BINARY_FILE_NAME);
        //Log.d("Model", this.getFilesDir().getAbsolutePath());
        //binaryExists = model.loadBinaryRepository(file);
        viewModel = ViewModelProviders.of(this).get(SaveGameViewModel.class);
    }

    /**
     * starts ConfigureGameActivity intent and finishes current intent
     * @param view the current view
     */
    public void onNewGamePressed(View view) {
        Intent i = new Intent(this, ConfigureGameActivity.class);
        this.startActivity(i);
        //this.finish();
    }

    /**
     * starts ConfigureGameActivity intent and finishes current intent
     * @param view the current view
     */
    public void onLoadGamePressed(View view) {
        Intent i = new Intent(this, GameSelectActivity.class);
        this.startActivity(i);
        //this.finish();
    }

    /**
     * starts MarketPlaceActivity intent with the saved game data and finishes current intent
     * @param view  the current view
     */
    public void onContinuePressed(View view) {
        if (binaryExists) {
            String playername = viewModel.getPlayerName();
            Toast.makeText(this, "Welcome back: " + playername, Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MarketPlaceActivity.class);

            this.startActivity(i);
        } else {
            Toast.makeText(this, "No previous game found", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void onResume() {
        super.onResume();

        music.start();
        music.setLooping(true);
    }
}
