package PFPackage.PFBooks.PFClasses;

import java.util.Arrays;
import java.util.List;

import PFPackage.PFBooks.DiceEnum;
import PFPackage.PFBooks.PFFeats.Feat;
import PFPackage.PFBooks.PFFeats.FeatFunction;
import PFPackage.PFBooks.PFFeats.FeatList;

import static PFPackage.PFBooks.DiceEnum.*;
import PFPackage.Character.SkillRankEnum;
import static PFPackage.Character.SkillRankEnum.*;
import PFPackage.PFBooks.AlignmentEnum;
import static PFPackage.PFBooks.AlignmentEnum.*;
import static PFPackage.PFBooks.PFClasses.PFClassName.*;

public class PFBarbarian implements PFClass {
    //UNPLANNED: Ex-Barbarian Status

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
    final List<AlignmentEnum> alignmentRestrictions = Arrays.asList(
        NG, NN, NE, CG, CN, CE
    );
    public List<AlignmentEnum> getAlignmentRestrictions(){
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
    final DiceEnum hitDie = d12;
    public DiceEnum getHitDie(){
        return hitDie;
    }

    // starting wealth
    final Object[] initWealth = { 3, d6, 10 };
    public Object[] getInitWealth(){
        return initWealth;
    }

    public double getInitOutfitWealth(){
        return PFClass.initOutfitWealth;
    }

    // CLASS SKILLS
    final List<SkillRankEnum> classSkills = Arrays.asList(
        acrobatics, climb, craft, handleAnimal, intimidate, knowledgeNature, 
        perception, ride, survival, swim
    );    
    public List<SkillRankEnum> getClassSkills(){
        return classSkills;
    }

    //Skill Ranks per level
    final int skillRanksPerLevel = 4; // n + INT
    public int getSkillRanksPerLevel(){
        return skillRanksPerLevel;
    }

    //Static List of all GENERAL Feats
    private FeatList classFeatures = createClassFeatures();
    //Access List
    public FeatList getClassFeatures(){
        return classFeatures;
    }    
    //Create List of Feats
    private static FeatList createClassFeatures(){                
        FeatList classFeatures = new FeatList();        
        classFeatures.add(new Feat(
            "Aberrant Tumor",
            "General",
            "Aberrant bloodline",
            "Gain a tumor familiar.",
            (FeatFunction) ((x) -> {
                return Feat.handleUnimplemented();
            }),
            "PZO1129"
        ));
        /*You gain a tumor familiar, as the tumor familiar
         alchemist discovery, with an effective alchemist
         level equal to the level of the class that grants
         your aberrant bloodline for determining the tumor
         familiar’s abilities. If multiple classes grant
         you the aberrant bloodline, those class levels
         stack for determining your effective alchemist
         level.*/
        return classFeatures;
    }
    
    
}