package com.narxoz.rpg.decorator;
public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return "Flaming " + super.getActionName();
    }

    @Override
    public int getDamage() {
        // Fire rune adds a flat 15 damage
        return super.getDamage() + 15;
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + " [FIRE: Burns the target.]";
    }
}