package com.aemurill.pathfinderproject.Model.PFPackage.PFBooks.PFFeats;

public class Feat {
    
    //More can be added but stop here pls
    private String featName;
    private String featCategory;
    private String featPrereq;
    //Heavily consider swapping Prereqs with functions?
    private String featBenefitDesc;
    private Function featBenefit;
    private String featSource;


    public Feat(String featName, String featCategory, String featPrereq, 
        String featBenefitDesc, Function featBenefit, String featSource
    ){
        this.featName           = featName;
        this.featCategory       = featCategory;
        this.featPrereq         = featPrereq;        
        this.featBenefitDesc    = featBenefitDesc;
        this.featBenefit        = featBenefit;
        this.featSource         = featSource;
    }

    /*@Override
    public boolean equals(Object o){
        System.out.println("D: pre");
        if(o == this) return true; //self
        System.out.println("D: not self");
        if(!(o instanceof String)) return false; //is Feat?
        System.out.println("D: o not string");
        if(this.featName.equals(o)){
            System.out.println("D: Success?");
            return true;
        }
        System.out.println("D: string not equals");
        return false;
    }*/

    public static boolean handleUnimplemented(){
        System.out.println("WARNING: FEAT UNIMPLEMENTED");
        return false;
    }

    /*@Override
    public int hashCode(){
        int h = hash;
        if (h == 0 && featName.length > 0) {
            char val[] = featName;

            for (int i = 0; i < featName.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }*/

    @Override
    public String toString() {
        return this.featName;
    }

    public String getCategory() {
        return this.featCategory;
    }
    public String getPrereq() {
        return this.featPrereq;
    }    
    public String getBenefitDesc() {
        return this.featBenefitDesc;
    }
    public Function getBenefit() {
        return this.featBenefit;
    }
    public String getSource() {
        return this.featSource;
    }
} 