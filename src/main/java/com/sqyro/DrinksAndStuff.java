package com.sqyro;

import com.sqyro.block.DrinksAndStuffBlocks;
import com.sqyro.entity.DrinksAndStuffEntities;
import com.sqyro.item.DrinksAndStuffCreativeModeTab;
import com.sqyro.item.DrinksAndStuffItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrinksAndStuff implements ModInitializer {
	public static final String MOD_ID = "drinksandstuff";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		DrinksAndStuffItems.register();
		DrinksAndStuffBlocks.register();
		DrinksAndStuffCreativeModeTab.register();

		DrinksAndStuffEntities.register();

		LOGGER.info("Hello Fabric world!");
	}
}
