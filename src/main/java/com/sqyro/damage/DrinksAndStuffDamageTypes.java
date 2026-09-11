package com.sqyro.damage;

import com.sqyro.DrinksAndStuff;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class DrinksAndStuffDamageTypes {
    public static final RegistryKey<DamageType> SOUR = register("sour");

    private static RegistryKey<DamageType> register(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(DrinksAndStuff.MOD_ID, name));
    }

    public static void register() {}
}