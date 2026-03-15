package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null || battleResult.getWinner() == null) {
            return "No Reward.";
        }

        if (battleResult.getWinner().equals("Draw (Timeout or Mutual Defeat)")) {
            return "10 Gold (Consolation Prize)";
        } else if (!battleResult.getWinner().contains("Boss")) {
            return "Epic Loot Chest & 500 Gold";
        } else {
            return "A bitter lesson in defeat.";
        }
    }
}