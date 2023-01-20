package com.example.scouting_2023.ui.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
public class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Intro introPage = new Intro();
                return introPage;
            case 1:
                Auto autoPage = new Auto();
                return autoPage;
            case 2:
                TeleOp teleOpPage = new TeleOp();
                return teleOpPage;
            case 3:
                EndGame endGameFragment = new EndGame();
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