package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int rounds = 0;

        result.addLine("--- BATTLE START ---");

        while (hero.isAlive() && boss.isAlive() && rounds < 50) {
            rounds++;
            result.addLine("\n[Round " + rounds + "]");
            int heroDamage = action.getDamage();
            if (random.nextInt(5) == 0) {
                result.addLine(hero.getName() + " missed their attack!");
            } else {
                boss.takeDamage(heroDamage);
                result.addLine(hero.getName() + " uses " + action.getActionName() + " and deals " + heroDamage + " damage. " + boss.getName() + " HP: " + boss.getHealth());
            }

            if (!boss.isAlive()) break;
            int bossDamage = boss.getAttackPower();
            hero.takeDamage(bossDamage);
            result.addLine(boss.getName() + " strikes back for " + bossDamage + " damage. " + hero.getName() + " HP: " + hero.getHealth());
        }

        result.setRounds(rounds);

        if (hero.isAlive() && !boss.isAlive()) {
            result.setWinner(hero.getName());
        } else if (!hero.isAlive() && boss.isAlive()) {
            result.setWinner(boss.getName());
        } else {
            result.setWinner("Draw (Timeout or Mutual Defeat)");
        }

        result.addLine("--- BATTLE END ---");
        return result;
    }
}
