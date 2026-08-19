package com.sqyro.item;

import com.sqyro.DrinksAndStuff;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DrinksAndStuffCreativeModeTab {
    public static final ItemGroup DRINKS_AND_STUFF_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DrinksAndStuff.MOD_ID, "drinks_and_stuff_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(DrinksAndStuffItems.BANANA_PEEL))
                    .displayName(Text.translatable("itemgroup.drinksandstuff.drinks_and_stuff_tab"))
                    .entries((displayContext, entries) -> {
                        entries.add(DrinksAndStuffItems.BANANA);
                        entries.add(DrinksAndStuffItems.PEELED_BANANA);
                        entries.add(DrinksAndStuffItems.BANANA_PEEL);
                    }).build());

    public static void register() {}
}
