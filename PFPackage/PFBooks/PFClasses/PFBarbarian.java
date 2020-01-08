package PFPackage.PFBooks.PFClasses;

import java.util.Arrays;
import java.util.List;

import PFPackage.PFBooks.Dice;
import static PFPackage.PFBooks.Dice.*;
import PFPackage.Character.SkillRank;
import PFPackage.PFBooks.Alignment;
import static PFPackage.PFBooks.Alignment.*;
import static PFPackage.PFBooks.PFClasses.PFClassName.*;

public class PFBarbarian implements PFClass {
    public enum ArchetypeNames {
        ArmoredHulk, Breaker, BrutalPugilist, BurnRider, Dreadnought,
        // More can be added but stop here pls
    }

    // class name
    PFClassName className = Barbarian;

    // alignment restrictions
    List<Alignment> alignmentRestrictions = Arrays.asList(LG, LN, LE);

    // role description
    String roleDesc = "Barbarians excel in combat, possessing the martial "
            + "prowess and fortitude to take on foes seemingly far superior to "
            + "themselves. With rage granting them boldness and daring beyond that "
            + "of most other warriors, barbarians charge furiously into battle and "
            + "ruin all who would stand in their way.";

    // hit die
    Dice hitDie = d12;

    // starting wealth
    Object[] initWealth = { 3, d6, 1000 };
    // In addition, each character begins play with an outfit worth 10 gp or less.
    int initOutfitWealth = 1000; // 10 gp = 100 sp = 1000 cp

    // CLASS SKILLS
    List<SkillRank> classSkills = Arrays.asList(
        SkillRank.acrobatics
    );
    
    //Skill Ranks per level
    int skillRanksPerLevel = 0; // n + INT

    
}