package com.sqyro.item;

import com.sqyro.DrinksAndStuff;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class DrinksAndStuffItems {
    public static final Item PEELED_BANANA = registerItem("peeled_banana",
            setting -> new Item(setting.food(DrinksAndStuffConsumables.PEELED_BANANA)));

    public static final Item BANANA_PEEL = registerItem("banana_peel",
            setting -> new Item(setting));

    public static final Item BANANA = registerItem("banana", setting -> new PeelableItem(PEELED_BANANA, BANANA_PEEL, setting));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(DrinksAndStuff.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DrinksAndStuff.MOD_ID, name)))));
    }

    public static void register() {}
}