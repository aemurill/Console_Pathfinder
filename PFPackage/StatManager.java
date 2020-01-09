package PFPackage;

import PFPackage.Character.*;
import PFPackage.PFBooks.PFClasses.*;
import PFPackage.PFBooks.Alignment;
import PFPackage.PFBooks.Dice;

import static PFPackage.Character.AbilityScore.*;
import static PFPackage.Character.SkillRank.*;

import java.util.List;

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
        PFClassName className = myClass.getClassName();
        System.out.println("Class: " +className);
        List<Alignment> badAlign = myClass.getAlignmentRestrictions();
        System.out.println("Alignment Restrictions: " +badAlign);
        String roleDesc = myClass.getRoleDescriptions();
        System.out.println("Role Description: " +roleDesc);
        Dice die = myClass.getHitDie();
        System.out.println("Hit Die: " +die.name());
        double initWealth = myClass.calcInitWealth();
        System.out.println("Initial Wealth: " + initWealth);
        double initOutfitWealth = myClass.getInitOutfitWealth();
        System.out.println("Outfit Wealth: " +initOutfitWealth);
        List<SkillRank> classSkills = myClass.getClassSkills();
        System.out.println("Class Skills: " +classSkills);
        int classSR = myClass.getSkillRanksPerLevel() + myAS.getModifier(INT);
        System.out.println("Skill Ranks per Level (INT): " +classSR);
    }





}