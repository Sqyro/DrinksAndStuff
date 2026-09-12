package com.sqyro.effect;

import com.sqyro.DrinksAndStuff;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class DrinksAndStuffEffects {
    public static final RegistryEntry<StatusEffect> SOUR = register("sour", new SourStatusEffect(StatusEffectCategory.HARMFUL, 15280531));

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(DrinksAndStuff.MOD_ID, id), statusEffect);
    }

    public static void register() {}
}