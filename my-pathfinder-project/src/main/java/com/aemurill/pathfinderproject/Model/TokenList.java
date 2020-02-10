package com.aemurill.pathfinderproject.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//A token list that sorts via INITIATIVE order
public class TokenList extends ArrayList<Token> {
    private static final long serialVersionUID = 1L;      

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