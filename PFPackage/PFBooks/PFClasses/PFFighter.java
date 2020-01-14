package PFPackage.PFBooks.PFClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import PFPackage.PFBooks.DiceEnum;
import PFPackage.PFBooks.PFFavoredClassBonus.FCBonus;
import PFPackage.PFBooks.PFFeats.Feat;
import PFPackage.PFBooks.PFFeats.Function;
import PFPackage.PFBooks.PFFeats.FeatList;

import static PFPackage.PFBooks.DiceEnum.*;
import PFPackage.Character.SkillRankEnum;
import static PFPackage.Character.SkillRankEnum.*;
import PFPackage.PFBooks.AlignmentEnum;
import static PFPackage.PFBooks.AlignmentEnum.*;
import static PFPackage.PFBooks.PFClasses.PFClassName.*;

public class PFFighter implements PFClass {
    //UNPLANNED: Ex-Barbarian Status

    public enum ArchetypeNames {
        
        // More can be added but stop here pls
    }

    // class name
    final PFClassName className = Fighter;
    public PFClassName getClassName(){
        return className;
    }

    // alignment restrictions
    final List<AlignmentEnum> alignmentRestrictions = Arrays.asList(
        LG, LN, LE, NG, NN, NE, CG, CN, CE
    );
    public List<AlignmentEnum> getAlignmentRestrictions(){
        return alignmentRestrictions;
    }

    // role description
    final String roleDesc = "Fighters excel at combat—defeating their " +
        "enemies, controlling the flow of battle, and surviving such sorties " +
        "themselves. While their specific weapons and methods grant them a " + 
        "wide variety of tactics, few can match fighters for sheer battle " + 
        "prowess.";

    public String getRoleDescriptions(){
        return roleDesc;
    }

    // hit die
    final DiceEnum hitDie = d10;
    public DiceEnum getHitDie(){
        return hitDie;
    }

    // starting wealth
    final Object[] initWealth = { 5, d6, 10 };
    public Object[] getInitWealth(){
        return initWealth;
    }

    public double getInitOutfitWealth(){
        return PFClass.initOutfitWealth;
    }

    // CLASS SKILLS
    final List<SkillRankEnum> classSkills = Arrays.asList(
        climb, craft, handleAnimal, intimidate, knowledgeDungeoneering, 
        knowledgeEngineering, profession, ride, survival, swim
    );    
    public List<SkillRankEnum> getClassSkills(){
        return classSkills;
    }

    //Skill Ranks per level
    final int skillRanksPerLevel = 2; // n + INT
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
            (Function) ((x) -> {
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
    
    //Favored Class bonus option
    //Static List of class FC options
    private List<FCBonus> classFCBonusOptions = createFCBonusOptions();
    //Access
    public List<FCBonus> getFCBonusOptionList(){
        return classFCBonusOptions;
    }
    //Create List of class FC options
    private static List<FCBonus> createFCBonusOptions(){                
        List<FCBonus> classFeatures = new ArrayList<FCBonus>();        
        classFeatures.add(new FCBonus(
            null,
            "Dwarf",
            "Add 1 to the elf’s base speed. In combat this has no effect "+
            "unless the elf has selected this reward 5 times (or another "+
            "increment of 5); a speed of 34 feet is effectively the same "+
            "as a speed of 30 feet, for example. This bonus stacks with a "+
            "class’s fast movement feature and applies only under the same "+
            "conditions as that ability.",
            (Function) ((x) -> {
                return FCBonus.handleUnimplemented();
            }),
            "APG"
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