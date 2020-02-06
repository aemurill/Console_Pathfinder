package com.aemurill.pathfinderproject.Model;

import com.aemurill.pathfinderproject.Controller.Game;
import com.aemurill.pathfinderproject.View.BGC_Paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;



public class Token {
    private int oldX = 1;
    private int oldY = 1;
    private int x = 1;
    private int y = 1;
    //private Game game;
    private Grid grid;
    //private Canvas canvas;
    private double squareSize;
    private int init;
    private int turnOrder;
    private boolean isTurn;
    public static int WIDTH = 10;
    public static int HEIGHT = 10;

    public Token(Game game){
        //this.game = game;
        this.grid = game.getGrid();
        //this.canvas = game.getCanvas();
        this.init = (int) Math.floor(10 * Math.random());
    }

    public Token(Game game, int x, int y){
        this(game);
        this.x = x;
        this.y = y;
        this.oldX = this.x;
        this.oldY = this.y;
    }

    public void setOrder(int order){
        this.turnOrder = order;
    }

    public void paint(GraphicsContext gc){
        squareSize = grid.getSquareSize(gc);
        double x = grid.getCanvasLocationX(this.x-1, gc);
        double y = grid.getCanvasLocationY(this.y-1, gc);
        gc.setFill(Color.RED);
        gc.fillOval(x, y, squareSize, squareSize);
            
        gc.drawImage(
            BGC_Paint.createCircledNumber(this.turnOrder, squareSize, squareSize),
            x-1, y-1
        );
    }

    public void keyPressed(KeyEvent e) {        
        //MOVEMENT
        if(this.isTurn == true){
            int x = this.x, y = this.y;
            if(e.getCode() == KeyCode.LEFT)
                x = x - 1;
            if(e.getCode() == KeyCode.RIGHT)
                x = x + 1;
            if(e.getCode() == KeyCode.UP)
                y = y - 1;
            if(e.getCode() == KeyCode.DOWN)
                y = y + 1;                
            updatePos(x, y);
            if(e.getCode() == KeyCode.TAB)
                updatePos(this.oldX, this.oldY);
        }  

        //END TURN
        if(e.getCode() == KeyCode.SPACE){
            this.oldX = this.x;
            this.oldY = this.y;
        }
    }
    
    private void updatePos(int x, int y){
        int newX, newY;
        System.out.println(this.x + "=" +  this.y);
        System.out.println(x + "+" +  y);
        newX = x;
        newY = y;
        if(x > grid.getNumCols())
            newX = grid.getNumCols();
        if(x < 1) newX = 1;
        if(y > grid.getNumRows())
            newY = grid.getNumRows();
        if(y < 1) newY = 1;

        this.x = newX;
        this.y = newY;
    }

    public void setTurn(boolean state){
        this.isTurn = state;
    }    

    public int getInit() {
        return init;
    }
}