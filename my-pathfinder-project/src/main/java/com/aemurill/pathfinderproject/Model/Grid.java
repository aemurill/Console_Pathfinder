package com.aemurill.pathfinderproject.Model;

import java.io.InputStream;

import com.aemurill.pathfinderproject.Controller.ResourceMaster;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Grid {
    private int numCols = 1;
    private int numRows = 1;    
    private double lineStroke = 1;
    private double frameStroke = 5;
    private double gridWidth;
    private double gridHeight;
    private Image imagePullLeft;
    //private Image imagePullUp;
    public boolean isBelow;   
    public boolean isPerfect; 
    /*  gridPositions{

        }
    */
    public Grid(){
        this.numCols  = 7;
        this.numRows  = 7;
    }

    public int getNumCols(){
        return numCols;
    }

    public int getNumRows(){
        return numRows;
    }

    public double getCanvasLocationX(int x,GraphicsContext gc){
        return (x * getSquareSize(gc) + ((x-1) * lineStroke) + 1);
    }

    public double getCanvasLocationY(int y, GraphicsContext gc){
        return (y * getSquareSize(gc) + ((y-1) * lineStroke) + 1);
    }

    public void paint(GraphicsContext gc){
        //print grid?
        double squareSize = getSquareSize(gc); 
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();   
        System.out.println(width +" "+ height);
        drawGridSquares(gc, squareSize);
        checkGrid(gc);
        drawGridLines(gc, squareSize, width, height);
        drawGridFrame(gc);     
        drawGridWarning(gc);  
        drawCanvasFrame(gc);

        InputStream imagePathLeft = ResourceMaster.getImagePathLeft();
        //InputStream imagePathUp = ResourceMaster.getImagePathUp();
        this.imagePullLeft = new Image(imagePathLeft);
        //this.imagePullUp = new Image(imagePathUp);
    }

    private void drawGridWarning(GraphicsContext gc) {
        double imagePos; 
        if(gc.getCanvas().getWidth() > getGridWidth()){
            imagePos = getGridWidth()-1+frameStroke;
            gc.drawImage(imagePullLeft, imagePos, 0,
                gc.getCanvas().getWidth()-imagePos, gc.getCanvas().getHeight());
        }
        /*if(gc.getCanvas().getHeight() > getGridHeight()){
            imagePos = getGridHeight()-1+frameStroke;
            gc.drawImage(imagePullUp, 0, imagePos,
                gc.getCanvas().getWidth(), gc.getCanvas().getHeight()-imagePos);
        }*/
    }

    private void checkGrid(GraphicsContext gc){
        if( getGridWidth()-1+frameStroke == gc.getCanvas().getWidth() &&
            getGridHeight()-1+frameStroke == gc.getCanvas().getHeight())
        {
            isPerfect = true;
        }
        else{
            isPerfect = false;
        }
    }

    private void drawGridFrame(GraphicsContext gc) {
        if( isPerfect){
            gc.setFill(Color.BLACK);
        }else{
            gc.setFill(Color.RED);
        }
        gc.fillRect(getGridWidth()-1, 0, 
            frameStroke, getGridHeight()-1+frameStroke);   
        gc.fillRect(0, getGridHeight()-1, 
            getGridWidth()-1+frameStroke, frameStroke);   
    }

    public double getGridWidth() {
        return gridWidth;
    }

    public double getGridHeight(){
        return gridHeight;
    }

    private void updateGridLengths(double squareSize){
        updateGridWidth(squareSize);
        updateGridHeight(squareSize);
    }

    private void updateGridWidth(double squareSize){
        this.gridWidth = Math.floor(numCols * ( squareSize + lineStroke));
    }

    private void updateGridHeight(double squareSize){
        this.gridHeight = Math.floor(numRows * ( squareSize + lineStroke));        
    }

    private void drawGridLines(GraphicsContext gc, double squareSize, double width, double height) {
        gc.setFill( Color.BLACK );
        gc.setStroke(null);        

        double gridWidth = getGridWidth()-1;//numCols * ( squareSize + lineStroke);
        double gridHeight = getGridHeight()-1;//numRows * ( squareSize + lineStroke);        
        double x, y;
        for(int ii = 0; ii < numCols-1; ii++){            
            x = squareSize + ii * ( squareSize + lineStroke);
            gc.fillRect(x, 0, lineStroke, gridHeight);   
        }
        
        
        for(int jj = 0; jj < numRows-1; jj++){
            y = squareSize + jj * ( squareSize + lineStroke);
            gc.fillRect(0, y, gridWidth, lineStroke);   
        }    
    }

    private void drawGridSquares(GraphicsContext gc, double squareSize) {
        gc.setFill( Color.LIGHTGRAY );
        gc.setStroke(null);
        double x, y;
        for(int ii = 0; ii < numCols; ii++){
            for(int jj = 0; jj < numRows; jj++){
                x = ii * (squareSize + lineStroke);
                y = jj * (squareSize + lineStroke);
                gc.fillRect(x, y, squareSize, squareSize);
            }    
        }
    }

    public double getSquareSize(GraphicsContext gc) {
        //int squareSize;
        double squareSize;
        double width = gc.getCanvas().getWidth()-frameStroke;
        double height = gc.getCanvas().getHeight()-frameStroke;
        if(width < height){
            //System.out.print("width < height ");
            
            if( numCols > numRows){
                double v1 = width - ((numCols - 1) * lineStroke);
                squareSize = v1 / numCols;
                //System.out.print("col > rows ");
                this.isBelow = true;
            }else{
                double v1 = height - ((numRows - 1) * lineStroke);
                squareSize = v1 / numRows;
                //System.out.print("col < rows ");
                this.isBelow = false;
            }
            updateGridLengths(squareSize);
            double gridWidth = getGridWidth() -1;        
            if(gridWidth > width){
                //System.out.print("GRID width + " +gridWidth+  " > width " +width+  " ");
                if( numCols > numRows){            
                    //System.out.print("GRID col > rows ");
                    double v1 = height - ((numRows - 1) * lineStroke);
                    squareSize = v1 / numRows;
                    this.isBelow = false;
                }else{                
                    //System.out.print("col < rows ");
                    double v1 = width - ((numCols - 1) * lineStroke);
                    squareSize = v1 / numCols;
                    this.isBelow = true;
                }
                updateGridLengths(squareSize);
            }
        }else{            
            //System.out.print("width > height ");
            if( numRows > numCols){
                double v1 = height - ((numRows - 1) * lineStroke);
                squareSize = v1 / numRows;
                //System.out.print("col < rows ");
                this.isBelow = false;
            }else{                
                double v1 = width - ((numCols - 1) * lineStroke);
                squareSize = v1 / numCols;
                //System.out.print("col > rows ");
                this.isBelow = true;
            }
            updateGridLengths(squareSize);
            double gridHeight = getGridHeight()-1;
            if(gridHeight > height){
                //System.out.print("GRID height + " +gridHeight+  " > height " +height+  " ");
                if( numRows > numCols){                
                    //System.out.print("col < rows ");
                    double v1 = width - ((numCols - 1) * lineStroke);
                    squareSize = v1 / numCols;
                    this.isBelow = true;
                }else{                                
                    //System.out.print("col > rows ");
                    double v1 = height - ((numRows - 1) * lineStroke);
                    squareSize = v1 / numRows;
                    this.isBelow = false;
                }                
                updateGridLengths(squareSize);
            }
        }            
        
        //System.out.println("");
        
        return squareSize;
    }

    private void drawCanvasFrame(GraphicsContext gc) {
        if(!isPerfect){
            gc.setFill( Color.GREY );
            gc.fillRect(gc.getCanvas().getWidth()-frameStroke, 0, 
                frameStroke, gc.getCanvas().getHeight()+frameStroke);   
            gc.fillRect(0, gc.getCanvas().getHeight()-frameStroke, 
            gc.getCanvas().getWidth()+frameStroke, frameStroke);   
        }
        
        if(gc.getCanvas().getParent().getScene().focusOwnerProperty().get() == gc.getCanvas().getParent()){
            gc.setFill( Color.TURQUOISE );
            gc.fillRect(gc.getCanvas().getWidth()-frameStroke, 0, 
                frameStroke, gc.getCanvas().getHeight()+frameStroke);   
            gc.fillRect(0, gc.getCanvas().getHeight()-frameStroke, 
            gc.getCanvas().getWidth()+frameStroke, frameStroke);   
        }

        if(isPerfect){
            gc.setFill( Color.DARKGREEN );
            gc.fillRect(
                gc.getCanvas().getWidth()-frameStroke-40, 
                gc.getCanvas().getHeight()-frameStroke, 
                gc.getCanvas().getWidth()+frameStroke+40,
                gc.getCanvas().getHeight()+frameStroke);   
            gc.fillRect(
                gc.getCanvas().getWidth()-frameStroke, 
                gc.getCanvas().getHeight()-frameStroke-40, 
                gc.getCanvas().getWidth()+frameStroke,
                gc.getCanvas().getHeight()+frameStroke+40);   
        }
    }
}