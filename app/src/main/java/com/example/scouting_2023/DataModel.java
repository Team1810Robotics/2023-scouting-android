package com.example.scouting_2023;

public class DataModel {
//  Declare variables


//  Intro
    private int teamID;
    private String allianceColor;
    private int roundNumbers;
//  Auto
    private int autoLowCones;
    private int autoLowCubes;
    private int autoMidCones;
    private int autoMidCubes;
    private int autoHighCones;
    private int autoHighCubes;
    private boolean autoLeftComm;
    private boolean autoDocked;
    private boolean autoEngaged;
//  TeleOp
    private int teleLowCones;
    private int teleLowCubes;
    private int teleMidCones;
    private int teleMidCubes;
    private int teleHighCones;
    private int teleHighCubes;
    private boolean teleInComm;
    private boolean teleDocked;
    private boolean teleEngaged;
    private String Role;
    private boolean dirty;
//  EndGame
    private String notes;
    private boolean win;
    private int endgameHigh;
    private int endgameMid;
    private int endgameLow;
    private int endgamePoints;
    private boolean coopertition;



    //Get functions

        //Intro
        public int getRoundNumbers() {
            return roundNumbers;
        }
        public String getAllianceColor() {return allianceColor;}
        public int getTeamID() {
        return teamID;
    }
        //Auto
        public int getAutoLowCones() {
            return autoLowCones;
        }
        public int getAutoLowCubes() {
            return autoLowCubes;
        }
        //TeleOp
        //EndGame
    //Set Functions

}
