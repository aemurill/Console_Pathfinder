package com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFClasses;

public enum PFClassName{
    Barbarian, Bard, Cleric, Druid, Fighter, Monk, Paladin, Ranger, Rogue, 
    Sorcerer, Wizard;
    //More can be added but stop here pls        
    
    private String string;

    private PFClassName(){
    }

    private PFClassName(String string){
        this.string = string;
    }

    @Override
    public String toString() {
        if (string == null)
            return this.name();
        return this.string;
    }
}