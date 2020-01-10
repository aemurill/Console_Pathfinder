package PFPackage;

import PFPackage.Character.*;
import PFPackage.PFBooks.PFClasses.*;
import PFPackage.PFBooks.PFFavoredClassBonus.FCBonus;
import PFPackage.PFBooks.PFFeats.Feat;
import PFPackage.PFBooks.PFFeats.FeatListArchive;
import PFPackage.PFBooks.PFFeats.Function;
import PFPackage.PFBooks.AlignmentEnum;
import PFPackage.PFBooks.DiceEnum;
import static PFPackage.Character.AbilityScoreEnum.*;
import static PFPackage.Character.SkillRankEnum.*;

import java.util.Arrays;
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

        System.out.println("\n\n== Class Stats == ");
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

        System.out.println("\n\n== Game Feat List ==");
        FeatListArchive.getCombatFeatList().printFeats();
        FeatListArchive.getGeneralFeatList().printFeats();        
        
        System.out.println("\n\n== Barbarian's Feat List == [");        
        player.characterClass.getClassFeatures().printFeats();

        player.characterFeats.addFeatByString("Acrobatic Spellcaster");
        for(Feat feat: player.characterClass.getClassFeatures()){
            player.characterFeats.add(feat);
        }
        
        System.out.println("\n\n== Player's Feat List == [");        
        player.characterFeats.printFeats();
        Arrays.toString(player.characterFeats.toArray());
        System.out.println("]");        
        

        System.out.println("\n\n== Barbarian's Focus Class Bonus List == ");        
        printFCBonusList(player.characterClass.getFCBonusOptionList());
        
    }

    public static void printFCBonusList(List<FCBonus> list){
        int ctr = 0;
        System.out.println("TEST");
        for(FCBonus fcb: list){
            if(ctr != 0) System.out.println("**************");            
            System.out.println("Name: " + fcb);
            System.out.println("Race: " + fcb.getRace());
            System.out.println("Bonus: " + fcb.getBonusDesc());
            Function FF = fcb.getBonus();
            System.out.println("Function Output: " +  FF.doFunction(null));
            System.out.println("Source: " + fcb.getSource());
            ctr++;
        }
    }
}