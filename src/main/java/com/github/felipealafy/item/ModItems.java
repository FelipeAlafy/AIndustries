package com.github.felipealafy.item;

import com.github.felipealafy.AIndustries;
import com.github.felipealafy.item.custom.OreFinderItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item ORE_FINDER = registerItem("ore_finder",
            new OreFinderItem(new FabricItemSettings().maxDamage(64)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AIndustries.MOD_ID, name), item);
    }

    public static void RegisterModItems() {
        AIndustries.LOGGER.info("Registering Mod items fot " + AIndustries.MOD_ID);
    }
}
