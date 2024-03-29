package com.aemurill.consolepathfinder.Model.PFPackage.PFBooks;

import java.util.Random;

public enum DiceEnum {
    d1(1), d2(2), d3(3), d4(4), d6(6), d8(8), d10(10), d10p(10), d12(12), d20(20);
    //More can be added but stop here pls

    private int value;

    private DiceEnum(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public int value() {
        return this.value;
    }

    public int roll() {
        Random rn = new Random();
        int diceVal = rn.nextInt(this.value) + 1;
        return diceVal;
    };
} 