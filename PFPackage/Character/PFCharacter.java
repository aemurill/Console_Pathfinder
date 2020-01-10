package PFPackage.Character;

import java.util.ArrayList;
import java.util.List;

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
    public PFClass characterClass = null;

    //SKILL RANKS
    public MySkillRanks characterSkills = new MySkillRanks();    

    //FEATS - keep track here, based off what's held and otther player stasts
    public FeatList characterFeats = new FeatList();

    //FC Class Options
    public List<FCBonus> characterFCoptions= new ArrayList<FCBonus>();
}