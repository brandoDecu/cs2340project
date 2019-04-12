package com.theLads.spacetrader.views.StartGame;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.Game;
import com.theLads.spacetrader.viewmodels.AddGameViewModel;
import com.theLads.spacetrader.views.TravelingAndMarketplace.GalaxyActivity;

public class GameSelectActivity extends AppCompatActivity {

    /** an int for the request code */
    private static final int EDIT_REQUEST = 5;
    /** our data model */
    private AddGameViewModel viewModel;
    /** an adapter for the recycler view */
    private GameAdapter adapter;

    @SuppressWarnings("unused")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_game);


        /*
         Set up our recycler view by grabbing the layout for a single game
         */
        RecyclerView recyclerView = findViewById(R.id.game_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapter = new GameAdapter();
        recyclerView.setAdapter(adapter);

        //grab our view model instance
        viewModel = ViewModelProviders.of(this).get(AddGameViewModel.class);

    }

    @Override
    public void onResume() {
        super.onResume();

        adapter.setGameList(viewModel.getAllGames());

        adapter.setOnGameClickListener(new GameAdapter.OnGameClickListener() {
            @Override
            public void onGameClicked(Game game) {
                viewModel.setCurrentGame(game);
                Intent intent = new Intent(GameSelectActivity.this, GalaxyActivity.class);
                startActivityForResult(intent, EDIT_REQUEST);
                finish();
            }
        });


    }

    /*
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameSelectActivity.this, MarketPlaceActivity.class);
        startActivity(intent);
        finish();
    }
    */
}
