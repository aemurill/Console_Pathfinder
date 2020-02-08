package com.aemurill.pathfinderproject.Controller;

import com.aemurill.pathfinderproject.Model.Token;
import com.aemurill.pathfinderproject.Model.TokenList;

import javafx.scene.input.KeyEvent;

public class TokenManager {
    private final TokenList tokenList;
    private final TokenPaintList tokenPaintList; 

    public TokenManager(){
        this.tokenList = new TokenList();
        this.tokenPaintList = new TokenPaintList();
    }

    public void add(Game game, int x, int y){
        Token token = new Token(game, x, y);
        tokenList.add(token);
        tokenPaintList.add(token);
    }

	public void add(Token token) {
        tokenList.add(token);
        tokenPaintList.add(token);
    }

    public void sort(){
        tokenList.sort();
    }

    public TokenList getTokenList(){
        return tokenList;
    }


    
    //KEY LINKAGE
    public void keyPressed(KeyEvent e) {        
        tokenList.keyPressed(e); 
    }

	public void keyTyped(KeyEvent e) {
        tokenList.keyTyped(e);
    }

	public void keyReleased(KeyEvent e) {
        tokenList.keyTyped(e);
	}
}