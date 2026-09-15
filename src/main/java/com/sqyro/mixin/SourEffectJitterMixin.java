package com.sqyro.mixin;

import com.sqyro.effect.DrinksAndStuffEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class SourEffectJitterMixin {
    @Inject(method = "updateMouse", at = @At("HEAD"), cancellable = true)
    private void drinksandstuff$applySournessJitter(double timeDelta, CallbackInfo callbackInfo) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null) {
            return;
        }

        if (!client.player.hasStatusEffect(DrinksAndStuffEffects.SOUR)) {
            return;
        }

        Random random = client.player.getRandom();

        double initialX = random.nextFloat() * 50;
        double initialY = random.nextFloat() * 50;

        double finalX = random.nextBoolean() ? initialX : -initialX;
        double finalY = random.nextBoolean() ? initialY : -initialY;

        client.player.changeLookDirection(finalX, finalY);
    }
}
