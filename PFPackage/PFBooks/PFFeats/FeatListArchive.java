package PFPackage.PFBooks.PFFeats;

public class FeatListArchive {    

    // == GENERAL FEATS ==
    //Static List of all GENERAL Feats
    static FeatList GeneralFeatList = createGeneralFeatList();
    //Access List
    public static FeatList getGeneralFeatList(){        
        return GeneralFeatList;
    }
    //Create List of Feats
    private static FeatList createGeneralFeatList(){                
        FeatList GeneralFeatList = new FeatList();        
        GeneralFeatList.add(new Feat(
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
        return GeneralFeatList;
    }

    // == COMBAT FEATS ==
    //Static List of all GENERAL Feats
    static FeatList CombatFeatList = createCombatFeatList();
    //Access List
    public static FeatList getCombatFeatList(){        
        return CombatFeatList;
    }
    //Create List of Feats
    private static FeatList createCombatFeatList(){                
        FeatList CombatFeatList = new FeatList();                
        CombatFeatList.add(new Feat(
            "Acrobatic Spellcaster",
            "Combat",
            "Combat Casting, Skill Focus (Acrobatics)",
            "Avoid attacks of opportunity from casting with Acrobatics",
            (Function) ((x) -> {
                Object[] blah = {"blah"};
                System.out.println("HELLO: " + blah[0] + " " + blah.toString());
                return Feat.handleUnimplemented();
            }),
            "PZO1134"
        ));
        CombatFeatList.add(new Feat(
            "Adder Strike",
            "Combat",
            "Poison use class feature, Improved Unarmed Strike, Craft (alchemy) 1",
            "Avoid attacks of opportunity from casting with Acrobatics",
            (Function) ((x) -> {                
                System.out.println("POISON STRIKE");
                return Feat.handleUnimplemented();
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