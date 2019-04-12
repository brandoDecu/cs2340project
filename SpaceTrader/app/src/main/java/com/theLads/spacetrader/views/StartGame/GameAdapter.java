package com.theLads.spacetrader.views.StartGame;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.Game;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {
    /** a copy of the list of games in the model */
    private List<Game> gameList = new ArrayList<>();

    /** a listener for a touch event on the game */
    private GameAdapter.OnGameClickListener listener;

    @NonNull
    @Override
    public GameAdapter.GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        // hook up to the view for a single game in the system
        View gameView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game, parent, false);

        return new GameAdapter.GameViewHolder(gameView);
    }


    @Override
    public void onBindViewHolder(@NonNull GameAdapter.GameViewHolder holder, int position) {

        //bind the Game data for one Game
        Game game = gameList.get(position);

        Log.d("APP", "Binding: " + position + " " + gameList.get(position));

        holder.gameIndex.setText(game.toString());

    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public void setGameList(List<Game> allGames) {
        gameList = allGames;
    }


    /**
     * This is a holder for the widgets associated with a single entry in the list of games
     */
    class GameViewHolder extends RecyclerView.ViewHolder {
        private final TextView gameIndex;

        GameViewHolder(@NonNull View gameView) {
            super(gameView);
            gameIndex = gameView.findViewById(R.id.text_game_id);

            gameView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if ((listener != null) && (position != RecyclerView.NO_POSITION)) {
                        listener.onGameClicked(gameList.get(position));
                    }
                }
            });

        }
    }

    public interface OnGameClickListener {
        void onGameClicked(Game game);
    }

    public void setOnGameClickListener(GameAdapter.OnGameClickListener listener) {
        this.listener = listener;
    }
}
