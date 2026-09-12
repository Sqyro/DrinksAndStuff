package com.sqyro.effect;

import com.sqyro.damage.DrinksAndStuffDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class SourStatusEffect extends StatusEffect {
    protected SourStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public void onApplied(LivingEntity entity, int amplifier) {
        DrinksAndStuffDamageSources damageSources = new DrinksAndStuffDamageSources(entity.getEntityWorld().getRegistryManager());
        entity.damage((ServerWorld) entity.getEntityWorld(), damageSources.sour(), (amplifier+1) *2);
    }
}