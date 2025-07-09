package com.lithiumcraft.stuff_and_things.block;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.item.LayeredBlockItem;
import com.lithiumcraft.stuff_and_things.util.SpecialBlockTextureRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class LayeredBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StuffAndThings.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StuffAndThings.MOD_ID);

    private static final Map<String, DeferredBlock<LayersBlock>> LAYERED_BLOCKS = new LinkedHashMap<>();
    private static final Map<String, DeferredBlock<PathLayerBlock>> PATH_LAYER_BLOCKS = new LinkedHashMap<>();
    private static final Map<String, DeferredBlock<FarmLayerBlock>> FARM_LAYER_BLOCKS = new LinkedHashMap<>();
    private static final Map<String, DeferredItem<? extends Item>> LAYERED_BLOCK_ITEMS = new LinkedHashMap<>();

    // === Main Registration ===
    public static final DeferredBlock<LayersBlock> ACACIA_PLANKS_LAYERS_BLOCK = register("acacia_planks_layers_block", Blocks.ACACIA_PLANKS, false);
    public static final DeferredBlock<LayersBlock> ANDESITE_LAYERS_BLOCK = register("andesite_layers_block", Blocks.ANDESITE, false);
    public static final DeferredBlock<LayersBlock> BAMBOO_PLANKS_LAYERS_BLOCK = register("bamboo_planks_layers_block", Blocks.BAMBOO_PLANKS, false);
    public static final DeferredBlock<LayersBlock> BIRCH_PLANKS_LAYERS_BLOCK = register("birch_planks_layers_block", Blocks.BIRCH_PLANKS, false);
    public static final DeferredBlock<LayersBlock> BLACKSTONE_LAYERS_BLOCK = register("blackstone_layers_block", Blocks.BLACKSTONE, false);
    public static final DeferredBlock<LayersBlock> BLUE_ICE_LAYERS_BLOCK = register("blue_ice_layers_block", Blocks.BLUE_ICE, false);
    public static final DeferredBlock<LayersBlock> CALCITE_LAYERS_BLOCK = register("calcite_layers_block", Blocks.CALCITE, false);
    public static final DeferredBlock<LayersBlock> CHERRY_PLANKS_LAYERS_BLOCK = register("cherry_planks_layers_block", Blocks.CHERRY_PLANKS, false);
    public static final DeferredBlock<LayersBlock> CLAY_LAYERS_BLOCK = register("clay_layers_block", Blocks.CLAY, false);
    public static final DeferredBlock<LayersBlock> COARSE_DIRT_LAYERS_BLOCK = register("coarse_dirt_layers_block", Blocks.COARSE_DIRT, false);
    public static final DeferredBlock<LayersBlock> COBBLED_DEEPSLATE_LAYERS_BLOCK = register("cobbled_deepslate_layers_block", Blocks.COBBLED_DEEPSLATE, false);
    public static final DeferredBlock<LayersBlock> COBBLESTONE_LAYERS_BLOCK = register("cobblestone_layers_block", Blocks.COBBLESTONE, false);
    public static final DeferredBlock<LayersBlock> CRIMSON_NYLIUM_LAYERS_BLOCK = register("crimson_nylium_layers_block", Blocks.CRIMSON_NYLIUM, false);
    public static final DeferredBlock<LayersBlock> CRIMSON_PLANKS_LAYERS_BLOCK = register("crimson_planks_layers_block", Blocks.CRIMSON_PLANKS, false);
    public static final DeferredBlock<LayersBlock> DARK_OAK_PLANKS_LAYERS_BLOCK = register("dark_oak_planks_layers_block", Blocks.DARK_OAK_PLANKS, false);
    public static final DeferredBlock<LayersBlock> DARK_PRISMARINE_LAYERS_BLOCK = register("dark_prismarine_layers_block", Blocks.DARK_PRISMARINE, false);
    public static final DeferredBlock<LayersBlock> DEEPSLATE_LAYERS_BLOCK = register("deepslate_layers_block", Blocks.DEEPSLATE, false);
    public static final DeferredBlock<LayersBlock> DIORITE_LAYERS_BLOCK = register("diorite_layers_block", Blocks.DIORITE, false);
    public static final DeferredBlock<LayersBlock> DIRT_LAYERS_BLOCK = register("dirt_layers_block", Blocks.DIRT, false);
    public static final DeferredBlock<PathLayerBlock> DIRT_PATH_LAYERS_BLOCK = registerPathBlock("dirt_path_layers_block", Blocks.DIRT_PATH);
    public static final DeferredBlock<LayersBlock> END_STONE_LAYERS_BLOCK = register("end_stone_layers_block", Blocks.END_STONE, false);
    public static final DeferredBlock<FarmLayerBlock> FARMLAND_LAYERS_BLOCK = registerFarmBlock("farmland_layers_block", Blocks.FARMLAND);
    public static final DeferredBlock<LayersBlock> GRANITE_LAYERS_BLOCK = register("granite_layers_block", Blocks.GRANITE, false);
    public static final DeferredBlock<LayersBlock> GRASS_BLOCK_LAYERS_BLOCK = register("grass_block_layers_block", Blocks.GRASS_BLOCK, false);
    public static final DeferredBlock<LayersBlock> GRAVEL_LAYERS_BLOCK = register("gravel_layers_block", Blocks.GRAVEL, false);
    public static final DeferredBlock<LayersBlock> ICE_LAYERS_BLOCK = register("ice_layers_block", Blocks.ICE, false);
    public static final DeferredBlock<LayersBlock> JUNGLE_PLANKS_LAYERS_BLOCK = register("jungle_planks_layers_block", Blocks.JUNGLE_PLANKS, false);
    public static final DeferredBlock<LayersBlock> MANGROVE_PLANKS_LAYERS_BLOCK = register("mangrove_planks_layers_block", Blocks.MANGROVE_PLANKS, false);
    public static final DeferredBlock<LayersBlock> MOSS_BLOCK_LAYERS_BLOCK = register("moss_block_layers_block", Blocks.MOSS_BLOCK, false);
    public static final DeferredBlock<LayersBlock> MOSSY_COBBLESTONE_LAYERS_BLOCK = register("mossy_cobblestone_layers_block", Blocks.MOSSY_COBBLESTONE, false);
    public static final DeferredBlock<LayersBlock> MOSSY_STONE_BRICKS_LAYERS_BLOCK = register("mossy_stone_bricks_layers_block", Blocks.MOSSY_STONE_BRICKS, false);
    public static final DeferredBlock<LayersBlock> MUD_LAYERS_BLOCK = register("mud_layers_block", Blocks.MUD, false);
    public static final DeferredBlock<LayersBlock> MUDDY_MANGROVE_ROOTS_LAYERS_BLOCK = register("muddy_mangrove_roots_layers_block", Blocks.MUDDY_MANGROVE_ROOTS, false);
    public static final DeferredBlock<LayersBlock> MYCELIUM_LAYERS_BLOCK = register("mycelium_layers_block", Blocks.MYCELIUM, false);
    public static final DeferredBlock<LayersBlock> NETHER_BRICKS_LAYERS_BLOCK = register("nether_bricks_layers_block", Blocks.NETHER_BRICKS, false);
    public static final DeferredBlock<LayersBlock> NETHERRACK_LAYERS_BLOCK = register("netherrack_layers_block", Blocks.NETHERRACK, false);
    public static final DeferredBlock<LayersBlock> OAK_PLANKS_LAYERS_BLOCK = register("oak_planks_layers_block", Blocks.OAK_PLANKS, false);
    public static final DeferredBlock<LayersBlock> OBSIDIAN_LAYERS_BLOCK = register("obsidian_layers_block", Blocks.OBSIDIAN, false);
    public static final DeferredBlock<LayersBlock> PACKED_ICE_LAYERS_BLOCK = register("packed_ice_layers_block", Blocks.PACKED_ICE, false);
    public static final DeferredBlock<LayersBlock> PACKED_MUD_LAYERS_BLOCK = register("packed_mud_layers_block", Blocks.PACKED_MUD, false);
    public static final DeferredBlock<LayersBlock> PODZOL_LAYERS_BLOCK = register("podzol_layers_block", Blocks.PODZOL, false);
    public static final DeferredBlock<LayersBlock> PRISMARINE_LAYERS_BLOCK = register("prismarine_layers_block", Blocks.PRISMARINE, false);
    public static final DeferredBlock<LayersBlock> RED_NETHER_BRICKS_LAYERS_BLOCK = register("red_nether_bricks_layers_block", Blocks.RED_NETHER_BRICKS, false);
    public static final DeferredBlock<LayersBlock> RED_SAND_LAYERS_BLOCK = register("red_sand_layers_block", Blocks.RED_SAND, false);
    public static final DeferredBlock<LayersBlock> ROOTED_DIRT_LAYERS_BLOCK = register("rooted_dirt_layers_block", Blocks.ROOTED_DIRT, false);
    public static final DeferredBlock<LayersBlock> SAND_LAYERS_BLOCK = register("sand_layers_block", Blocks.SAND, false);
    public static final DeferredBlock<LayersBlock> SMOOTH_RED_SANDSTONE_LAYERS_BLOCK = register("smooth_red_sandstone_layers_block", Blocks.SAND, false);
    public static final DeferredBlock<LayersBlock> SMOOTH_SANDSTONE_LAYERS_BLOCK = register("smooth_sandstone_layers_block", Blocks.SAND, false);
    public static final DeferredBlock<LayersBlock> SPRUCE_PLANKS_LAYERS_BLOCK = register("spruce_planks_layers_block", Blocks.SPRUCE_PLANKS, false);
    public static final DeferredBlock<LayersBlock> STONE_LAYERS_BLOCK = register("stone_layers_block", Blocks.STONE, false);
    public static final DeferredBlock<LayersBlock> STONE_BRICKS_LAYERS_BLOCK = register("stone_bricks_layers_block", Blocks.STONE_BRICKS, false);
    public static final DeferredBlock<LayersBlock> TUFF_LAYERS_BLOCK = register("tuff_layers_block", Blocks.TUFF, false);
    public static final DeferredBlock<LayersBlock> WARPED_NYLIUM_LAYERS_BLOCK = register("warped_nylium_layers_block", Blocks.WARPED_NYLIUM, false);
    public static final DeferredBlock<LayersBlock> WARPED_PLANKS_LAYERS_BLOCK = register("warped_planks_layers_block", Blocks.WARPED_PLANKS, false);
    public static final DeferredBlock<LayersBlock> GLASS_LAYERS_BLOCK = register("glass_layers_block", Blocks.GLASS, true);

    // === Stained Glass Layered Blocks ===
    public static final Map<String, DeferredBlock<LayersBlock>> STAINED_GLASS_LAYERS = registerColored("stained_glass", Blocks.GLASS, true);

    // === Register a single layered block with translucent option ===
    private static DeferredBlock<LayersBlock> register(String name, Block baseBlock, boolean translucent) {
        DeferredBlock<LayersBlock> block = BLOCKS.register(name, () -> new LayersBlock(copyOf(baseBlock, translucent).requiresCorrectToolForDrops(), baseBlock));
        DeferredItem<LayeredBlockItem> item = ITEMS.register(name, () -> new LayeredBlockItem(block.get(), new Item.Properties()));
        LAYERED_BLOCKS.put(name, block);
        LAYERED_BLOCK_ITEMS.put(name, item);
        return block;
    }

    // === Register a single shadow layered block===
    private static DeferredBlock<PathLayerBlock> registerPathBlock(String name, Block baseBlock) {
        DeferredBlock<PathLayerBlock> block = BLOCKS.register(name, () -> new PathLayerBlock(copyOf(baseBlock, false).requiresCorrectToolForDrops(), baseBlock));
        DeferredItem<LayeredBlockItem> item = ITEMS.register(name, () -> new LayeredBlockItem(block.get(), new Item.Properties()));
        PATH_LAYER_BLOCKS.put(name, block);
        LAYERED_BLOCK_ITEMS.put(name, item);
        return block;
    }

    // === Register a single shadow layered block===
    private static DeferredBlock<FarmLayerBlock> registerFarmBlock(String name, Block baseBlock) {
        DeferredBlock<FarmLayerBlock> block = BLOCKS.register(name, () -> new FarmLayerBlock(copyOf(baseBlock, false).requiresCorrectToolForDrops(), baseBlock));
        DeferredItem<LayeredBlockItem> item = ITEMS.register(name, () -> new LayeredBlockItem(block.get(), new Item.Properties()));
        FARM_LAYER_BLOCKS.put(name, block);
        LAYERED_BLOCK_ITEMS.put(name, item);
        return block;
    }

    // === Register color variants using base block, reusing `register()` ===
    private static Map<String, DeferredBlock<LayersBlock>> registerColored(String baseName, Block unusedBaseBlock, boolean translucent) {
        Map<String, DeferredBlock<LayersBlock>> registered = new LinkedHashMap<>();

        for (String color : SpecialBlockTextureRegistry.VANILLA_COLORS) {
            String name = color + "_" + baseName + "_layers_block";

            // Look up the actual base block, e.g., "minecraft:yellow_stained_glass"
            ResourceLocation baseId = ResourceLocation.fromNamespaceAndPath("minecraft", color + "_" + baseName);
            Block actualBaseBlock = BuiltInRegistries.BLOCK.get(baseId);

            if (actualBaseBlock != null && actualBaseBlock != Blocks.AIR) {
                DeferredBlock<LayersBlock> block = register(name, actualBaseBlock, translucent);
                registered.put(color, block);
            } else {
                StuffAndThings.LOGGER.warn("Missing base block for '{}'", baseId);
            }
        }

        return registered;
    }

    // === Copy block properties and apply translucency if needed ===
    private static BlockBehaviour.Properties copyOf(Block baseBlock, boolean translucent) {
        BlockState baseState = baseBlock.defaultBlockState();
        SoundType sound = baseBlock.getSoundType(baseState, null, null, null);

        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(baseState.getMapColor(null, null))
                .strength(baseBlock.defaultDestroyTime(), baseBlock.getExplosionResistance())
                .sound(sound != null ? sound : SoundType.STONE)
                .noOcclusion()
                .dynamicShape();

        if (translucent) {
            props = props.isViewBlocking((s, l, p) -> false); // Makes it transparent to light/view
        }

        return props;
    }

    // === Accessors for usage in DataGen or runtime ===
    @SuppressWarnings("unchecked")
    public static Collection<DeferredItem<LayeredBlockItem>> getAllItems() {
        return (Collection<DeferredItem<LayeredBlockItem>>) (Collection<?>) LAYERED_BLOCK_ITEMS.values();
    }

    public static Iterable<DeferredBlock<LayersBlock>> getAllBlocks() {
        return LAYERED_BLOCKS.values();
    }

    public static Iterable<DeferredBlock<PathLayerBlock>> getPathBlocks() {
        return PATH_LAYER_BLOCKS.values();
    }

    public static Iterable<DeferredBlock<FarmLayerBlock>> getFarmBlocks() {
        return FARM_LAYER_BLOCKS.values();
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}