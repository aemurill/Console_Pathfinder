package PFPackage.PFBooks.PFFeats;

import java.util.ArrayList;

public class FeatList extends ArrayList<Feat> {
    //Not used for anything but Serialization which we don't do
    private static final long serialVersionUID = -8206848538013371913L;

    public boolean addFeatByString(String input){
    //check ONE of the archives
        FeatList featList = (FeatList) FeatListArchive.getCombatFeatList();
        //featList.printFeats(); //DEBUG
        int element_index = featList.indexOf((Object) "Adder Strike");
        System.out.println(element_index);
        if(element_index >= 0){
            super.add(featList.get(element_index));
        }
        return false;
    }

    @Override
    public int indexOf(Object o){
        int size = super.size();
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (super.get(i)==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (super.get(i).toString().equals(o))
                    return i;
        }
        return -1;
    }

    public void printFeats(){  
        int ctr = 0;  
        for (Feat feat: this){
            if(ctr != 0) System.out.println("**************");            
            System.out.println("Feat: " + feat);
            System.out.println("Category: " + feat.getCategory());
            System.out.println("Prereq: " + feat.getPrereq());
            System.out.println("Benefit: " + feat.getBenefitDesc());
            FeatFunction FF = feat.getBenefit();
            System.out.println("FeatFunction Output: " +  FF.doFunction(null));
            System.out.println("Source: " + feat.getSource());
            ctr++;
        }
    }
}