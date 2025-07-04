package com.lithiumcraft.stuff_and_things.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.util.TriState;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class LayersBlock extends Block {
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 1, 8);
    private final Block fullBlock;

    public LayersBlock(Properties properties, Block fullBlock) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LAYERS, 1));
        this.fullBlock = fullBlock;

    }

//    public static final Map<String, BlockSound> SOUND_MAP = new HashMap<>();
//    static {
//        SOUND_MAP.put("acacia_planks_layers_block", new BlockSound(Blocks.ACACIA_PLANKS, SoundEvents.WOOD_PLACE));
//        SOUND_MAP.put("andesite_layers_block", new BlockSound(Blocks.ANDESITE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("bamboo_planks_layers_block", new BlockSound(Blocks.BAMBOO_PLANKS, SoundEvents.BAMBOO_WOOD_PLACE));
//        SOUND_MAP.put("birch_planks_layers_block", new BlockSound(Blocks.BIRCH_PLANKS, SoundEvents.WOOD_PLACE));
//        SOUND_MAP.put("blackstone_layers_block", new BlockSound(Blocks.BLACKSTONE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("blue_ice_layers_block", new BlockSound(Blocks.BLUE_ICE, SoundEvents.GLASS_PLACE));
//        SOUND_MAP.put("calcite_layers_block", new BlockSound(Blocks.CALCITE, SoundEvents.CALCITE_PLACE));
//        SOUND_MAP.put("cherry_planks_layers_block", new BlockSound(Blocks.CHERRY_PLANKS, SoundEvents.CHERRY_WOOD_PLACE));
//        SOUND_MAP.put("clay_layers_block", new BlockSound(Blocks.CLAY, SoundEvents.GRAVEL_PLACE));
//        SOUND_MAP.put("coarse_dirt_layers_block", new BlockSound(Blocks.COARSE_DIRT, SoundEvents.GRAVEL_PLACE));
//        SOUND_MAP.put("cobbled_deepslate_layers_block", new BlockSound(Blocks.COBBLED_DEEPSLATE, SoundEvents.DEEPSLATE_PLACE));
//        SOUND_MAP.put("cobblestone_layers_block", new BlockSound(Blocks.COBBLESTONE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("crimson_nylium_layers_block", new BlockSound(Blocks.CRIMSON_NYLIUM, SoundEvents.NETHERRACK_PLACE));
//        SOUND_MAP.put("crimson_planks_layers_block", new BlockSound(Blocks.CRIMSON_PLANKS, SoundEvents.WOOD_PLACE));
//        SOUND_MAP.put("dark_oak_planks_layers_block", new BlockSound(Blocks.DARK_OAK_PLANKS, SoundEvents.WOOD_PLACE));
//        SOUND_MAP.put("dark_prismarine_layers_block", new BlockSound(Blocks.DARK_PRISMARINE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("deepslate_layers_block", new BlockSound(Blocks.DEEPSLATE, SoundEvents.DEEPSLATE_PLACE));
//        SOUND_MAP.put("diorite_layers_block", new BlockSound(Blocks.DIORITE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("dirt_layers_block", new BlockSound(Blocks.DIRT, SoundEvents.GRAVEL_PLACE));
//        SOUND_MAP.put("end_stone_layers_block", new BlockSound(Blocks.END_STONE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("granite_layers_block", new BlockSound(Blocks.GRANITE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("grass_layers_block", new BlockSound(Blocks.GRASS_BLOCK, SoundEvents.GRASS_PLACE));
//        SOUND_MAP.put("gravel_layers_block", new BlockSound(Blocks.GRAVEL, SoundEvents.GRAVEL_PLACE));
//        SOUND_MAP.put("ice_layers_block", new BlockSound(Blocks.ICE, SoundEvents.GLASS_PLACE));
//        SOUND_MAP.put("jungle_planks_layers_block", new BlockSound(Blocks.JUNGLE_PLANKS, SoundEvents.WOOD_PLACE));
//        SOUND_MAP.put("mangrove_planks_layers_block", new BlockSound(Blocks.MANGROVE_PLANKS, SoundEvents.WOOD_PLACE));
//        SOUND_MAP.put("moss_block_layers_block", new BlockSound(Blocks.MOSS_BLOCK, SoundEvents.MOSS_PLACE));
//        SOUND_MAP.put("mossy_cobblestone_layers_block", new BlockSound(Blocks.MOSSY_COBBLESTONE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("mossy_stone_bricks_layers_block", new BlockSound(Blocks.MOSSY_STONE_BRICKS, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("mud_layers_block", new BlockSound(Blocks.MUD, SoundEvents.MUD_PLACE));
//        SOUND_MAP.put("mycelium_layers_block", new BlockSound(Blocks.MYCELIUM, SoundEvents.GRAVEL_PLACE));
//        SOUND_MAP.put("nether_bricks_layers_block", new BlockSound(Blocks.NETHER_BRICKS, SoundEvents.NETHER_BRICKS_PLACE));
//        SOUND_MAP.put("netherrack_layers_block", new BlockSound(Blocks.NETHERRACK, SoundEvents.NETHERRACK_PLACE));
//        SOUND_MAP.put("oak_planks_layers_block", new BlockSound(Blocks.OAK_PLANKS, SoundEvents.WOOD_PLACE));
//        SOUND_MAP.put("obsidian_layers_block", new BlockSound(Blocks.OBSIDIAN, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("packed_ice_layers_block", new BlockSound(Blocks.PACKED_ICE, SoundEvents.GLASS_PLACE));
//        SOUND_MAP.put("packed_mud_layers_block", new BlockSound(Blocks.PACKED_MUD, SoundEvents.PACKED_MUD_PLACE));
//        SOUND_MAP.put("podzol_layers_block", new BlockSound(Blocks.PODZOL, SoundEvents.GRAVEL_PLACE));
//        SOUND_MAP.put("prismarine_layers_block", new BlockSound(Blocks.PRISMARINE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("red_nether_bricks_layers_block", new BlockSound(Blocks.RED_NETHER_BRICKS, SoundEvents.NETHER_BRICKS_PLACE));
//        SOUND_MAP.put("red_sand_layers_block", new BlockSound(Blocks.RED_SAND, SoundEvents.SAND_PLACE));
//        SOUND_MAP.put("rooted_dirt_layers_block", new BlockSound(Blocks.ROOTED_DIRT, SoundEvents.ROOTED_DIRT_PLACE));
//        SOUND_MAP.put("sand_layers_block", new BlockSound(Blocks.SAND, SoundEvents.SAND_PLACE));
//        SOUND_MAP.put("spruce_planks_layers_block", new BlockSound(Blocks.SPRUCE_PLANKS, SoundEvents.WOOD_PLACE));
//        SOUND_MAP.put("stone_layers_block", new BlockSound(Blocks.STONE, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("stone_bricks_layers_block", new BlockSound(Blocks.STONE_BRICKS, SoundEvents.STONE_PLACE));
//        SOUND_MAP.put("tuff_layers_block", new BlockSound(Blocks.TUFF, SoundEvents.TUFF_PLACE));
//        SOUND_MAP.put("warped_nylium_layers_block", new BlockSound(Blocks.WARPED_NYLIUM, SoundEvents.NETHERRACK_PLACE));
//        SOUND_MAP.put("warped_planks_layers_block", new BlockSound(Blocks.WARPED_PLANKS, SoundEvents.WOOD_PLACE));
//    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        int layers = state.getValue(LAYERS);
        return Block.box(0.0, 0.0, 0.0, 16.0, layers * 2.0, 16.0);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int layers = state.getValue(LAYERS);
        return Block.box(0.0, 0.0, 0.0, 16.0, layers * 2.0, 16.0);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getBlockSupportShape(BlockState state, BlockGetter level, BlockPos pos) {
        int layers = state.getValue(LAYERS);
        return Block.box(0.0, 0.0, 0.0, 16.0, layers * 2.0, 16.0);
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return getShape(state, level, pos, context);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentState, Direction side) {
        // Skip if both are this block and both are layer 8 (full cube)
        if (adjacentState.is(this)) {
            return state.getValue(LAYERS) == 8 && adjacentState.getValue(LAYERS) == 8;
        }

        // Skip if this is layer 8 and adjacent is the full block (e.g., acacia_planks)
        if (state.getValue(LAYERS) == 8 && adjacentState.is(fullBlock)) return true;

        // Skip if adjacent is another LayersBlock of same full block and layer 8
        if (adjacentState.getBlock() instanceof LayersBlock other
                && other.getFullBlock() == this.fullBlock
                && adjacentState.getValue(LAYERS) == 8
                && state.getValue(LAYERS) == 8) return true;

        return false;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }
//
//    public void placeFullBlock(Level level, BlockPos pos, Player player) {
//        // Confirm this is a LayersBlock and has a valid full block mapped
//        if (!(this instanceof LayersBlock layersBlock) || layersBlock.getFullBlock() == null) {
//            BlockState fallback = Blocks.GRASS_BLOCK.defaultBlockState();
//
//            // Set fallback block
//            level.setBlock(pos, fallback, 3);
//
//            // Play fallback placement sound
//            level.playSound(player, pos, fallback.getSoundType().getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
//
//            // Show break particles for feedback
//            level.levelEvent(2001, pos, Block.getId(fallback));
//            return;
//        }
//
//        // Get the mapped full block and its properties
//        Block fullBlock = layersBlock.getFullBlock();
//        BlockState fullState = fullBlock.defaultBlockState();
//        SoundEvent placeSound = fullState.getSoundType().getPlaceSound();
//
//        // Replace with full block
//        level.setBlock(pos, fullState, 3);
//
//        // Play placement sound only (no break sound)
//        level.playSound(player, pos, placeSound, SoundSource.BLOCKS, 1.0F, 1.0F);
//
//        // Emit break particle effect (visual only)
//        level.levelEvent(2001, pos, Block.getId(fullState));
//    }




    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }

    @Override
    public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return false; // It's *never* a full block, because 8 becomes the real block
    }

    @Override
    public boolean isPossibleToRespawnInThis(BlockState state) {
        return false;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (state.is(this)) {
            int layers = state.getValue(LAYERS);
            return state.setValue(LAYERS, Math.min(7, layers + 1));
        }
        return super.getStateForPlacement(context);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        ItemStack heldItem = context.getItemInHand();
        Block heldBlock = Block.byItem(heldItem.getItem());

        return heldBlock == this && state.getValue(LAYERS) < 8;
    }



    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (!level.isClientSide && isCorrectTool(state, player) && player.isShiftKeyDown()) {
            int layers = state.getValue(LAYERS);
            if (layers > 1) {
                level.setBlock(pos, state.setValue(LAYERS, layers - 1), Block.UPDATE_ALL);
                popResource(level, pos, new ItemStack(this.asItem()));
                return false; // Cancel full block break
            }
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    private boolean isCorrectTool(BlockState state, Player player) {
        ItemStack stack = player.getMainHandItem();
        return stack.isCorrectToolForDrops(state);
    }

    public Block getFullBlock() {
        return fullBlock;
    }

    @Override
    public void onRemove(BlockState oldState, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!oldState.is(newState.getBlock())) {
            super.onRemove(oldState, level, pos, newState, isMoving);
        }
    }

//    @Override
//    public TriState canSustainPlant(BlockState state, BlockGetter level, BlockPos pos, Direction direction, BlockState plant) {
//        return state.getValue(LAYERS) == 8 ? TriState.TRUE : TriState.FALSE;
//    }


//    @Override
//    public void onRemove(BlockState oldState, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
//        // Suppress block break sound if we are replacing with the full block (ourself → our fullBlock)
//        if (newState.is(this.getFullBlock())) {
//            // Do nothing to suppress default behavior
//            return;
//        }
//        super.onRemove(oldState, level, pos, newState, isMoving);
//    }


//
//    public record BlockSound(Block block, net.minecraft.sounds.SoundEvent sound) {
//
//    }
}