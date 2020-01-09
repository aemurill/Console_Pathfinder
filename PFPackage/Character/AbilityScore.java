package PFPackage.Character;

public enum AbilityScore {
    STR("STR", "Strength"), DEX("DEX", "Dexterity"), CON("CON", "Constitution"),
    INT("INT", "Intelligence"), WIS("WIS", "Wisdom"), CHA("CHA", "Charisma");

    private String string;
    private String fullString;

    private AbilityScore(String string, String fullString){
        this.string = string;
        this.fullString = fullString;
    }

    @Override
    public String toString() {
        return string;
    }

    public String fullString() {
        return fullString;
    }
}