package com.lithiumcraft.stuff_and_things.block;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class StairBlocks extends StairBlock {

    public StairBlocks(BlockState baseState, Properties properties) {
        super(baseState, properties);
    }

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StuffAndThings.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StuffAndThings.MOD_ID);

    private static final Map<String, DeferredBlock<StairBlock>> STAIR_BLOCKS = new LinkedHashMap<>();
    private static final Map<String, DeferredItem<BlockItem>> STAIR_ITEMS = new LinkedHashMap<>();

    public static final DeferredBlock<StairBlock> BLUE_ICE_STAIR = register("blue_ice_stairs", Blocks.BLUE_ICE, true);

    // === Register a single stair block ===
    private static DeferredBlock<StairBlock> register(String name, Block baseBlock, boolean translucent) {
        DeferredBlock<StairBlock> block = BLOCKS.register(name, () ->
                new StairBlock(baseBlock.defaultBlockState(), copyOf(baseBlock, translucent).requiresCorrectToolForDrops())
        );
        DeferredItem<BlockItem> item = ITEMS.register(name, () ->
                new BlockItem(block.get(), new Item.Properties()));
        STAIR_BLOCKS.put(name, block);
        STAIR_ITEMS.put(name, item);
        return block;
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

    public static Collection<DeferredBlock<StairBlock>> getStairBlocks() {
        return STAIR_BLOCKS.values();
    }

    public static Collection<DeferredItem<BlockItem>> getAllItems() {
        return STAIR_ITEMS.values();
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
//
//    static {
//        WATERLOGGED = BlockStateProperties.WATERLOGGED;
//    }
}
