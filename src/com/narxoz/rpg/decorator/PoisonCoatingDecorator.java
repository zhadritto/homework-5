package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return "Poisonous " + super.getActionName();
    }

    @Override
    public int getDamage() {
        // Poison adds a flat 5 damage
        return super.getDamage() + 5;
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + " [POISON: Toxic damage applied.]";
    }
}