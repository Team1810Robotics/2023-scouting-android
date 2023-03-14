package com.example.scouting_2023.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.scouting_2023.DataModel;

import java.io.Serializable;

public class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    DataModel data;
    Bundle arguments;
    public MyAdapter(Context c, FragmentManager fm, int totalTabs, DataModel data) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
        this.data = data;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Intro introPage = new Intro();
                // Create a new FragmentB and pass in the myDataObject instance as an argument
                arguments = new Bundle();
                arguments.putSerializable("data", (Serializable) data);
                introPage.setArguments(arguments);
                return introPage;
            case 1:
                Auto autoPage = new Auto();
                // Create a new FragmentB and pass in the myDataObject instance as an argument
                arguments = new Bundle();
                arguments.putSerializable("data", (Serializable) data);
                autoPage.setArguments(arguments);
                return autoPage;
            case 2:
                TeleOp teleOpPage = new TeleOp();
                // Create a new FragmentB and pass in the myDataObject instance as an argument
                arguments = new Bundle();
                arguments.putSerializable("data", (Serializable) data);
                teleOpPage.setArguments(arguments);
                return teleOpPage;
            case 3:
                EndGame endGameFragment = new EndGame();
                arguments = new Bundle();
                arguments.putSerializable("data", (Serializable) data);
                endGameFragment.setArguments(arguments);
                return endGameFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}