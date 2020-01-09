package PFPackage.Character;

import java.util.EnumMap;

public class MySkillRanks{    
    //Base Skill Rank Map
    private EnumMap<SkillRankEnum, Integer> baseSRMap = 
        new EnumMap<SkillRankEnum, Integer>(SkillRankEnum.class);    

    //CONSTRUCTOR
    public MySkillRanks(){        
        //init all to 0
        for(SkillRankEnum aEnum: SkillRankEnum.values()){
            baseSRMap.put(aEnum, 0);        
        }
    }        

    // return base number of skill ranks given enum
    public int getBase(SkillRankEnum enumvar){
        return baseSRMap.get(enumvar);    
    }
    
    // set base number of skill ranks given enum
    public int setBase(SkillRankEnum enumvar, int value){
        baseSRMap.put(enumvar, value);
        return baseSRMap.get(enumvar);    
    }

    
}