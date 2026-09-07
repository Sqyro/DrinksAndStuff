package com.sqyro.entity;

import com.sqyro.DrinksAndStuff;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class DrinksAndStuffEntities {
    private static final RegistryKey<EntityType<?>> BANANA_PEEL_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(DrinksAndStuff.MOD_ID, "banana_peel"));

    public static final EntityType<BananaPeelProjectileEntity> BANANA_PEEL_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(DrinksAndStuff.MOD_ID, "banana_peel_projectile"),
            EntityType.Builder.<BananaPeelProjectileEntity>create(BananaPeelProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f).build(BANANA_PEEL_KEY));

    public static void register() {}
}
