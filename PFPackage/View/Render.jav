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
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Render extends Application { // implements Runnable {

    public class IntValue{
        public int value;

        public IntValue(int x){
            this.value = x;
        }
    };

    public void start(Stage theStage) throws Exception {
        theStage.setTitle( "Click the Target!" );
 
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
     
        Canvas canvas = new Canvas( 500, 500 );
     
        root.getChildren().add( canvas );
     
        Circle targetData = new Circle(100,100,32);
        Circle targetData2 = new Circle(100,100,16);
        Circle targetData3 = new Circle(100,100,8);
        IntValue points = new IntValue(0);
        IntValue headshots = new IntValue(0);
        IntValue goodshots = new IntValue(0);
        IntValue okayshots = new IntValue(0);
        IntValue misses = new IntValue(0);
     
        theScene.setOnMouseClicked(
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent e)
                {
                    if ( targetData3.contains( e.getX(), e.getY() ) )
                    {
                        double x = 50 + 400 * Math.random(); 
                        double y = 50 + 400 * Math.random();
                        targetData.setCenterX(x);
                        targetData.setCenterY(y);
                        targetData2.setCenterX(x);
                        targetData2.setCenterY(y);
                        targetData3.setCenterX(x);
                        targetData3.setCenterY(y);
                        points.value += 3;
                        okayshots.value++;
                    }
                    else if ( targetData2.contains( e.getX(), e.getY() ) )
                    {
                        double x = 50 + 400 * Math.random(); 
                        double y = 50 + 400 * Math.random();
                        targetData.setCenterX(x);
                        targetData.setCenterY(y);
                        targetData2.setCenterX(x);
                        targetData2.setCenterY(y);
                        targetData3.setCenterX(x);
                        targetData3.setCenterY(y);
                        points.value += 2;
                        goodshots.value++;
                    }
                    else if ( targetData.contains( e.getX(), e.getY() ) )
                    {
                        double x = 50 + 400 * Math.random(); 
                        double y = 50 + 400 * Math.random();
                        targetData.setCenterX(x);
                        targetData.setCenterY(y);
                        targetData2.setCenterX(x);
                        targetData2.setCenterY(y);
                        targetData3.setCenterX(x);
                        targetData3.setCenterY(y);
                        points.value += 1;
                        headshots.value++;
                    }
                    else{
                        points.value = 0;
                        misses.value++;
                    } 
                }
            });
     
        GraphicsContext gc = canvas.getGraphicsContext2D();
     
        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);        
     
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // Clear the canvas
                gc.setFill( new Color(0.85, 0.85, 1.0, 1.0) );
                gc.fillRect(0,0, 512,512);
     
                /*gc.drawImage( bullseye, 
                    targetData.getX() - targetData.getRadius(),
                    targetData.getY() - targetData.getRadius() );*/
                gc.setFill( Color.RED );
                gc.fillArc(targetData.getCenterX() - targetData.getRadius(), 
                    targetData.getCenterY() - targetData.getRadius(),
                    2*targetData.getRadius(), 2*targetData.getRadius(), 0, 360, ArcType.ROUND);
                gc.setFill( Color.GREEN );
                gc.fillArc(targetData2.getCenterX() - targetData2.getRadius(), 
                    targetData2.getCenterY() - targetData2.getRadius(),
                    2*targetData2.getRadius(), 2*targetData2.getRadius(), 0, 360, ArcType.ROUND);
                gc.setFill( Color.YELLOW );
                gc.fillArc(targetData3.getCenterX() - targetData3.getRadius(), 
                    targetData3.getCenterY() - targetData3.getRadius(),
                    2*targetData3.getRadius(), 2*targetData3.getRadius(), 0, 360, ArcType.ROUND);
     
                gc.setFill( Color.BLUE );
     
                String pointsText = "Points: " + points.value;
                gc.fillText( pointsText, 360, 36 );
                gc.strokeText( pointsText, 360, 36 );
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