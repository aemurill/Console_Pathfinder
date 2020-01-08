package PFPackage.Character;

import java.util.EnumMap;

public class AbilityScore {
    public enum AbilityScoreEnum{
        STR, DEX, CON, INT, WIS, CHA
    }
    //Base Ability Score Map
    private EnumMap<AbilityScoreEnum, Integer> baseAbScMap = new EnumMap<AbilityScoreEnum,
        Integer>(AbilityScoreEnum.class);    

    public AbilityScore(){        
        //init all to 10
        for(AbilityScoreEnum aEnum: AbilityScoreEnum.values()){
            baseAbScMap.put(aEnum, 10);        
        }
    }        

    // return base Ability Score given enum
    public int getBase(AbilityScoreEnum enumvar){
        return baseAbScMap.get(enumvar);    
    }

    // To be used PURELY for character creation, all other increases to be 
    // stored in temp adjustments.
    // set base Ability Score given enum
    public int setBase(AbilityScoreEnum enumvar, int value){
        baseAbScMap.put(enumvar, value);
        return baseAbScMap.get(enumvar);    
    }

    public int getModifier(AbilityScoreEnum enumvar){
        int base = getBase(enumvar);
        int modifier = (int) (Math.floor(base/2)) - 5;

        return modifier;    
    }
}