package com.example.scouting_2023.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.scouting_2023.DataModel;
import com.example.scouting_2023.DataModelDAO;
import com.example.scouting_2023.R;


public class TeleOp extends Fragment {


    private Spinner spnRole;
    boolean spnRoleInitialized;
    private CheckBox chkDirty;
    public TeleOp() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teleoppage, container, false);
        // Get a reference to the singleton instance of DataSingleton
        DataModelDAO dataModelDAO = DataModelDAO.getInstance();
        // Get a reference to your data object
        DataModel data = dataModelDAO.getMyDataObject();
        chkDirty= (CheckBox) view.findViewById(R.id.TeleOpNaughtyCheck);
        spnRole= (Spinner) view.findViewById(R.id.TeleopRoleDrop);


        spnRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
              if  (!spnRoleInitialized) {
                    spnRoleInitialized = true;
                    return;
                }
                saveData();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        return view;
    }

    public void saveData(){
        try {
            boolean retChkDirty = chkDirty.isChecked();
            String retRole = spnRole.getSelectedItem().toString();

            // Create an instance of MyDataObject and save the text to it
            // Get a reference to the singleton instance of DataSingleton
            DataModelDAO dataModelDAO = DataModelDAO.getInstance();
            // Get a reference to your data object
            DataModel data = dataModelDAO.getMyDataObject();
            data.setdirty(retChkDirty);
            data.setRole(retRole);

// Get a reference to the activity and set the myDataObject instance as an argument for the next fragment
            dataModelDAO.setMyDataObject(data);
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }
    @Override
    public void onPause() {
        super.onPause();
         saveData();
        // Get the text entered by the user

    }


}