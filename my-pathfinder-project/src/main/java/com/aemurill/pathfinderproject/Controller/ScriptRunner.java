package com.aemurill.pathfinderproject.Controller;

import com.aemurill.pathfinderproject.lib.Console;

public class ScriptRunner {
    //private final Game game;
    private final Console console;
    private final StatManager statManager;

    public ScriptRunner(Game game){
        //this.game = game;
        this.console = game.getConsole();
        this.statManager = game.statManager;
    }

    // statManager.genChar4Fight();
    // statManager.generateCharacter();
    // statManager.testPunchingFight();
    // statManager.testhuman();
    //statManager.test();
    public void scriptRunnerCheck(){
        this.console.println("RUN SCRIPT");
        this.statManager.generateCharacter();
    }
}