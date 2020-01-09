package PFPackage.PFBooks.PFFeats;

import java.util.function.Function;

public class Feat {
    
    //More can be added but stop here pls
    private String featName;
    private String featCategory;
    private String featPrereq;
    //Heavily consider swapping Prereqs with functions?
    private String featBenefitDesc;
    private FeatFunction featBenefit;
    private String featSource;


    public Feat(String featName, String featCategory, String featPrereq, 
        String featBenefitDesc, FeatFunction featBenefit, String featSource
    ){
        this.featName           = featName;
        this.featCategory       = featCategory;
        this.featPrereq         = featPrereq;        
        this.featBenefitDesc    = featBenefitDesc;
        this.featBenefit        = featBenefit;
        this.featSource         = featSource;
    }

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
    public FeatFunction getBenefit() {
        return this.featBenefit;
    }
    public String getSource() {
        return this.featSource;
    }
} 