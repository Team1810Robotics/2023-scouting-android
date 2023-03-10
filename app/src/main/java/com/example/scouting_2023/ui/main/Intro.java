package com.example.scouting_2023.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.scouting_2023.DataModel;
import com.example.scouting_2023.DataModelDAO;
import com.example.scouting_2023.R;

public class Intro extends Fragment {

    private EditText txtTeamNumber;
    private EditText txtRoundNumber;
    private Spinner spnAllianceColor;
    public Intro() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intropage, container, false);
        txtTeamNumber = (EditText) view.findViewById(R.id.IntroTeam);
        txtRoundNumber= (EditText) view.findViewById(R.id.IntroRound);
        spnAllianceColor= (Spinner) view.findViewById(R.id.IntroAlliance);
        // Get a reference to the singleton instance of DataSingleton
        DataModelDAO dataModelDAO = DataModelDAO.getInstance();
        // Get a reference to your data object
        DataModel data = dataModelDAO.getMyDataObject();
        return view;//
        // inflater.inflate(R.layout.intropage, container, false);
    }
 public void saveData(){
     // Get the text entered by the user
     String retTxtTeamNumber = txtTeamNumber.getText().toString();
     String retTxtRoundNumber = txtRoundNumber.getText().toString();
     String retTxtAllianceColor = spnAllianceColor.getSelectedItem().toString();

     // Create an instance of MyDataObject and save the text to it
     // Get a reference to the singleton instance of DataSingleton
     DataModelDAO dataModelDAO = DataModelDAO.getInstance();
     // Get a reference to your data object
     DataModel data = dataModelDAO.getMyDataObject();
     data.setTeamID(retTxtTeamNumber);
     data.setRoundNumber(retTxtRoundNumber);
     data.setAllianceColor(retTxtAllianceColor);

     // Get a reference to the activity and set the myDataObject instance as an argument for the next fragment
     dataModelDAO.setMyDataObject(data);

 }
    @Override
    public void onPause() {
        super.onPause();
        saveData();
    }

    }




