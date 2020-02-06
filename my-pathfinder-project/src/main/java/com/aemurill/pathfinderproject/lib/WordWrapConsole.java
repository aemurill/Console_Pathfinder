package com.aemurill.pathfinderproject.lib;

//https://codereview.stackexchange.com/questions/52197/console-component-in-javafx
public class WordWrapConsole extends Console {
    public WordWrapConsole() {
        super();
        textArea.setWrapText(true);
    }
}