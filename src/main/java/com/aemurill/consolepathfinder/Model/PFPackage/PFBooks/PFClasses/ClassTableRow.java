package com.aemurill.consolepathfinder.Model.PFPackage.PFBooks.PFClasses;

import com.aemurill.consolepathfinder.Lib.LambdaClass;

public class ClassTableRow {
    public int level;
    public int BAB;
    public int FortSave;
    public int RefSave;
    public int WillSave;
    public LambdaClass Special;
    public int[] spellsPerDay;

    public ClassTableRow(
        int level, int BAB, int FortSave, int RefSave,
        int WillSave, LambdaClass Special, int[] spellsPerDay
    ){
        this.level = level;
        this.BAB = BAB;
        this.FortSave = FortSave;
        this.RefSave = RefSave;
        this.WillSave = WillSave;
        this.Special = Special;
        this.spellsPerDay = spellsPerDay;
    };
}
