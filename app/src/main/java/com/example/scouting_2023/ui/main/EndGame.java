package com.example.scouting_2023.ui.main;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.example.scouting_2023.MainActivity;
import com.example.scouting_2023.R;
import com.example.scouting_2023.bundleValues;
import com.opencsv.CSVWriter;

public class EndGame extends Fragment {
    public EndGame() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.endgamepage, container, false);

    }
 }


