package com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFClasses;

import java.util.List;

import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.DiceEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFFeats.FeatList;
//import com.aemurill.consolepathfinder.Lib.Console;
import com.aemurill.consolepathfinder.Model.PFPackage.Character.SkillRankEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.AlignmentEnum;

public interface PFClass {
    // class name
    //final PFClassName className = null;
    public PFClassName getClassName();

    // alignment restrictions
    //final List<Alignment> alignmentRestrictions = null;
    public List<AlignmentEnum> getAlignmentRestrictions();

    //role description
    //final String roleDesc = null;
    public String getRoleDescriptions();

    //hit die
    //final Dice hitDie = null;    
    public DiceEnum getHitDie();

    //starting wealth
    //final Object[] initWealth = null;// = {5, d6, 10 } ;
    public Object[] getInitWealth();
    //return calculated value of init wealth
    default double calcInitWealth(){
        Object[] temp = this.getInitWealth();
        int dieMult = (int) temp[0];
        System.out.println(String.valueOf(dieMult));
        int roll = ((DiceEnum) temp[1]).roll();
        System.out.println("rolled "+roll);
        int mult = (int)temp[2];
        System.out.println(String.valueOf(mult));
        double val = (dieMult * roll) * mult;
        return val;
    }

    //In addition, each character begins play with an outfit worth 10 gp or less.
    double initOutfitWealth = 10; //10 gp = 100 sp = 1000 cp
    public double getInitOutfitWealth();

    //CLASS SKILLS
    //List<SkillRank> classSkills = null;
    /*List<SkillRankEnum> classSkills = Arrays.asList(
        SkillRankEnum.acrobatics,  
    );*/
    public List<SkillRankEnum> getClassSkills();
    
    //Skill Ranks per level
    //public int skillRanksPerLevel = 0; // n + INT
    public int getSkillRanksPerLevel();

    //Class Features     
    public FeatList getClassFeatures();

    
    //Favored Class bonus option
    public List<String> getFCBonusOptionList();
    /* 
        updateStatsManager?

        Make Features a list of things that get run through?
        Make Bonuses a list of things that get run through?

        When?
            Before Checks - if affects checks
            Before Rolls - if affects rolls
            
            When item gained
            When item lost

            When CHANGE occures to player stats
            
            When Spell casted
            When Feature Gained
            >> Duration of change
            >> Conditions of change
            >> **Temporariness** of change
            >> Permenance of change


     */

    public ClassTableRow[] getClassTable();
    //Class leveling TABLE
    /*
        CONSULT WHENEVER LEVELING UP 
        PER LEVEL
            upgrade BAB bonus
            upgrade Fort Save bonus
            upgrade Ref Save bonus
            update Will Save bonus
            Add Feat / Feat upgrade!
        Array?
        [level][BAB, FORT, REF, WILL, {specials}]

        new ClassTableRow(
            1, 0, 0, 0, 2, ((Function) ((x) -> {return false;})), 
            new int[]{3, 1, -1, -1, -1, -1, -1, -1, -1, -1}
        ),
    */

}