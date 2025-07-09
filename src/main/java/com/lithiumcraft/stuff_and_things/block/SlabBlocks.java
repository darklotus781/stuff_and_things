package com.lithiumcraft.stuff_and_things.block;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.util.SpecialBlockTextureRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class SlabBlocks extends SlabBlock {
    public SlabBlocks(Properties properties) {
        super(properties);
    }

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StuffAndThings.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StuffAndThings.MOD_ID);

    private static final Map<String, DeferredBlock<SlabBlock>> SLAB_BLOCKS = new LinkedHashMap<>();
    private static final Map<String, DeferredItem<BlockItem>> SLAB_ITEMS = new LinkedHashMap<>();

    public static final DeferredBlock<SlabBlock> BLUE_ICE_SLAB = register("blue_ice_slab", Blocks.BLUE_ICE, true);
    public static final DeferredBlock<SlabBlock> CALCITE_SLAB = register("calcite_slab", Blocks.CALCITE, true);
    public static final DeferredBlock<SlabBlock> CLAY_SLAB = register("clay_slab", Blocks.CLAY, true);
    public static final DeferredBlock<SlabBlock> COARSE_DIRT_SLAB = register("coarse_dirt_slab", Blocks.COARSE_DIRT, true);
    public static final DeferredBlock<SlabBlock> CRIMSON_NYLIUM_SLAB = register("crimson_nylium_slab", Blocks.CRIMSON_NYLIUM, true);
    public static final DeferredBlock<SlabBlock> DIRT_SLAB = register("dirt_slab", Blocks.DIRT, true);
//    public static final DeferredBlock<SlabBlock> DIRT_PATH_SLAB = register("dirt_path_slab", Blocks.DIRT_PATH, true);
    public static final DeferredBlock<SlabBlock> END_STONE_SLAB = register("end_stone_slab", Blocks.END_STONE, true);
//    public static final DeferredBlock<SlabBlock> FARMLAND_SLAB = register("farmland_slab", Blocks.FARMLAND, true);
    public static final DeferredBlock<SlabBlock> GRASS_BLOCK_SLAB = register("grass_block_slab", Blocks.GRASS_BLOCK, true);
    public static final DeferredBlock<SlabBlock> GRAVEL_SLAB = register("gravel_slab", Blocks.GRAVEL, true);
    public static final DeferredBlock<SlabBlock> ICE_SLAB = register("ice_slab", Blocks.ICE, true);
    public static final DeferredBlock<SlabBlock> MOSS_BLOCK_SLAB = register("moss_block_slab", Blocks.MOSS_BLOCK, true);
    public static final DeferredBlock<SlabBlock> MUD_SLAB = register("mud_slab", Blocks.MUD, true);
    public static final DeferredBlock<SlabBlock> MUDDY_MANGROVE_ROOTS_SLAB = register("muddy_mangrove_roots_slab", Blocks.MUDDY_MANGROVE_ROOTS, true);
    public static final DeferredBlock<SlabBlock> MYCELIUM_SLAB = register("mycelium_slab", Blocks.MYCELIUM, true);
    public static final DeferredBlock<SlabBlock> NETHERRACK_SLAB = register("netherrack_slab", Blocks.NETHERRACK, true);
    public static final DeferredBlock<SlabBlock> PACKED_MUD_SLAB = register("packed_mud_slab", Blocks.PACKED_MUD, true);
    public static final DeferredBlock<SlabBlock> OBSIDIAN_SLAB = register("obsidian_slab", Blocks.OBSIDIAN, true);
    public static final DeferredBlock<SlabBlock> PACKED_ICE_SLAB = register("packed_ice_slab", Blocks.PACKED_ICE, true);
    public static final DeferredBlock<SlabBlock> PODZOL_SLAB = register("podzol_slab", Blocks.PODZOL, true);
    public static final DeferredBlock<SlabBlock> RED_SAND_SLAB = register("red_sand_slab", Blocks.RED_SAND, true);
    public static final DeferredBlock<SlabBlock> ROOTED_DIRT_SLAB = register("rooted_dirt_slab", Blocks.ROOTED_DIRT, true);
    public static final DeferredBlock<SlabBlock> SAND_SLAB = register("sand_slab", Blocks.SAND, true);
    public static final DeferredBlock<SlabBlock> SMOOTH_RED_SANDSTONE_SLAB = register("smooth_red_sandstone_slab", Blocks.SMOOTH_RED_SANDSTONE_SLAB, true);
    public static final DeferredBlock<SlabBlock> SMOOTH_SANDSTONE_SLAB = register("smooth_sandstone_slab", Blocks.SMOOTH_SANDSTONE_SLAB, true);
    public static final DeferredBlock<SlabBlock> TUFF_SLAB = register("tuff_slab", Blocks.TUFF, true);
    public static final DeferredBlock<SlabBlock> WARPED_NYLIUM_SLAB = register("warped_nylium_slab", Blocks.WARPED_NYLIUM, true);

    public static final DeferredBlock<SlabBlock> GLASS_SLAB = register("glass_slab", Blocks.GLASS, true);
    public static final Map<String, DeferredBlock<SlabBlock>> STAINED_GLASS_SLABS = registerColored("stained_glass", true);

    // === Register a single slab block ===
    private static DeferredBlock<SlabBlock> register(String name, Block baseBlock, boolean translucent) {
        DeferredBlock<SlabBlock> block = BLOCKS.register(name, () ->
                new SlabBlock(copyOf(baseBlock, translucent).requiresCorrectToolForDrops())
        );
        DeferredItem<BlockItem> item = ITEMS.register(name, () ->
                new BlockItem(block.get(), new Item.Properties()));
        SLAB_BLOCKS.put(name, block);
        SLAB_ITEMS.put(name, item);
        return block;
    }

    private static Map<String, DeferredBlock<SlabBlock>> registerColored(String baseName, boolean translucent) {
        Map<String, DeferredBlock<SlabBlock>> registered = new LinkedHashMap<>();

        for (String color : SpecialBlockTextureRegistry.VANILLA_COLORS) {
            String slabName = color + "_" + baseName + "_slab";
            ResourceLocation baseId = ResourceLocation.fromNamespaceAndPath("minecraft", color + "_" + baseName);
            Block baseBlock = BuiltInRegistries.BLOCK.get(baseId);

            if (baseBlock != null && baseBlock != Blocks.AIR) {
                DeferredBlock<SlabBlock> block = register(slabName, baseBlock, translucent);
                registered.put(color, block);
            } else {
                StuffAndThings.LOGGER.warn("Missing base block for '{}'", baseId);
            }
        }

        return registered;
    }

    private static BlockBehaviour.Properties copyOf(Block baseBlock, boolean translucent) {
        BlockState state = baseBlock.defaultBlockState();
        SoundType sound = baseBlock.getSoundType(state, null, null, null);

        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(state.getMapColor(null, null))
                .strength(baseBlock.defaultDestroyTime(), baseBlock.getExplosionResistance())
                .sound(sound != null ? sound : SoundType.STONE);

        if (translucent) {
            props = props
                    .noOcclusion()
                    .isViewBlocking((s, l, p) -> false)
                    .isRedstoneConductor((s, l, p) -> false);
        }

        return props;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        SlabType type = state.getValue(TYPE);
        return switch (type) {
            case DOUBLE -> Shapes.block();
            case TOP -> Block.box(0, 8, 0, 16, 16, 16); // normal top slab shape
            case BOTTOM -> Block.box(0, 0, 0, 16, 8, 16); // not full height, blocks `isFaceSturdy`
        };
    }


    public static Collection<DeferredBlock<SlabBlock>> getSlabBlocks() {
        return SLAB_BLOCKS.values();
    }

    public static Collection<DeferredItem<BlockItem>> getAllSlabItems() {
        return SLAB_ITEMS.values();
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
