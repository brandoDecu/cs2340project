package com.theLads.spacetrader.views.StartGame;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.enums.GameDifficulty;
import com.theLads.spacetrader.viewmodels.AddGameViewModel;

/**
 * Activity that displays login screen
 */
public class ConfigureGameActivity extends AppCompatActivity {

//    lets create a splash screen before moving to this screen
    private AddGameViewModel viewModel;

    private EditText nameField;

    private EditText editEngineerSkill;
    private EditText editTraderSkill;
    private EditText editPilotSkill;
    private EditText editFighterSkill;

    private Spinner difficultySpinner;


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
                R.layout.spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(AddGameViewModel.class);
    }

    @SuppressLint("DefaultLocale")
    public void onAddPressed(View view) {
        Log.d("Edit", "Add/Update Game Pressed");


        final int SKILL_LIMIT = 16;
        GameDifficulty difficulty = (GameDifficulty) difficultySpinner.getSelectedItem();
        int engineerS = 0;
        int tradeS = 0;
        int pilotS = 0;
        int fightS = 0;
        int total = 0;

        String name = nameField.getText().toString();


        try {

            if (!editEngineerSkill.getText().toString().equals(""))
                engineerS = Integer.parseInt(editEngineerSkill.getText().toString());
            if (!editTraderSkill.getText().toString().equals(""))
                tradeS = Integer.parseInt(editTraderSkill.getText().toString());
            if (!editPilotSkill.getText().toString().equals(""))
                pilotS = Integer.parseInt(editPilotSkill.getText().toString());
            if (!editFighterSkill.getText().toString().equals(""))
                fightS = Integer.parseInt(editFighterSkill.getText().toString());
            total = engineerS + tradeS + pilotS + fightS;
            if (name.equals("")) {
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_LONG).show();
            } else if ((engineerS < 0) || (tradeS < 0) || (pilotS < 0) || (fightS < 0)) {
                Toast.makeText(this, "Skill points cannot be negative",
                        Toast.LENGTH_LONG).show();
            } else if (total > SKILL_LIMIT) {
                Toast.makeText(this, "Skill points must add up to 16 or less",
                        Toast.LENGTH_LONG).show();
            } else {

                int bonusCreds = (SKILL_LIMIT - total) * 100;
                Toast.makeText(this,
                        String.format("Character created with %d extra credits!", bonusCreds),
                        Toast.LENGTH_LONG).show();

                viewModel.createGame(difficulty, name, pilotS, fightS, tradeS, engineerS);
                Log.d("malleable", "malleable");

                Intent i = new Intent(this, IntroStoryActivity.class);
                Log.d("aga", "aga");

                this.startActivity(i);
                this.finish();

            }

        } catch (Exception e) {
            Toast.makeText(this, "You must write valid numbers." + editEngineerSkill.getText().toString() + ". points",
                    Toast.LENGTH_LONG).show();
        }



    }
    @Override
    public void onResume() {
        super.onResume();
    }
}
