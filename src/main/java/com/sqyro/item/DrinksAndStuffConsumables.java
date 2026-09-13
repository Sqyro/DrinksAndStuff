package com.sqyro.item;

import com.sqyro.effect.DrinksAndStuffEffects;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;

public class DrinksAndStuffConsumables {
    public static final FoodComponent PEELED_LEMON_FOOD = new FoodComponent.Builder().nutrition(2).saturationModifier(0.15f).build();
    public static final ConsumableComponent PEELED_LEMON = food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(DrinksAndStuffEffects.SOUR, 40, 0), 0.7F)).build();

    public static final FoodComponent PEELED_BANANA_FOOD = new FoodComponent.Builder().nutrition(2).saturationModifier(0.15f).build();

    public static final FoodComponent CHERRY_FOOD = new FoodComponent.Builder().nutrition(2).saturationModifier(0.15f).build();

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }
}