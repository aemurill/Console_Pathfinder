package PFPackage.PFBooks.PFClasses;

import java.util.Arrays;
import java.util.List;

import PFPackage.PFBooks.Dice;
import static PFPackage.PFBooks.Dice.*;
import PFPackage.Character.SkillRank;
import static PFPackage.Character.SkillRank.*;
import PFPackage.PFBooks.Alignment;
import static PFPackage.PFBooks.Alignment.*;
import static PFPackage.PFBooks.PFClasses.PFClassName.*;

public class PFBarbarian implements PFClass {
    public enum ArchetypeNames {
        ArmoredHulk, Breaker, BrutalPugilist, BurnRider, Dreadnought,
        // More can be added but stop here pls
    }

    // class name
    final PFClassName className = Barbarian;

    public PFClassName getClassName(){
        return className;
    }

    // alignment restrictions
    final List<Alignment> alignmentRestrictions = Arrays.asList(LG, LN, LE);

    public List<Alignment> getAlignmentRestrictions(){
        return alignmentRestrictions;
    }

    // role description
    final String roleDesc = "Barbarians excel in combat, possessing the martial "
            + "prowess and fortitude to take on foes seemingly far superior to "
            + "themselves. With rage granting them boldness and daring beyond that "
            + "of most other warriors, barbarians charge furiously into battle and "
            + "ruin all who would stand in their way.";

    public String getRoleDescriptions(){
        return roleDesc;
    }

    // hit die
    final Dice hitDie = d12;
    public Dice getHitDie(){
        return hitDie;
    }

    // starting wealth
    final Object[] initWealth = { 3, d6, 1000 };
    public Object[] getInitWealth(){
        return initWealth;
    }

    public int getInitOutfitWealth(){
        return PFClass.initOutfitWealth;
    }

    // CLASS SKILLS
    final List<SkillRank> classSkills = Arrays.asList(
        acrobatics, climb, craft, handleAnimal, intimidate, knowledgeNature, 
        perception, ride, survival, swim
    );
    
    public List<SkillRank> getClassSkills(){
        return classSkills;
    }

    //Skill Ranks per level
    final int skillRanksPerLevel = 4; // n + INT
    public int getSkillRanksPerLevel(){
        return skillRanksPerLevel;
    }

    
}