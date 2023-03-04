package com.example.scouting_2023.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.scouting_2023.DataModel;
import com.example.scouting_2023.MainActivity;
import com.example.scouting_2023.R;


public class TeleOp extends Fragment {


    private Spinner spnRole;
    private CheckBox chkDirty;
    public TeleOp() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teleoppage, container, false);

        chkDirty= (CheckBox) view.findViewById(R.id.TeleOpNaughtyCheck);
        spnRole= (Spinner) view.findViewById(R.id.TeleopRoleDrop);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        // Get the text entered by the user
        String retChkDirty = chkDirty.getText().toString();
        String retRole = spnRole.getSelectedItem().toString();


        // Create an instance of MyDataObject and save the text to it
        DataModel data = new DataModel();
        data.setdirty(Boolean.parseBoolean(retRole));
        data.setRole(retRole);


        // Get a reference to the activity and set the myDataObject instance as an argument for the next fragment
        MainActivity activity = (MainActivity) getActivity();
        activity.setMyDataObject(data);
    }
}