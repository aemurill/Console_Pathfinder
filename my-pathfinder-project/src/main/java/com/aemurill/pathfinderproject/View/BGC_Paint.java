package com.aemurill.pathfinderproject.View;

import com.aemurill.pathfinderproject.lib.Paint;

import com.aemurill.pathfinderproject.Controller.Game;
import com.aemurill.pathfinderproject.Model.Grid;
import com.aemurill.pathfinderproject.Model.Token;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class BGC_Paint extends Paint{
    Game game;
    Grid grid;
    Canvas canvas;
    GraphicsContext gc;
    Pane pane;
    int frameStroke = 5;

    public BGC_Paint(Game game){
        this.game = game;
        this.canvas = game.getCanvas();
        this.gc = canvas.getGraphicsContext2D();
        this.pane = game.getPane();
        this.grid = game.getGrid();
    }

    public void paint() {
        super.paint(canvas, gc);
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);
        grid.paint(gc);
        game.getGUI_logic().paint(gc);
        for(Token token: game.getTokens()){
            token.paint(gc);   
        }
        
        //game.getBall().paint(gc);
        //game.getRacquet().paint(gc);
        //gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
     
        /*Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);        
     
        gc.fillText(String.valueOf(game.getScore()), 10, 30);*/
        
    }

    public static WritableImage createCircledNumber(int number, double w, double h) {
        //createCircledNumber() method always returns 26px X 26px sized image
        StackPane sPane = new StackPane();
        sPane.setPrefSize(w, h);        

        Circle c = new Circle(w/2.0);
        c.setStroke(Color.TRANSPARENT);
        c.setFill(Color.TRANSPARENT);
        c.setStrokeWidth(3);
        sPane.getChildren().add(c);

        Text txtNum = new Text(number+"");
        sPane.getChildren().add(txtNum);
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        return sPane.snapshot(parameters, null);
    }

    
}