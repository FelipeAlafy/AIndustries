package com.github.felipealafy.item;

import com.github.felipealafy.AIndustries;
import com.github.felipealafy.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(AIndustries.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby")).icon(() -> new ItemStack(ModItems.RUBY))
                    .entries((displayContext, entries) -> {
                        //Items
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                        //Block Items
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                    }).build());
    public static void RegisterItemGroups() {
        AIndustries.LOGGER.info("Registering " + AIndustries.MOD_ID + " ItemGroups");

    }
}
