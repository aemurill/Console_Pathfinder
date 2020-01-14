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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class StatManager {
    public static <T> T cast(Object obj, Class<T> clazz) {
        return (T) obj;
    }

    public static PFClass Barbarian = (PFClass) new PFBarbarian();
    public static PFClass Fighter = (PFClass) new PFFighter();

    @SuppressWarnings("resource")
    public static int getIntInput(int min, int max) {
        Scanner in = new Scanner(System.in);
        int check = -1;
        while(true) {            
            try { 
                check = in.nextInt();                
            } catch (Exception InputMismatchException) {
                System.out.println("Type Number!");
                in.nextLine();
                continue;
            }

            if(check >= min && check <= max ){
                break;
            }   
            System.out.println("Type Valid Number");
        }

        return check;
    }

    public static PFClass getPFClass(PFClassName name) {
        if (name == PFClassName.Barbarian) {
            return Barbarian;
        }
        if (name == PFClassName.Fighter) {
            return Fighter;
        }

        System.out.println("Unhandled Class entered!");
        return null;
    }

    public static PFClass promptPFClass(){        
        PFClass out = null;
        int ctr = 1;
        PFClassName[] pfClassArray = PFClassName.values();
        for(PFClassName name : pfClassArray){
            System.out.println(name.toString() + " (" + ctr + ")");
            ctr++;
        }
        System.out.println("Pick Class: ");
        while(true){                    
            int value = getIntInput(1, pfClassArray.length) - 1;
            System.out.println(pfClassArray[value].toString());
            out = getPFClass(pfClassArray[value]);
            if(out != null) break;
            System.out.println("PICK A DIFFERENT CLASS");
        }
        return out;
    }

    public static int promptAbScore(){        
        int value;
        System.out.println("Enter Value" + " (" + 1 + ")");
        System.out.println("7 d20 rolls" + " (" + 2 + ")");
        System.out.println("Anarchy rolls" + " (" + 3 + ")");        
        System.out.println("Pick Abscore Input mode: ");
        while(true){                    
            value = getIntInput(1, 3);
            break;
        }
        return value;
    }

    public static void genAnarchyABScore(MyAbilityScore stats){
        for(AbilityScoreEnum stat: AbilityScoreEnum.values()){
            stats.setBase(stat, DiceEnum.d20.roll());
        }
    }

    public static int promptPickScore(List<Integer> rolls, AbilityScoreEnum aEnum){
        System.out.println("Pick Value for " + aEnum);
        int ctr = 1;
        int value = -1;
        for(int roll : rolls){
            System.out.println(roll + " (" + ctr + ")");
            ctr++;
        }
        while(true){                    
            value = getIntInput(1, rolls.size()) - 1;
            break;
        }
        return value;
    }

    public static void genTopSixABScore(MyAbilityScore stats){        
        List<Integer> rolls = new ArrayList<Integer>(0);
        for(int i = 0; i < 7; i++){
            rolls.add(DiceEnum.d20.roll());
        }
        for(AbilityScoreEnum aEnum: AbilityScoreEnum.values()){
            int value = promptPickScore(rolls, aEnum);
            Integer IntValue = rolls.remove(value);
            stats.setBase(aEnum, IntValue.intValue());
        }
    }

    public static void genPrompt(MyAbilityScore stats){
        for(AbilityScoreEnum aEnum: AbilityScoreEnum.values()){
            System.out.println("Input " + aEnum + " Value");
            int value = getIntInput(1,20);
            stats.setBase(aEnum, value);
        }        
    }

    public static void initAbScore(MyAbilityScore AB){
        int rollType = promptAbScore();
        if(rollType == 1){
            System.out.println("ENTER");
            genPrompt(AB);
        }
        if(rollType == 2){
            System.out.println("7 d20s");
            genTopSixABScore(AB);
        }
        if(rollType == 3){
            System.out.println("ANARCHY");
            genAnarchyABScore(AB);
        }
    }

    public static void printAbS(MyAbilityScore stats){
        for(AbilityScoreEnum enumvar : AbilityScoreEnum.values()){
            System.out.println(
                enumvar.toString() + ": " + stats.getBase(enumvar)
            );
            System.out.println(
                enumvar.fullString() + " mod: " + stats.getModifier(enumvar)
            );
        }
    }

    public static void run2(){
        System.out.println(" --- Generate a Character! --- ");
        System.out.println(" --- Player 1 --- ");        
        PFCharacter player = new PFCharacter();
                
        PFClass myClass = promptPFClass();
        player.characterClass.add(myClass);
        
        initAbScore(player.characterStats);
        printAbS(player.characterStats);
        
        
        
        
        //PFBarbarian.getInitOutfitWealth();
        //PFCharacter player = new PFCharacter();
        //player.characterClass = (PFClass) new PFBarbarian();
    }


    public static void run() {
        System.out.println(" --- Player 1 --- ");
        PFCharacter player = new PFCharacter();
        MyAbilityScore myAS = player.characterStats;
        MySkillRanks mySK = player.characterSkills;
        player.characterClass.add(Fighter);
        PFClass myClass = player.characterClass.get(0);

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
        
        System.out.println("\n\n== Classes's (" + 
            myClass.getClassName().toString() + 
            ") Feat List == ");        
            myClass.getClassFeatures().printFeats();

        player.characterFeats.addFeatByString("Acrobatic Spellcaster");
        for(Feat feat: myClass.getClassFeatures()){
            player.characterFeats.add(feat);
        }
        
        System.out.println("\n\n== Player's Feat List == [");        
        player.characterFeats.printFeats();
        Arrays.toString(player.characterFeats.toArray());
        System.out.println("]");        
        

        System.out.println("\n\n== Classes's (" + 
            myClass.getClassName().toString() + 
            ") Focus Class Bonus List == ");        
        printFCBonusList(myClass.getFCBonusOptionList());
        
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