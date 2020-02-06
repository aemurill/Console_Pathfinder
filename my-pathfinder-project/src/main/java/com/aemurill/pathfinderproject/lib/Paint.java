package com.aemurill.pathfinderproject.lib;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Paint{
    public void paint(Canvas canvas, GraphicsContext gc){    
        //ONLY clears the grid.
        gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
        gc.setFill( Color.BLACK );
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        /*gc.setStroke( Color.BLACK );
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        double max = Math.max(width, height);
        gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());        
        for(int ii = 0; ii < 2*max; ii +=25){                    
            gc.strokeLine(ii, 0, 0, ii);
        }*/
    }
}