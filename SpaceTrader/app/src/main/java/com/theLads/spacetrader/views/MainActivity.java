package com.theLads.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.GameDifficulty;
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
//        Button button = findViewById(R.id.add_button);

        ArrayAdapter<GameDifficulty> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);
    }

    public void onAddPressed(View view) {
        Log.d("Edit", "Add/Update Game Pressed");

        String name = nameField.getText().toString();
        GameDifficulty difficulty = (GameDifficulty) difficultySpinner.getSelectedItem();

        try {
            int engineerS = Integer.parseInt(editEngineerSkill.getText().toString());
            int tradeS = Integer.parseInt(editTraderSkill.getText().toString());
            int pilotS = Integer.parseInt(editPilotSkill.getText().toString());
            int fightS = Integer.parseInt(editFighterSkill.getText().toString());
        } catch (Exception e) {

        }

//        student.setName(nameField.getText().toString());
//        student.setMajor((String) majorSpinner.getSelectedItem());
//        student.setStanding(ClassStanding.val2e( (String) standingSpinner.getSelectedItem()));

        Log.d("Edit", "Got new player info: " + student);

        //do the right thing depending on whether this is a new student or an edit
        if (editing) {
            viewModel.updateStudent(student);
        } else {
            viewModel.addStudent(student);
        }

        finish();
    }
}
