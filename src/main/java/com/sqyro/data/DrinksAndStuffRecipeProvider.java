package com.sqyro.data;

import com.sqyro.block.DrinksAndStuffBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class DrinksAndStuffRecipeProvider extends FabricRecipeProvider {
    public DrinksAndStuffRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.BUILDING_BLOCKS, DrinksAndStuffBlocks.RECEPTION_BELL)
                        .pattern(" B ")
                        .pattern("GNG")
                        .pattern(" S ")
                        .input('B', Blocks.STONE_BUTTON)
                        .input('G', Items.GOLD_INGOT)
                        .input('N', Blocks.NOTE_BLOCK)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Drinks And Stuff Recipes";
    }
}
