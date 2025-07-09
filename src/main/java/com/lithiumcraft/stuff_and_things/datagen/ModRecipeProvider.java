package com.lithiumcraft.stuff_and_things.datagen;

import com.google.gson.JsonObject;
import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.GlowInkSacItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public record ColoredLightRecipeData(String colorName, Item concrete, Item glass,
                                         Supplier<? extends Block> solidLightBlock,
                                         Supplier<? extends Block> glassLightBlock) {
    }

    List<ColoredLightRecipeData> recipes = List.of(
            new ColoredLightRecipeData("white", Items.WHITE_CONCRETE, Items.WHITE_STAINED_GLASS,
                    ModBlocks.WHITE_LIGHT_BLOCK, ModBlocks.WHITE_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("orange", Items.ORANGE_CONCRETE, Items.ORANGE_STAINED_GLASS,
                    ModBlocks.ORANGE_LIGHT_BLOCK, ModBlocks.ORANGE_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("magenta", Items.MAGENTA_CONCRETE, Items.MAGENTA_STAINED_GLASS,
                    ModBlocks.MAGENTA_LIGHT_BLOCK, ModBlocks.MAGENTA_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("light_blue", Items.LIGHT_BLUE_CONCRETE, Items.LIGHT_BLUE_STAINED_GLASS,
                    ModBlocks.LIGHT_BLUE_LIGHT_BLOCK, ModBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("yellow", Items.YELLOW_CONCRETE, Items.YELLOW_STAINED_GLASS,
                    ModBlocks.YELLOW_LIGHT_BLOCK, ModBlocks.YELLOW_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("lime", Items.LIME_CONCRETE, Items.LIME_STAINED_GLASS,
                    ModBlocks.LIME_LIGHT_BLOCK, ModBlocks.LIME_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("pink", Items.PINK_CONCRETE, Items.PINK_STAINED_GLASS,
                    ModBlocks.PINK_LIGHT_BLOCK, ModBlocks.PINK_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("gray", Items.GRAY_CONCRETE, Items.GRAY_STAINED_GLASS,
                    ModBlocks.GRAY_LIGHT_BLOCK, ModBlocks.GRAY_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("light_gray", Items.LIGHT_GRAY_CONCRETE, Items.LIGHT_GRAY_STAINED_GLASS,
                    ModBlocks.LIGHT_GRAY_LIGHT_BLOCK, ModBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("cyan", Items.CYAN_CONCRETE, Items.CYAN_STAINED_GLASS,
                    ModBlocks.CYAN_LIGHT_BLOCK, ModBlocks.CYAN_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("purple", Items.PURPLE_CONCRETE, Items.PURPLE_STAINED_GLASS,
                    ModBlocks.PURPLE_LIGHT_BLOCK, ModBlocks.PURPLE_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("blue", Items.BLUE_CONCRETE, Items.BLUE_STAINED_GLASS,
                    ModBlocks.BLUE_LIGHT_BLOCK, ModBlocks.BLUE_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("brown", Items.BROWN_CONCRETE, Items.BROWN_STAINED_GLASS,
                    ModBlocks.BROWN_LIGHT_BLOCK, ModBlocks.BROWN_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("green", Items.GREEN_CONCRETE, Items.GREEN_STAINED_GLASS,
                    ModBlocks.GREEN_LIGHT_BLOCK, ModBlocks.GREEN_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("red", Items.RED_CONCRETE, Items.RED_STAINED_GLASS,
                    ModBlocks.RED_LIGHT_BLOCK, ModBlocks.RED_GLASS_LIGHT_BLOCK),
            new ColoredLightRecipeData("black", Items.BLACK_CONCRETE, Items.BLACK_STAINED_GLASS,
                    ModBlocks.BLACK_LIGHT_BLOCK, ModBlocks.BLACK_GLASS_LIGHT_BLOCK)
    );


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
            stonecuttingRecipe(recipeOutput, fullName + "_from_" + baseName + "_block", baseBlock, layeredBlock, 8);
        }

        for (DeferredHolder<Block, SlabBlock> entry : SlabBlocks.getSlabBlocks()) {
            SlabBlock slabBlock = entry.get();
            String fullName = entry.getId().getPath(); // e.g., "stone_slab"
            String baseName = fullName.replace("_slab", ""); // e.g., "stone"

            ResourceLocation baseBlockId = ResourceLocation.fromNamespaceAndPath("minecraft", baseName);
            Block baseBlock = BuiltInRegistries.BLOCK.get(baseBlockId);

            if (baseBlock == null || baseBlock.asItem().getDefaultInstance().isEmpty()) continue;

            stonecuttingRecipe(recipeOutput, fullName + "_from_" + baseName + "_block", baseBlock, slabBlock, 2);
        }

        for (ColoredLightRecipeData data : recipes) {
            // Concrete-based solid light block
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, data.solidLightBlock().get())
                    .pattern(" A ")
                    .pattern("ABA")
                    .pattern(" A ")
                    .define('A', Items.GLOW_INK_SAC)
                    .define('B', data.concrete())
                    .unlockedBy("has_" + data.colorName() + "_concrete", has(data.concrete()))
                    .save(recipeOutput, modLoc("light_block/" + data.colorName() + "_light_block"));

            // Glass-based glass light block
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, data.glassLightBlock().get())
                    .pattern(" A ")
                    .pattern("ABA")
                    .pattern(" A ")
                    .define('A', Items.GLOW_INK_SAC)
                    .define('B', data.glass())
                    .unlockedBy("has_" + data.colorName() + "_glass", has(data.glass()))
                    .save(recipeOutput, modLoc("light_block/" + data.colorName() + "_glass_light_block"));
        }

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THATCH_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.DEAD_BUSH)
                .unlockedBy("has_dead_bush", has(Items.DEAD_BUSH))
                .save(recipeOutput, modLoc("blocks/thatch_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MULCH_BLOCK.get())
                .requires(ModBlocks.OLD_THATCH_BLOCK.get())
                .requires(Blocks.MUD)
                .unlockedBy("has_mud", has(Blocks.MUD))
                .save(recipeOutput, modLoc("blocks/mulch_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_MULCH_BLOCK.get())
                .requires(ModBlocks.MULCH_BLOCK.get().asItem())
                .requires(ModBlocks.MULCH_BLOCK.get().asItem())
                .requires(ModBlocks.MULCH_BLOCK.get().asItem())
                .requires(ModBlocks.MULCH_BLOCK.get().asItem())
                .unlockedBy("has_mulch_block", has(ModBlocks.COMPRESSED_MULCH_BLOCK.get()))
                .save(recipeOutput, modLoc("blocks/compressed_mulch_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_COAL_BLOCK.get())
                .requires(ModBlocks.HOT_COAL_BLOCK.get().asItem())
                .requires(ModBlocks.HOT_COAL_BLOCK.get().asItem())
                .requires(ModBlocks.HOT_COAL_BLOCK.get().asItem())
                .requires(ModBlocks.HOT_COAL_BLOCK.get().asItem())
                .unlockedBy("has_hot_coal_block", has(ModBlocks.HOT_COAL_BLOCK.get()))
                .save(recipeOutput, modLoc("blocks/compressed_coal_block"));

        stonecuttingRecipe(recipeOutput, "iron_plating_block_from_iron_ingot", Items.IRON_INGOT, ModBlocks.IRON_PLATING_BLOCK, 2);
        stonecuttingRecipe(recipeOutput, "iron_grate_block_from_iron_ingot", Items.IRON_INGOT, ModBlocks.IRON_GRATE_BLOCK, 2);
        stonecuttingRecipe(recipeOutput, "industrial_iron_grate_block_from_iron_ingot", Items.IRON_INGOT, ModBlocks.INDUSTRIAL_IRON_GRATE_BLOCK, 2);
        stonecuttingRecipe(recipeOutput, "farmland_layers_block_from_dirt", Items.DIRT, LayeredBlocks.FARMLAND_LAYERS_BLOCK, 8);
        stonecuttingRecipe(recipeOutput, "dirt_path_layers_block_from_dirt", Items.DIRT, LayeredBlocks.DIRT_PATH_LAYERS_BLOCK, 8);

//        stonecuttingRecipe(recipeOutput, "andesite_grate_block_from_andesite_alloy", ingredientFromId("create", "andesite_alloy"), ModBlocks.ANDESITE_GRATE_BLOCK.get(), 2, "create");
        stonecuttingRecipe(recipeOutput,
                "andesite_grate_block_from_alloy_tag",
                "c", // namespace
                "ingots/andesite_alloy", // path
                ModBlocks.ANDESITE_GRATE_BLOCK.get(),
                2,
                "andesite_alloy");


//        campfireCookingRecipe(recipeOutput, "hot_coal_block", Items.COAL_BLOCK, ModBlocks.HOT_COAL_BLOCK.get().asItem(), 0.1f, 600);
//        campfireCookingRecipe(recipeOutput, "hot_compressed_coal_block", ModBlocks.COMPRESSED_COAL_BLOCK.get().asItem(), ModBlocks.HOT_COMPRESSED_COAL_BLOCK.get().asItem(), 0.1f, 600);
    }

    private void smeltingRecipe(RecipeOutput recipeOutput, String name, ItemLike input, ItemLike result, float xp, int time) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, result, xp, time)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "smelting/" + name));
    }

    private void blastingRecipe(RecipeOutput recipeOutput, String name, ItemLike input, ItemLike result, float xp, int time) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, result, xp, time)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "blasting/" + name));
    }

    private void smokingRecipe(RecipeOutput recipeOutput, String name, ItemLike input, ItemLike result, float xp, int time) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, result, xp, time)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "smoking/" + name));
    }

    private void campfireCookingRecipe(RecipeOutput recipeOutput, String name, ItemLike input, ItemLike result, float xp, int time) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, result, xp, time)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "campfire/" + name));
    }

    private void stonecuttingRecipe(RecipeOutput recipeOutput, String name, ItemLike input, ItemLike result, int count) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result, count)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "stonecutting/" + name));
    }

    private void stonecuttingRecipe(RecipeOutput recipeOutput, String name, String tagNamespace, String tagPath, ItemLike result, int count, String unlockName) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath(tagNamespace, tagPath));
        Ingredient ingredient = Ingredient.of(tag);

        SingleItemRecipeBuilder.stonecutting(ingredient, RecipeCategory.BUILDING_BLOCKS, result, count)
                .unlockedBy("has_" + unlockName, has(tag))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "stonecutting/" + name));
    }

//    private void stonecuttingRecipe(
//            RecipeOutput recipeOutput,
//            String name,
//            Ingredient input,
//            ItemLike result,
//            int count,
//            String modDependency
//    ) {
//        SingleItemRecipeBuilder.stonecutting(input, RecipeCategory.BUILDING_BLOCKS, result, count)
//                .save(
//                        recipeOutput.withConditions(new ModLoadedCondition(modDependency)),
//                        ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "stonecutting/" + name)
//                );
//    }
//
//    private static Ingredient ingredientFromId(String namespace, String path) {
//        JsonObject json = new JsonObject();
//        json.addProperty("item", namespace + ":" + path);
//        return Ingredient.CODEC.decode(JsonOps.INSTANCE, json)
//                .result()
//                .orElseThrow(() -> new IllegalArgumentException("Failed to parse Ingredient for " + namespace + ":" + path))
//                .getFirst();
//    }

    private static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, path);
    }
}
//.save(recipeOutput.withConditions(new ModLoadedCondition("ae2")));