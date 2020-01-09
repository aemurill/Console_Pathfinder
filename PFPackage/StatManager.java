package PFPackage;

import PFPackage.Character.*;
import PFPackage.PFBooks.PFClasses.*;

import static PFPackage.Character.AbilityScore.*;
import static PFPackage.Character.SkillRank.*;

class StatManager {

    static public void run() {
        System.out.println(" --- Player 1 --- ");
        PFCharacter player = new PFCharacter();
        MyAbilityScore myAS = player.characterStats;
        MySkillRanks mySK = player.characterSkills;
        player.characterClass = (PFClass) new PFBarbarian();
        PFClass myClass = player.characterClass;

        for(AbilityScore enumvar : AbilityScore.values()){
            System.out.println(
                enumvar.toString() + ": " + myAS.getBase(enumvar)
            );
            System.out.println(
                enumvar.fullString() + " mod: " + myAS.getModifier(enumvar)
            );
        }
        System.out.println("<Set STR: " + myAS.setBase(STR, 20) + ">");
        for(AbilityScore enumvar : AbilityScore.values()){
            System.out.println(
                enumvar.toString() + ": " + myAS.getBase(enumvar)
            );
            System.out.println(
                enumvar.fullString() + " mod: " + myAS.getModifier(enumvar)
            );
        }

        System.out.println("<Set Stealth: " + mySK.setBase(stealth, 12) + ">");
        for(SkillRank enumvar : SkillRank.values()){
            System.out.println(
                enumvar.toString() + ": " + mySK.getBase(enumvar)
            );
        }

        System.out.println("== Class Stats == ");
        System.out.println(myClass);
        PFClassName className = myClass.className;
        System.out.println(className);
        PFClassName roleDesc = myClass.className;
        System.out.println(roleDesc);
        System.out.println(myClass.hitDie.name());
        
    }





}