package PFPackage.PFBooks;

import java.util.ArrayList;
import java.util.List;

public class FeatList {
    public static final List<Feat> FeatList = createList();
    private static List<Feat> createList(){        
        List<Feat> FeatList = new ArrayList<Feat>(0);
        FeatList.add(new Feat(
            "Aberrant Tumor",
            "General",
            "Aberrant bloodline",
            "Gain a tumor familiar.",
            null,
            "PZO1129"));
        return FeatList;
    }
    public static List<Feat> getList(){        
        return FeatList;
    }
}