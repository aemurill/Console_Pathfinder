package PFPackage.Character;

import java.util.EnumMap;

public class MyAbilityScore {    
    
    // Base Ability Score Map
    private EnumMap<AbilityScore, Integer> baseAbScMap = new EnumMap<AbilityScore, Integer>(
            AbilityScore.class);

    public MyAbilityScore() {
        //init all to 10
        for(AbilityScore aEnum: AbilityScore.values()){
            baseAbScMap.put(aEnum, 10);        
        }
    }        

    // return base Ability Score given enum
    public int getBase(AbilityScore enumvar){
        return baseAbScMap.get(enumvar);    
    }

    // To be used PURELY for character creation, all other increases to be 
    // stored in temp adjustments.
    // set base Ability Score given enum
    public int setBase(AbilityScore enumvar, int value){
        baseAbScMap.put(enumvar, value);
        return baseAbScMap.get(enumvar);    
    }

    public int getModifier(AbilityScore enumvar){
        int base = getBase(enumvar);
        int modifier = (int) (Math.floor(base/2)) - 5;

        return modifier;    
    }
}