package com.aemurill.consolepathfinder.Controller;

public class Main {
    public static void main(String[] args) {
        System.out.println("<><><>Running Main<><><>");

        
        //StatManager.generateCharacter();
        //StatManager.testhuman();
        //StatManager.test();
        //StatManager.genChar4Fight();
        StatManager stats = new StatManager();
        stats.testPunchingFight();


        System.out.println("<><><>Leaving Main<><><>\n");
    }
}