package PFPackage.Character;

import java.util.EnumMap;

public class MySkillRanks{    
    //Base Skill Rank Map
    /*private EnumMap<SkillRankEnum, Integer> baseSRMap = 
        new EnumMap<SkillRankEnum, Integer>(SkillRankEnum.class);    */
    int[] baseSRMap = new int[35];

    //CONSTRUCTOR
    public MySkillRanks(){        
        //init all to 0
        for(SkillRankEnum aEnum: SkillRankEnum.values()){
            setBase(aEnum, 0);
        }
    }        

    private static int getIndex(SkillRankEnum enumvar){        
        return enumvar.val(); 
    }

    // return base number of skill ranks given enum
    public int getBase(SkillRankEnum enumvar){
        return baseSRMap[getIndex(enumvar)];    
    }
    
    // set base number of skill ranks given enum
    public int setBase(SkillRankEnum enumvar, int value){
        baseSRMap[getIndex(enumvar)] = value;
        return this.getBase(enumvar);    
    }

    
}