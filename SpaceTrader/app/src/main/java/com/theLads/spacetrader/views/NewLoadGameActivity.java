package com.theLads.spacetrader.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.MarketPlace;
import com.theLads.spacetrader.model.Model;

import java.io.File;

public class NewLoadGameActivity extends AppCompatActivity{

    MediaPlayer music;
    Boolean binaryExists;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        music = MediaPlayer.create(NewLoadGameActivity.this, R.raw.music_intro);
        music.start();
        music.setLooping(true);
        setTitle("");
        Model model = Model.getInstance();
        File file = new File(this.getFilesDir(), Model.DEFAULT_BINARY_FILE_NAME);
        Log.d("Model", this.getFilesDir().getAbsolutePath());
        binaryExists = model.loadBinaryRepository(file);
    }
    public void onNewGamePressed(View view) {
        Intent i = new Intent(this, ConfigureGameActivity.class);
        this.startActivity(i);
        //this.finish();
    }

    public void onContinuePressed(View view) {
        if (binaryExists) {
            Toast.makeText(this, "Welcome Back: " + Model.getInstance().getGameInteractor().getCurrentGame().getPlayer().getName(), Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MarketPlaceActivity.class);

            this.startActivity(i);
        } else {
            Toast.makeText(this, "No previous game found", Toast.LENGTH_LONG).show();
        }

    }


    public void onResume() {
        super.onResume();

        music.start();
        music.setLooping(true);
    }
}
