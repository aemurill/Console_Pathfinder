package PFPackage.View;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

import PFPackage.StatManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Render extends Application { // implements Runnable {

    public void start(Stage theStage) throws Exception {
        theStage.setTitle( "Timeline Example" );
    
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
    
        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add( canvas );
    
        GraphicsContext gc = canvas.getGraphicsContext2D();
    
        final long startNanoTime = System.nanoTime();
    
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                gc.clearRect(0, 0, 512, 512);
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
    
                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);
    
                // background image clears canvas
                double[] xR = {x+5,x+5,x-5,x-5};
                double[] yR = {y+5,y-5,y-5,y+5};
                gc.fillPolygon(xR, yR, 4);
                double[] xR2 = {196+10,196+10,196-10,196-10};
                double[] yR2 = {196+10,196-10,196-10,196+10};
                gc.fillPolygon(xR2,yR2, 4);
            }
        }.start();
    
        theStage.show();      
    }

    public void run(String[] args) {
        launch(args);
        /*
         * setSize(480, 320); // For AppletViewer, remove later.
         * 
         * // Set up the graphics stuff, double-buffering. BufferedImage screen = new
         * BufferedImage(480, 320, BufferedImage.TYPE_INT_RGB); Graphics g =
         * screen.getGraphics(); Graphics appletGraphics = getGraphics();
         * 
         * long delta = 0l;
         * 
         * // Game loop. while (true) { long lastTime = System.nanoTime();
         * 
         * g.setColor(Color.black); g.fillRect(0, 0, 480, 320);
         * 
         * // Draw the entire results on the screen. appletGraphics.drawImage(screen, 0,
         * 0, null);
         * 
         * // Lock the frame rate delta = System.nanoTime() - lastTime; if (delta <
         * 20000000L) { try { Thread.sleep((20000000L - delta) / 1000000L); } catch
         * (Exception e) { // It's an interrupted exception, and nobody cares } } if
         * (!isActive()) { return; } } }
         * 
         * public boolean handleEvent(Event e) { return false; }
         */
    }
}