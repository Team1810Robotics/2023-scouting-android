package com.example.scouting_2023;

import android.arch.lifecycle.ViewModel;

public class DataModel extends ViewModel {
//  Declare variables


//  Intro
    private int teamID;
    private String allianceColor;
    private int roundNumber;
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
        public int getRoundNumber() {
            return roundNumber;
        }
        public String getAllianceColor() {return allianceColor;}
        public int getTeamID() {
        return teamID;
    }
        //Auto
        public int getAutoLowCones() {return autoLowCones;}
        public int getAutoLowCubes() {return autoLowCubes;}
        public int getAutoMidCones() {return autoMidCones;}
        public int getAutoMidCubes() {return autoMidCubes;}
        public int getAutoHighCones(){return autoHighCones;}
        public int getAutoHighCubes(){return autoHighCubes;}
        public boolean autoLeftComm(){return autoLeftComm;}
        public boolean autoDocked()  {return autoDocked;}
        public boolean autoEngaged() {return autoEngaged;}
        //TeleOp
        public int getteleLowCones() {return teleLowCones;}
        public int getteleLowCubes() {return teleLowCubes;}
        public int getteleMidCones() {return teleMidCones;}
        public int getteleMidCubes() {return teleMidCubes;}
        public int getteleHighCones(){return teleHighCones;}
        public int getteleHighCubes(){return teleHighCubes;}
        public String getRole() {return Role;}
        public boolean getteleInComm() {return teleInComm;}
        public boolean getteleDocked() {return teleDocked;}
        public boolean getteleEndgaged() {return teleEngaged;}

        //EndGame
        public String getnotes(){return notes;}
        public boolean getwin(){return win;}
        public int getendgameHigh() {return endgameHigh;}
        public int getendgameMid()  {return endgameMid;}
        public int getendgameLow()  {return endgameLow;}
        public int getendgamePoints() {return endgamePoints;}
        public boolean getcoopertition(){return coopertition;}
    //Set Functions
        //Intro

        //Auto
        //TeleOp
        //Final
        //Intro
        public void setRoundNumber(final int roundNumber) {
            this.roundNumber = roundNumber;
        }
        public void setAllianceColor(final int AllianceColor) {this.allianceColor = allianceColor;}
        public void setTeamID(final int TeamID) {this.teamID = TeamID;}
        public void setautoLowCones(final int autoLowCones) {this.autoLowCones = autoLowCones;}
        public void setautoLowCubes(final int autoLowCubes) {this.autoLowCubes = autoLowCubes;}
        public void setautoMidCones(final int autoMidCones) {this.autoMidCones = autoMidCones;}
        public void setautoMidCubes(final int autoMidCubes) {this.autoMidCubes = autoMidCubes;}
        public void setautoHighCones(final int autoHighCones) {this.autoHighCones = autoHighCones;}
        public void setautoHighCubes(final int autoHighCubes) {this.autoHighCubes = autoHighCubes;}

        public void setautoLeftComm(final boolean autoLeftComm) {this.autoLeftComm = autoLeftComm;}
        public void setautoDocked(final boolean autoDocked) {this.autoDocked = autoDocked;}
        public void setautoEngaged(final boolean autoEngaged) {this.autoEngaged = autoEngaged;}

        //TeleOp
        public void setteleLowCones(final int teleLowCones) {this.teleLowCones = teleLowCones;}
        public void setteleLowCubes(final int teleLowCubes) {this.teleLowCubes = teleLowCubes;}
        public void setteleMidCones(final int teleMidCones) {this.teleMidCones = teleMidCones;}
        public void setteleMidCubes(final int teleMidCubes) {this.teleMidCubes = teleMidCubes;}
        public void setteleHighCones(final int teleHighCones) {this.teleHighCones = teleHighCones;}
        public void setteleHighCubes(final int teleHighCubes) {this.teleHighCubes = teleHighCubes;}

        public void setRole(final String Role) {this.Role = Role;}
        public void setdirty(final boolean dirty) {this.dirty = dirty;}
        public void setTeleInComm(final boolean teleInComm) {this.teleInComm = teleInComm;}
        public void setteleDocked(final boolean teleDocked) {this.teleDocked = teleDocked;}
        public void setteleEngaged(final boolean teleEngaged) {this.teleEngaged = teleEngaged;}
    //Endgame

        public void setendgameLow(final int endgameLow) {this.endgameLow = endgameLow;}
        public void setendgameMid(final int endgameMid) {this.endgameMid = endgameMid;}
        public void setendgameHigh(final int endgameHigh) {this.endgameHigh = endgameHigh;}
        public void setendgamePoints(final int endgamePoints) {this.endgamePoints = endgamePoints;}

        public void setnotes(final String notes) {this.notes = notes;}
        public void setwin(final boolean win){this.win = win;}
        public void setcoopertition(final boolean coopertition){this.coopertition = coopertition;}


}
