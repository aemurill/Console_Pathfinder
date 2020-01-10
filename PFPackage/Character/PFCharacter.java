package PFPackage.Character;

import java.util.ArrayList;
import java.util.List;

import PFPackage.PFBooks.PFClasses.*;
import PFPackage.PFBooks.PFFeats.Feat;

public class PFCharacter {
    //BASE STATS
    public MyAbilityScore characterStats = new MyAbilityScore();
    
    //SKILL RANKS
    public MySkillRanks characterSkills = new MySkillRanks();

    //CLASS
    public PFClass characterClass = null;

    //FEATS - keep track here, based off what's held and otther player stasts
    public List<Feat> characterFeats = new ArrayList<Feat>(0);
}