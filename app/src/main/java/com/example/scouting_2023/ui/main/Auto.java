package com.example.scouting_2023.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.scouting_2023.DataModel;
import com.example.scouting_2023.DataModelDAO;
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
        View view = inflater.inflate(R.layout.autopage, container, false);
        // Get a reference to the singleton instance of DataSingleton
        DataModelDAO dataModelDAO = DataModelDAO.getInstance();
        // Get a reference to your data object
        DataModel data = dataModelDAO.getMyDataObject();
        chkLeftCommunity = (CheckBox) view.findViewById(R.id.AutoLeftCommunity);
        chkDocked = (CheckBox) view.findViewById(R.id.AutoDocked);
        chkEngaged= (CheckBox) view.findViewById(R.id.AutoEngaged);

        return view;
    }



    public void saveData(){
        // Get the text entered by the user
        boolean retChkLeftCommunity = chkLeftCommunity.isChecked();
        boolean retChkDocked = chkDocked.isChecked();
        boolean retChkEngaged = chkEngaged.isChecked();

        // Create an instance of MyDataObject and save the text to it
        // Get a reference to the singleton instance of DataSingleton
        DataModelDAO dataModelDAO = DataModelDAO.getInstance();
        // Get a reference to your data object
        DataModel data = dataModelDAO.getMyDataObject();
        data.setautoLeftComm(retChkLeftCommunity);
        data.setautoDocked(retChkDocked);
        data.setautoEngaged(retChkEngaged);

        // Get a reference to the activity and set the myDataObject instance as an argument for the next fragment
        dataModelDAO.setMyDataObject(data);
    }
    @Override
    public void onPause() {
        super.onPause();
        saveData();
    }
}