package com.aemurill.pathfinderproject.PFPackage;

import com.aemurill.pathfinderproject.PFPackage.View.Render;

public class Main {
    public static void main(String[] args) {
        System.out.println("<><><>Running Main<><><>");

        Render render = new Render();
        render.run(args);
        //StatManager.generateCharacter();
        //StatManager.testhuman();
        //StatManager.test();
        //StatManager.genChar4Fight();
        //StatManager.testPunchingFight();


        System.out.println("<><><>Leaving Main<><><>\n");
    }
}