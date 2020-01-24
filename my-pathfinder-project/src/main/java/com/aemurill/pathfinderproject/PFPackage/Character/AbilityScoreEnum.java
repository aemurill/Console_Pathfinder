package com.aemurill.pathfinderproject.PFPackage.Character;

public enum AbilityScoreEnum {
    STR("Strength"), DEX("Dexterity"), CON("Constitution"),
    INT("Intelligence"), WIS("Wisdom"), CHA("Charisma");

    private String fullString;

    private AbilityScoreEnum(String fullString){
        this.fullString = fullString;
    }

    public String fullString() {
        return fullString;
    }
}