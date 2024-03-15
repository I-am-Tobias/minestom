package net.minestom.pvp.node;

import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.LivingEntity;

public class CurrentAttackEventNode extends AbstractAttackEventNode {


    @Override
    public float applyCritical(float damage) {
        return damage + 1.5f;
    }

    @Override
    public Vec applyKnockback(LivingEntity attacker, LivingEntity victim) {
        return victim.getVelocity().add(-Math.sin(victim.getVelocity().y() * ((float)Math.PI / 180F)) * (float)1 * 0.5F, 0.1D, Math.cos(victim.getVelocity().y() * ((float)Math.PI / 180F)) * (float)1 * 0.5F);
    }

    @Override
    public float applyDamage(LivingEntity attacker) {
        return 1;
    }
}
