package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        for (DeferredHolder<Block, LayersBlock> entry : LayeredBlocks.getAllBlocks()) {
            Block layeredBlock = entry.get();
            String fullName = entry.getId().getPath(); // e.g., "stone_layers_block"
            String baseName = fullName.replace("_layers_block", ""); // e.g., "stone"

            // Resolve the base block from Minecraft's registry
            ResourceLocation baseBlockId = ResourceLocation.fromNamespaceAndPath("minecraft", baseName);
            Block baseBlock = BuiltInRegistries.BLOCK.get(baseBlockId);

            // Skip if the base block is missing or AIR
            if (baseBlock == null || baseBlock.asItem().getDefaultInstance().isEmpty()) continue;

            // Define stonecutting recipe: 1 base block => 8 layered blocks
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), RecipeCategory.BUILDING_BLOCKS, layeredBlock, 8)
                    .unlockedBy(getHasName(baseBlock), has(baseBlock))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID,
                            "stonecutting/" + fullName + "_from_" + baseName + "_block"));
        }
    }
}
