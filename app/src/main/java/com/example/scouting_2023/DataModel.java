package com.example.scouting_2023;

import android.arch.lifecycle.ViewModel;

public class DataModel extends ViewModel {
//  Declare variables
    //  Intro
        private String teamID = "";
        private String allianceColor ="";
        private String roundNumber = "";
    //  Auto
        private int autoLowCones = 0;
        private int autoLowCubes = 0;
        private int autoMidCones = 0;
        private int autoMidCubes = 0;
        private int autoHighCones = 0;
        private int autoHighCubes = 0;
        private boolean autoLeftComm = false;
        private boolean autoDocked= false;
        private boolean autoEngaged = false;
    //  TeleOp
        private int teleLowCones = 0;
        private int teleLowCubes=0;
        private int teleMidCones=0;
        private int teleMidCubes=0;
        private int teleHighCones=0;
        private int teleHighCubes=0;
        private boolean teleInComm=false;
        private boolean teleDocked=false;
        private boolean teleEngaged=false;
        private String Role="";
        private boolean dirty = false;
    //  EndGame
        private String notes ="";
        private boolean win = false;
        private int endgameHigh = 0;
        private int endgameMid =0;
        private int endgameLow=0;
        private String endgamePoints="";
        private boolean coopertition =false;

        private boolean endgameDocked= false;

        private boolean endgameEngaged = false;



    //Get functions

        //Intro
        public String getRoundNumber() {
            return this.roundNumber;
        }
        public String getAllianceColor() {return this.allianceColor;}
        public String getTeamID() {
        return this.teamID;
    }
        //Auto
        public int getAutoLowCones() {return autoLowCones;}
        public int getAutoLowCubes() {return autoLowCubes;}
        public int getAutoMidCones() {return autoMidCones;}
        public int getAutoMidCubes() {return autoMidCubes;}
        public int getAutoHighCones(){return autoHighCones;}
        public int getAutoHighCubes(){return autoHighCubes;}
        public boolean getAutoLeftComm(){return autoLeftComm;}
        public boolean getAutoDocked()  {return autoDocked;}
        public boolean getAutoEngaged() {return autoEngaged;}
        //TeleOp
        public int getteleLowCones() {return teleLowCones;}
        public int getteleLowCubes() {return teleLowCubes;}
        public int getteleMidCones() {return teleMidCones;}
        public int getteleMidCubes() {return teleMidCubes;}
        public int getteleHighCones(){return teleHighCones;}
        public int getteleHighCubes(){return teleHighCubes;}
        public String getRole() {return Role;}

        public boolean getDirty() {return dirty;}
        public boolean getteleInComm() {return teleInComm;}
        public boolean getteleDocked() {return teleDocked;}
        public boolean getteleEndgaged() {return teleEngaged;}

        //EndGame
        public String getnotes(){return notes;}
        public boolean getwin(){return win;}
        public int getendgameHigh() {return endgameHigh;}
        public int getendgameMid()  {return endgameMid;}
        public int getendgameLow()  {return endgameLow;}
        public String getendgamePoints() {return endgamePoints;}
        public boolean getcoopertition(){return coopertition;}
        public boolean getendgameDocked(){return endgameDocked;}
        public boolean getendgameEngaged(){return endgameEngaged;}
    //Set Functions
        //Intro

        //Auto
        //TeleOp
        //Final
        //Intro
        public void setRoundNumber(final String roundNumber) {this.roundNumber = roundNumber;}
        public void setAllianceColor(final String allianceColor) {this.allianceColor = allianceColor;}
        public void setTeamID(final String TeamID) {this.teamID = TeamID;}
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
        public void setendgamePoints(final String endgamePoints) {this.endgamePoints = endgamePoints;}

        public void setnotes(final String notes) {this.notes = notes;}
        public void setwin(final boolean win){this.win = win;}
        public void setcoopertition(final boolean coopertition){this.coopertition = coopertition;}
        public void setEndgameDocked(final boolean endgameDocked){this.endgameDocked = endgameDocked;}
        public void setEndgameEngaged(final boolean endgameEngaged){this.endgameEngaged = endgameEngaged;}




}
