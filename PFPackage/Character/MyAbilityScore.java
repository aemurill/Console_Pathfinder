package PFPackage.Character;

import java.util.EnumMap;
import static PFPackage.Character.AbilityScoreEnum.*;

public class MyAbilityScore {    

    // Base Ability Score Map
    //private EnumMap<AbilityScoreEnum, Integer> baseAbScMap = new EnumMap<AbilityScoreEnum, Integer>(
    //        AbilityScoreEnum.class);
    private int[] baseAbScMap = new int[6];

    public MyAbilityScore() {
        //init all to 10
        for(AbilityScoreEnum aEnum: AbilityScoreEnum.values()){
            setBase(aEnum, 10);
        }
    }        

    private static int getIndex(AbilityScoreEnum enumvar){
        if(enumvar == STR) return 0;
        if(enumvar == DEX) return 1;
        if(enumvar == CON) return 2;
        if(enumvar == INT) return 3;
        if(enumvar == WIS) return 4;
        if(enumvar == CHA) return 5;
        System.out.println("ABSCORE ERROR INDEXING");
        return -1; 
    }

    // return base Ability Score given enum
    public int getBase(AbilityScoreEnum enumvar){
        return baseAbScMap[getIndex(enumvar)];    
    }

    // To be used PURELY for character creation, all other increases to be 
    // stored in temp adjustments.
    // set base Ability Score given enum
    public int setBase(AbilityScoreEnum enumvar, int value){
        int actValue = value;
        if(value <= 0){
            actValue = 0;
        }
        baseAbScMap[getIndex(enumvar)] = actValue;
        return this.getBase(enumvar);    
    }

    public int getModifier(AbilityScoreEnum enumvar){
        int base = getBase(enumvar);
        int modifier = (int) (Math.floor(base/2)) - 5;

        return modifier;    
    }

    public int calcModifier(int value){
        int modifier = (int) (Math.floor(value/2)) - 5;

        return modifier;    
    }
}