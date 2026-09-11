package com.sqyro.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.*;
import net.minecraft.world.World;

import java.util.IdentityHashMap;
import java.util.Map;

public class DrinksAndStuffDamageSources {
    private static final Map<DynamicRegistryManager, DrinksAndStuffDamageSources> DAMAGE_SOURCES = new IdentityHashMap<>();

    public static DrinksAndStuffDamageSources get(World world) {
        return DAMAGE_SOURCES.get(world.getRegistryManager());
    }

    public Registry<DamageType> registry;
    public DamageSource sour;

    public DrinksAndStuffDamageSources(DynamicRegistryManager registryManager) {
        registry = registryManager.getOrThrow(RegistryKeys.DAMAGE_TYPE);
        sour = create(DrinksAndStuffDamageTypes.SOUR);
    }

    public DamageSource create(RegistryKey<DamageType> key) {
        return new DamageSource(this.registry.getOrThrow(key));
    }

    public static void register(DynamicRegistryManager registryManager) {
        DAMAGE_SOURCES.put(registryManager, new DrinksAndStuffDamageSources(registryManager));
    }
}
