package com.aemurill.pathfinderproject.Controller;

import java.util.List;

import com.aemurill.pathfinderproject.Model.GUI_logic;
import com.aemurill.pathfinderproject.Model.Grid;
import com.aemurill.pathfinderproject.Model.Token;
import com.aemurill.pathfinderproject.Model.TokenList;
import com.aemurill.pathfinderproject.View.*;
import com.aemurill.pathfinderproject.lib.CanvasPane;
import com.aemurill.pathfinderproject.lib.Console;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Game implements Runnable {
    private final Canvas canvas;
    private final Application gameApp;
    private final BGC_Paint painter;
    private final GUI_logic gui;
    private final Grid grid;
    private final TokenList tokens;
    private final Console console;
    private final StatManager statManager;
    private final Pane pane;
    private boolean doD = false;
    // private Ball ball;
    // private Racquet racquet;
    private boolean running;
    private boolean paused;
    private boolean keyIsPressed;
    private int frameRate;
    private float interval;
    // private double width;
    // private double height;
    // private boolean gameOver;
    // private SoundObserver soundObserverBall;
    public int speed = 1;

    public Game(final Basic_Grid_Combat_Controller gameApp, final CanvasPane canvasPane, final Pane pane,
            final Console console, final GraphicsContext gc) {
        this.canvas = canvasPane.canvas;
        this.pane = pane;
        this.console = console;
        this.running = true;
        this.paused = false;
        this.keyIsPressed = false;
        this.frameRate = 60;
        this.interval = 1000.0f / this.frameRate; // 1000ms in a second
        // this.width = canvas.getWidth();
        // this.height = canvas.getHeight();
        this.grid = new Grid();
        this.gui = new GUI_logic(this);

        this.gameApp = gameApp;
        this.painter = new BGC_Paint(this);
        this.tokens = new TokenList();
        this.tokens.add(new Token(this));
        this.tokens.add(new Token(this, 6, 6));
        this.tokens.add(new Token(this, 2, 4));
        this.tokens.add(new Token(this, 4, 5));
        this.tokens.add(new Token(this, 3, 2));
        this.tokens.add(new Token(this, 1, 4));
        this.tokens.sort();
        this.statManager = new StatManager(console);
        // this.gameOver = false;
        /*
         * this.soundObserverBall = new SoundObserverConcrete(
         * this.ball.getSoundSubject() ){
         * 
         * @Override public void update() { Platform.runLater(() -> {
         * gameApp.playBallSound(); } ); } };
         */

    }

    @Override
    public void run() {
        while (running && !paused) {
            float time = System.currentTimeMillis();
            // If you want updates seperate to graphics updates, keep these untied!
            this.doGameLogic();
            // MUST DO PLATFOR RUN LATER
            // ONLY APPLICATION THREAD CAN DO UI STUFF, THIS QUEUES IT FOR THAT
            Platform.runLater(() -> painter.paint());
            // this.playSounds();
            System.out.println(this.tokens.currentAgent);

            time = System.currentTimeMillis() - time;

            // Adjust the timing correctly
            if (time < interval) {
                try {
                    Thread.sleep((long) (interval - time));
                } catch (InterruptedException ignore) {
                }
            }
            // break;
        }

    }

    // UPDATE / CHECK GAME STATE?
    private void doGameLogic() {
        if(this.doD == false){
        // statManager.genChar4Fight();
        // statManager.generateCharacter();
        // statManager.testPunchingFight();
        statManager.testhuman();
        //statManager.test();
        //gameOver();
            this.doD = true;
        }
    }

	/*public Ball getBall() {
		return this.ball;
	}*/
    
    public void stop(){
        running = false;
    }


	public boolean isPaused() {
		return this.paused;
	}

    public boolean isRunning() {
		return this.running;
	}

	/*public Racquet getRacquet() {
		return this.racquet;
	}*/


	public boolean isKeyPressed() {
		return this.keyIsPressed;
    }
    
    public Application getApp(){
        return this.gameApp;
    }

    public void gameOver(){ 
        //Sound.getGameoverPlayer().play();
        running = false;
    }

    public int getScore() {
        return speed - 1;
    }

    public void keyTyped(KeyEvent e) {
        this.tokens.keyTyped(e);
	}

	public void keyPressed(KeyEvent e) {
        if(e.getCode() == KeyCode.ESCAPE){
            gameOver();
        }
        this.tokens.keyPressed(e);
    }
    
    public void keyReleased(KeyEvent e) {
        this.tokens.keyReleased(e);
	}

	public Grid getGrid() {
		return grid;
    }
    
    public GUI_logic getGUI_logic() {
		return gui;
	}

	public Canvas getCanvas() {
		return this.canvas;
	}

	public Pane getPane() {
		return this.pane;
    }
    
    public List<Token> getTokens(){
        return this.tokens;
    }

    public Console getConsole(){
        return this.console;
    }
}