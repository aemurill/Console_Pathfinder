package com.aemurill.pathfinderproject.Controller;

import java.io.InputStream;

import com.aemurill.pathfinderproject.App;

public class ResourceMaster {
    private static String imagePathLeft = "Basic_Grid_Combat/canvas_pull_left.png";
    private static String imagePathUp = "Basic_Grid_Combat/canvas_pull_up.png";

    public static  InputStream getImagePathLeft() {
        return App.class.getClassLoader().getResourceAsStream(imagePathLeft);
    }

    public static InputStream getImagePathUp() {
        return App.class.getClassLoader().getResourceAsStream(imagePathUp);
    }
}