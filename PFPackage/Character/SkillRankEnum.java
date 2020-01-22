package PFPackage.Character;

public enum SkillRankEnum {
    acrobatics(0), 
    appraise(1), 
    bluff(2), 
    climb(3), 
    craft(4), 
    diplomacy(5), 
    disableDevice(6, "disable device"), 
    disguise(7), 
    escapeArtist(8), 
    fly(9), 
    handleAnimal(10), 
    heal(11), 
    intimidate(12), 
    knowledgeArcana(13,"knowledge arcana"),
    knowledgeDungeoneering(14,"knowledge dungeoneering"), 
    knowledgeEngineering(15,"knowledge engineering"),
    knowledgeGeography(16,"knowledge geography"), 
    knowledgeHistory(17,"knowledge history"), 
    knowledgeLocal(18,"knowledge local"), 
    knowledgeNature(19,"knowledge nature"),
    knowledgeNobility(20,"knowledge nobility"), 
    knowledgePlanes(21,"knowledge planes"), 
    knowledgeReligion(22,"knowledge religion"), 
    linguistics(23),
    perception(24), 
    perform(25), 
    profession(26), 
    ride(27), 
    senseMotive(28,"sense motive"), 
    sleightOfHand(29,"sleight of hand"), 
    spellcraft(30), 
    stealth(31), 
    survival(32), 
    swim(33), 
    useMagicalDevice(34,"acrobatics");
    
    private String string = null;
    private int num = -1;

    private SkillRankEnum(int num){
        this.num = num;
    }

    private SkillRankEnum(int num, String string){
        this.num = num;
        this.string = string;
    }

    @Override
    public String toString() {
        if (string == null)
            return this.name();
        return this.string;
    }

    public int val(){
        return num;
    }
}