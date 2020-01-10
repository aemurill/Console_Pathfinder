package PFPackage.Character;

import java.util.ArrayList;
import java.util.List;

import PFPackage.PFBooks.PFClasses.*;
import PFPackage.PFBooks.PFFeats.*;
import PFPackage.PFBooks.PFRaces.*;
import PFPackage.PFBooks.PFFavoredClassBonus.*;

public class PFCharacter {
    //BASE STATS
    public MyAbilityScore characterStats = new MyAbilityScore();
    
    //CLASS
    public PFRace characterRace = null;

    //CLASS
    public PFClass characterClass = null;

    //SKILL RANKS
    public MySkillRanks characterSkills = new MySkillRanks();    

    //FEATS - keep track here, based off what's held and otther player stasts
    //GET ONE EVERY ODD LEVEL + anything from classes or whatever
    public FeatList characterFeats = new FeatList();

    //FC Class Options
    public List<FCBonus> characterFCoptions= new ArrayList<FCBonus>();

    //Alignment
        
    //Class feats?
        //Domain
        //School
        //Bloodline

    //SPELlS IF ARCANE OR SOMETHING

    //GEAR
        //USABILITY DEPENDS ON FEATS / RESTRICTIONS
        //WEAPONS 
        //ETC
    
        //AC STUFF RELATED TO GEAR
            //BONUSES, TYPE, CHECK, SPELL FAILURE, EWIGHT, PROPERTIES
            //SPEED REDUCTION
            //AC CALCULATIONS?

        //ATTACK TYPES, etc

    /* AC = 10 + Armor Bonus + Shield Bonus +
         DEXm + SIZEm + NatArmM + DeflectM + MiscMod
       Touch AC = 10 + DEXm + Deflection
       Flat Foot AC = Touch AC - DEXm
    */

    /*
        SIZE PENALTIES ARE NEGATIVE MISC BONUSES


        Order:
            Class
                pick class            
            Ability Score
                generate AbScore
            Race
                pick
                add racial bonuses to AbSCore
                add Racial Traits
                    size, base speed, language
                *Alt Racial Traits here!*                
            Class Basics (Alignment, Class Skills, HD, etc)
                Note Alignment Restriction
                set Hit Die -> get Hit Points (MAX HD AT 1ST LEVEL)
                Note Class Skills!!!!!!!
                    //Create Bonus Tracker? Deffo but how?
                Select 1st Favored Class Bonus (CAN CHANGE EVERY LEVEL)
            Class Table
                //BASE ALL ON CLASS TABLE
                add BAB 
                add BASE save throw modifiers
                //cmb is bab + STRm + bonuses
                //cmd is bab + STRm + DEXm + bonuses
                gain [INITIAL] Special Abilties/PClass Feats!
                    //Treat Special Abilities like Feats?
                    //Seperate out Special Abilities from Feats?
                    //Like, some feats basically bestow Special Abilties, 
                    //which are basically types of attacks rather than whatever idk
                
            (Spells)
                //not at all going to be worked on soon
                # of spells known (if necessary) as per class table
                    //Bonus spells?
                    //Can have Bonus spells even if table hasn't unlocked spell level
                spells per day as per class table
                    //details can depend per class
                Track # of spells cast in day

                Prepared vs Spontaneous vs Special?
                    //Most spells autohit
                        //usually roll is ranged touch attack
                        //attack roll is BAB + DEX + modifiers 

                        //spells might have a save 
                            //10 + spell level + CASTERm
                Orsions/Cantrips/0th Level Spells
                    FREE SPELLS FOREVER 
            Gear
                Gen starting wealth (Class)
                Use Class Feats to figure out WEAPON RESTRICIONS
                    weapon dmg dice/crit etec etc etc
                Get Weapons!/Gear!
                    Enter into sheet
                        //AC penalties (EQUIPEED/UNEQUIPPED)
                        //modifiers etc
                        //AC bonuses
            Feats
                Pick 1 free feat
                get bonus class feat (if required)                
            Traits (again)
                Pick traits
                treat like feats. Just, you can't pick from traits.
                barring exceptions i'm sure.
            Character Details 
                derive from previous.
                or
                Do whatever.
    */
}