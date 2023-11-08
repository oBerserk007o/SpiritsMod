package com.berserk007.spiritsmod.datagen.loot;

import com.berserk007.spiritsmod.block.ModBlocks;
import com.berserk007.spiritsmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CHATTY_BLOCK.get());

        this.add(ModBlocks.WISP_FOOD_BLOCK.get(),
                block -> createSingleItemTable(ModItems.WISP_FOOD.get(), ConstantValue.exactly(9.0F)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
