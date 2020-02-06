package com.aemurill.pathfinderproject.Controller;

public class Main {
    public static void main(String[] args) {
        System.out.println("<><><>Running Main<><><>");

        Basic_Grid_Combat_Controller render = new Basic_Grid_Combat_Controller();
        render.run(args);
        //StatManager.generateCharacter();
        //StatManager.testhuman();
        //StatManager.test();
        //StatManager.genChar4Fight();
        //StatManager.testPunchingFight();


        System.out.println("<><><>Leaving Main<><><>\n");
    }
}