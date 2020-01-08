package PFPackage.Character;

import java.util.EnumMap;

public class MySkillRanks{    
    //Base Skill Rank Map
    private EnumMap<SkillRank, Integer> baseSRMap = 
        new EnumMap<SkillRank, Integer>(SkillRank.class);    

    //CONSTRUCTOR
    public MySkillRanks(){        
        //init all to 0
        for(SkillRank aEnum: SkillRank.values()){
            baseSRMap.put(aEnum, 0);        
        }
    }        

    // return base number of skill ranks given enum
    public int getBase(SkillRank enumvar){
        return baseSRMap.get(enumvar);    
    }
    
    // set base number of skill ranks given enum
    public int setBase(SkillRank enumvar, int value){
        baseSRMap.put(enumvar, value);
        return baseSRMap.get(enumvar);    
    }

    
}