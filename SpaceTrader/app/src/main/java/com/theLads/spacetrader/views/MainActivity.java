package com.theLads.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.GameDifficulty;
import com.theLads.spacetrader.entity.Player;
import com.theLads.spacetrader.viewmodels.AddGameViewModel;


public class MainActivity extends AppCompatActivity {

//    lets create a splash screen before moving to this screen
    private AddGameViewModel viewModel;

    private EditText nameField;

    private EditText editEngineerSkill;
    private EditText editTraderSkill;
    private EditText editPilotSkill;
    private EditText editFighterSkill;

    private Spinner difficultySpinner;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Grab the dialog widgets so we can get info for later
         */
        nameField = findViewById(R.id.nameField);
        editEngineerSkill = findViewById(R.id.editEngineerSkill);
        editTraderSkill = findViewById(R.id.editTraderSkill);
        editPilotSkill = findViewById(R.id.editPilotSkill);
        editFighterSkill = findViewById(R.id.editFighterSkill);

        difficultySpinner = findViewById(R.id.difficultySpinner);
//        Button button = findViewById(R.id.add_button);

        ArrayAdapter<GameDifficulty> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);
    }

    public void onAddPressed(View view) {
        Log.d("Edit", "Add/Update Game Pressed");

        GameDifficulty difficulty = (GameDifficulty) difficultySpinner.getSelectedItem();
        int engineerS = 0;
        int tradeS = 0;
        int pilotS = 0;
        int fightS = 0;
        int total = 0;

        String name = "";

        try {
            engineerS = Integer.parseInt(editEngineerSkill.getText().toString());
            tradeS = Integer.parseInt(editTraderSkill.getText().toString());
            pilotS = Integer.parseInt(editPilotSkill.getText().toString());
            fightS = Integer.parseInt(editFighterSkill.getText().toString());
            total = engineerS + tradeS + pilotS + fightS;

            name = (String) nameField.getText().toString();
        } catch (Exception e) {
            Toast.makeText(this, "You must write valid numbers in each skill field", Toast.LENGTH_LONG).show();
        }


//        //student.setName(nameField.getText().toString());
//        //student.setMajor((String) majorSpinner.getSelectedItem());
//        //student.setStanding(ClassStanding.val2e( (String) standingSpinner.getSelectedItem()));

        if (engineerS < 0 || tradeS < 0 || pilotS < 0 || fightS < 0) {
            Toast.makeText(this, "Skill points cannot be negative", Toast.LENGTH_LONG).show();

        } else if (total == 16) {
            Toast.makeText(this, "Character created!", Toast.LENGTH_LONG).show();
            //String nam, int pilot, int fighter, int trader, int engineer
            player = new Player(name, pilotS, fightS, tradeS,  engineerS);
            Log.d("Player Made: ", player.toString());
//            finish();
        } else {
            Toast.makeText(this, "Skill points must add up to 16", Toast.LENGTH_LONG).show();
        }
    }
}
