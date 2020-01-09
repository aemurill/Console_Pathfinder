package PFPackage.Character;

public enum SkillRankEnum {
    acrobatics, 
    appraise, 
    bluff, 
    climb, 
    craft, 
    diplomacy, 
    disableDevice("disable device"), 
    disguise, 
    escapeArtist, 
    fly, 
    handleAnimal, 
    heal, 
    intimidate, 
    knowledgeArcana("knowledge arcana"),
    knowledgeDungeoneering("knowledge dungeoneering"), 
    knowledgeEngineering("knowledge engineering"),
    knowledgeGeography("knowledge geography"), 
    knowledgeHistory("knowledge history"), 
    knowledgeLocal("knowledge local"), 
    knowledgeNature("knowledge nature"),
    knowledgeNobility("knowledge nobility"), 
    knowledgePlanes("knowledge planes"), 
    knowledgeReligion("knowledge religion"), 
    linguistics,
    perception, 
    perform, 
    profession, 
    ride, 
    senseMotive("sense motive"), 
    sleightOfHand("sleight of hand"), 
    spellcraft, 
    stealth, 
    survival, 
    swim, 
    useMagicalDevice("acrobatics");
    
    private String string = null;

    private SkillRankEnum(){
    }

    private SkillRankEnum(String string){
        this.string = string;
    }

    @Override
    public String toString() {
        if (string == null)
            return this.name();
        return this.string;
    }
}