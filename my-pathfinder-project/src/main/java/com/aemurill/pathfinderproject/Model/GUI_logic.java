package com.aemurill.pathfinderproject.Model;

import com.aemurill.pathfinderproject.Controller.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class GUI_logic {
    //private Game game;
    private FlowPane pane;
    private Button button;
    public GUI_logic(Game game){
        //this.game = game;
        this.pane = (FlowPane) game.getPane();
        button = new Button("test");
        Button button1 = new Button("test");
        Button button2 = new Button("test");
        Button button3 = new Button("test");
        Button button4 = new Button("test");
        Button button5 = new Button("test");
        pane.getChildren().add(button);
        pane.getChildren().add(button1);
        pane.getChildren().add(button2);
        pane.getChildren().add(button3);
        pane.getChildren().add(button4);
        pane.getChildren().add(button5);
        
    }

    public void paint(GraphicsContext gridGC){        
        gridGC.setFill( Color.YELLOW );
        /*if(grid.isBelow){
            //paintGUIBelow(gc);
            anchorPaintHoriz(gridGC);
        }else{
            //paintGUIRight(gc);
            anchorPaintVert(gridGC);            
        }*/
        
    }

    /*
    private void paintGUIRight(GraphicsContext gridGC) {
        gridGC.fillRect(grid.getGridWidth()-1, 0, gridGC.getCanvas().getWidth(),
            gridGC.getCanvas().getHeight());
    }

    private void paintGUIBelow(GraphicsContext gridGC) {
        gridGC.fillRect(0, grid.getGridHeight()-1, gridGC.getCanvas().getWidth(),
            gridGC.getCanvas().getHeight());
    }*/

    /*
    private void anchorPaintVert(GraphicsContext gridGC) {
        button.setLayoutX(
            (pane.getWidth()*(1.5)) -
            (button.getWidth()/2)
        );            
        button.setLayoutY(0);
    }

    private void anchorPaintHoriz(GraphicsContext gridGC) {
        button.setLayoutX(0);            
        button.setLayoutY(
            (pane.getHeight()*(1.5)) -
            (button.getHeight()/2)
        );
    }*/
}