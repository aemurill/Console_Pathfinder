package com.aemurill.pathfinderproject.lib;

import javafx.scene.layout.Pane;

//https://codereview.stackexchange.com/questions/52197/console-component-in-javafx
public class WordWrapConsole extends Console {
    public WordWrapConsole(Pane root) {
        super(root);
        textArea.setWrapText(true);
    }
}