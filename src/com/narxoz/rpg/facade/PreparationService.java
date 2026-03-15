package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        if (hero == null || boss == null || action == null) {
            return "ERROR: Invalid preparation state. Missing combatants or action.";
        }
        return "PREPARATION: " + hero.getName() + " steps into the dungeon to face " + boss.getName() + " wielding [" + action.getActionName() + "].";
    }
}