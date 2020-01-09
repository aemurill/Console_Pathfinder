package PFPackage.PFBooks.PFFeats;

import java.util.ArrayList;
import java.util.List;

public class FeatList {
    private static boolean handleUnimplemented(){
        System.out.println("WARNING: FEAT UNIMPLEMENTED");
        return false;
    }

    // == GENERAL FEATS ==
    //Static List of all GENERAL Feats
    static List<Feat> GeneralFeatList = createGeneralFeatList();
    //Access List
    public static List<Feat> getGeneralFeatList(){        
        return GeneralFeatList;
    }
    //Create List of Feats
    private static List<Feat> createGeneralFeatList(){                
        List<Feat> GeneralFeatList = new ArrayList<Feat>(0);        
        GeneralFeatList.add(new Feat(
            "Aberrant Tumor",
            "General",
            "Aberrant bloodline",
            "Gain a tumor familiar.",
            (FeatFunction) ((x) -> {
                return handleUnimplemented();
            }),
            "PZO1129"
        ));
        /*You gain a tumor familiar, as the tumor familiar alchemist discovery, with an effective alchemist level equal to the level of the class that grants your aberrant bloodline for determining the tumor familiar’s abilities. If multiple classes grant you the aberrant bloodline, those class levels stack for determining your effective alchemist level.

*/
        return GeneralFeatList;
    }

    // == COMBAT FEATS ==
    //Static List of all GENERAL Feats
    static List<Feat> CombatFeatList = createCombatFeatList();
    //Access List
    public static List<Feat> getCombatFeatList(){        
        return CombatFeatList;
    }
    //Create List of Feats
    private static List<Feat> createCombatFeatList(){                
        List<Feat> CombatFeatList = new ArrayList<Feat>(0);                
        CombatFeatList.add(new Feat(
            "Acrobatic Spellcaster",
            "Combat",
            "Combat Casting, Skill Focus (Acrobatics)",
            "Avoid attacks of opportunity from casting with Acrobatics",
            (FeatFunction) ((x) -> {
                Object[] blah = {"blah"};
                System.out.println("HELLO: " + blah[0] + " " + blah.toString());
                return handleUnimplemented();
            }),
            "PZO1134"
        ));
        CombatFeatList.add(new Feat(
            "Adder Strike",
            "Combat",
            "Poison use class feature, Improved Unarmed Strike, Craft (alchemy) 1",
            "Avoid attacks of opportunity from casting with Acrobatics",
            (FeatFunction) ((x) -> {                
                System.out.println("POISON STRIKE");
                return handleUnimplemented();
            }),
            "PZO1118"
        ));
        return CombatFeatList;
    }

    // == CRITICAL FEATS ==

    // == ITEM CREATION FEATS ==

    // == METAMAGIC FEATS ==

    // == ACHIEVEMENT FEATS ==

    // == BLOOD HEX FEATS ==

    // == FACTION FEATS ==
    
    // == GRIT AND PANACHE FEATS ==

    // == HERO POINT FEATS ==

    // == ITEM MASTERY FEATS ==

    // == MEDITATION FEATS ==
    
    // == MYTHIC FEATS ==

    // == PERFORMANCE FEATS ==

    // == RACIAL FEATS ==

    // == STORY FEATS ==

    // == STYLE FEATS ==

    // == TARGETING FEATS ==

    // == TEAMWORK FEATS ==    
}