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
}