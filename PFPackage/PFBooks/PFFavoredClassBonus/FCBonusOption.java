package PFPackage.PFBooks.PFFavoredClassBonus;

public class FCBonusOption {
    
    //More can be added but stop here pls
    private String featName;


    public FCBonusOption(String featName){
        this.featName = featName;
    }

    @Override
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
    }

    public static boolean handleUnimplemented(){
        System.out.println("WARNING: FEAT UNIMPLEMENTED");
        return false;
    } 

    @Override
    public String toString() {
        return this.featName;
    }
} 