package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import com.lithiumcraft.stuff_and_things.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, StuffAndThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Static
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(ModTags.Blocks.LIGHT_BLOCKS)
                .add(LayeredBlocks.ANDESITE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.BLACKSTONE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.BLACKSTONE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.BLUE_ICE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.CALCITE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.COBBLED_DEEPSLATE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.COBBLESTONE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.CRIMSON_NYLIUM_LAYERS_BLOCK.get())
                .add(LayeredBlocks.DARK_PRISMARINE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.DEEPSLATE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.DIORITE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.END_STONE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.GLASS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.GRANITE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.ICE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MOSSY_COBBLESTONE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MOSSY_STONE_BRICKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.NETHER_BRICKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.NETHERRACK_LAYERS_BLOCK.get())
                .add(LayeredBlocks.OBSIDIAN_LAYERS_BLOCK.get())
                .add(LayeredBlocks.PACKED_ICE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.PACKED_MUD_LAYERS_BLOCK.get())
                .add(LayeredBlocks.PRISMARINE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.RED_NETHER_BRICKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.SMOOTH_RED_SANDSTONE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.SMOOTH_SANDSTONE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.STONE_LAYERS_BLOCK.get())
                .add(LayeredBlocks.STONE_BRICKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.TUFF_LAYERS_BLOCK.get())
                .add(LayeredBlocks.WARPED_NYLIUM_LAYERS_BLOCK.get())
                .add(LayeredBlocks.STAINED_GLASS_LAYERS.values().stream()
                        .map(DeferredHolder::get)
                        .toArray(Block[]::new))

                .add(SlabBlocks.BLUE_ICE_SLAB.get())
                .add(SlabBlocks.CALCITE_SLAB.get())
                .add(SlabBlocks.CRIMSON_NYLIUM_SLAB.get())
                .add(SlabBlocks.END_STONE_SLAB.get())
                .add(SlabBlocks.ICE_SLAB.get())
                .add(SlabBlocks.NETHERRACK_SLAB.get())
                .add(SlabBlocks.OBSIDIAN_SLAB.get())
                .add(SlabBlocks.PACKED_ICE_SLAB.get())
                .add(SlabBlocks.PACKED_MUD_SLAB.get())
                .add(SlabBlocks.SMOOTH_RED_SANDSTONE_SLAB.get())
                .add(SlabBlocks.SMOOTH_SANDSTONE_SLAB.get())
                .add(SlabBlocks.TUFF_SLAB.get())
                .add(SlabBlocks.WARPED_NYLIUM_SLAB.get())
                .add(SlabBlocks.GLASS_SLAB.get())
                .add(SlabBlocks.STAINED_GLASS_SLABS.values().stream()
                        .map(DeferredHolder::get)
                        .toArray(Block[]::new));

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(LayeredBlocks.ACACIA_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.BAMBOO_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.BIRCH_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.CHERRY_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.CRIMSON_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.DARK_OAK_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.JUNGLE_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MANGROVE_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.OAK_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.SPRUCE_PLANKS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.WARPED_PLANKS_LAYERS_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(LayeredBlocks.MOSS_BLOCK_LAYERS_BLOCK.get())

                .add(SlabBlocks.MOSS_BLOCK_SLAB.get())

                .add(SlabBlocks.MOSS_BLOCK_SLAB.get())
                .add(ModBlocks.THATCH_BLOCK.get())
                .add(ModBlocks.WAXED_THATCH_BLOCK.get())
                .add(ModBlocks.AGED_THATCH_BLOCK.get())
                .add(ModBlocks.WAXED_AGED_THATCH_BLOCK.get())
                .add(ModBlocks.OLD_THATCH_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(LayeredBlocks.CLAY_LAYERS_BLOCK.get())
                .add(LayeredBlocks.COARSE_DIRT_LAYERS_BLOCK.get())
                .add(LayeredBlocks.DIRT_LAYERS_BLOCK.get())
                .add(LayeredBlocks.GRASS_BLOCK_LAYERS_BLOCK.get())
                .add(LayeredBlocks.GRAVEL_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MUD_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MUDDY_MANGROVE_ROOTS_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MYCELIUM_LAYERS_BLOCK.get())
                .add(LayeredBlocks.PODZOL_LAYERS_BLOCK.get())
                .add(LayeredBlocks.RED_SAND_LAYERS_BLOCK.get())
                .add(LayeredBlocks.ROOTED_DIRT_LAYERS_BLOCK.get())
                .add(LayeredBlocks.SAND_LAYERS_BLOCK.get())

                .add(SlabBlocks.CLAY_SLAB.get())
                .add(SlabBlocks.COARSE_DIRT_SLAB.get())
                .add(SlabBlocks.DIRT_SLAB.get())
                .add(SlabBlocks.GRASS_BLOCK_SLAB.get())
                .add(SlabBlocks.GRAVEL_SLAB.get())
                .add(SlabBlocks.MUD_SLAB.get())
                .add(SlabBlocks.MUDDY_MANGROVE_ROOTS_SLAB.get())
                .add(SlabBlocks.MYCELIUM_SLAB.get())
                .add(SlabBlocks.PACKED_MUD_SLAB.get())
                .add(SlabBlocks.PODZOL_SLAB.get())
                .add(SlabBlocks.RED_SAND_SLAB.get())
                .add(SlabBlocks.ROOTED_DIRT_SLAB.get())
                .add(SlabBlocks.SAND_SLAB.get())
                .add(SlabBlocks.DIRT_PATH_SLAB.get())
                .add(SlabBlocks.FARMLAND_SLAB.get())

                .add(ModBlocks.HOT_COAL_BLOCK.get())
                .add(ModBlocks.COMPRESSED_COAL_BLOCK.get())
                .add(ModBlocks.HOT_COMPRESSED_COAL_BLOCK.get())
                .add(ModBlocks.MULCH_BLOCK.get())
                .add(ModBlocks.COMPRESSED_MULCH_BLOCK.get())
                .add(ModBlocks.AGED_COMPRESSED_MULCH_BLOCK.get())
                .add(ModBlocks.HOT_AGED_COMPRESSED_MULCH_BLOCK.get())
                .add(LayeredBlocks.FARMLAND_LAYERS_BLOCK.get())
                .add(LayeredBlocks.DIRT_PATH_LAYERS_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(LayeredBlocks.OBSIDIAN_LAYERS_BLOCK.get())
                .add(SlabBlocks.OBSIDIAN_SLAB.get());

        // Add all registered translucent blocks (like glass layers)
        this.tag(ModTags.Blocks.TRANSLUCENT)
                .add(LayeredBlocks.GLASS_LAYERS_BLOCK.value())
                .add(LayeredBlocks.STAINED_GLASS_LAYERS.values().stream()
                        .map(DeferredHolder::get)
                        .toArray(Block[]::new))
                .add(SlabBlocks.GLASS_SLAB.get())
                .add(SlabBlocks.STAINED_GLASS_SLABS.values().stream()
                        .map(DeferredHolder::get)
                        .toArray(Block[]::new));

        for (DeferredHolder<Block, ? extends LayersBlock> block : LayeredBlocks.getAllBlocks()) {
            String blockName = block.getId().getPath();

            this.tag(ModTags.Blocks.LAYER_BLOCKS).add(block.get());
        }

        for (DeferredHolder<Block, ? extends SlabBlock> block : SlabBlocks.getAllBlocks()) {
            String blockName = block.getId().getPath();

            this.tag(ModTags.Blocks.SLABS).add(block.get());
            this.tag(BlockTags.SLABS).add(block.get());
        }

//        this.tag(ModTags.Blocks.LAYER_BLOCKS)
//                .add(LayeredBlocks.FARMLAND_LAYERS_BLOCK.get())
//                .add(LayeredBlocks.DIRT_PATH_LAYERS_BLOCK.get());

//        this.tag(ModTags.Blocks.SLABS)
//                .add(SlabBlocks.DIRT_PATH_SLAB.get())
//                .add(SlabBlocks.FARMLAND_SLAB.get());
//
//        this.tag(BlockTags.SLABS)
//                .add(SlabBlocks.DIRT_PATH_SLAB.get())
//                .add(SlabBlocks.FARMLAND_SLAB.get());

        this.tag(BlockTags.DIRT)
                .add(LayeredBlocks.COARSE_DIRT_LAYERS_BLOCK.get())
                .add(LayeredBlocks.DIRT_LAYERS_BLOCK.get())
                .add(LayeredBlocks.GRASS_BLOCK_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MYCELIUM_LAYERS_BLOCK.get())
                .add(LayeredBlocks.PODZOL_LAYERS_BLOCK.get())
                .add(LayeredBlocks.ROOTED_DIRT_LAYERS_BLOCK.get())
                .add(LayeredBlocks.FARMLAND_LAYERS_BLOCK.get())
                .add(LayeredBlocks.DIRT_PATH_LAYERS_BLOCK.get())

                .add(SlabBlocks.COARSE_DIRT_SLAB.get())
                .add(SlabBlocks.DIRT_SLAB.get())
                .add(SlabBlocks.GRASS_BLOCK_SLAB.get())
                .add(SlabBlocks.MYCELIUM_SLAB.get())
                .add(SlabBlocks.PODZOL_SLAB.get())
                .add(SlabBlocks.ROOTED_DIRT_SLAB.get())
                .add(SlabBlocks.DIRT_PATH_SLAB.get())
                .add(SlabBlocks.FARMLAND_SLAB.get());

        this.tag(BlockTags.SAND)
                .add(LayeredBlocks.SAND_LAYERS_BLOCK.get())
                .add(LayeredBlocks.RED_SAND_LAYERS_BLOCK.get())

                .add(SlabBlocks.SAND_SLAB.get())
                .add(SlabBlocks.RED_SAND_SLAB.get());

        this.tag(BlockTags.MUSHROOM_GROW_BLOCK)
                .add(LayeredBlocks.CRIMSON_NYLIUM_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MYCELIUM_LAYERS_BLOCK.get())
                .add(LayeredBlocks.PODZOL_LAYERS_BLOCK.get())
                .add(LayeredBlocks.WARPED_NYLIUM_LAYERS_BLOCK.get())

                .add(SlabBlocks.CRIMSON_NYLIUM_SLAB.get())
                .add(SlabBlocks.MYCELIUM_SLAB.get())
                .add(SlabBlocks.PODZOL_SLAB.get())
                .add(SlabBlocks.WARPED_NYLIUM_SLAB.get());

        this.tag(BlockTags.AZALEA_GROWS_ON)
                .add(LayeredBlocks.COARSE_DIRT_LAYERS_BLOCK.get())
                .add(LayeredBlocks.DIRT_LAYERS_BLOCK.get())
                .add(LayeredBlocks.GRASS_BLOCK_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MOSS_BLOCK_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MUD_LAYERS_BLOCK.get())
                .add(LayeredBlocks.MYCELIUM_LAYERS_BLOCK.get())
                .add(LayeredBlocks.PODZOL_LAYERS_BLOCK.get())
                .add(LayeredBlocks.RED_SAND_LAYERS_BLOCK.get())
                .add(LayeredBlocks.ROOTED_DIRT_LAYERS_BLOCK.get())
                .add(LayeredBlocks.SAND_LAYERS_BLOCK.get())

                .add(SlabBlocks.COARSE_DIRT_SLAB.get())
                .add(SlabBlocks.DIRT_SLAB.get())
                .add(SlabBlocks.GRASS_BLOCK_SLAB.get())
                .add(SlabBlocks.MOSS_BLOCK_SLAB.get())
                .add(SlabBlocks.MUD_SLAB.get())
                .add(SlabBlocks.MYCELIUM_SLAB.get())
                .add(SlabBlocks.PODZOL_SLAB.get())
                .add(SlabBlocks.RED_SAND_SLAB.get())
                .add(SlabBlocks.ROOTED_DIRT_SLAB.get())
                .add(SlabBlocks.SAND_SLAB.get());

        this.tag(BlockTags.NYLIUM)
                .add(LayeredBlocks.CRIMSON_NYLIUM_LAYERS_BLOCK.get())
                .add(LayeredBlocks.WARPED_NYLIUM_LAYERS_BLOCK.get())

                .add(SlabBlocks.CRIMSON_NYLIUM_SLAB.get())
                .add(SlabBlocks.WARPED_NYLIUM_SLAB.get());

        this.tag(ModTags.Blocks.LIGHT_BLOCKS)
                .add(ModBlocks.BLUE_LIGHT_BLOCK.get())
                .add(ModBlocks.BLACK_LIGHT_BLOCK.get())
                .add(ModBlocks.BROWN_LIGHT_BLOCK.get())
                .add(ModBlocks.CYAN_LIGHT_BLOCK.get())
                .add(ModBlocks.GRAY_LIGHT_BLOCK.get())
                .add(ModBlocks.GREEN_LIGHT_BLOCK.get())
                .add(ModBlocks.LIGHT_BLUE_LIGHT_BLOCK.get())
                .add(ModBlocks.LIGHT_GRAY_LIGHT_BLOCK.get())
                .add(ModBlocks.LIME_LIGHT_BLOCK.get())
                .add(ModBlocks.MAGENTA_LIGHT_BLOCK.get())
                .add(ModBlocks.ORANGE_LIGHT_BLOCK.get())
                .add(ModBlocks.PINK_LIGHT_BLOCK.get())
                .add(ModBlocks.PURPLE_LIGHT_BLOCK.get())
                .add(ModBlocks.RED_LIGHT_BLOCK.get())
                .add(ModBlocks.WHITE_LIGHT_BLOCK.get())
                .add(ModBlocks.YELLOW_LIGHT_BLOCK.get())

                .add(ModBlocks.BLUE_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.BLACK_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.BROWN_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.CYAN_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.GRAY_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.GREEN_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.LIME_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.ORANGE_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.PINK_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.PURPLE_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.RED_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.WHITE_GLASS_LIGHT_BLOCK.get())
                .add(ModBlocks.YELLOW_GLASS_LIGHT_BLOCK.get());

        this.tag(ModTags.Blocks.MULCH)
                .add(ModBlocks.MULCH_BLOCK.get())
                .add(ModBlocks.COMPRESSED_MULCH_BLOCK.get())
                .add(ModBlocks.AGED_COMPRESSED_MULCH_BLOCK.get())
                .add(ModBlocks.HOT_AGED_COMPRESSED_MULCH_BLOCK.get());

        this.tag(ModTags.Blocks.COAL)
                .add(ModBlocks.HOT_COAL_BLOCK.get())
                .add(ModBlocks.COMPRESSED_COAL_BLOCK.get())
                .add(ModBlocks.HOT_COMPRESSED_COAL_BLOCK.get());

        this.tag(ModTags.Blocks.THATCH)
                .add(ModBlocks.THATCH_BLOCK.get())
                .add(ModBlocks.WAXED_THATCH_BLOCK.get())
                .add(ModBlocks.AGED_THATCH_BLOCK.get())
                .add(ModBlocks.WAXED_AGED_THATCH_BLOCK.get())
                .add(ModBlocks.OLD_THATCH_BLOCK.get());

        this.tag(BlockTags.BAMBOO_PLANTABLE_ON)
                .add(ModBlocks.MULCH_BLOCK.get())
                .add(ModBlocks.COMPRESSED_MULCH_BLOCK.get())
                .add(ModBlocks.AGED_COMPRESSED_MULCH_BLOCK.get());

        this.tag(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
                .add(ModBlocks.MULCH_BLOCK.get())
                .add(ModBlocks.COMPRESSED_MULCH_BLOCK.get())
                .add(ModBlocks.AGED_COMPRESSED_MULCH_BLOCK.get());

        this.tag(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON)
                .add(ModBlocks.HOT_AGED_COMPRESSED_MULCH_BLOCK.get())
                .add(ModBlocks.HOT_COMPRESSED_COAL_BLOCK.get())
                .add(ModBlocks.HOT_COAL_BLOCK.get());

        this.tag(ModTags.Blocks.WRENCHABLE)
                .addTag(ModTags.Blocks.LAYER_BLOCKS)
                .addTag(ModTags.Blocks.SLABS)
                .addTag(ModTags.Blocks.LIGHT_BLOCKS)
                .addTag(ModTags.Blocks.GRATES)
                .addTag(ModTags.Blocks.PLATING);

        this.tag(ModTags.Blocks.CREATE_WRENCH_PICKUP)
                .addTag(ModTags.Blocks.WRENCHABLE);

        this.tag(ModTags.Blocks.FRAMEABLE)
                .addTag(ModTags.Blocks.LIGHT_BLOCKS)
                .addTag(ModTags.Blocks.GRATES)
                .addTag(ModTags.Blocks.PLATING);

        this.tag(ModTags.Blocks.GRATES)
                .add(ModBlocks.ANDESITE_GRATE_BLOCK.get())
                .add(ModBlocks.INDUSTRIAL_IRON_GRATE_BLOCK.get())
                .add(ModBlocks.IRON_GRATE_BLOCK.get());

        this.tag(ModTags.Blocks.PLATING)
                .add(ModBlocks.IRON_PLATING_BLOCK.get());
    }
}
