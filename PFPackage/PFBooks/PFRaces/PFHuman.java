package PFPackage.PFBooks.PFRaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import PFPackage.PFBooks.BodyTypeEnum;
import PFPackage.PFBooks.EntitySizeEnum;
import PFPackage.PFBooks.LanguageEnum;
import PFPackage.PFBooks.PFFeats.FeatList;
import static PFPackage.PFBooks.PFRaces.PFRaceName.*;
import static PFPackage.PFBooks.BodyTypeEnum.*;
import static PFPackage.PFBooks.EntitySizeEnum.*;
import static PFPackage.PFBooks.LanguageEnum.*;

public class PFHuman implements PFRace {
    private PFRaceName raceName = Human;
    private String raceDescription = "Humans possess exceptional drive and a " +
        "great capacity to endure and expand, and as such are currently the " +
        "dominant race in the world. Their empires and nations are vast, " +
        "sprawling things, and the citizens of these societies carve names " +
        "for themselves with the strength of their sword arms and the power " +
        "of their spells. Humanity is best characterized by its " +
        "tumultuousness and diversity, and human cultures run the gamut from " +
        "savage but honorable tribes to decadent, devil-worshiping noble " +
        "families in the most cosmopolitan cities. Humans’ curiosity and " +
        "ambition often triumph over their predilection for a sedentary " +
        "lifestyle, and many leave their homes to explore the innumerable " + 
        "forgotten corners of the world or lead mighty armies to conquer " + 
        "their neighbors, simply because they can.";
    
    private static List<String> raceFemaleNameList =
        Arrays.asList(
            "Alerdene", "Alinza", "Aula", "Bach Hien", "Belka", "Beshkee", 
            "Chammady", "Chao", "Do Quyen", "Eshe", "Eudomia", "Gerda", 
            "Hiriko", "Ilinica", "Indah", "Ingirt", "Izora", "Jalket", "Jayazi",
            "Kaede", "Kalizama", "Kamshi", "Lestari", "Leyli", "Marisan", 
            "Me’amesa", "Meilin", "Mirelinda", "Mpaandi", "Nalmida", "Nanya", 
            "Narantuyaa", "Ntisi", "Pasara", "Pontia", "Que Xuan", "Revhi", 
            "Runa", "Sahba", "Shirin", "Shivkah", "Sinkitah", "Surenchinua", 
            "Udara", "Umie", "Valki", "Waajida", "Xemne", "Xue", "Zalika", 
            "Zova"
        );
    private static List<String> raceMaleNameList =
        Arrays.asList(
            "Aakif", "Andrezi", "Arasmes", "Bahram", "Baolo", "Barid", 
            "Batsaikhan", "Belor", "Budi", "Darvan", "Dolok", "Eilif", 
            "Garidan", "Gellius", "Hadzi", "Hamengku", "Harisko", "Iacobus", 
            "Jaali", "Jianguo", "Kjell", "Kousei", "Kronug", "Menas", "Mitabu",
            "Narsius", "Nonek", "Pateba", "Pratavh", "Qorchi", "Ragnar", 
            "Rubani", "Seckor", "Shokamb", "Shuo", "Sunaki", "Suryo", "Tabansi",
            "Teruawa", "Thanh Liem", "Toan Hao", "Tomorbataar", "Tuong Kinh", 
            "Ursion", "Vachedi", "Viorec", "Yekskya", "Zaiho", "Zhen"
        );
    private List<String> raceDefaultNameList = merge();

    private static List<String> merge(){
        List<String> newList = new ArrayList<String>(raceFemaleNameList);
        newList.addAll(raceMaleNameList);
        Collections.sort(newList);
        return newList;
    }
        
    private int[] raceAbScoreMods = {0,0,0,0,0,0};
    private int raceBaseSpeed = 30;
    private List<LanguageEnum> raceLanguages = 
        Arrays.asList(Common);
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
    public int getRandomStartingAge(){
        return 0;
    }

    //random height & weight
    public Object[] getRandomHeight(){
        return null;
    }

    public int getRandomWeight(){
        return 0;
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