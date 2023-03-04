package com.example.scouting_2023.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.scouting_2023.DataModel;
import com.example.scouting_2023.MainActivity;
import com.example.scouting_2023.R;




public class Auto extends Fragment {
    private CheckBox chkLeftCommunity;
    private CheckBox chkDocked;
    private CheckBox chkEngaged;
    public Auto() {
        // Required empty public constructor
    }
    @SuppressLint("MissingInflatedId")  //This might be a problem
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intropage, container, false);

        chkLeftCommunity = (CheckBox) view.findViewById(R.id.AutoLeftCommunity);
        chkDocked = (CheckBox) view.findViewById(R.id.AutoDocked);
        chkEngaged= (CheckBox) view.findViewById(R.id.AutoEngaged);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        // Get the text entered by the user
        String retChkLeftCommunity = chkLeftCommunity.getText().toString();
        String retChkDocked = chkDocked.getText().toString();
        String retChkEngaged = chkEngaged.getText().toString();

        // Create an instance of MyDataObject and save the text to it
        DataModel data = new DataModel();
        data.setautoLeftComm(Boolean.parseBoolean(retChkLeftCommunity));
        data.setautoDocked(Boolean.parseBoolean(retChkDocked));
        data.setautoEngaged(Boolean.parseBoolean(retChkEngaged));

        // Get a reference to the activity and set the myDataObject instance as an argument for the next fragment
        MainActivity activity = (MainActivity) getActivity();
        activity.setMyDataObject(data);
    }
}