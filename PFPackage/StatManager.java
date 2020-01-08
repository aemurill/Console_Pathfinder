package PFPackage;

import PFPackage.Character.*;

class StatManager {

    static public void run(){
        System.out.println(" --- Player 1 --- ");
        PFCharacter player = new PFCharacter();
        System.out.println("STR: " + player.characterStats
            .getBase(AbilityScore.AbilityScoreEnum.STR));
        System.out.println("STR mod: " + player.characterStats
            .getModifier(AbilityScore.AbilityScoreEnum.STR));
        System.out.println("Set STR: " + player.characterStats
            .setBase(AbilityScore.AbilityScoreEnum.STR, 20));
        System.out.println("STR mod: " + player.characterStats
            .getModifier(AbilityScore.AbilityScoreEnum.STR));

        System.out.println("Stealth: " + player.characterSkills
            .getBase(SkillRanks.SkillRankEnum.stealth));
    }





}