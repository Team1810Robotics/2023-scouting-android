package com.example.scouting_2023;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
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
    String fileName = "/chargedUp-";
    //String filepath = (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + fileName); // change
    String filepath = (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + fileName);

    //Global access tp UI Elements
    //TODO: Add onChange/equivalent listeners to update these on update to set the bundle - access on submit
    public EditText txtTeamNum = (EditText)findViewById(R.id.IntroTeam);
    public EditText txtMatchNum= (EditText)findViewById(R.id.IntroRound);
    public Spinner spnAlliance= (Spinner)findViewById(R.id.IntroAlliance);
    public Spinner spnRole = (Spinner)findViewById(R.id.TeleopRoleDrop);
    public EditText txtNotes = (EditText)findViewById(R.id.EndgameNoteButton);
    public EditText txtScore = (EditText)findViewById(R.id.EndgameTotalScoreBox);
    public CheckBox chkLeftComm = (CheckBox)findViewById(R.id.AutoLeftCommunity);
    public CheckBox chkAutoDocked = (CheckBox)findViewById(R.id.AutoDocked);
    public CheckBox chkAutoEngaged = (CheckBox)findViewById(R.id.AutoEngaged);
    public CheckBox chkWin = (CheckBox)findViewById(R.id.EndgameDidTheyWinBox);
    public CheckBox chkDirty = (CheckBox)findViewById(R.id.TeleOpNaughtyCheck);
    public CheckBox chkEndgameDocked = (CheckBox)findViewById(R.id.EndgameDockedBox);
    public CheckBox chkEndgameEngaged = (CheckBox)findViewById(R.id.EndgameEngagedBox);
    public CheckBox chkCoopertition = (CheckBox)findViewById(R.id.EndgameCooperatitionBounusBox);








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
        increaseCone(R.id.TeleOpLowConeTicker, bundleValues.TeleOpLowConeTicker, conesUpperLimit);
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
        decreaseCone(R.id.TeleOpLowConeTicker, bundleValues.TeleOpLowConeTicker, conesLowerLimit);
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




    public void endgameSubmit(View view) {


        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
       final DataModel data = new DataModel();

        CSVWriter writer = null;
        //Populating the bundles

       // String tmpTeamIDX = findViewById(R.id.IntroTeam).toString();
        //IntroPage Bundle =String tmpMatchID = bundle.getString(bundleValues.IntroRoundNumber.toString(), 0);
     //   String tmpTeamID = bundle.getString(bundleValues.IntroTeamNumber.toString());
      //  String tmpAllianceColor = bundle.getString(bundleValues.IntroAllianceColor.toString());

        //AutoPage Bundle
        String tmpAutoHighCone = bundle.getString(bundleValues.AutoHighConesTicker.toString());
        String tmpAutoHighCube = bundle.getString(bundleValues.AutoHighCubeTicker.toString());
        String tmpAutoMidCone = bundle.getString(bundleValues.AutoMidConesTicker.toString());
        String tmpAutoMidCube = bundle.getString(bundleValues.AutoMidCubeTicker.toString());
        String tmpAutoLowCone = bundle.getString(bundleValues.AutoLowConesTicker.toString());
        String tmpAutoLowCube = bundle.getString(bundleValues.AutoLowCubeTicker.toString());
        String tmpAutoDocked = bundle.getString(bundleValues.AutoDocked.toString());
        String tmpAutoEngaged = bundle.getString(bundleValues.AutoEngaged.toString());
        String tmpAutoLeft = bundle.getString(bundleValues.AutoLeftCommunity.toString());

        Log.d("variable", "hi");

        // data.setMatchID(bundle.getInt(bundleValues.IntroRoundNumber.toString(), 0));

        /*    data.setTeamID(TeamNumbers.fromValue(bundle.getString(bundleValues.IntroTeamNumber.toString(), TeamNumbers.TEAM_245.toString())));
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
*/
        // Try is only for creating the file
        try {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            String currentFileName = filepath + uuidAsString + ".csv";
            writer = new CSVWriter(new FileWriter(currentFileName));
//change capitilazation
            List<String[]> outputdata = new ArrayList<String[]>();
            outputdata.add(new String[]{"MatchId", "TeamId", "Color", "AutoLowCone", "AutoLowCube", "AutoMidCone", "AutoMidCube", "AutoHighCone", "AutoHighCube", "AutoLeftComm", "AutoDocked", "AutoEngaged", "TeleLowCone", "TeleLowCube", "TeleMidCone", "TeleMidCube", "TeleHighCone", "TeleHighCube", "TeleInComm", "TeleDocked", "TeleEngaged", "TeleTeamRole", "TeleDirtyPlay", "EndGameNotes", "EndGamePoints", "EndGameCoopertition", "EndGameLinkLow", "EndGameLinkMid", "EndGameLinkHigh", "Won"});
            outputdata.add(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"});
            //confirmation message
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Press Okay to Return to Start, Thank a Programmer");
            alertDialogBuilder.setTitle("Submitted");

            writer.writeAll(outputdata); // data is adding to csv

            writer.close();
//          callRead();

            alertDialogBuilder.setNegativeButton("Okay", (dialog, which) -> {
                final Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        catch (IOException e) {
            e.printStackTrace();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(e.getMessage());
            alertDialogBuilder.setTitle("File Save Error, Blame Josh Van De Creek");

            alertDialogBuilder.setNegativeButton("Okay", (dialog, which) -> {
                finish();
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();


        }
        BundleUtils.resetBundleValues(bundle);
    }





}








