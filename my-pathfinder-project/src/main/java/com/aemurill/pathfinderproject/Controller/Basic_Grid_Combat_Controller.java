package com.aemurill.pathfinderproject.Controller;

import java.util.Optional;

import com.aemurill.pathfinderproject.lib.CanvasPane;
import com.aemurill.pathfinderproject.lib.Console;
import com.aemurill.pathfinderproject.lib.DragResizer;
import com.aemurill.pathfinderproject.lib.ResizeHelper;
import com.aemurill.pathfinderproject.lib.WordWrapConsole;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Basic_Grid_Combat_Controller extends Application { // implements Runnable {

    private Game loop;
    private CanvasPane canvasPane;
    private GraphicsContext gc;
    private Pane pane;
    private Console console;
    // private Sound soundInstance;
    // private MediaPlayer background;
    // private MediaPlayer ball;
    // private MediaPlayer gameover;
    private Task<Void> task;

    public class IntValue {
        public int value;

        public IntValue(int x) {
            this.value = x;
        }
    };

    public void start(Stage theStage) throws Exception {
        startGame(theStage);
    }

    public void restart(Stage theStage) throws Exception {
        cleanup();
        startGame(theStage);
    }

    private void cleanup() {
        // if necessary
    }

    public void startGame(Stage theStage) throws Exception {
        // soundInstance = new Sound();
        // background = soundInstance.getBackPlayer();
        // ball = soundInstance.getBallPlayer();
        // gameover = soundInstance.getGameoverPlayer();
        
        theStage.setWidth(600);
        theStage.setHeight(300);
        Platform.setImplicitExit(true);
        //AnchorPane root = new AnchorPane();
        //BorderPane root = new BorderPane();
        HBox root = new HBox();
        root.setFillHeight(true);
        Scene theScene = new Scene(root); 
        theStage.setTitle("Basic Grid Combat");
        theStage.setScene(theScene);
        root.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));

        // SoundListener soundListener = new SoundListener();
        canvasPane = new CanvasPane(600, 600);
        // canvas.widthProperty().bind(theScene.widthProperty());
        // canvas.heightProperty().bind(theScene.heightProperty());
        theStage.setMinWidth(200);

        gc = canvasPane.canvas.getGraphicsContext2D();
        canvasPane.setFocusTraversable(true);
        canvasPane.setOnKeyTyped(e -> {
            loop.keyTyped(e);
            e.consume();
        });
        canvasPane.setOnKeyReleased(e -> {
            loop.keyReleased(e);
            e.consume();
        });
        canvasPane.setOnKeyPressed(e -> {
            loop.keyPressed(e);
            e.consume();
        });
        canvasPane.setOnMouseClicked(e ->{
            canvasPane.requestFocus();
        });
        
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");

        pane = flow;
        pane.setBorder(
            new Border(
                new BorderStroke(
                    Color.GREY,
                    BorderStrokeStyle.SOLID, 
                    CornerRadii.EMPTY,
                    new BorderWidths(0, 5, 0, 0)
                )
            )
        );

        console = new WordWrapConsole(canvasPane);

        //root.setLeft(canvasPane);
        canvasPane.setMinWidth(200);
        canvasPane.setMaxWidth(200);
        
        
        //root.setCenter(pane);
        pane.setMinWidth(100);
        pane.setMaxWidth(100);
        
        console.prefWidthProperty().bind(root.widthProperty());
        //root.setRight(console);
        //console.setMinWidth(400);
        root.getChildren().add(canvasPane);
        root.getChildren().add(pane);
        root.getChildren().add(console);

        
        //console.layoutYProperty().bind(canvasPane.heightProperty());
        

        
        System.out.println(pane.getHeight() +" "+pane.getWidth());
        //ResizeHelper.addResizeListener(theStage, 0);
        canvasPane.minHeightProperty().bind(theStage.minHeightProperty());
        
        theStage.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent window) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        console.disableCursor();
                        DragResizer.makeResizableX(canvasPane, root, -1, false);
                        DragResizer.makeResizableX(pane, root, 1, false);
                    }
                });
            }
        });
        
        //canvasPane.setMinWidth(140);
        //canvasPane.setMinHeight(140);

        task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                loop.run();
                return null;
            }
        };
        task.setOnSucceeded(e -> {
            // GAME LOOP BROKEN = GAMEOVER
            loop.stop();
            theStage.close();
            gameOver(theStage);
        });
        task.setOnRunning(e -> {
        });


        
        theStage.show();
        // WINDOW CLOSE = SHUT DOWN
        Thread gameThread = new Thread(task);
        theStage.setOnCloseRequest(e -> {
            loop.gameOver(); //FORCE TASK LOOP TO CLOSE
            task.cancel();
            //try {
                //gameThread.join();
                
            //} catch (InterruptedException e1) {
                //e1.printStackTrace();
            //}
            Platform.exit();
        });
        reset(); //INITIALIZE GAME LOOP

        
        
        gameThread.start();
    }

    public void run(String[] args) {
        launch(args);
    }

    public void gameOver(Stage theStage){
        //background.stop();
        //gameover.seek(Duration.ZERO);
        //gameover.play();        

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("GAME OVER");
        alert.setHeaderText("Game Ended");
        alert.setContentText("CONTINUE?");
        Optional<ButtonType> result = alert.showAndWait();
        boolean doRestart = false;
        if(!result.isPresent()){
        }else if(result.get() == ButtonType.OK){
            doRestart = true;
        }else if(result.get() == ButtonType.CANCEL){
        }

        if(doRestart){
            try {
                //gameover.stop();
                restart(theStage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void reset(){
        loop = new Game(this, canvasPane, pane, console, gc);
        //background.seek(Duration.ZERO);
        //background.play();
    }

    /*public void playBallSound(){
        ball.setVolume(0.5);
        ball.seek(Duration.ZERO);
        ball.play();
    }*/

}