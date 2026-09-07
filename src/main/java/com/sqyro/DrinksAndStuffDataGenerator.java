package com.sqyro;

import com.sqyro.data.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DrinksAndStuffDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(DrinksAndStuffModelProvider::new);
		pack.addProvider(DrinksAndStuffBlockTagProvider::new);
		pack.addProvider(DrinksAndStuffItemTagProvider::new);
		pack.addProvider(DrinksAndStuffLootTableProvider::new);
		pack.addProvider(DrinksAndStuffRecipeProvider::new);
	}
}
