package PFPackage.Character;

import PFPackage.PFBooks.PFClasses.*;
import PFPackage.PFBooks.PFFeats.FeatList;

public class PFCharacter {
    //BASE STATS
    public MyAbilityScore characterStats = new MyAbilityScore();
    
    //SKILL RANKS
    public MySkillRanks characterSkills = new MySkillRanks();

    //CLASS
    public PFClass characterClass = null;

    //FEATS - keep track here, based off what's held and otther player stasts
    public FeatList characterFeats = new FeatList();
}