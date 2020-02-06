package com.aemurill.pathfinderproject.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;



public class TokenList extends ArrayList<Token> {
    private static final long serialVersionUID = 1L;  
    public int currentAgent = 0;

    public void keyPressed(KeyEvent e) {        
        thisAgent().keyPressed(e);        
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
        Token agent = this.get(currentAgent);
        agent.setTurn(false);

        if( currentAgent + 1 >= this.size()){
            currentAgent = 0;
        }else currentAgent++;
        
        agent = this.get(currentAgent);
        agent.setTurn(true);
        
    }

    private Token thisAgent(){
        return this.get(currentAgent);
    }

    public void sort() {
        Collections.sort(this, new TokenComp());
        int ctr = 1;
        for(Token token: this){
            token.setOrder(ctr++);            
        }
        this.get(0).setTurn(true);
    }
}

class TokenComp implements Comparator<Token>{
    @Override
    public int compare(Token e1, Token e2){
        if(e1.getInit() < e2.getInit()){
            return 1;
        }
        else if(e1.getInit() == e2.getInit()){
            return 0;
        }
        else{
            return -1;
        }

    }
}