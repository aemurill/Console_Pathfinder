package PFPackage.Character;

import java.util.EnumMap;

public class SkillRanks {
    public enum SkillRankEnum{
        acrobatics, appraise, bluff, climb, craft, diplomacy, disableDevice, 
        disguise, escapeArtist, fly, handleAnimal, heal, intimidate, 
        knowledgeArcana, knowledgeDungeoneering, knowledgeEngineering,
        knowledgeGeography, knowledgeHistory, knowledgeLocal, knowledgeNature,
        knowledgeNobility, knowledgePlanes, knowledgeReligion, linguistics,
        perception, perform, profession, ride, senseMotive, sleightOfHand, 
        spellCraft, stealth, survival, swim, useMagicalDevice
    }
    //Base Skill Rank Map
    private EnumMap<SkillRankEnum, Integer> baseSRMap = 
        new EnumMap<SkillRankEnum, Integer>(SkillRankEnum.class);    

    //CONSTRUCTOR
    public SkillRanks(){        
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