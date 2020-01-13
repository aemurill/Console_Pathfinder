package PFPackage.Character;

import java.util.ArrayList;
import java.util.List;

import PFPackage.PFBooks.AlignmentEnum;
import PFPackage.PFBooks.PFClasses.*;
import PFPackage.PFBooks.PFFeats.*;
import PFPackage.PFBooks.PFRaces.*;
import PFPackage.PFBooks.PFFavoredClassBonus.*;

public class PFCharacter {
    //BASE STATS
    public MyAbilityScore characterStats = new MyAbilityScore();
    
    //CLASS
    public PFRace characterRace = null;

    //CLASS
    public List<PFClass> characterClass = new ArrayList<PFClass>();

    //SKILL RANKS
    public MySkillRanks characterSkills = new MySkillRanks();    

    //FEATS - keep track here, based off what's held and otther player stasts
    //GET ONE EVERY ODD LEVEL + anything from classes or whatever
    public FeatList characterFeats = new FeatList();
    //Class feats?
        //Domain
        //School
        //Bloodline

    //FC Class Options
    public List<FCBonus> characterFCoptions= new ArrayList<FCBonus>();

    //Alignment
    public AlignmentEnum alignment = null;

    //SPELlS IF ARCANE OR SOMETHING

    //GEAR
        //USABILITY DEPENDS ON FEATS / RESTRICTIONS
        //WEAPONS 
        //ETC
    
        //AC STUFF RELATED TO GEAR
            //BONUSES, TYPE, CHECK, SPELL FAILURE, EWIGHT, PROPERTIES
            //SPEED REDUCTION
            //AC CALCULATIONS?

        //ATTACK TYPES, etc

    /* AC = 10 + Armor Bonus + Shield Bonus +
         DEXm + SIZEm + NatArmM + DeflectM + MiscMod
       Touch AC = 10 + DEXm + Deflection
       Flat Foot AC = Touch AC - DEXm
    */
}