package com.example.scouting_2023.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.scouting_2023.MainActivity;
import com.example.scouting_2023.R;

public class EndGame extends Fragment {


    public EndGame() {
        // Required empty public constructor
    }

    private Button mEndgameSubmitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.endgamepage, container, false);

        // Get a reference to the button in the layout
        mEndgameSubmitButton = view.findViewById(R.id.EndgameSubmitButton);

        // Set an OnClickListener for the button
        mEndgameSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the function in MainActivity.java
                ((MainActivity)getActivity()).endgameSubmit(v);
            }
        });

        return view;
    }

    // return inflater.inflate(R.layout.endgamepage, container, false);

}



