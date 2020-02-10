package com.aemurill.pathfinderproject.Controller;

import java.util.UUID;

import com.aemurill.pathfinderproject.Model.Token;
import com.aemurill.pathfinderproject.Model.TokenList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TokenManager {
    private final TokenList tokenList;
    private final TokenPaintList tokenPaintList; 
    private int currentAgent = 0;
    private boolean init = false;

    public TokenManager(){
        this.tokenList = new TokenList();
        this.tokenPaintList = new TokenPaintList();
    }

    public void add(Game game, int x, int y){
        Token token = new Token(game, x, y);
        this.add(token);
    }

	public void add(Token token) {
        token.setID(UUID.randomUUID());
        tokenList.add(token);
        tokenPaintList.add(token);
    }

    public void sort(){
        tokenList.sort();
    }

    public TokenList getTokenList(){
        return tokenList;
    }

    //Token Interaction

    public void keyPressed(KeyEvent e) {        
        getAgent().keyPressed(e);  //LET TOKEN HEAR KEYS      
        if(e.getCode() == KeyCode.SPACE){
            nextAgent();
        }            
    }

	public void keyTyped(KeyEvent e) {
        //thisAgent().keyTyped(e);
    }

	public void keyReleased(KeyEvent e) {
        //thisAgent().keyReleased(e);
	}
    
 

    private void nextAgent() {
        Token agent = getAgent();
        agent.setTurn(false);

        if( currentAgent + 1 >= tokenList.size()){
            currentAgent = 0;
        }else currentAgent++;
        
        agent = tokenList.get(currentAgent);
        agent.setTurn(true);
        tokenPaintList.moveToBack(agent);
    }

    private Token getAgent(){
        Token agent = tokenList.get(currentAgent);
        if(!init){
            tokenPaintList.moveToBack(agent);
        }
        return agent;
    }

    
    //KEY LINKAGE
    /*public void keyPressed(KeyEvent e) {        
        tokenList.keyPressed(e); 
    }

	public void keyTyped(KeyEvent e) {
        tokenList.keyTyped(e);
    }

	public void keyReleased(KeyEvent e) {
        tokenList.keyTyped(e);
    }*/
    
    public void paint(GraphicsContext gc){
        for(Token token: this.tokenPaintList){
            token.paint(gc);   
        }
    }
}