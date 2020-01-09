package PFPackage.PFBooks;

public class Feat {
    
    //More can be added but stop here pls
    private String featName;
    private String featCategory;
    private String featPrereq;
    private String featBenefitDesc;
    private Object[] featBenefit;
    private String featSource;


    public Feat(String featName, String featCategory, String featPrereq, 
        String featBenefitDesc, Object[] featBenefit, String featSource
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
    public Object[] getBenefit() {
        return this.featBenefit;
    }
    public String getSource() {
        return this.featSource;
    }
} 