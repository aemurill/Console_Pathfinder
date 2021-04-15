package com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFRaces;

import java.util.List;

import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.BodyTypeEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.DiceEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.EntitySizeEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.LanguageEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFClasses.PFClassName;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFFeats.FeatList;
//import com.aemurill.consolepathfinder.Lib.Console;

import static com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFClasses.PFClassName.*;

public interface PFRace {
    // class name
    public PFRaceName getRaceName();    
    
    // descriptions
    public String getDescription();

    //default names
    public List<String> getDefaultNames();
    public List<String> getFemaleNames();
    public List<String> getMaleNames();
    
    //randomStartingAge
    public int getRandomStartingAge(PFClassName aEnum); 
    default int calcRandomStartingAge(Object[] input) {
        int start = (int) input[0];
        int mult = (int) input[1];
        DiceEnum die = (DiceEnum) input[2];
        int temp = 0;
        for(int i = 0; i < mult; i++){
            temp += die.roll();
            System.out.println("["+temp+"]");
        }        
        return start + temp;
    }       
    default int getCategory(PFClassName aEnum){
        int val = -1;
        //Oracles 
        if(aEnum == Barbarian || aEnum == Rogue || aEnum == Sorcerer ){
            val = 1;
        }
        //Cavalier, Gunslinger, Summoner, Witch
        if(aEnum == Bard || aEnum == Fighter || aEnum == Paladin ||
             aEnum == Ranger){
            val = 2;
        }
        //Alchemist, Inquisitor, Magi
        if(aEnum == Cleric || aEnum == Druid || aEnum == Monk || 
            aEnum == Wizard){
            val = 3;
        }
        return val;
    }
    

    //random height & weight
    public int getRandomHeight(int gender);

    public int getRandomWeight(int gender);

    //==RACIAL TRAITS==    
        //standard racial traits!        
            //Ability Score Modifiers!
    public int[] getRacialAbScoreMods();            
            //Size
    public EntitySizeEnum getSize();                        
            //Type (humanoid/subtype)
    public BodyTypeEnum getType();                        
            //Base Speed 
    public int getBaseSpeed();
                //defacto speed
                //special rules -> Feat?
            //Languages (LIST)
    public List<LanguageEnum> getLanguages();
        
        //TRAITS
    public FeatList getTraits();
        //Defensive racial traits
        //Feat & Skill racial traits
        //Senses Racial traits
        //Offense Racial traits

    public FeatList getAlternateTraits();
        //ALTERNATE RACIAL TRAITS
            //may be selected in place of one(or more) std racial traits
                


}

/*
    // alignment restrictions
    //final List<Alignment> alignmentRestrictions = null;
    public List<AlignmentEnum> getAlignmentRestrictions();

    //hit die
    //final Dice hitDie = null;    
    public DiceEnum getHitDie();

    //starting wealth
    //final Object[] initWealth = null;// = {5, d6, 10 } ;
    public Object[] getInitWealth();
    //return calculated value of init wealth
    default double calcInitWealth() {
        Object[] temp = this.getInitWealth();
        int dieMult = (int) temp[0];
        System.out.println(dieMult);
        int roll = ((DiceEnum) temp[1]).roll();
        System.out.println("rolled "+roll);
        int mult = (int)temp[2];
        System.out.println(mult);
        double val = (dieMult * roll) * mult;
        return val;
    }

    
    //CLASS SKILLS
    //List<SkillRank> classSkills = null;
    /*List<SkillRankEnum> classSkills = Arrays.asList(
        SkillRankEnum.acrobatics,  
    );
    public List<SkillRankEnum> getClassSkills();
    
    //Skill Ranks per level
    //public int skillRanksPerLevel = 0; // n + INT
    public int getSkillRanksPerLevel();

    //Class Features     
    public FeatList getClassFeatures();

    
    //Favored Class bonus option
    public List<FCBonus> getFCBonusOptionList();
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
    

}*/