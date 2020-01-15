package PFPackage;

import PFPackage.Character.*;
import PFPackage.PFBooks.PFClasses.*;
import PFPackage.PFBooks.PFFavoredClassBonus.FCBonus;
import PFPackage.PFBooks.PFFeats.*;
import PFPackage.PFBooks.PFRaces.*;
import PFPackage.PFBooks.AlignmentEnum;
import PFPackage.PFBooks.DiceEnum;
import PFPackage.PFBooks.LanguageEnum;

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

    public static PFClass BarbarianInst = (PFClass) new PFBarbarian();
    public static PFClass FighterInst = (PFClass) new PFFighter();

    public static PFRace HumanInst = (PFRace) new PFHuman();
    public static PFRace DwarfInst = (PFRace) new PFDwarf();
    

    @SuppressWarnings("resource")
    private static int getIntInput(int min, int max) {
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

    private static void printIntChoice(int number, String option){
        System.out.println("(" + number + ")     " + option);
    }

    private static PFClass getPFClass(PFClassName name) {
        if (name == PFClassName.Barbarian) {
            return BarbarianInst;
        }
        if (name == PFClassName.Fighter) {
            return FighterInst;
        }

        System.out.println("Unhandled Class entered!");
        return null;
    }

    private static PFRace getPFRace(PFRaceName name) {
        if (name == PFRaceName.Human) {
            return HumanInst;
        }
        if (name == PFRaceName.Dwarf){
            return DwarfInst;
        }

        System.out.println("Unhandled Race entered!");
        return null;
    }

    private static PFClass promptPFClass(){        
        PFClass out = null;
        int ctr = 1;
        PFClassName[] pfClassArray = PFClassName.values();
        for(PFClassName name : pfClassArray){
            //System.out.println("(" + ctr + ") " + name.toString());
            printIntChoice(ctr, name.toString());
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

    private static int promptAbScore(){        
        int value;
        //System.out.println("(" + 1 + ") Enter Value");
        printIntChoice(1, "Enter Value");
        //System.out.println("(" + 2 + ") 7 d20 rolls");
        printIntChoice(2, "7 d20 rolls");
        //System.out.println("(" + 3 + ") Anarchy rolls");        
        printIntChoice(3, "Anarchy rolls");
        System.out.println("Pick Abscore Input mode: ");
        while(true){                    
            value = getIntInput(1, 3);
            break;
        }
        return value;
    }

    private static PFRace promptPFRace(){        
        PFRace out = null;
        int ctr = 1;
        PFRaceName[] pfRaceArray = PFRaceName.values();
        for(PFRaceName name : pfRaceArray){
            //System.out.println("(" + ctr + ") " + name.toString());
            printIntChoice(ctr, name.toString());
            ctr++;
        }
        System.out.println("Pick Race: ");
        while(true){                    
            int value = getIntInput(1, pfRaceArray.length) - 1;
            System.out.println(pfRaceArray[value].toString());
            out = getPFRace(pfRaceArray[value]);
            if(out != null) break;
            System.out.println("PICK A DIFFERENT RACE");
        }
        return out;
    }

    private static void genAnarchyABScore(MyAbilityScore stats){
        for(AbilityScoreEnum stat: AbilityScoreEnum.values()){
            stats.setBase(stat, DiceEnum.d20.roll());
        }
    }

    private static int promptPickScore(List<Integer> rolls, AbilityScoreEnum aEnum){
        System.out.println("Pick Value for " + aEnum);
        int ctr = 1;
        int value = -1;
        for(int roll : rolls){
            //System.out.println("(" + ctr + ") " + roll );
            printIntChoice(ctr, String.valueOf(roll));
            ctr++;
        }
        while(true){                    
            value = getIntInput(1, rolls.size()) - 1;
            break;
        }
        return value;
    }

    private static void genTopSixABScore(MyAbilityScore stats){        
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

    private static void genPrompt(MyAbilityScore stats){
        for(AbilityScoreEnum aEnum: AbilityScoreEnum.values()){
            System.out.println("Input " + aEnum + " Value");
            int value = getIntInput(1,20);
            stats.setBase(aEnum, value);
        }        
    }

    private static void initAbScore(MyAbilityScore AB){
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



    private static void printAbS(MyAbilityScore stats){
        for(AbilityScoreEnum enumvar : AbilityScoreEnum.values()){
            String enumString = enumvar.toString();
            String enumStat = String.valueOf(stats.getBase(enumvar));
            String enumMod = String.valueOf(stats.getModifier(enumvar));
            System.out.println(
                enumString + ": " + enumStat + " mod[" + enumMod + "]"
            );
        }
    }

    /*========= TEST =========*/
    public static void testhuman(){
        PFRace race = new PFHuman();
        List<String> list = race.getDefaultNames();
        int ctr = 1;
        for(String name : list){
            System.out.print(name + ", ");
            if(ctr % 10 == 0) System.out.println();
            ctr++;
        }
        for(int i = 0; i < 1; i++){
            System.out.println("---");
            int test = race.getRandomStartingAge(PFClassName.Wizard);
            System.out.println(test);
            test = race.getRandomHeight(0);        
            System.out.println(test/12 + "'" +test%12 + "''");
            test = race.getRandomWeight(0);
            System.out.println(test);
        }
        System.out.println(race.getDescription());        
    }

    private static int promptRaceStatModHuman(MyAbilityScore myStats){        
        int value;
        int ctr = 1;
        AbilityScoreEnum[] pfAbsArray = AbilityScoreEnum.values();
        for(AbilityScoreEnum name : pfAbsArray){
            String option = name.toString() +
                "[" + myStats.getBase(name) + "](" +
                myStats.getModifier(name) + ")";
            printIntChoice(ctr, option);
            ctr++;
        }
        System.out.println("Select Ability Score to increase by 2:");
        while(true){                    
            value = getIntInput(1, pfAbsArray.length) - 1;
            break;
        }
        return value;
    }

    private static void applyRaceStatMod(PFRace myRace, MyAbilityScore myStats){
        AbilityScoreEnum[] enumArray = AbilityScoreEnum.values();
        if(myRace.getRaceName() == PFRaceName.Human){            
            int value = promptRaceStatModHuman(myStats);
            int newVal = 2 + myStats.getBase(enumArray[value]);
            myStats.setBase(enumArray[value], newVal);
        }else{
            int[] modArray = myRace.getRacialAbScoreMods();            
            for(int i = 0; i < modArray.length; i++){                        
                int newVal = modArray[i] + myStats.getBase(enumArray[i]);
                myStats.setBase(enumArray[i], newVal);
            }
        }    
    }

    private static FCBonus promptFCChoice(List<FCBonus> fcOptions) {
        /*
        int value;
        int ctr = 1;
        AbilityScoreEnum[] pfAbsArray = AbilityScoreEnum.values();
        for(AbilityScoreEnum name : pfAbsArray){
            String option = name.toString() +
                "[" + myStats.getBase(name) + "](" +
                myStats.getModifier(name) + ")";
            printIntChoice(ctr, option);
            ctr++;
        }
        System.out.println("Select Ability Score to increase by 2:");
        while(true){                    
            value = getIntInput(1, pfAbsArray.length) - 1;
            break;
        }
        return value;
        */
        int value = -1;
        int ctr = 1;
        for(FCBonus fcBonus: fcOptions){
            String option = fcBonus.toString();
            printIntChoice(ctr, option);
            System.out.println("        " + fcBonus.getBonusDesc());
            ctr++;
        }
        System.out.println("Select Focus Class Bonus for this level!:");
        while(true){                    
            value = getIntInput(1, fcOptions.size()) - 1;
            break;
        }
        return fcOptions.get(value);
    }

    /*========= TEST =========*/
    public static void generateCharacter(){
        System.out.println(" --- Generate a Character! --- ");
        System.out.println(" --- Player 1 --- ");        
        PFCharacter player = new PFCharacter();                

        initAbScore(player.characterStats);
        printAbS(player.characterStats);                
        
        System.out.println("===============");

        PFClass myClass = promptPFClass();
        player.characterClass.add(myClass);
        
        System.out.println("===============");

        PFRace myRace = promptPFRace();
        player.characterRace = myRace;
        
        System.out.println("===============");
        
        MyAbilityScore myStats = player.characterStats;
        applyRaceStatMod(myRace, myStats);
        printAbS(myStats);
        
        System.out.println("===============");

        player.characterSize = myRace.getSize();
        player.characterBaseSpeed = myRace.getBaseSpeed();
        player.characterLanguages.addAll(myRace.getLanguages());

        System.out.println("Set Size:");
        System.out.println(player.characterSize);

        System.out.println("Set Base Speed:");
        System.out.println(player.characterBaseSpeed);

        System.out.println("Set Languages:");
        for(LanguageEnum lang :  player.characterLanguages){
            System.out.println(lang.toString());
        }        

        System.out.println("Alignment Restrictions Noted:");
        player.alignmentRestriction.addAll(myClass.getAlignmentRestrictions());
        Object[] alignResArray = player.alignmentRestriction.toArray();
        String alignResArrayString = Arrays.toString(alignResArray);
        System.out.println(alignResArrayString);
        player.characterHitDie = myClass.getHitDie();

        System.out.println("Hit Die:");
        System.out.println(player.characterHitDie.toString());

        System.out.println("Hit Points:");
        int maxval = player.characterHitDie.value() + 
            player.characterStats.getModifier(CON);
        player.maxHitPoints = maxval;
        System.out.println(player.maxHitPoints);
        
        System.out.println("Class Skills Noted:");
        player.characterClassSkills.addAll(myClass.getClassSkills());
        Object[] classSkillArray = player.characterClassSkills.toArray();
        String classSkillArrayString = Arrays.toString(classSkillArray);
        System.out.println(classSkillArrayString);

        System.out.println("FC Bonus For 1st Level:");
        //player.characterFCoptions.addAll(myClass.getFCBonusOptionList());
        List<FCBonus> FCoptions = player.characterFCoptions; 
        List<FCBonus> classFCoptions = myClass.getFCBonusOptionList();
        addValidFCOptions(FCoptions, classFCoptions, myRace);
        player.characterFCBonus = promptFCChoice(FCoptions);
        System.out.println(player.characterFCBonus.toString());
    }

    private static void addValidFCOptions(List<FCBonus> fcOptions,
        List<FCBonus> classFCoptions, PFRace race) {
        for(FCBonus bonus : classFCoptions){
            if(race.getRaceName() == bonus.getRace()){
                fcOptions.add(bonus);
            }
        }
    }

    /* ========= TEST ========= */
    public static void test() {
        System.out.println(" --- Player 1 --- ");
        PFCharacter player = new PFCharacter();
        MyAbilityScore myAS = player.characterStats;
        MySkillRanks mySK = player.characterSkills;
        player.characterClass.add(FighterInst);
        PFClass myClass = player.characterClass.get(0);

        printAbS(myAS);
        System.out.println("<Set STR: " + myAS.setBase(STR, 20) + ">");
        printAbS(myAS);

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

    private static void printFCBonusList(List<FCBonus> list){
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