package com.sqyro;

import com.sqyro.entity.DrinksAndStuffEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class DrinksAndStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(DrinksAndStuffEntities.BANANA_PEEL_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
