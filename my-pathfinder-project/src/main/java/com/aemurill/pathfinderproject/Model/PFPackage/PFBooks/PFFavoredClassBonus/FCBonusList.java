package com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFFavoredClassBonus;

import java.util.HashMap;
import java.util.Map;

import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFFeats.Function;
import static com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFRaces.PFRaceName.*;

public class FCBonusList {
    Map<String, FCBonus> FCBonusMap = new HashMap<String, FCBonus>();

    public FCBonusList(){
        putBonusInMap(new FCBonus(
            "+1 HP", 
            null, 
            "Add 1 HP to your Max HP", 
            ((Function) ((x) -> {return false;})), 
            "PFG"
        ));
        putBonusInMap(new FCBonus(
            "+1 Skill Rank", 
            null, 
            "Add 1 Skill rank to Skill ranks", 
            ((Function) ((x) -> {return false;})), 
            "PFG"
        ));
        putBonusInMap(new FCBonus(
            "Barbarian/Dwarf",
            Dwarf,
            "Add 1 to the dwarf’s total number of rage rounds per day.",
            (Function) ((x) -> {
                return FCBonus.handleUnimplemented();
            }),
            "APG"
        ));
        putBonusInMap(new FCBonus(
            "Barbarian/Elf",
            Elf,
            "Add 1 to the elf’s base speed. In combat this has no effect "+
            "unless the elf has selected this reward 5 times (or another "+
            "increment of 5); a speed of 34 feet is effectively the same "+
            "as a speed of 30 feet, for example. This bonus stacks with a "+
            "class’s fast movement feature and applies only under the same "+
            "conditions as that ability.",
            (Function) ((x) -> {
                return FCBonus.handleUnimplemented();
            }),
            "APG"
        ));
        putBonusInMap(new FCBonus(
            "Fighter/Dwarf",
            Dwarf,
            "Add +1 to the fighter’s CMD when resisting a bull rush or trip.",
            (Function) ((x) -> {
                return FCBonus.handleUnimplemented();
            }),
            "APG"
        ));
        putBonusInMap(new FCBonus(
            "Fighter/Elf",
            Elf,
            "Add +1 to the elf’s CMD when resisting a disarm or sunder attempt.",
            (Function) ((x) -> {
                return FCBonus.handleUnimplemented();
            }),
            "APG"
        ));
    }

    private void putBonusInMap(FCBonus bonus){
        FCBonusMap.put(bonus.toString(), bonus);
    }

    public FCBonus getBonus(String key){
        FCBonus bonus = FCBonusMap.get(key);
        return bonus;
    }
}