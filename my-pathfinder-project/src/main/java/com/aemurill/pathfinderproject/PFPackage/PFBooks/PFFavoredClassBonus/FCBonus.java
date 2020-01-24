package com.aemurill.pathfinderproject.PFPackage.PFBooks.PFFavoredClassBonus;

import com.aemurill.pathfinderproject.PFPackage.PFBooks.PFFeats.Function;
import com.aemurill.pathfinderproject.PFPackage.PFBooks.PFRaces.PFRaceName;

public class FCBonus {
    
    //More can be added but stop here pls
    private String fcBonusName;
    private PFRaceName fcRace;
    private String fcBonusDesc;
    private Function fcBonus;
    private String fcSource;


    public FCBonus(String fcBonusName, PFRaceName fcRace,
     String fcBonusDesc, Function fcBonus, String fcSource){
        this.fcBonusName = fcBonusName;
        this.fcRace = fcRace;
        this.fcBonusDesc = fcBonusDesc;
        this.fcBonus = fcBonus;
        this.fcSource = fcSource;
    }

    /*@Override
    public boolean equals(Object o){
        System.out.println("D: pre");
        if(o == this) return true; //self
        System.out.println("D: not self");
        if(!(o instanceof String)) return false; //is Feat?
        System.out.println("D: o not string");
        if(this.fcBonusName.equals(o)){
            System.out.println("D: Success?");
            return true;
        }
        System.out.println("D: string not equals");
        return false;
    }*/

    public static boolean handleUnimplemented(){
        System.out.println("WARNING: FCBONUS UNIMPLEMENTED");
        return false;
    } 

    @Override
    public String toString() {
        return this.fcBonusName;
    }

    public PFRaceName getRace() {
        return this.fcRace;
    }

    public String getBonusDesc() {
        return this.fcBonusDesc;
    }

    public Function getBonus() {
        return this.fcBonus;
    }

    public String getSource() {
        return this.fcSource;
    }
} 