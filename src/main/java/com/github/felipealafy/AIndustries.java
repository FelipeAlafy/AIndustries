package com.github.felipealafy;

import com.github.felipealafy.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AIndustries implements ModInitializer {
	public static final String MOD_ID = "aindustries";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("AIndustries loading");
		ModItems.RegisterModItems();
	}
}