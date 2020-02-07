package com.aemurill.pathfinderproject.Controller;

import java.io.ByteArrayInputStream;
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
import java.util.function.Consumer;

import com.aemurill.pathfinderproject.Model.PFPackage.Character.*;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.AlignmentEnum;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.DiceEnum;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.LanguageEnum;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFClasses.*;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFFavoredClassBonus.*;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFFeats.*;
import com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFRaces.*;
import com.aemurill.pathfinderproject.lib.Console;
import com.aemurill.pathfinderproject.lib.LambdaClass;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import static com.aemurill.pathfinderproject.Model.PFPackage.Character.AbilityScoreEnum.*;
import static com.aemurill.pathfinderproject.Model.PFPackage.Character.SkillRankEnum.*;

public class StatManager {
    /*public static <T> T cast(Object obj, Class<T> clazz) {
        return (T) obj;
    }*/
    private Console console;
    private Consumer<String> onMessageReceivedHandler;

    public static PFClass BarbarianInst = (PFClass) new PFBarbarian();
    public static PFClass FighterInst = (PFClass) new PFFighter();

    public static PFRace HumanInst = (PFRace) new PFHuman();
    public static PFRace DwarfInst = (PFRace) new PFDwarf();

    public static FCBonusList FCBonusList = new FCBonusList();

    enum RollMode {
        Official, Fun, Exploding
    }

    public static RollMode intRollMode = RollMode.Fun;

    public StatManager(Console console){
        this.console = console;
        //this.onMessageReceivedHandler = ((x) -> return x;);
    }

    @SuppressWarnings("resource")
    private int getIntInput(int min, int max, LambdaClass lambda){
        InputStream inStream = console.getIn();
        Scanner in = new Scanner(inStream);
        in.useDelimiter("\n");        
        int check = -1;
        while (true) {
            lambda.doLambda(null);
            while(!in.hasNextInt()){
                console.println("Type Number!");
                in.nextLine();
            } 
            check = in.nextInt();

            if (check >= min && check <= max) {
                break;
            }
            console.println("Type Valid Number");
        }

        return check;
    }

    @SuppressWarnings("resource")
    private static String getString() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        return s;
    }

    private void printIntChoice(int number, String option) {
        console.println("(" + number + ")     " + option);
    }

    private PFClass getPFClass(PFClassName name) {
        if (name == PFClassName.Barbarian) {
            return BarbarianInst;
        }
        if (name == PFClassName.Fighter) {
            return FighterInst;
        }

        console.println("Unhandled Class entered!");
        return null;
    }

    private PFClassName getPFClassName(PFClass aClass) {
        if (aClass instanceof PFBarbarian) {
            return PFClassName.Barbarian;
        }
        if (aClass instanceof PFFighter) {
            return PFClassName.Fighter;
        }

        console.println("Unhandled RaceName entered!");
        return null;
    }

    private PFRace getPFRace(PFRaceName name) {
        if (name == PFRaceName.Human) {
            return HumanInst;
        }
        if (name == PFRaceName.Dwarf) {
            return DwarfInst;
        }

        console.println("Unhandled Race entered!");
        return null;
    }

    private PFRaceName getPFRaceName(PFRace race) {
        if (race instanceof PFHuman) {
            return PFRaceName.Human;
        }
        if (race instanceof PFDwarf) {
            return PFRaceName.Dwarf;
        }

        console.println("Unhandled RaceName entered!");
        return null;
    }

    private PFClass promptPFClass() {
        PFClass out = null;        
        PFClassName[] pfClassArray = PFClassName.values();
        LambdaClass lambda = (x) -> {
            int ctr = 1;
            for (PFClassName name : pfClassArray) {
                // console.println("(" + ctr + ") " + name.toString());
                printIntChoice(ctr, name.toString());
                ctr++;
            }
            return true;
        };   
        console.println("Pick Class: ");
        while (true) {
            int value = getIntInput(1, pfClassArray.length, lambda) - 1;
            console.println(pfClassArray[value].toString());
            out = getPFClass(pfClassArray[value]);
            if (out != null)
                break;
            console.println("PICK A DIFFERENT CLASS");
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
        console.println("Pick Abscore Input mode: ");
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
                // console.println("(" + ctr + ") " + name.toString());
                printIntChoice(ctr, name.toString());
                ctr++;
            }
            return true;
        };
        console.println("Pick Race: ");
        while (true) {
            int value = getIntInput(1, pfRaceArray.length, lambda) - 1;
            console.println(pfRaceArray[value].toString());
            out = getPFRace(pfRaceArray[value]);
            if (out != null)
                break;
            console.println("PICK A DIFFERENT RACE");
        }
        return out;
    }

    private static void genAnarchyABScore(MyAbilityScore stats) {
        for (AbilityScoreEnum stat : AbilityScoreEnum.values()) {
            stats.setBase(stat, DiceEnum.d20.roll());
        }
    }

    private int promptPickScore(List<Integer> rolls, AbilityScoreEnum aEnum) {
        console.println("Pick Value for " + aEnum);        
        int value = -1;
        LambdaClass lambda = (x) -> {
            int ctr = 1;
            for (int roll : rolls) {
                // console.println("(" + ctr + ") " + roll );
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
                console.println("Input " + aEnum + " Value");
                return true;
            };
            int value = getIntInput(1, 20, lambda);
            stats.setBase(aEnum, value);
        }
    }

    private void initAbScore(MyAbilityScore AB) {
        int rollType = promptAbScore();
        if (rollType == 1) {
            console.println("ENTER");
            genPrompt(AB);
        }
        if (rollType == 2) {
            console.println("7 d20s");
            genTopSixABScore(AB);
        }
        if (rollType == 3) {
            console.println("ANARCHY");
            genAnarchyABScore(AB);
        }
    }

    private void printAbS(MyAbilityScore stats) {
        for (AbilityScoreEnum enumvar : AbilityScoreEnum.values()) {
            String enumString = enumvar.toString();
            String enumStat = String.valueOf(stats.getBase(enumvar));
            String enumMod = String.valueOf(stats.getModifier(enumvar));
            console.println(enumString + ": " + enumStat + " mod[" + enumMod + "]");
        }
    }

    /* ========= TEST ========= */
    public void testhuman() {
        PFRace race = new PFHuman();
        List<String> list = race.getDefaultNames();
        int ctr = 1;
        for (String name : list) {
            console.print(name + ", ");
            if (ctr % 10 == 0)
                console.println();
            ctr++;
        }
        for (int i = 0; i < 1; i++) {
            console.println("---");
            int test = race.getRandomStartingAge(PFClassName.Wizard, console);
            console.println(String.valueOf(i));
            test = race.getRandomHeight(0, console);
            console.println(test / 12 + "'" + test % 12 + "''");
            test = race.getRandomWeight(0, console);
            console.println(String.valueOf(test));
        }
        console.println(race.getDescription());
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
            console.println("Select Ability Score to increase by 2:");
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
                console.println("        " + fcbOBJ.getBonusDesc());
                ctr++;
            }
            console.println("Select Focus Class Bonus for this level!:");
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
        console.println("Select Character Name:");
        while (true) {
            value = getString();
            break;
        }
        return value;
    }

    /* ========= TEST ========= */
    public void generateCharacter() {
        console.println(" --- Generate a Character! --- ");
        console.println(" --- Player 1 --- ");
        PFCharacter player = new PFCharacter();

        initAbScore(player.characterStats);
        printAbS(player.characterStats);

        console.println("===============");

        PFClass myClass = promptPFClass();
        player.characterClassName.add(getPFClassName(myClass));

        console.println("===============");

        PFRace myRace = promptPFRace();
        player.characterRaceName = getPFRaceName(myRace);

        console.println("===============");

        MyAbilityScore myStats = player.characterStats;
        applyRaceStatMod(myRace, myStats);
        printAbS(myStats);

        console.println("===============");

        player.characterSize = myRace.getSize();
        player.characterBaseSpeed = myRace.getBaseSpeed();
        player.characterLanguages.addAll(myRace.getLanguages());

        console.println("Set Size:");
        console.println(player.characterSize.toString());

        console.println("Set Base Speed:");
        console.println(String.valueOf(player.characterBaseSpeed));

        console.println("Set Languages:");
        for (LanguageEnum lang : player.characterLanguages) {
            console.println(lang.toString());
        }

        console.println("Alignment Restrictions Noted:");
        player.alignmentRestriction.addAll(myClass.getAlignmentRestrictions());
        Object[] alignResArray = player.alignmentRestriction.toArray();
        String alignResArrayString = Arrays.toString(alignResArray);
        console.println(alignResArrayString);
        player.characterHitDie = myClass.getHitDie();

        console.println("Hit Die:");
        console.println(player.characterHitDie.toString());

        console.println("Hit Points:");
        int maxval = player.characterHitDie.value() + 
            player.characterStats.getModifier(CON);
        player.characterMaxHitPoints = maxval;
        console.println(String.valueOf(player.characterMaxHitPoints));

        console.println("Class Skills Noted:");
        player.characterClassSkills.addAll(myClass.getClassSkills());
        Object[] classSkillArray = player.characterClassSkills.toArray();
        String classSkillArrayString = Arrays.toString(classSkillArray);
        console.println(classSkillArrayString);

        console.println("FC Bonus For 1st Level:");
        List<String> FCoptions = player.characterFCoptions;
        List<String> classFCoptions = myClass.getFCBonusOptionList();
        addValidFCOptions(FCoptions, classFCoptions, myRace);
        player.characterFCBonus = promptFCChoice(FCoptions);
        console.println(player.characterFCBonus.toString());

        console.println("===============");

        ClassTableRow[] myClassTable = myClass.getClassTable();
        player.characterBAB = myClassTable[0].BAB;
        console.println("BAB: +" + player.characterBAB);
        player.characterFortSave = myClassTable[0].FortSave;
        console.println("Fortitude Save: +" + player.characterFortSave);
        player.characterRefSave = myClassTable[0].RefSave;
        console.println("Reflex Save: +" + player.characterRefSave);
        player.characterWillSave = myClassTable[0].WillSave;
        console.println("Will Save: +" + player.characterWillSave);

        console.println("CMB: " + player.getCMB());
        console.println("CMD: " + player.getCMD());
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
        console.println("<Set STR: " + myAS.setBase(STR, 20) + ">");
        printAbS(myAS);

        console.println("<Set Stealth: " + mySK.setBase(stealth, 12) + ">");
        for (SkillRankEnum enumvar : SkillRankEnum.values()) {
            console.println(enumvar.toString() + ": " + mySK.getBase(enumvar));
        }

        console.println("\n\n== Class Stats == ");
        PFClassName className = myClass.getClassName();
        console.println("Class: " + className);
        List<AlignmentEnum> badAlign = myClass.getAlignmentRestrictions();
        console.println("Alignment Restrictions: " + badAlign);
        String roleDesc = myClass.getRoleDescriptions();
        console.println("Role Description: " + roleDesc);
        DiceEnum die = myClass.getHitDie();
        console.println("Hit Die: " + die.name());
        double initWealth = myClass.calcInitWealth(console);
        console.println("Initial Wealth: " + initWealth);
        double initOutfitWealth = myClass.getInitOutfitWealth();
        console.println("Outfit Wealth: " + initOutfitWealth);
        List<SkillRankEnum> classSkills = myClass.getClassSkills();
        console.println("Class Skills: " + classSkills);
        int classSR = myClass.getSkillRanksPerLevel() + myAS.getModifier(INT);
        console.println("Skill Ranks per Level (INT): " + classSR);

        console.println("\n\n== Game Feat List ==");
        FeatListArchive.getCombatFeatList().printFeats(console);
        FeatListArchive.getGeneralFeatList().printFeats(console);

        console.println("\n\n== Classes's (" + myClass.getClassName().toString() + ") Feat List == ");
        myClass.getClassFeatures().printFeats(console);

        player.characterFeats.addFeatByString("Acrobatic Spellcaster");
        for (Feat feat : myClass.getClassFeatures()) {
            player.characterFeats.add(feat);
        }

        console.println("\n\n== Player's Feat List == [");
        player.characterFeats.printFeats(console);
        Arrays.toString(player.characterFeats.toArray());
        console.println("]");

        console.println("\n\n== Classes's (" + myClass.getClassName().toString() + ") Focus Class Bonus List == ");
        printFCBonusList(myClass.getFCBonusOptionList());

    }

    private void printFCBonusList(List<String> list) {
        int ctr = 0;
        console.println("TEST");
        for (String key : list) {
            FCBonus fcb = FCBonusList.getBonus(key);
            if (ctr != 0)
                console.println("**************");
            console.println("Name: " + fcb);
            console.println("Race: " + fcb.getRace());
            console.println("Bonus: " + fcb.getBonusDesc());
            LambdaClass FF = fcb.getBonus();
            console.println("Function Output: " + FF.doLambda(null));
            console.println("Source: " + fcb.getSource());
            ctr++;
        }
    }    

    public static Map<Integer, PFCharacter> loadChars(Console console) {
        /*Gson gson = new GsonBuilder().registerTypeAdapter(
            new TypeToken<EnumMap<AbilityScoreEnum, Integer>>() {}.getType(),
            new EnumMapInstanceCreator<AbilityScoreEnum, Integer>(
                AbilityScoreEnum.class)).create();*/
        console.println("load chars");
        int ctr = 0;
        console.println(String.valueOf(ctr++));
        Gson gson = new Gson();
        console.println(String.valueOf(ctr++));
        Type type = new TypeToken<Map<Integer, PFCharacter>>() {}.getType();
        console.println(String.valueOf(ctr++));
        Map<Integer, PFCharacter> map = null;
        console.println(String.valueOf(ctr++));
        try {
            console.println(String.valueOf(ctr++));
            Reader reader = new FileReader("character.tmp");            
            console.println(String.valueOf(ctr++));
            JsonReader jReader = new JsonReader(reader);
            console.println(String.valueOf(ctr++));
            JsonObject jObject = gson.fromJson(jReader, JsonObject.class);
            console.println(String.valueOf(ctr++));
            console.println("BOOP");
            System.out.println("boop");
            JsonElement jElement = jObject.get("general");    
            console.println("BOOP");
            System.out.println("boop");
            console.println(String.valueOf(ctr++));
            console.println(jElement.toString());
            console.println(String.valueOf(ctr++));
            map = gson.fromJson(jElement, type);
            console.println(String.valueOf(ctr++));
            reader.close();
            console.println(String.valueOf(ctr++));
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            console.println("ERROR LOADING PLAYERS");
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
        //console.flush();
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
        console.println(" --- Generate 2 Characters! --- ");
        PFCharacter player1 = genCharacter();
        PFCharacter player2 = genCharacter();
        PFCharacter[] players = {player1, player2};
        saveChars(players);
    }

    /* ========= TEST ========= */
    public void testPunchingFight() {
        console.println("TEST PUNCHING FIGHT");
        Map<Integer, PFCharacter> map = loadChars(console);
        PFCharacter player1 = map.get(0);
        PFCharacter player2 = map.get(1);
        //PFCharacter player1 = genCharacter();
        //PFCharacter player2 = genCharacter();

        console.println("**************");
        console.println("ATTACK");
        console.println("**************");
        int initOrder = initOrder(player1, player2);
        boolean bothLive = true;
        PFCharacter faster = player1;
        PFCharacter slower = player2;
        PFCharacter winner = null;
        if (initOrder == 2) {
            faster = player2;
            slower = player1;
        }
        console.println("Int Order: " + faster.characterName + " " + slower.characterName);
        int ctr = 1;
        while (bothLive) {            
            console.println("@@@@@@@ TURN " + ctr + " @@@@@@@@");
            ctr++;
            //attack loop
            console.println("====== " + faster.characterName + "'s turn! ======");
            attack(faster, slower);
            if(slower.characterHitPoints == 0){
                winner = faster;
                break;
            }
            console.println("====== " + slower.characterName + "'s turn! ======");
            attack(slower, faster);
            if(faster.characterHitPoints == 0){
                winner = slower;
                break;                
            }
            console.println("@@@@@@@@@@@@@@@@@@@@@@@");
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
        console.println(faster.characterName);
        printAbS(faster.characterStats);
        console.println(slower.characterName);
        printAbS(slower.characterStats);
    }   

    private void printWinner(PFCharacter winner){
        console.println("@@@@@@@@ " + winner.characterName + " Wins! @@@@@@@@");
    }

    private void printCharBattleStatus(PFCharacter combatant){
        double percent = (combatant.characterHitPoints * (100.0))
                / combatant.characterMaxHitPoints;
        console.println(
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
        console.println("Actual Roll: " + roll[0]);
        if(roll[0] == 20){
            if(intRollMode == RollMode.Official){
                console.print("Confirming Crit: ");
                int[] roll2 = {1};
                int noCritRoll = rollHitNoCrit(player, roll2);
                if(checkHit(noCritRoll, roll2, player) == 0){
                    crit[0] = true;                    
                }else{
                    console.println("No crit today :(");
                }
            }    
            if(intRollMode == RollMode.Fun)  crit[0] = true;
        } 
        if(crit[0] == true){
            console.println("CRITICAL HIT!");
        }
        attack = roll[0] + attack - 4;    

        return attack;
    }

    private int checkHit(int attack, int[] roll, PFCharacter defender){
        //console.println("check roll: " + roll[0]);
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

        console.println("Attack: " + attack + ", AC :" + AC);
        if(attack >= AC){
            return 0;
        }
        return -1;
    }

    private int rollDamage(PFCharacter player, boolean[] crit){
        int attack = 0;
        int roll = DiceEnum.d3.roll();
        console.println(String.valueOf(roll));
        int subAttack = roll + player.characterStats.getModifier(STR);
        if( subAttack <= 1) subAttack = 1;
        attack += subAttack;
        if(crit[0] == true){
            roll = DiceEnum.d3.roll();
            console.println(" " + roll);
            subAttack = roll + player.characterStats.getModifier(STR);
            if( subAttack <= 1) subAttack = 1;
            attack += subAttack;
        }        
        if( attack <= 1) attack = 1;
        console.println("Total Damage: " + attack);
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
        console.print("ROLL TO HIT: ");
        int toHit = rollHit(attacker, roll, crit);        
        console.println("CHECK HIT:");
        if( checkHit(toHit, roll, defender) == 0 ){
            console.print(attacker.characterName + " HIT! ");
            console.print("ROLL DAMAGE: ");
            int toDamage = rollDamage(attacker, crit);
            console.println("APPLY DAMAGE");
            updateHealth(toDamage, defender);            
            console.println(toDamage + " DEALT! ");            
            return;
        }
        console.println(attacker.characterName + " MISSED!");
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
        
        console.println("Class Skills Noted:");
        player.characterClassSkills.addAll(myClass.getClassSkills());

        console.println("FC Bonus For 1st Level:");
        List<String> FCoptions = player.characterFCoptions; 
        List<String> classFCoptions = myClass.getFCBonusOptionList();
        addValidFCOptions(FCoptions, classFCoptions, myRace);
        player.characterFCBonus = promptFCChoice(FCoptions);

        ClassTableRow[] myClassTable = myClass.getClassTable();
        player.characterBAB = myClassTable[0].BAB;
        player.characterFortSave = myClassTable[0].FortSave;
        player.characterRefSave = myClassTable[0].RefSave;
        player.characterWillSave = myClassTable[0].WillSave;

        console.println("Name:");
        player.characterName = promptCharName();
        return player;
    }
}