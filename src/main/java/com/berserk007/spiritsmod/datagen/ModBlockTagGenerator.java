package com.berserk007.spiritsmod.datagen;

import com.berserk007.spiritsmod.SpiritsMod;
import com.berserk007.spiritsmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SpiritsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.WISP_FOOD_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.CHATTY_BLOCK.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
