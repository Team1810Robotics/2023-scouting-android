package com.example.scouting_2023;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.scouting_2023.databinding.ActivityMainBinding;
import com.example.scouting_2023.ui.main.MyAdapter;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    TabLayout tabLayout;
    ViewPager viewPager;
    String fileName = "/chargedUp";
    String filepath = (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + fileName); // change

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final MyAdapter adapter = new MyAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
        //mathmatics

        int cube;
        int links;
        int ticker;
        int conesUpperLimit = 9;
        int conesLowerLimit = 0;





        //TeleOp Page
    public void incrementTeleOpLowerCone(View view){
        increaseCone(R.id.TeleOpLowConesTicker, bundleValues.TeleOpLowConesTicker, conesUpperLimit);
    }

    public void incrementTeleOpMiddleCone(View view){
        increaseCone(R.id.TeleOpMidConeTicker, bundleValues.TeleOpMidConeTicker, conesUpperLimit);
    }

    public void incrementTeleOpHighCone(View view){
        increaseCone(R.id.TeleOpHighConeTicker, bundleValues.TeleOpHighConeTicker, conesUpperLimit);
    }



    public void incrementTeleOpLowCube(View view){
        increaseCone(R.id.TeleOpLowCubesTicker, bundleValues.TeleOpLowCubeTicker, conesUpperLimit);
    }

    public void incrementTeleOpMidCube(View view){
        increaseCone(R.id.TeleOpMidCubeTicker, bundleValues.TeleOpMidCubeTicker, conesUpperLimit);
    }

    public void incrementTeleOpHighCube(View view){
        increaseCone(R.id.TeleOpHighCubeTicker, bundleValues.TeleOpHighCubeTicker, conesUpperLimit);
    }

    //Auto page
    public void incrementAutoLowerCone(View view){
        increaseCone(R.id.AutoLowConeTicker, bundleValues.AutoLowConesTicker, conesUpperLimit);
    }

    public void incrementAutoMiddleCone(View view){
        increaseCone(R.id.AutoMidConeTicker, bundleValues.AutoMidConesTicker, conesUpperLimit);
    }

    public void incrementAutoHighCone(View view){
        increaseCone(R.id.AutoHighConeTicker, bundleValues.AutoHighConesTicker, conesUpperLimit);
    }



    public void incrementAutoLowCube(View view){
        increaseCone(R.id.AutoLowCubesTicker, bundleValues.AutoLowCubeTicker, conesUpperLimit);
    }

    public void incrementAutoMidCube(View view){
        increaseCone(R.id.AutoMidCubeTicker, bundleValues.AutoMidCubeTicker, conesUpperLimit);
    }

    public void incrementAutoHighCube(View view){
        increaseCone(R.id.AutoHighCubeTicker, bundleValues.AutoHighCubeTicker, conesUpperLimit);
    }


    //Endgame Page
    public void incrementEndgameLowLink(View view){
        increaseCone(R.id.EndgameLowLinkTicker, bundleValues.EndgameLowLinkTicker, conesUpperLimit);
    }

    public void incrementEndgameMidLink(View view){
        increaseCone(R.id.EndgameMidLinkTicker, bundleValues.EndgameMidLinkTicker, conesUpperLimit);
    }

    public void incrementEndgameHighLink(View view){
        increaseCone(R.id.EndgameHighLinkTicker, bundleValues.EndgameHighLinkTicker, conesUpperLimit);
    }



    //Decrement



    //TeleOp Page
    public void decrementTeleOpLowerCone(View view){
        decreaseCone(R.id.TeleOpLowConesTicker, bundleValues.TeleOpLowConesTicker, conesLowerLimit);
    }

    public void decrementTeleOpMiddleCone(View view){
        decreaseCone(R.id.TeleOpMidConeTicker, bundleValues.TeleOpMidConeTicker, conesLowerLimit);
    }

    public void decrementTeleOpHighCone(View view){
        decreaseCone(R.id.TeleOpHighConeTicker, bundleValues.TeleOpHighConeTicker, conesLowerLimit);
    }



    public void decrementTeleOpLowCube(View view){
        decreaseCone(R.id.TeleOpLowCubesTicker, bundleValues.TeleOpLowCubeTicker, conesLowerLimit);
    }

    public void decrementTeleOpMidCube(View view){
        decreaseCone(R.id.TeleOpMidCubeTicker, bundleValues.TeleOpMidCubeTicker, conesLowerLimit);
    }

    public void decrementTeleOpHighCube(View view){
        decreaseCone(R.id.TeleOpHighCubeTicker, bundleValues.TeleOpHighCubeTicker, conesLowerLimit);
    }

    //Auto page
    public void decrementAutoLowerCone(View view){
        decreaseCone(R.id.AutoLowConeTicker, bundleValues.AutoLowConesTicker, conesLowerLimit);
    }

    public void decrementAutoMiddleCone(View view){
        decreaseCone(R.id.AutoMidConeTicker, bundleValues.AutoMidConesTicker, conesLowerLimit);
    }


    public void decrementAutoHighCone(View view){
        decreaseCone(R.id.AutoHighConeTicker, bundleValues.AutoHighConesTicker, conesLowerLimit);
    }



    public void decrementAutoLowCube(View view){
        decreaseCone(R.id.AutoLowCubesTicker, bundleValues.AutoLowCubeTicker, conesLowerLimit);
    }

    public void decrementAutoMidCube(View view){
        decreaseCone(R.id.AutoMidCubeTicker, bundleValues.AutoMidCubeTicker, conesLowerLimit);
    }

    public void decrementAutoHighCube(View view){
        decreaseCone(R.id.AutoHighCubeTicker, bundleValues.AutoHighCubeTicker, conesLowerLimit);
    }


    //Endgame Page
    public void decrementEndgameLowLink(View view){
        decreaseCone(R.id.EndgameLowLinkTicker, bundleValues.EndgameLowLinkTicker, conesLowerLimit);
    }

    public void decrementEndgameMidLink(View view){
        decreaseCone(R.id.EndgameMidLinkTicker, bundleValues.EndgameMidLinkTicker, conesLowerLimit);
    }

    public void decrementEndgameHighLink(View view){
        decreaseCone(R.id.EndgameHighLinkTicker, bundleValues.EndgameHighLinkTicker, conesLowerLimit);
    }


    //TODO figure out how to make buttons work in csv. Also need to do intro









        public void increaseCone(int id, bundleValues bundleLocation ,int conesLimit){
            final Intent i = getIntent();
            Bundle bundle = i.getExtras();
            if (bundle == null) {
                bundle = new Bundle();
            }

            int tempConeValue = bundle.getInt(bundleLocation.toString(), 0);
            if (tempConeValue < conesUpperLimit) {
                tempConeValue++;
                final TextView displayCones = findViewById(id);
                displayCones.setText("" + tempConeValue);

                bundle.putInt(bundleLocation.toString(), tempConeValue);
                i.putExtras(bundle);
            }

        }





    public void decreaseCone(int id, bundleValues bundleLocation ,int conesLimit){
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();

        }
        int tempConeValue = bundle.getInt(bundleLocation.toString(), 0);
        if (tempConeValue > conesLowerLimit) {
            tempConeValue--;
            final TextView displayCones = findViewById(id);
            displayCones.setText("" + tempConeValue);


            bundle.putInt(bundleLocation.toString(), tempConeValue);
            i.putExtras(bundle);
        }
    }




        public void endgameSubmit (View view){

            CSVWriter writer = null;
            try {
                UUID uuid = UUID.randomUUID();
                String uuidAsString = uuid.toString();
                String currentFileName = filepath + uuidAsString + ".csv";
                writer = new CSVWriter(new FileWriter(currentFileName));

                List<String[]> data = new ArrayList<String[]>();
                data.add(new String[]{"MatchId", "TeamId", "Color", "AutoLowCone", "AutoLowCube", "AutoMidCone", "AutoMidCube", "AutoHighCone", "AutoHighCube", "AutoLeftComm", "AutoDocked", "AutoEngaged", "TeleLowCone", "TeleLowCube", "TeleMidCone", "TeleMidCube", "TeleHighCone", "TeleHighCube", "TeleLeftComm", "TeleDocked", "TeleEngaged", "TeleTeamRole", "TeleDirtyPlay", "EndGameNotes", "Won"});
                data.add(new String[]{"India", "New Delhi"});
                data.add(new String[]{"United States", "Washington D.C"});
                data.add(new String[]{"Germany", "Berlin"});

                writer.writeAll(data); // data is adding to csv

                writer.close();

            } catch (IOException e) {
                e.printStackTrace();

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage(e.getMessage());
                alertDialogBuilder.setTitle("File Save Error, Blame Josh");

                alertDialogBuilder.setNegativeButton("Okay", (dialog, which) -> {
                    finish();
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        }





}










/*
    public void FinalSave(View view) {

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
//the code after Bennett's code be like: https://www.youtube.com/watch?v=nC3jilxNyes
      //  final DataModel data = new DataModel();
  */


