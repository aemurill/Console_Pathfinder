package PFPackage;

import PFPackage.Character.*;
import PFPackage.PFBooks.PFClasses.*;
import PFPackage.PFBooks.PFFeats.Feat;
import PFPackage.PFBooks.PFFeats.FeatFunction;
import PFPackage.PFBooks.PFFeats.FeatList;
import PFPackage.PFBooks.AlignmentEnum;
import PFPackage.PFBooks.DiceEnum;
import static PFPackage.Character.AbilityScoreEnum.*;
import static PFPackage.Character.SkillRankEnum.*;

import java.util.List;

class StatManager {

    static public void run() {
        System.out.println(" --- Player 1 --- ");
        PFCharacter player = new PFCharacter();
        MyAbilityScore myAS = player.characterStats;
        MySkillRanks mySK = player.characterSkills;
        player.characterClass = (PFClass) new PFBarbarian();
        PFClass myClass = player.characterClass;

        for(AbilityScoreEnum enumvar : AbilityScoreEnum.values()){
            System.out.println(
                enumvar.toString() + ": " + myAS.getBase(enumvar)
            );
            System.out.println(
                enumvar.fullString() + " mod: " + myAS.getModifier(enumvar)
            );
        }
        System.out.println("<Set STR: " + myAS.setBase(STR, 20) + ">");
        for(AbilityScoreEnum enumvar : AbilityScoreEnum.values()){
            System.out.println(
                enumvar.toString() + ": " + myAS.getBase(enumvar)
            );
            System.out.println(
                enumvar.fullString() + " mod: " + myAS.getModifier(enumvar)
            );
        }

        System.out.println("<Set Stealth: " + mySK.setBase(stealth, 12) + ">");
        for(SkillRankEnum enumvar : SkillRankEnum.values()){
            System.out.println(
                enumvar.toString() + ": " + mySK.getBase(enumvar)
            );
        }

        System.out.println("== Class Stats == \n\n");
        PFClassName className = myClass.getClassName();
        System.out.println("Class: " +className);
        List<AlignmentEnum> badAlign = myClass.getAlignmentRestrictions();
        System.out.println("Alignment Restrictions: " +badAlign);
        String roleDesc = myClass.getRoleDescriptions();
        System.out.println("Role Description: " +roleDesc);
        DiceEnum die = myClass.getHitDie();
        System.out.println("Hit Die: " +die.name());
        double initWealth = myClass.calcInitWealth();
        System.out.println("Initial Wealth: " + initWealth);
        double initOutfitWealth = myClass.getInitOutfitWealth();
        System.out.println("Outfit Wealth: " +initOutfitWealth);
        List<SkillRankEnum> classSkills = myClass.getClassSkills();
        System.out.println("Class Skills: " +classSkills);
        int classSR = myClass.getSkillRanksPerLevel() + myAS.getModifier(INT);
        System.out.println("Skill Ranks per Level (INT): " +classSR);

        System.out.println("== Game Feat List == \n\n");
        printFeats(FeatList.getCombatFeatList());
        printFeats(FeatList.getGeneralFeatList());
    }

    private static void printFeats(List<Feat> featList){    
        for (Feat feat: featList){
            System.out.println("Feat: " + feat);
            System.out.println("Category: " + feat.getCategory());
            System.out.println("Prereq: " + feat.getPrereq());
            System.out.println("Benefit: " + feat.getBenefitDesc());
            FeatFunction FF = feat.getBenefit();
            System.out.println("FeatFunction Output: " +  FF.doFunction(null));
            System.out.println("Source: " + feat.getSource());
        }
    }


}