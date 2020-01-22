package PFPackage.PFBooks.PFClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import PFPackage.PFBooks.DiceEnum;
import PFPackage.PFBooks.PFFavoredClassBonus.FCBonus;
import PFPackage.PFBooks.PFFeats.Feat;
import PFPackage.PFBooks.PFFeats.Function;
import PFPackage.PFBooks.PFRaces.PFRaceName;
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
    private List<String> classFCBonusOptions = createFCBonusOptions();
    //Access
    public List<String> getFCBonusOptionList(){
        return classFCBonusOptions;
    }
    //Create List of class FC options
    private static List<String> createFCBonusOptions(){                
        List<String> bonusList = new ArrayList<String>();        
        bonusList.add("Barbarian/Dwarf");
        bonusList.add("Barbarian/Elf");        
        return bonusList;
    }

    public static ClassTableRow[] classTable = {
        new ClassTableRow(
            1, 1, 2, 0, 0, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            2, 2, 3, 0, 0, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            3, 3, 3, 1, 1, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            4, 4, 4, 1, 1, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            5, 5, 4, 1, 1, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            6, 6, 5, 2, 2, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            7, 7, 5, 2, 2, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            8, 8, 6, 2, 2, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            9, 9, 6, 3, 3, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            10, 10, 7, 3, 3, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            11, 11, 7, 3, 3, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            12, 12, 8, 4, 4, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            13, 13, 8, 4, 4, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            14, 14, 9, 4, 4, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            15, 15, 9, 5, 5, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            16, 16, 10, 5, 5, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            17, 17, 10, 5, 5, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            18, 18, 11, 6, 6, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            19, 19, 11, 6, 6, 
            ((Function) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            20, 20, 12, 6, 6, 
            ((Function) ((x) -> {return false;})), 
            null
        )
    };
    public ClassTableRow[] getClassTable() {        
        return classTable;
    }
}