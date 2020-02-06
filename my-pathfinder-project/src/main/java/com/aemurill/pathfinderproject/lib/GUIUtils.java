package com.aemurill.pathfinderproject.lib;

import java.util.Objects;

import javafx.application.Platform;

//https://codereview.stackexchange.com/questions/52197/console-component-in-javafx
public final class GUIUtils {
    private GUIUtils() {
        throw new UnsupportedOperationException();
    }

    public static void runSafe(final Runnable runnable) {
        Objects.requireNonNull(runnable, "runnable");
        if (Platform.isFxApplicationThread()) {
            runnable.run();
        }
        else {
            Platform.runLater(runnable);
        }
    }
}