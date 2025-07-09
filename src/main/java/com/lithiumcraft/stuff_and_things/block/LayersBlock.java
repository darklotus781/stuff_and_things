package com.lithiumcraft.stuff_and_things.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.FarmlandWaterManager;

import javax.annotation.Nullable;

public class LayersBlock extends Block implements SimpleWaterloggedBlock {
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 1, 8);
    public static final BooleanProperty WATERLOGGED;
    protected final Block fullBlock;

    public LayersBlock(Properties properties, Block fullBlock) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LAYERS, 1).setValue(WATERLOGGED, false));
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
        if (state.getValue(LAYERS) == 8) {
            return getFullBlock().defaultBlockState().getBlockSupportShape(level, pos);
        } else {
            return Shapes.empty();
        }
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
        builder.add(new Property[]{LAYERS, WATERLOGGED});
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
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        BlockState currentState = level.getBlockState(pos);
        FluidState fluid = level.getFluidState(pos);

        if (currentState.is(this)) {
            int layers = currentState.getValue(LAYERS);
            return currentState.setValue(LAYERS, Math.min(7, layers + 1));
        }

        boolean waterlogged = fluid.getType() == Fluids.WATER;

        BlockState baseState = this.defaultBlockState()
                .setValue(LAYERS, 1)
                .setValue(WATERLOGGED, waterlogged);

        return baseState;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (state.getValue(LAYERS) == 8) return false;

        ItemStack held = context.getItemInHand();
        Block heldBlock = Block.byItem(held.getItem());
        return heldBlock == this && context.getClickedFace() == Direction.UP;
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
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

//    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
//        if ((Boolean)state.getValue(WATERLOGGED)) {
//            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
//        }
//
//        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
//    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!state.getValue(WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
            level.setBlock(pos, state.setValue(WATERLOGGED, true), 3);
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            return true;
        }
        return false;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        if (state.getValue(LAYERS) > 7) {
            return false;
        }

        return true;
    }

    @Override
    public void onRemove(BlockState oldState, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!oldState.is(newState.getBlock())) {
            super.onRemove(oldState, level, pos, newState, isMoving);
        }
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }
}