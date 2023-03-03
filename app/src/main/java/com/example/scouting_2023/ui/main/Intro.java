package com.example.scouting_2023.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.scouting_2023.DataModel;
import com.example.scouting_2023.MainActivity;
import com.example.scouting_2023.R;

public class Intro extends Fragment {
    public Intro() {
        // Required empty public constructor
    }
    private DataModel mViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intropage, container, false);
        EditText txtTeamNum = (EditText) view.findViewById(R.id.IntroTeam);
        EditText txtMatchNum= (EditText) view.findViewById(R.id.IntroRound);
        Spinner spnAlliance= (Spinner) view.findViewById(R.id.IntroAlliance);

        mViewModel = ((MainActivity) requireActivity()).getViewModel();

        return view;//
        // inflater.inflate(R.layout.intropage, container, false);
    }


}