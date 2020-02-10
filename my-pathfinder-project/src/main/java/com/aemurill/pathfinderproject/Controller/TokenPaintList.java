package com.aemurill.pathfinderproject.Controller;

import java.util.Iterator;
//import java.util.ArrayList;
import java.util.LinkedList;

import com.aemurill.pathfinderproject.Model.Token;

public class TokenPaintList extends LinkedList<Token> {
    private static final long serialVersionUID = -7942283450652077273L;

    //Makes Token be on top of the drawing (drawn last!)
    public boolean moveToBack(Token token){
        Iterator<Token> it = this.iterator();
        while (it.hasNext()) {
            Token thing = it.next();
            if (token.getID() == thing.getID()) {
                it.remove();
                this.addLast(thing);
                return true;
            }
        }
        return false;
    }
}
