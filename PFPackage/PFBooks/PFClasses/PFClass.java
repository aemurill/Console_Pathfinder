package PFPackage.PFBooks.PFClasses;

import java.util.List;

import PFPackage.PFBooks.Dice;
import PFPackage.Character.SkillRank;
import PFPackage.PFBooks.Alignment;

public interface PFClass {
    // class name
    //final PFClassName className = null;
    public PFClassName getClassName();

    // alignment restrictions
    //static List<Alignment> alignmentRestrictions = null;
    public List<Alignment> getAlignmentRestrictions();

    //role description
    //static String roleDesc = null;
    public String getRoleDescriptions();

    //hit die
    //static Dice hitDie = null;    
    public Dice getHitDie();

    //starting wealth
    //static Object[] initWealth = null;// = {5, d6, 10 } ;
    public Object[] getInitWealth();

    default double calcInitWealth() {
        Object[] temp = this.getInitWealth();
        int dieMult = (int) temp[0];
        System.out.println(dieMult);
        int roll = ((Dice) temp[1]).roll();
        System.out.println("rolled "+roll);
        int mult = (int)temp[2];
        System.out.println(mult);
        double val = (dieMult * roll) * mult;
        return val;
    }

    //In addition, each character begins play with an outfit worth 10 gp or less.
    double initOutfitWealth = 10; //10 gp = 100 sp = 1000 cp
    public double getInitOutfitWealth();

    //CLASS SKILLS
    //static List<SkillRank> classSkills = null;
    /*List<SkillRankEnum> classSkills = Arrays.asList(
        SkillRankEnum.acrobatics,  
    );*/
    public List<SkillRank> getClassSkills();
    
    //Skill Ranks per level
    //static int skillRanksPerLevel = 0; // n + INT
    public int getSkillRanksPerLevel();

    //Class leveling TABLE

    //Class Features     

    //Favored Class bonus option

    /* 
        updateStatsManager?

        Make Features a list of things that get run through?
        Make Bonuses a list of things that get run through?

        When?
            Before Checks - if affects checks
            Before Rolls - if affects rolls
            
            When item gained
            When item lost

            When CHANGE occures to player stats
            
            When Spell casted
            When Feature Gained
            >> Duration of change
            >> Conditions of change
            >> **Temporariness** of change
            >> Permenance of change


     */

}