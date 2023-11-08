package com.berserk007.spiritsmod.datagen;

import com.berserk007.spiritsmod.block.ModBlocks;
import com.berserk007.spiritsmod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WISP_FOOD_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.WISP_FOOD.get())
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WISP_FOOD.get())
                .pattern("BBB")
                .pattern("SSS")
                .pattern("EEE")
                .define('B', Items.BAMBOO)
                .define('S', Items.SUGAR)
                .define('E', Items.WHEAT_SEEDS)
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TIMED_ENDER_PEARL.get())
                .pattern("BBB")
                .pattern("SSS")
                .pattern("EEE")
                .define('B', Items.BAMBOO)
                .define('S', Items.SUGAR)
                .define('E', Items.WHEAT_SEEDS)
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WISP_FOOD.get(), 9)
                .requires(ModBlocks.WISP_FOOD_BLOCK.get())
                .unlockedBy("has_wisp_food", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.WISP_FOOD.get()).build()))
                .save(pWriter);
    }
}
