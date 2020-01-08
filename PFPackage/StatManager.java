package PFPackage;

import static PFPackage.Character.AbilityScore.*;

import PFPackage.Character.MyAbilityScore;
import PFPackage.Character.MySkillRanks;
import PFPackage.Character.PFCharacter;
import PFPackage.Character.SkillRank;

class StatManager {

    static public void run() {
        System.out.println(" --- Player 1 --- ");
        PFCharacter player = new PFCharacter();
        MyAbilityScore myAS = player.characterStats;
        MySkillRanks mySK = player.characterSkills;

        System.out.println("STR: " + myAS.getBase(STR));
        System.out.println("STR mod: " + myAS.getModifier(STR));
        System.out.println("Set STR: " + myAS.setBase(STR, 20));
        System.out.println("STR mod: " + myAS.getModifier(STR));

        System.out.println("Stealth: " + mySK.getBase(SkillRank.stealth));
    }





}