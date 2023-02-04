package com.example.scouting_2023;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.example.scouting_2023.ui.main.MyAdapter;
import com.example.scouting_2023.ui.main.SectionsPagerAdapter;
import com.example.scouting_2023.databinding.ActivityMainBinding;
import com.opencsv.CSVWriter;

import java.io.FileWriter;

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

            //      public void incrementUpperCone() {

            //      }
        });
    }
            public void endgameSubmit(View view) {

                CSVWriter writer = null;
                try {
                    UUID uuid = UUID.randomUUID();
                    String uuidAsString = uuid.toString();
                    String currentFileName = filepath + uuidAsString + ".csv";
                    writer = new CSVWriter(new FileWriter(currentFileName));

                    List<String[]> data = new ArrayList<String[]>();
                    data.add(new String[]{"MatchId", "TeamId", "Color", "AutoLowCone","AutoLowCube","AutoMidCone","AutoMidCube","AutoHighCone","AutoHighCube","AutoLeftComm","AutoDocked","AutoEngaged","TeleLowCone","TeleLowCube","TeleMidCone","TeleMidCube","TeleHighCone","TeleHighCube","TeleLeftComm","TeleDocked","TeleEngaged","TeleTeamRole","TeleDirtyPlay","EndGameNotes","Won"});
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
//test comment
      //  final DataModel data = new DataModel();
  */


