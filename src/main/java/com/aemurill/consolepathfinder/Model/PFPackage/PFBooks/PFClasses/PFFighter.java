package com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aemurill.consolepathfinder.Model.PFPackage.Character.SkillRankEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.DiceEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFFeats.Feat;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFFeats.FeatList;
import com.aemurill.consolepathfinder.Lib.LambdaClass;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.AlignmentEnum;

import static com.aemurill.consolepathfinder.Model.PFPackage.Character.SkillRankEnum.*;
import static com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.DiceEnum.*;
import static com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.AlignmentEnum.*;
import static com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFClasses.PFClassName.*;

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
            (LambdaClass) ((x) -> {
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
        bonusList.add("Fighter/Dwarf");
        bonusList.add("Fighter/Elf");        
        return bonusList;
    }

    public static ClassTableRow[] classTable = {
        new ClassTableRow(
            1, 1, 2, 0, 0, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            2, 2, 3, 0, 0, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            3, 3, 3, 1, 1, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            4, 4, 4, 1, 1, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            5, 5, 4, 1, 1, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            6, 6, 5, 2, 2, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            7, 7, 5, 2, 2, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            8, 8, 6, 2, 2, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            9, 9, 6, 3, 3, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            10, 10, 7, 3, 3, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            11, 11, 7, 3, 3, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            12, 12, 8, 4, 4, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            13, 13, 8, 4, 4, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            14, 14, 9, 4, 4, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            15, 15, 9, 5, 5, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            16, 16, 10, 5, 5, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            17, 17, 10, 5, 5, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            18, 18, 11, 6, 6, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            19, 19, 11, 6, 6, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        ),
        new ClassTableRow(
            20, 20, 12, 6, 6, 
            ((LambdaClass) ((x) -> {return false;})), 
            null
        )
    };
    public ClassTableRow[] getClassTable() {
        return classTable;
    }
}