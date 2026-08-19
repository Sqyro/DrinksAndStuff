package com.sqyro.data;

import com.sqyro.DrinksAndStuff;
import com.sqyro.item.DrinksAndStuffItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class DrinksAndStuffModelProvider extends FabricModelProvider {
    public DrinksAndStuffModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DrinksAndStuffItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(DrinksAndStuffItems.PEELED_BANANA, Models.GENERATED);
        itemModelGenerator.register(DrinksAndStuffItems.BANANA_PEEL, Models.GENERATED);
    }
}
