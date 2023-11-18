package com.github.felipealafy;

import net.fabricmc.api.ClientModInitializer;

public class AIndustriesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AIndustries.LOGGER.info("Starting AIndustriesClient");
    }
}
