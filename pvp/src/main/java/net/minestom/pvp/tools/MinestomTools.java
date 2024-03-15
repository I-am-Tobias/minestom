package net.minestom.pvp.tools;

import net.minestom.server.item.Material;

public class MinestomTools {

    private final Material item;
    private final float attackDamageValue;
    private final float attackSpeedValue;
    private final float legacyAttackDamageValue;

    public MinestomTools(Material item, float attackDamageValue, float attackSpeedValue, float legacyAttackDamageValue) {
        this.item = item;
        this.attackDamageValue = attackDamageValue;
        this.attackSpeedValue = attackSpeedValue;
        this.legacyAttackDamageValue = legacyAttackDamageValue;
    }

    public Material getItem() {
        return item;
    }

    public float getAttackDamageValue() {
        return attackDamageValue;
    }

    public float getAttackSpeedValue() {
        return attackSpeedValue;
    }

    public float getLegacyAttackDamageValue() {
        return legacyAttackDamageValue;
    }
}
