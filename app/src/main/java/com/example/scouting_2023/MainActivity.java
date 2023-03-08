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

    //Global access to UI Elements
    private DataModel data;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
       // setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        try {
            // Get a reference to the singleton instance of DataSingleton
            DataModelDAO dataSingleton = DataModelDAO.getInstance();

            // Set any initial data for your data object
            DataModel data = dataSingleton.getMyDataObject();


            // Save the initial data back to the singleton instance
            DataModelDAO.setMyDataObject(data);
        }
        catch(Exception e){
            e.printStackTrace();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(e.getMessage());
            alertDialogBuilder.setTitle("File Save Error, Blame Google");

            alertDialogBuilder.setNegativeButton("Okay", (dialog, which) -> {
                finish();
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }



        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final MyAdapter adapter = new MyAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount(), data);
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


       // mViewModel = new ViewModelProvider(this,this);

    }


        //mathmatics
        int conesUpperLimit = 9;
        int conesLowerLimit = 0;


//Reinstatiate the data object
public void createDAO(){

    // Get a reference to the singleton instance of DataSingleton
    DataModelDAO dataSingleton = DataModelDAO.getInstance();
    // Set any initial data for your data object
    DataModel data = dataSingleton.getMyDataObject();
    // Save the initial data back to the singleton instance
    DataModelDAO.setMyDataObject(data);
}

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
        DataModelDAO dataModelDAO = DataModelDAO.getInstance();
        // Get a reference to the data object
        DataModel data = dataModelDAO.getMyDataObject();


        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }



        //TODO: Finish all of the variables

        //IntroPage Bundle
        String tmpMatchID = data.getRoundNumber();
        String tmpTeamID = data.getTeamID();
        String tmpAllianceColor = data.getAllianceColor();


        //AutoPage Bundle

        int tempAutoHighCone = bundle.getInt(String.valueOf(bundleValues.AutoHighConesTicker),0);
        int tempAutoHighCube = bundle.getInt(String.valueOf(bundleValues.AutoHighCubeTicker),0);
        int tempAutoMidCone = bundle.getInt(bundleValues.AutoMidConesTicker.toString(),0);
        int tempAutoMidCube = bundle.getInt(bundleValues.AutoMidCubeTicker.toString(),0);
        int tempAutoLowCone = bundle.getInt(bundleValues.AutoLowConesTicker.toString(),0);
        int tempAutoLowCube = bundle.getInt(bundleValues.AutoLowCubeTicker.toString(),0);
        String tmpAutoHighCone = String.valueOf(tempAutoHighCone);
        String tmpAutoHighCube = String.valueOf(tempAutoHighCube);
        String tmpAutoMidCone = String.valueOf(tempAutoMidCone);
        String tmpAutoMidCube = String.valueOf(tempAutoMidCube);
        String tmpAutoLowCone = String.valueOf(tempAutoLowCone);
        String tmpAutoLowCube = String.valueOf(tempAutoLowCube);
        String tmpAutoLeft = String.valueOf(data.getAutoLeftComm());
        String tmpAutoDocked = String.valueOf(data.getAutoDocked());
        String tmpAutoEngaged = String.valueOf(data.getAutoEngaged());



        //TeleOp
        int tempTeleOpHighCone = bundle.getInt(String.valueOf(bundleValues.TeleOpHighConeTicker),0);
        int tempTeleOpHighCube = bundle.getInt(String.valueOf(bundleValues.TeleOpHighCubeTicker),0);
        int tempTeleOpMidCone = bundle.getInt(String.valueOf(bundleValues.TeleOpMidConeTicker),0);
        int tempTeleOpMidCube = bundle.getInt(String.valueOf(bundleValues.TeleOpMidCubeTicker),0);
        int tempTeleOpLowCone = bundle.getInt(String.valueOf(bundleValues.TeleOpLowConeTicker),0);
        int tempTeleOpLowCube = bundle.getInt(String.valueOf(bundleValues.TeleOpLowCubeTicker),0);

        String tmpTeleOpHighCone = String.valueOf(tempTeleOpHighCone);
        String tmpTeleOpHighCube = String.valueOf(tempTeleOpHighCube);
        String tmpTeleOpMidCone = String.valueOf(tempTeleOpMidCone);
        String tmpTeleOpMidCube = String.valueOf(tempTeleOpMidCube);
        String tmpTeleOpLowCone = String.valueOf(tempTeleOpLowCone);
        String tmpTeleOpLowCube = String.valueOf(tempTeleOpLowCube);

        String tmpTeleOpRoleDrop = data.getRole();
        String tmpTeleOpNaughtyCheck= String.valueOf(data.getDirty());


        //Endgame
        int tempEndgameHighLink = bundle.getInt(String.valueOf(bundleValues.EndgameHighLinkTicker),0);
        int tempEndgameMidLink = bundle.getInt(String.valueOf(bundleValues.EndgameMidLinkTicker),0);
        int tempEndgameLowLink = bundle.getInt(String.valueOf(bundleValues.EndgameLowLinkTicker),0);
        String tmpEndgameHighLink = String.valueOf(tempEndgameHighLink);
        String tmpEndgameMidLink = String.valueOf(tempEndgameMidLink);
        String tmpEndgameLowLink = String.valueOf(tempEndgameLowLink);

        String tmpEndgameTotalScoreBox = String.valueOf(data.getendgamePoints());
        String tmpEndgameNotes = String.valueOf(data.getnotes());
        String tmpEndgameCoopertitionBonusBox = String.valueOf(data.getcoopertition());
        String tmpEndgameDidTheyWinBox = String.valueOf(data.getwin());
        String tmpEndgameDockedBox = String.valueOf(data.getendgameDocked());
        String tmpEndgameEngagedBox= String.valueOf(data.getendgameEngaged());




       

        CSVWriter writer = null;
        //Populating the bundles





        Log.d("variable", "hi");
        Log.d("Low Cone", tmpAutoLowCone);
        // data.setMatchID(bundle.getInt(bundleValues.IntroRoundNumber.toString(), 0));


        // Try is only for creating the file

        try {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            String currentFileName = filepath + uuidAsString + ".csv";
            writer = new CSVWriter(new FileWriter(currentFileName));
//change capitilazation

            List<String[]> outputdata = new ArrayList<String[]>();
            outputdata.add(new String[]{"MatchId", "TeamId", "Color", "AutoLowCone", "AutoLowCube", "AutoMidCone", "AutoMidCube", "AutoHighCone", "AutoHighCube", "AutoLeftComm", "AutoDocked", "AutoEngaged", "TeleLowCone", "TeleLowCube", "TeleMidCone", "TeleMidCube", "TeleHighCone", "TeleHighCube", "TeleTeamRole", "TeleDirtyPlay", "EndGameNotes", "EndGamePoints", "EndGameCoopertition", "EndGameLinkLow", "EndGameLinkMid", "EndGameLinkHigh", "Won"});
            outputdata.add(new String[]{tmpMatchID, tmpTeamID, tmpAllianceColor, tmpAutoLowCone, tmpAutoLowCube, tmpAutoMidCone, tmpAutoMidCube, tmpAutoHighCone, tmpAutoHighCube, tmpAutoLeft, tmpAutoDocked, tmpAutoEngaged, tmpTeleOpLowCone, tmpTeleOpLowCube, tmpTeleOpMidCone, tmpTeleOpMidCube, tmpTeleOpHighCone, tmpTeleOpHighCube, tmpTeleOpRoleDrop, tmpTeleOpNaughtyCheck, tmpEndgameNotes, tmpEndgameTotalScoreBox, tmpEndgameCoopertitionBonusBox, tmpEndgameLowLink, tmpEndgameMidLink, tmpEndgameHighLink, tmpEndgameDidTheyWinBox, tmpEndgameDockedBox, tmpEndgameEngagedBox});
            //confirmation message

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Press Okay to Return to Start, Thank a Programmer");
            alertDialogBuilder.setTitle("Submitted");

            writer.writeAll(outputdata); // data is adding to csv
            writer.close();


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

        //Reset the bundle values
        BundleUtils.resetBundleValues(bundle);
        //reset the dataobject
        dataModelDAO.destroyMyDataObject();
        //Create a new instance
        DataModel newObj = dataModelDAO.getMyDataObject();

        //Go back to the home tab
        setContentView(R.layout.intropage);

    }


}

//Noah's updateds 3/1/23
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(currentFileName))) {
//            for (var row : data) {
//                writer.write(String.join(",", row) + "\n");
//            }
//            writer = new CSVWriter(new FileWriter(currentFileName));
////change capitilazation
//            List<String[]> data = new ArrayList<String[]>();
//            List().add(new Number[]{1,2,2,3});
//            //confirmation message
//
//            writer.writeAll(data); // data is adding to csv
//
//            writer.close();
//          callRead();



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


    /*String[] submitVariable = new String[]{tmpMatchID, tmpTeamID, tmpAllianceColor,
                tmpAutoLowCone, tmpAutoLowCube, tmpAutoMidCone, tmpAutoMidCube, tmpAutoHighCone,
                tmpAutoHighCube};

        String[] headers = new String[]{"MatchId", "TeamId", "Color", "AutoLowCone", "AutoLowCube",
                "AutoMidCone", "AutoMidCube", "AutoHighCone", "AutoHighCube", "AutoLeftComm",
                "AutoDocked", "AutoEngaged", "TeleLowCone", "TeleLowCube", "TeleMidCone",
                "TeleMidCube", "TeleHighCone", "TeleHighCube", "TeleLeftComm", "TeleDocked",
                "TeleEngaged", "TeleTeamRole", "TeleDirtyPlay", "EndgameLowLink", "EndGameMidLink",
                "EndGameHighLink", "EndGameScore", "EndgameCoopertition","EndgameDocked",
                "EndgameEngaged","EndGameNotes", "Won"};

        int listLength = submitVariable.length;

        for (int i = 0; i < listLength; i++) {
            try {
                Log.d("didItWork", "yea :D");
                Log.d("" + headers[i+3], "" + submitVariable[i]);
            } catch (Exception e) {
                Log.d("didItWork", headers[i+3] + " can't be printed :/");
            }
        }
*/

// String tmpTeamIDX = findViewById(R.id.IntroTeam).toString();
//IntroPage Bundle =String tmpMatchID = bundle.getString(bundleValues.IntroRoundNumber.toString(), 0);
//   String tmpTeamID = bundle.getString(bundleValues.IntroTeamNumber.toString());
//  String tmpAllianceColor = bundle.getString(bundleValues.IntroAllianceColor.toString());
//   String tmpTeamID = txtTeamNum.toString();txtMatchNum
//  String tmpMatchID = txtMatchNum.toString();


    //AutoPage Bundle
    /*String tmpAutoHighCone = bundle.getString(bundleValues.AutoHighConesTicker.toString(), String.valueOf(0));
    String tmpAutoHighCube = bundle.getString(bundleValues.AutoHighCubeTicker.toString(), String.valueOf(0));
    String tmpAutoMidCone = bundle.getString(bundleValues.AutoMidConesTicker.toString(), String.valueOf(0));
    String tmpAutoMidCube = bundle.getString(bundleValues.AutoMidCubeTicker.toString(), String.valueOf(0));
    String tmpAutoLowCone = bundle.getString(bundleValues.AutoLowConesTicker.toString(), String.valueOf(0));
    String tmpAutoLowCube = bundle.getString(bundleValues.AutoLowCubeTicker.toString(), String.valueOf(0));
    String tmpAutoDocked = bundle.getString(bundleValues.AutoDocked.toString(), String.valueOf(0));
    String tmpAutoEngaged = bundle.getString(bundleValues.AutoEngaged.toString(), String.valueOf(0));
    String tmpAutoLeft = bundle.getString(bundleValues.AutoLeftCommunity.toString(), String.valueOf(0));
    */
