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

    int cone;
    int cube;
    int links;
    int ticker;
    int conesLimit = 9;
    int cubesLimit = 9;


    //TODO need to make a working enum for buttons
    public void incrementCone(int id, bundleValues bundleLocation, int conesLimit) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();

        if (bundle == null) {
            bundle = new Bundle();

            bundle.putInt(bundleLocation.toString(), cone);
            i.putExtras(bundle);
        }

        if (cone < conesLimit) {
            cone++;
            final TextView displayCones = findViewById(id);
            displayCones.setText("" + cone);

        }
    }

    public void endgameSubmit(View view) {
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
            CSVWriter writer = null;
            //Populating the bundles

            //IntroPage Bundle
            data.setMatchID(bundle.getInt(bundleValues.IntroRoundNumber.toString(), 0));
            data.setTeamID(TeamNumbers.fromValue(bundle.getString(bundleValues.IntroTeamNumber.toString(), TeamNumbers.TEAM_245.toString())));
            data.setAllianceColor(TeamColors.forLabel(bundle.getString(bundleValues.IntroAllianceColor.toString(), TeamColors.BLUE.toString())));

            //Auto Page Bundle
            data.setAutoHighCone(bundle.getInt(bundleValues.AutoHighConesTicker.toString(), 0));
            data.setAutoHighCube(bundle.getInt(bundleValues.AutoHighCubeTicker.toString(), 0));
            data.setAutoMidCone(bundle.getInt(bundleValues.AutoMidConesTicker.toString(), 0));
            data.setAutoMidCube(bundle.getInt(bundleValues.AutoMidCubeTicker.toString(), 0));
            data.setAutoLowCone(bundle.getInt(bundleValues.AutoLowConesTicker.toString(), 0));
            data.setAutoLowCube(bundle.getInt(bundleValues.AutoLowCubeTicker.toString(), 0));
            data.setAutoDocked(bundle.getBoolean(bundleValues.AutoDocked.toString(), false));
            data.setAutoEngaged(bundle.getBoolean(bundleValues.AutoEngaged.toString(), false));
            data.setAutoLeft(bundle.getBoolean(bundleValues.AutoLeftCommunity.toString(), false));

            //TeleOp Page Bundle
            data.setTeleOpHighCone(bundle.getInt(bundleValues.TeleOpHighConeTicker.toString(), 0));
            data.setTeleOpHighCube(bundle.getInt(bundleValues.TeleOpHighCubeTicker.toString(), 0));
            data.setTeleOpMidCone(bundle.getInt(bundleValues.TeleOpMidConeTicker.toString(), 0));
            data.setTeleOpMidCube(bundle.getInt(bundleValues.TeleOpMidCubeTicker.toString(), 0));
            data.setTeleOpLowCone(bundle.getInt(bundleValues.TeleOpLowConeTicker.toString(), 0));
            data.setTeleOpLowCube(bundle.getInt(bundleValues.TeleOpLowCubeTicker.toString(), 0));
            data.setTeleOpRole(BarGrabPosition.fromValue(bundle.getString(bundleValues.TeleOpRoleDrop.toString(), BarGrabPosition.NONE.toString())));
            data.setTeleOpNaughty(bundle.getBoolean(bundleValues.TeleOpNaughtyCheck.toString(), false));

            //EndGame Page Bundle
            data.setEndgameHighLink(bundle.getInt(bundleValues.EndgameHighLinkTicker.toString(), 0));
            data.setEndgameMidLink(bundle.getInt(bundleValues.EndgameMidLinkTicker.toString(), 0));
            data.setEndgameLowLink(bundle.getInt(bundleValues.EndgameLowLinkTicker.toString(), 0));
            data.setEndgameDocked(bundle.getBoolean(bundleValues.EndgameDockedBox.toString(), false));
            data.setEndgameEngaged(bundle.getBoolean(bundleValues.EndgameEngagedBox.toString(), false));
            data.setEndgameWin(bundle.getBoolean(bundleValues.EndgameDidTheyWinBox.toString(), false));
            data.setEndgameScore(bundle.getInt(bundleValues.EndgameTotalScoreBox.toString(), 0));
            data.setEndgameCoopertition(bundle.getBoolean(bundleValues.EndgameCooperatitionBounusBox.toString(), false));

            // Try is only for creating the file
            try {
                UUID uuid = UUID.randomUUID();
                String uuidAsString = uuid.toString();
                String currentFileName = filepath + uuidAsString + ".csv";
                writer = new CSVWriter(new FileWriter(currentFileName));

                List<String[]> data = new ArrayList<String[]>();
                data.add(new String[]{"MatchId", "TeamId", "Color", "AutoLowCone", "AutoLowCube", "AutoMidCone", "AutoMidCube", "AutoHighCone", "AutoHighCube", "AutoLeftComm", "AutoDocked", "AutoEngaged", "TeleLowCone", "TeleLowCube", "TeleMidCone", "TeleMidCube", "TeleHighCone", "TeleHighCube", "TeleLeftComm", "TeleDocked", "TeleEngaged", "TeleTeamRole", "TeleDirtyPlay", "EndGameNotes", "Won"});
                data.add(new String[]{"India", "New Delhi"});
    }
        //mathmatics
        int cone;
        int cube;
        int links;
        int ticker;
        int conesLimit = 9;
        int cubesLimit = 9;





        //TeleOp Page
    public void incrementTeleOpLowerCone(View view){
        increaseCone(R.id.TeleOpLowConesTicker, bundleValues.TeleOpLowConesTicker, conesLimit);
    }

    public void incrementTeleOpMiddleCone(View view){
        increaseCone(R.id.TeleOpMidConeTicker, bundleValues.TeleOpMidConeTicker, conesLimit);
    }

    public void incrementTeleOpHighCone(View view){
        increaseCone(R.id.TeleOpHighConeTicker, bundleValues.TeleOpHighConeTicker, conesLimit);
    }



    public void incrementTeleOpLowCube(View view){
        increaseCone(R.id.TeleOpLowCubesTicker, bundleValues.TeleOpLowCubeTicker, conesLimit);
    }

    public void incrementTeleOpMidCube(View view){
        increaseCone(R.id.TeleOpMidCubeTicker, bundleValues.TeleOpMidCubeTicker, conesLimit);
    }

    public void incrementTeleOpHighCube(View view){
        increaseCone(R.id.TeleOpHighCubeTicker, bundleValues.TeleOpHighCubeTicker, conesLimit);
    }

    //Auto page
    public void incrementAutoLowerCone(View view){
        increaseCone(R.id.AutoLowConeTicker, bundleValues.AutoLowConesTicker, conesLimit);
    }

    public void incrementAutoMiddleCone(View view){
        increaseCone(R.id.AutoMidConeTicker, bundleValues.AutoMidConesTicker, conesLimit);
    }

    public void incrementAutoHighCone(View view){
        increaseCone(R.id.AutoHighConeTicker, bundleValues.AutoHighConesTicker, conesLimit);
    }



    public void incrementAutoLowCube(View view){
        increaseCone(R.id.AutoLowCubesTicker, bundleValues.AutoLowCubeTicker, conesLimit);
    }

    public void incrementAutoMidCube(View view){
        increaseCone(R.id.AutoMidCubeTicker, bundleValues.AutoMidCubeTicker, conesLimit);
    }

    public void incrementAutoHighCube(View view){
        increaseCone(R.id.AutoHighCubeTicker, bundleValues.AutoHighCubeTicker, conesLimit);
    }



    public void incrementEndgameLowLink(View view){
        increaseCone(R.id.EndgameLowLinkTicker, bundleValues.EndgameLowLinkTicker, conesLimit);
    }

    public void incrementEndgameMidLink(View view){
        increaseCone(R.id.EndgameMidLinkTicker, bundleValues.EndgameMidLinkTicker, conesLimit);
    }

    public void incrementEndgameHighLink(View view){
        increaseCone(R.id.EndgameHighLinkTicker, bundleValues.EndgameHighLinkTicker, conesLimit);
    }


    //TODO figure out how to make buttons work in csv. Also need to do intro









        public void increaseCone(int id, bundleValues bundleLocation ,int conesLimit){
            final Intent i = getIntent();
            Bundle bundle = i.getExtras();
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putInt(bundleLocation.toString(), cone);
                i.putExtras(bundle);
            }

            if (cone < conesLimit) {
                cone++;
                final TextView displayCones = findViewById(id);
                displayCones.setText("" + cone);

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
}











