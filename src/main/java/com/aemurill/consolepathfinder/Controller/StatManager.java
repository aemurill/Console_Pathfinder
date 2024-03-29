package com.aemurill.consolepathfinder.Controller;

//import java.io.ByteArrayInputStream;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
//import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//import java.util.function.Consumer;

import com.aemurill.consolepathfinder.Model.PFPackage.Character.*;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.AlignmentEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.DiceEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.LanguageEnum;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFClasses.*;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFFavoredClassBonus.*;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFFeats.*;
import com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFRaces.*;
//import com.aemurill.consolepathfinder.Lib.System.out;
import com.aemurill.consolepathfinder.Lib.LambdaClass;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import static com.aemurill.consolepathfinder.Model.PFPackage.Character.AbilityScoreEnum.*;
import static com.aemurill.consolepathfinder.Model.PFPackage.Character.SkillRankEnum.*;

public class StatManager {
    /*public static <T> T cast(Object obj, Class<T> clazz) {
        return (T) obj;
    }*/
    //private ;
    //private Consumer<String> onMessageReceivedHandler;

    public static PFClass BarbarianInst = (PFClass) new PFBarbarian();
    public static PFClass FighterInst = (PFClass) new PFFighter();

    public static PFRace HumanInst = (PFRace) new PFHuman();
    public static PFRace DwarfInst = (PFRace) new PFDwarf();

    public static FCBonusList FCBonusList = new FCBonusList();

    enum RollMode {
        Official, Fun, Exploding
    }

    public static RollMode intRollMode = RollMode.Fun;

    public StatManager(){
        //this.System.out = System.out;
        //this.onMessageReceivedHandler = ((x) -> return x;);
    }

    @SuppressWarnings("resource")
    private int getIntInput(int min, int max, LambdaClass lambda){
        InputStream inStream = System.in;
        Scanner in = new Scanner(inStream);
        in.useDelimiter("\n");        
        int check = -1;
        while (true) {
            lambda.doLambda(null);
            printEqualsLine();
            if(!in.hasNextInt()){
                System.out.println("Must enter a number! ("+ min + " to " + max +"):");                
                in.nextLine();
                continue;
            } 
            check = in.nextInt();

            if (check >= min && check <= max) {
                break;
            }
            System.out.println("Type Valid Number ("+ min + " to " + max +"):");
        }

        return check;
    }

    private void printEqualsLine(){
        System.out.println("===============");
    }

    @SuppressWarnings("resource")
    private static String getString() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        return s;
    }

    private void printIntChoice(int number, String option) {
        System.out.println("(" + number + ")     " + option);
    }

    private PFClass getPFClass(PFClassName name) {
        if (name == PFClassName.Barbarian) {
            return BarbarianInst;
        }
        if (name == PFClassName.Fighter) {
            return FighterInst;
        }

        System.out.println("Unhandled Class entered!");
        return null;
    }

    private PFClassName getPFClassName(PFClass aClass) {
        if (aClass instanceof PFBarbarian) {
            return PFClassName.Barbarian;
        }
        if (aClass instanceof PFFighter) {
            return PFClassName.Fighter;
        }

        System.out.println("Unhandled RaceName entered!");
        return null;
    }

    private PFRace getPFRace(PFRaceName name) {
        if (name == PFRaceName.Human) {
            return HumanInst;
        }
        if (name == PFRaceName.Dwarf) {
            return DwarfInst;
        }

        System.out.println("Unhandled Race entered!");
        return null;
    }

    private PFRaceName getPFRaceName(PFRace race) {
        if (race instanceof PFHuman) {
            return PFRaceName.Human;
        }
        if (race instanceof PFDwarf) {
            return PFRaceName.Dwarf;
        }

        System.out.println("Unhandled RaceName entered!");
        return null;
    }

    private PFClass promptPFClass() {
        PFClass out = null;        
        PFClassName[] pfClassArray = PFClassName.values();
        LambdaClass lambda = (x) -> {
            int ctr = 1;
            for (PFClassName name : pfClassArray) {
                // System.out.println("(" + ctr + ") " + name.toString());
                printIntChoice(ctr, name.toString());
                ctr++;
            }
            return true;
        };   
        System.out.println("Pick Class: ");
        while (true) {
            int value = getIntInput(1, pfClassArray.length, lambda) - 1;
            System.out.println(pfClassArray[value].toString());
            out = getPFClass(pfClassArray[value]);
            if (out != null)
                break;
            System.out.println("PICK A DIFFERENT CLASS");
        }
        return out;
    }

    private int promptAbScore() {
        int value;
        LambdaClass lambda = (x) -> {
            printIntChoice(1, "Enter Value");
            printIntChoice(2, "7 d20 rolls");        
            printIntChoice(3, "Anarchy rolls");
            return true;
        };
        System.out.println("Pick Abscore Input mode: ");
        while (true) {
            value = getIntInput(1, 3, lambda);
            break;
        }
        return value;
    }

    private PFRace promptPFRace() {
        PFRace out = null;        
        PFRaceName[] pfRaceArray = PFRaceName.values();
        LambdaClass lambda = (x) -> {
            int ctr = 1;
            for (PFRaceName name : pfRaceArray) {
                // System.out.println("(" + ctr + ") " + name.toString());
                printIntChoice(ctr, name.toString());
                ctr++;
            }
            return true;
        };
        System.out.println("Pick Race: ");
        while (true) {
            int value = getIntInput(1, pfRaceArray.length, lambda) - 1;
            System.out.println(pfRaceArray[value].toString());
            out = getPFRace(pfRaceArray[value]);
            if (out != null)
                break;
            System.out.println("PICK A DIFFERENT RACE");
        }
        return out;
    }

    private static void genAnarchyABScore(MyAbilityScore stats) {
        for (AbilityScoreEnum stat : AbilityScoreEnum.values()) {
            stats.setBase(stat, DiceEnum.d20.roll());
        }
    }

    private int promptPickScore(List<Integer> rolls, AbilityScoreEnum aEnum) {
        System.out.println("Pick Value for " + aEnum);        
        int value = -1;
        LambdaClass lambda = (x) -> {
            int ctr = 1;
            for (int roll : rolls) {
                // System.out.println("(" + ctr + ") " + roll );
                printIntChoice(ctr, String.valueOf(roll));
                ctr++;
            }
            return true;
        };
        while (true) {
            value = getIntInput(1, rolls.size(), lambda) - 1;
            break;
        }
        return value;
    }

    private void genTopSixABScore(MyAbilityScore stats) {
        List<Integer> rolls = new ArrayList<Integer>(0);
        for (int i = 0; i < 7; i++) {
            rolls.add(DiceEnum.d20.roll());
        }
        for (AbilityScoreEnum aEnum : AbilityScoreEnum.values()) {
            int value = promptPickScore(rolls, aEnum);
            Integer IntValue = rolls.remove(value);
            stats.setBase(aEnum, IntValue.intValue());
        }
    }

    private void genPrompt(MyAbilityScore stats) {
        for (AbilityScoreEnum aEnum : AbilityScoreEnum.values()) {
            LambdaClass lambda = (x) -> {
                System.out.println("Input " + aEnum + " Value");
                return true;
            };
            int value = getIntInput(1, 20, lambda);
            stats.setBase(aEnum, value);
        }
    }

    private void initAbScore(MyAbilityScore AB) {
        int rollType = promptAbScore();
        if (rollType == 1) {
            System.out.println("<Prepare to enter scores>");
            genPrompt(AB);
        }
        if (rollType == 2) {
            System.out.println("<Rolling 7 d20s>");
            genTopSixABScore(AB);
        }
        if (rollType == 3) {
            System.out.println("<ANARCHY>");
            genAnarchyABScore(AB);
        }
    }

    private void printAbS(MyAbilityScore stats) {
        for (AbilityScoreEnum enumvar : AbilityScoreEnum.values()) {
            String enumString = enumvar.toString();
            String enumStat = String.valueOf(stats.getBase(enumvar));
            String enumMod = String.valueOf(stats.getModifier(enumvar));
            System.out.println(enumString + ": " + enumStat + " mod[" + enumMod + "]");
        }
    }

    /* ========= TEST ========= */
    public void testhuman() {
        PFRace race = new PFHuman();
        List<String> list = race.getDefaultNames();
        int ctr = 1;
        for (String name : list) {
            System.out.print(name + ", ");
            if (ctr % 10 == 0)
                System.out.println();
            ctr++;
        }
        for (int i = 0; i < 1; i++) {
            System.out.println("---");
            int test = race.getRandomStartingAge(PFClassName.Wizard);
            System.out.println(String.valueOf(i));
            test = race.getRandomHeight(0);
            System.out.println(test / 12 + "'" + test % 12 + "''");
            test = race.getRandomWeight(0);
            System.out.println(String.valueOf(test));
        }
        System.out.println(race.getDescription());
    }

    private int promptRaceStatModHuman(MyAbilityScore myStats) {
        int value;        
        AbilityScoreEnum[] pfAbsArray = AbilityScoreEnum.values();
        LambdaClass lambda = (x) -> {
            int ctr = 1;
            for (AbilityScoreEnum name : pfAbsArray) {
                String option = name.toString() + "[" + myStats.getBase(name) + "](" + myStats.getModifier(name) + ")";
                printIntChoice(ctr, option);
                ctr++;
            }
            System.out.println("Select Ability Score to increase by 2:");
            return true;
        };
        while (true) {
            value = getIntInput(1, pfAbsArray.length, lambda) - 1;
            break;
        }
        return value;
    }

    private void applyRaceStatMod(PFRace myRace, MyAbilityScore myStats) {
        AbilityScoreEnum[] enumArray = AbilityScoreEnum.values();
        if (myRace.getRaceName() == PFRaceName.Human) {
            int value = promptRaceStatModHuman(myStats);
            int newVal = 2 + myStats.getBase(enumArray[value]);
            myStats.setBase(enumArray[value], newVal);
        } else {
            int[] modArray = myRace.getRacialAbScoreMods();
            for (int i = 0; i < modArray.length; i++) {
                int newVal = modArray[i] + myStats.getBase(enumArray[i]);
                myStats.setBase(enumArray[i], newVal);
            }
        }
    }

    private String promptFCChoice(List<String> fcOptions) {
        int value = -1;
        LambdaClass lambda = (x) -> {
            int ctr = 1;
            String option = null;
            for (String fcBonus : fcOptions) {
                option = fcBonus;
                FCBonus fcbOBJ = FCBonusList.getBonus(option);
                printIntChoice(ctr, option);
                System.out.println("        " + fcbOBJ.getBonusDesc());
                ctr++;
            }
            System.out.println("Select Focus Class Bonus for this level!:");
            return true;
        };
        while (true) {
            value = getIntInput(1, fcOptions.size(), lambda) - 1;
            break;
        }
        
        return fcOptions.get(value);
    }

    private static void addValidFCOptions(List<String> fcOptions, List<String> classFCoptions, PFRace race) {
        for (String bonus : classFCoptions) {
            if (race.getRaceName() == FCBonusList.getBonus(bonus).getRace()) {
                fcOptions.add(bonus);
            }
        }
    }

    private String promptCharName() {
        String value = null;
        System.out.println("Select Character Name:");
        while (true) {
            value = getString();
            break;
        }
        return value;
    }

    /* ========= TEST ========= */
    public void generateCharacter() {
        System.out.println(" --- Generate a Character! --- ");
        System.out.println(" --- Player 1 --- ");
        PFCharacter player = new PFCharacter();

        initAbScore(player.characterStats);
        printAbS(player.characterStats);

        System.out.println("===============");// TODO 

        PFClass myClass = promptPFClass();
        player.characterClassName.add(getPFClassName(myClass));

        System.out.println("===============");// TODO 

        PFRace myRace = promptPFRace();
        player.characterRaceName = getPFRaceName(myRace);

        System.out.println("===============");// TODO 

        MyAbilityScore myStats = player.characterStats;
        applyRaceStatMod(myRace, myStats);
        printAbS(myStats);

        System.out.println("===============");// TODO 

        player.characterSize = myRace.getSize();
        player.characterBaseSpeed = myRace.getBaseSpeed();
        player.characterLanguages.addAll(myRace.getLanguages());

        System.out.println("Set Size:");
        System.out.println(player.characterSize.toString());

        System.out.println("Set Base Speed:");
        System.out.println(String.valueOf(player.characterBaseSpeed));

        System.out.println("Set Languages:");
        for (LanguageEnum lang : player.characterLanguages) {
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
        player.characterMaxHitPoints = maxval;
        System.out.println(String.valueOf(player.characterMaxHitPoints));

        System.out.println("Class Skills Noted:");
        player.characterClassSkills.addAll(myClass.getClassSkills());
        Object[] classSkillArray = player.characterClassSkills.toArray();
        String classSkillArrayString = Arrays.toString(classSkillArray);
        System.out.println(classSkillArrayString);

        System.out.println("FC Bonus For 1st Level:");
        List<String> FCoptions = player.characterFCoptions;
        List<String> classFCoptions = myClass.getFCBonusOptionList();
        addValidFCOptions(FCoptions, classFCoptions, myRace);
        player.characterFCBonus = promptFCChoice(FCoptions);
        System.out.println(player.characterFCBonus.toString());

        System.out.println("===============");// TODO 

        ClassTableRow[] myClassTable = myClass.getClassTable();
        player.characterBAB = myClassTable[0].BAB;
        System.out.println("BAB: +" + player.characterBAB);
        player.characterFortSave = myClassTable[0].FortSave;
        System.out.println("Fortitude Save: +" + player.characterFortSave);
        player.characterRefSave = myClassTable[0].RefSave;
        System.out.println("Reflex Save: +" + player.characterRefSave);
        player.characterWillSave = myClassTable[0].WillSave;
        System.out.println("Will Save: +" + player.characterWillSave);

        System.out.println("CMB: " + player.getCMB());
        System.out.println("CMD: " + player.getCMD());
    }

    /* ========= TEST ========= */
    public void test() {
        System.out.println(" --- Player 1 --- ");
        PFCharacter player = new PFCharacter();
        MyAbilityScore myAS = player.characterStats;
        MySkillRanks mySK = player.characterSkills;
        player.characterClassName.add(PFClassName.Fighter);
        PFClass myClass = getPFClass(player.characterClassName.get(0));

        printAbS(myAS);
        System.out.println("<Set STR: " + myAS.setBase(STR, 20) + ">");
        printAbS(myAS);

        System.out.println("<Set Stealth: " + mySK.setBase(stealth, 12) + ">");
        for (SkillRankEnum enumvar : SkillRankEnum.values()) {
            System.out.println(enumvar.toString() + ": " + mySK.getBase(enumvar));
        }

        System.out.println("\n\n== Class Stats == ");
        PFClassName className = myClass.getClassName();
        System.out.println("Class: " + className);
        List<AlignmentEnum> badAlign = myClass.getAlignmentRestrictions();
        System.out.println("Alignment Restrictions: " + badAlign);
        String roleDesc = myClass.getRoleDescriptions();
        System.out.println("Role Description: " + roleDesc);
        DiceEnum die = myClass.getHitDie();
        System.out.println("Hit Die: " + die.name());
        double initWealth = myClass.calcInitWealth();
        System.out.println("Initial Wealth: " + initWealth);
        double initOutfitWealth = myClass.getInitOutfitWealth();
        System.out.println("Outfit Wealth: " + initOutfitWealth);
        List<SkillRankEnum> classSkills = myClass.getClassSkills();
        System.out.println("Class Skills: " + classSkills);
        int classSR = myClass.getSkillRanksPerLevel() + myAS.getModifier(INT);
        System.out.println("Skill Ranks per Level (INT): " + classSR);

        System.out.println("\n\n== Game Feat List ==");
        FeatListArchive.getCombatFeatList().printFeats();
        FeatListArchive.getGeneralFeatList().printFeats();

        System.out.println("\n\n== Classes's (" + myClass.getClassName().toString() + ") Feat List == ");
        myClass.getClassFeatures().printFeats();

        player.characterFeats.addFeatByString("Acrobatic Spellcaster");
        for (Feat feat : myClass.getClassFeatures()) {
            player.characterFeats.add(feat);
        }

        System.out.println("\n\n== Player's Feat List == [");
        player.characterFeats.printFeats();
        Arrays.toString(player.characterFeats.toArray());
        System.out.println("]");

        System.out.println("\n\n== Classes's (" + myClass.getClassName().toString() + ") Focus Class Bonus List == ");
        printFCBonusList(myClass.getFCBonusOptionList());

    }

    private void printFCBonusList(List<String> list) {
        int ctr = 0;
        System.out.println("TEST");
        for (String key : list) {
            FCBonus fcb = FCBonusList.getBonus(key);
            if (ctr != 0)
                System.out.println("**************");
            System.out.println("Name: " + fcb);
            System.out.println("Race: " + fcb.getRace());
            System.out.println("Bonus: " + fcb.getBonusDesc());
            LambdaClass FF = fcb.getBonus();
            System.out.println("Function Output: " + FF.doLambda(null));
            System.out.println("Source: " + fcb.getSource());
            ctr++;
        }
    }    

    public static Map<Integer, PFCharacter> loadChars() {
        /*Gson gson = new GsonBuilder().registerTypeAdapter(
            new TypeToken<EnumMap<AbilityScoreEnum, Integer>>() {}.getType(),
            new EnumMapInstanceCreator<AbilityScoreEnum, Integer>(
                AbilityScoreEnum.class)).create();*/
        System.out.println("load chars");
        int ctr = 0;
        System.out.println(String.valueOf(ctr++));
        Gson gson = new Gson();
        System.out.println(String.valueOf(ctr++));
        Type type = new TypeToken<Map<Integer, PFCharacter>>() {}.getType();
        System.out.println(String.valueOf(ctr++));
        Map<Integer, PFCharacter> map = null;
        System.out.println(String.valueOf(ctr++));
        try {
            System.out.println(String.valueOf(ctr++));
            Reader reader = new FileReader("character.tmp");            
            System.out.println(String.valueOf(ctr++));
            JsonReader jReader = new JsonReader(reader);
            System.out.println(String.valueOf(ctr++));
            JsonObject jObject = gson.fromJson(jReader, JsonObject.class);
            System.out.println(String.valueOf(ctr++));
            System.out.println("BOOP");
            System.out.println("boop");
            JsonElement jElement = jObject.get("general");    
            System.out.println("BOOP");
            System.out.println("boop");
            System.out.println(String.valueOf(ctr++));
            System.out.println(jElement.toString());
            System.out.println(String.valueOf(ctr++));
            map = gson.fromJson(jElement, type);
            System.out.println(String.valueOf(ctr++));
            reader.close();
            System.out.println(String.valueOf(ctr++));
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            System.out.println("ERROR LOADING PLAYERS");
            e.printStackTrace();
            
        }
        return map;
    }

    public void saveChars(PFCharacter[] players){    
        Map<Integer, PFCharacter> map = new HashMap<Integer, PFCharacter>();
        int ctr = 0;
        for(PFCharacter player: players){
            map.put(ctr++, player);
        }
        //System.out.flush();
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Integer, PFCharacter>>() {}.getType();
        try {
            //Writer writer = new FileWriter("character.tmp");
            JsonElement jsonTree = gson.toJsonTree(map, type);
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("general", jsonTree);
            //writer.write(jsonObject.toString());
            //writer.flush();
            //writer.close();
        } catch (JsonIOException /*| IOException*/ e1) {
            e1.printStackTrace();
        }
    }

    public void genChar4Fight(){
        System.out.println(" --- Generate 2 Characters! --- ");
        PFCharacter player1 = genCharacter();
        PFCharacter player2 = genCharacter();
        PFCharacter[] players = {player1, player2};
        saveChars(players);
    }

    /* ========= TEST ========= */
    public void testPunchingFight() {
        System.out.println("TEST PUNCHING FIGHT");
        Map<Integer, PFCharacter> map = loadChars();
        PFCharacter player1 = map.get(0);
        PFCharacter player2 = map.get(1);
        //PFCharacter player1 = genCharacter();
        //PFCharacter player2 = genCharacter();

        System.out.println("**************");
        System.out.println("ATTACK");
        System.out.println("**************");
        int initOrder = initOrder(player1, player2);
        boolean bothLive = true;
        PFCharacter faster = player1;
        PFCharacter slower = player2;
        PFCharacter winner = null;
        if (initOrder == 2) {
            faster = player2;
            slower = player1;
        }
        System.out.println("Int Order: " + faster.characterName + " " + slower.characterName);
        int ctr = 1;
        while (bothLive) {            
            System.out.println("@@@@@@@ TURN " + ctr + " @@@@@@@@");
            ctr++;
            //attack loop
            System.out.println("====== " + faster.characterName + "'s turn! ======");
            attack(faster, slower);
            if(slower.characterHitPoints == 0){
                winner = faster;
                break;
            }
            System.out.println("====== " + slower.characterName + "'s turn! ======");
            attack(slower, faster);
            if(faster.characterHitPoints == 0){
                winner = slower;
                break;                
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
            printCharBattleStatus(faster);
            printCharBattleStatus(slower);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }        
        printWinner(winner);
        printCharBattleStatus(faster);
        printCharBattleStatus(slower);
        System.out.println(faster.characterName);
        printAbS(faster.characterStats);
        System.out.println(slower.characterName);
        printAbS(slower.characterStats);
    }   

    private void printWinner(PFCharacter winner){
        System.out.println("@@@@@@@@ " + winner.characterName + " Wins! @@@@@@@@");
    }

    private void printCharBattleStatus(PFCharacter combatant){
        double percent = (combatant.characterHitPoints * (100.0))
                / combatant.characterMaxHitPoints;
        System.out.println(
            combatant.characterName + ": " + 
            combatant.characterHitPoints + "/" + 
            combatant.characterMaxHitPoints + " " +                
            String.valueOf(percent)
        );
    }

    private static int initOrder(PFCharacter player1, PFCharacter player2){
        int dex1 = player1.characterStats.getModifier(DEX);
        int dex2 = player2.characterStats.getModifier(DEX);

        int init1  = DiceEnum.d20.roll() + dex1;
        int init2  = DiceEnum.d20.roll() + dex2;

        if(init1 > init2) return 1;
        if(init1 < init2) return 2;
        
        if(dex1 > dex2 ) return 1;
        if(dex1 < dex2 ) return 2;

        while(true){
            if(init1 > init2) return 1;
            if(init1 < init2) return 2;
        }
    }
    
    private static int rollHitNoCrit(PFCharacter player, int[] roll){
        int attack = player.characterBAB + player.characterStats.getModifier(STR) +
            player.characterSize.getMod();
        roll[0] = DiceEnum.d20.roll();        
        attack = roll[0] + attack - 4;    

        return attack;
    }

    private int rollHit(PFCharacter player, int[] roll, boolean[] crit){
        int attack = player.characterBAB + player.characterStats.getModifier(STR) +
            player.characterSize.getMod();
        roll[0] = DiceEnum.d20.roll();
        System.out.println("Actual Roll: " + roll[0]);
        if(roll[0] == 20){
            if(intRollMode == RollMode.Official){
                System.out.print("Confirming Crit: ");
                int[] roll2 = {1};
                int noCritRoll = rollHitNoCrit(player, roll2);
                if(checkHit(noCritRoll, roll2, player) == 0){
                    crit[0] = true;                    
                }else{
                    System.out.println("No crit today :(");
                }
            }    
            if(intRollMode == RollMode.Fun)  crit[0] = true;
        } 
        if(crit[0] == true){
            System.out.println("CRITICAL HIT!");
        }
        attack = roll[0] + attack - 4;    

        return attack;
    }

    private int checkHit(int attack, int[] roll, PFCharacter defender){
        //System.out.println("check roll: " + roll[0]);
        if(roll[0] == 20){ //NAT 20 MEANS AUTO HIT / CONFIRM
            return 0;
        }

        int armorB = 2;
        int maxDexBonus = 6;
        int DexBonus = defender.characterStats.getModifier(DEX);
        if(DexBonus < maxDexBonus){
            maxDexBonus = DexBonus;
        }
        int AC = 10 + armorB + maxDexBonus + 0;

        System.out.println("Attack: " + attack + ", AC :" + AC);
        if(attack >= AC){
            return 0;
        }
        return -1;
    }

    private int rollDamage(PFCharacter player, boolean[] crit){
        int attack = 0;
        int roll = DiceEnum.d3.roll();
        System.out.println(String.valueOf(roll));
        int subAttack = roll + player.characterStats.getModifier(STR);
        if( subAttack <= 1) subAttack = 1;
        attack += subAttack;
        if(crit[0] == true){
            roll = DiceEnum.d3.roll();
            System.out.println(" " + roll);
            subAttack = roll + player.characterStats.getModifier(STR);
            if( subAttack <= 1) subAttack = 1;
            attack += subAttack;
        }        
        if( attack <= 1) attack = 1;
        System.out.println("Total Damage: " + attack);
        return attack;
    }

    private static void updateHealth(int attack, PFCharacter defender){
        int temp =  defender.characterHitPoints - attack;
        if (temp < 0) temp = 0;
        defender.characterHitPoints = temp;
    }

    private void attack(PFCharacter attacker, PFCharacter defender){
        boolean crit[] = {false};
        int roll[] = {1};
        System.out.print("ROLL TO HIT: ");
        int toHit = rollHit(attacker, roll, crit);        
        System.out.println("CHECK HIT:");
        if( checkHit(toHit, roll, defender) == 0 ){
            System.out.print(attacker.characterName + " HIT! ");
            System.out.print("ROLL DAMAGE: ");
            int toDamage = rollDamage(attacker, crit);
            System.out.println("APPLY DAMAGE");
            updateHealth(toDamage, defender);            
            System.out.println(toDamage + " DEALT! ");            
            return;
        }
        System.out.println(attacker.characterName + " MISSED!");
    }
    
    

    private PFCharacter genCharacter(){
        PFCharacter player = new PFCharacter();                

        //GEN ABSCORE
        initAbScore(player.characterStats);

        //GET CLASS
        PFClass myClass = promptPFClass();
        player.characterClassName.add(getPFClassName(myClass));        

        //GET RACE
        PFRace myRace = promptPFRace();
        player.characterRaceName = getPFRaceName(myRace);
        
        //APPLY MOD
        MyAbilityScore myStats = player.characterStats;
        applyRaceStatMod(myRace, myStats);
        printAbS(myStats);
        
        //APPLY PROPERTIES
        player.characterSize = myRace.getSize();
        player.characterBaseSpeed = myRace.getBaseSpeed();
        player.characterLanguages.addAll(myRace.getLanguages());
        player.alignmentRestriction.addAll(myClass.getAlignmentRestrictions());
        player.characterHitDie = myClass.getHitDie();
        int maxval = player.characterHitDie.value() + 
            player.characterStats.getModifier(CON);
        player.characterMaxHitPoints = maxval;
        player.characterHitPoints = maxval;
        
        System.out.println("Class Skills Noted:");
        player.characterClassSkills.addAll(myClass.getClassSkills());

        System.out.println("FC Bonus For 1st Level:");
        List<String> FCoptions = player.characterFCoptions; 
        List<String> classFCoptions = myClass.getFCBonusOptionList();
        addValidFCOptions(FCoptions, classFCoptions, myRace);
        player.characterFCBonus = promptFCChoice(FCoptions);

        ClassTableRow[] myClassTable = myClass.getClassTable();
        player.characterBAB = myClassTable[0].BAB;
        player.characterFortSave = myClassTable[0].FortSave;
        player.characterRefSave = myClassTable[0].RefSave;
        player.characterWillSave = myClassTable[0].WillSave;

        System.out.println("Name:");
        player.characterName = promptCharName();
        return player;
    }
}