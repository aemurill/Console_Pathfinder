package PFPackage.Character;

import java.util.ArrayList;
import java.util.List;

import PFPackage.PFBooks.AlignmentEnum;
import PFPackage.PFBooks.DiceEnum;
import PFPackage.PFBooks.EntitySizeEnum;
import PFPackage.PFBooks.LanguageEnum;
import PFPackage.PFBooks.PFClasses.*;
import PFPackage.PFBooks.PFFeats.*;
import PFPackage.PFBooks.PFRaces.*;
import PFPackage.PFBooks.PFFavoredClassBonus.*;

public class PFCharacter {
    //BASE STATS
    public MyAbilityScore characterStats = new MyAbilityScore();    

    //CLASS
    public List<PFClass> characterClass = new ArrayList<PFClass>();    

    //RACE
    public PFRace characterRace = null;    

        //SIZE
    public EntitySizeEnum characterSize = null;

        //BASE SPEED
    public int characterBaseSpeed = -1;

        //LANGUANGES
    public List<LanguageEnum> characterLanguages = 
        new ArrayList<LanguageEnum>();

        //HD
    public DiceEnum characterHitDie = null;
        //HP
    public int maxHitPoints = 0;
    public int characterHitPoints = 0;

        //BAB
    public int characterBAB = 0;

        //Saves
    public int FortSave = 0;
    public int RefSave = 0;
    public int WillSave = 0;

    public int getCMB(){

        return 0;
    }

    public int getCMD(){
        return 0;
    }



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
    public List<AlignmentEnum> alignmentRestriction = new ArrayList<AlignmentEnum>();

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