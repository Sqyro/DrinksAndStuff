package com.sqyro.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.*;

public class DrinksAndStuffDamageSources {
    public Registry<DamageType> registry;
    public DamageSource sour;

    public DrinksAndStuffDamageSources(DynamicRegistryManager registryManager) {
        this.registry = registryManager.getOrThrow(RegistryKeys.DAMAGE_TYPE);
        this.sour = this.create(DrinksAndStuffDamageTypes.SOUR);
    }

    public DamageSource create(RegistryKey<DamageType> key) {
        return new DamageSource(this.registry.getOrThrow(key));
    }

    public DamageSource sour() {
        return this.sour;
    }
}
