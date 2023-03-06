package com.example.scouting_2023.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.scouting_2023.DataModel;
import com.example.scouting_2023.DataModelDAO;
import com.example.scouting_2023.MainActivity;
import com.example.scouting_2023.R;

public class EndGame extends Fragment {


    public EndGame() {
        // Required empty public constructor
    }

    private Button mEndgameSubmitButton;
    private EditText txtNotes;
    private EditText txtScore;
    private CheckBox chkCoopertition;
    private CheckBox chkWin;
    private CheckBox chkEndGameDocked;
    private CheckBox chkEndGameEngaged;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.endgamepage, container, false);
        // Get a reference to the singleton instance of DataSingleton
        DataModelDAO dataModelDAO = DataModelDAO.getInstance();
        // Get a reference to your data object
        DataModel data = dataModelDAO.getMyDataObject();

        txtScore = (EditText) view.findViewById(R.id.EndgameTotalScoreBox);
        txtNotes = (EditText) view.findViewById(R.id.EndgameNoteButton);
        chkCoopertition = (CheckBox) view.findViewById(R.id.EndgameCoopertitionBonusBox);
        chkWin = (CheckBox) view.findViewById(R.id.EndgameDidTheyWinBox);
        chkEndGameDocked = (CheckBox) view.findViewById(R.id.EndgameDockedBox);
        chkEndGameEngaged= (CheckBox) view.findViewById(R.id.EndgameEngagedBox);
        // Get a reference to the button in the layout
        mEndgameSubmitButton = view.findViewById(R.id.EndgameSubmitButton);

        // Set an OnClickListener for the button
        mEndgameSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text entered by the user
                String retTxtScore = txtScore.getText().toString();
                String retTxtNotes = txtNotes.getText().toString();
                String retChkCoopertition = String.valueOf(chkCoopertition.isChecked());
                String retChkWin = String.valueOf(chkWin.isChecked());
                String retChkEndGameDocked = String.valueOf(chkEndGameDocked.isChecked());
                String retChkEndGameEngaged = String.valueOf(chkEndGameEngaged.isChecked());

                // Create an instance of MyDataObject and save the text to it
                // Get a reference to the singleton instance of DataSingleton
                DataModelDAO dataModelDAO = DataModelDAO.getInstance();
                // Get a reference to your data object
                DataModel data = dataModelDAO.getMyDataObject();
                data.setendgamePoints(Integer.parseInt(retTxtScore));
                data.setnotes(retTxtNotes);
                data.setwin(Boolean.parseBoolean(retChkWin));
                data.setcoopertition(Boolean.parseBoolean(retChkCoopertition));
                data.setEndgameDocked(Boolean.parseBoolean(retChkEndGameDocked));
                data.setEndgameEngaged(Boolean.parseBoolean(retChkEndGameEngaged));


                // Get a reference to the activity and set the myDataObject instance as an argument for the next fragment
                dataModelDAO.setMyDataObject(data);

                //Run the main function
                ((MainActivity)getActivity()).endgameSubmit(v);
            }
        });
        return view;
    }
public void saveData(){
    // Get the text entered by the user
    String retTxtScore = txtScore.getText().toString();
    String retTxtNotes = txtNotes.getText().toString();
    String retChkCoopertition = String.valueOf(chkCoopertition.isChecked());
    String retChkWin = String.valueOf(chkWin.isChecked());
    String retChkEndGameDocked = String.valueOf(chkEndGameDocked.isChecked());
    String retChkEndGameEngaged = String.valueOf(chkEndGameEngaged.isChecked());

    // Create an instance of MyDataObject and save the text to it
    // Get a reference to the singleton instance of DataSingleton
    DataModelDAO dataModelDAO = DataModelDAO.getInstance();
    // Get a reference to your data object
    DataModel data = dataModelDAO.getMyDataObject();
    data.setendgamePoints(Integer.parseInt(retTxtScore));
    data.setnotes(retTxtNotes);
    data.setwin(Boolean.parseBoolean(retChkWin));
    data.setcoopertition(Boolean.parseBoolean(retChkCoopertition));
    data.setEndgameDocked(Boolean.parseBoolean(retChkEndGameDocked));
    data.setEndgameEngaged(Boolean.parseBoolean(retChkEndGameEngaged));


    // Get a reference to the activity and set the myDataObject instance as an argument for the next fragment
    dataModelDAO.setMyDataObject(data);
}
    // return inflater.inflate(R.layout.endgamepage, container, false);
    @Override
    public void onPause() {
        super.onPause();
        saveData();

    }
}



