package com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFRaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.BodyTypeEnum;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.EntitySizeEnum;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.LanguageEnum;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFClasses.PFClassName;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFFeats.FeatList;
import com.aemurill.pathfinderproject.lib.Console;

import static com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFRaces.PFRaceName.*;
import static com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.EntitySizeEnum.*;
import static com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.LanguageEnum.*;
import static com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.DiceEnum.*;
import static com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.BodyTypeEnum.*;

public class PFDwarf implements PFRace {
    private PFRaceName raceName = Dwarf;
    private String raceDescription = "Dwarves are a stoic but stern race, " +
    "ensconced in cities carved from the hearts of mountains and fiercely " +
    "determined to repel the depredations of savage races like orcs and " +
    "goblins. More than any other race, dwarves have acquired a reputation " +
    "as dour and humorless artisans of the earth. It could be said that " +
    "their history shapes the dark disposition of many dwarves, for they " +
    "reside in high mountains and dangerous realms below the earth, " +
    "constantly at war with giants, goblins, and other such horrors.";
    
    private static List<String> raceFemaleNameList =
        Arrays.asList(
            "Agna", "Bodill", "Ingra", "Kotri", "Rusilka", "Yangrit"
        );
    private static List<String> raceMaleNameList =
        Arrays.asList(
            "Dolgrin", "Grunyar", "Harsk", "Kazmuk", "Morgrym", "Rogar"
        );
    private List<String> raceDefaultNameList = merge();

    private static List<String> merge(){
        List<String> newList = new ArrayList<String>(raceFemaleNameList);
        newList.addAll(raceMaleNameList);
        Collections.sort(newList);
        return newList;
    }
        
    private int[] raceAbScoreMods = {0,0,2,0,2,-2};
    private int raceBaseSpeed = 20; //SPEED NEVER MODIFIED BY ARMOR OR INV WEIGHT
    private List<LanguageEnum> raceLanguages = 
        Arrays.asList(Common, Dwarven);
    private EntitySizeEnum raceSize = Medium;
    private BodyTypeEnum raceType = Humanoid;

    // class name
    public PFRaceName getRaceName(){
        return raceName;
    }    
    
    // descriptions
    public String getDescription(){
        return raceDescription;
    }

    //default names
    public List<String> getDefaultNames(){
        return raceDefaultNameList;
    }
    public List<String> getFemaleNames() {
        return raceFemaleNameList;
    }
    public List<String> getMaleNames() {
        return raceMaleNameList;
    }
    
    //randomStartingAge
    public int getRandomStartingAge(PFClassName aEnum, Console console){
        int mode = getCategory(aEnum);
        Object[] obj = {40, null, null}; 
        if(mode == 1){
            obj[1] = 3;
            obj[2] = d6;
        }
        if(mode == 2){
            obj[1] = 5;
            obj[2] = d6;
        } 
        if(mode == 3){
            obj[1] = 7;
            obj[2] = d6;
        }
        return this.calcRandomStartingAge(obj, console);
    }

    //random height & weight
    //gender 0 = female, 1 = male
    public int getRandomHeight(int gender, Console console){
        Object[] obj = { (3 * 12), 2, d4};
        if(gender == 0){
            obj[0] = ((int) obj[0]) + 7;
        }
        if(gender == 1){
            obj[0] =  ((int) obj[0]) + 9;
        } 
        return this.calcRandomStartingAge(obj, console);
    }

    public int getRandomWeight(int gender, Console console){
        Object[] obj = { 0, 2, d4};        
        int out = this.calcRandomStartingAge(obj, console);
        out *= 7;
        if(gender == 0){
            out += 120;
        }
        if(gender == 1){
            out += 150;
        } 
        return out;
    }

    //==RACIAL TRAITS==    
        //standard racial traits!        
            //Ability Score Modifiers!
    public int[] getRacialAbScoreMods(){
        return raceAbScoreMods;
    }            
            //Size
    public EntitySizeEnum getSize(){
        return raceSize;
    }                       
            //Type (humanoid/subtype)
    public BodyTypeEnum getType(){
        return raceType;
    }
            //Base Speed 
    public int getBaseSpeed(){
        return raceBaseSpeed;
    }
                //defacto speed
                //special rules -> Feat?
            //Languages (LIST)
    public List<LanguageEnum> getLanguages(){
        return raceLanguages;
    }
        
        //TRAITS
    public FeatList getTraits(){
        return null;
    }
        //Defensive racial traits
        //Feat & Skill racial traits
        //Senses Racial traits
        //Offense Racial traits

    public FeatList getAlternateTraits(){
        return null;
    }
        //ALTERNATE RACIAL TRAITS
            //may be selected in place of one(or more) std racial traits
                


}