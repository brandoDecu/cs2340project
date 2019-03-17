package com.theLads.spacetrader.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.theLads.spacetrader.R;

public class NewLoadGameActivity extends AppCompatActivity{

    MediaPlayer music;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        music = MediaPlayer.create(NewLoadGameActivity.this, R.raw.music_intro);
        music.start();
        music.setLooping(true);
        setTitle("");
    }
    public void onNewGamePressed(View view) {
        Intent i = new Intent(this, ConfigureGameActivity.class);
        this.startActivity(i);
        //this.finish();
    }


    public void onResume() {
        super.onResume();

        music.start();
        music.setLooping(true);
    }
}
