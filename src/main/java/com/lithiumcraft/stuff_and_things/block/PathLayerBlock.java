package com.lithiumcraft.stuff_and_things.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PathLayerBlock extends LayersBlock {
    public static final int BASE_HEIGHT = 15; // pixels

    public PathLayerBlock(BlockBehaviour.Properties properties, Block fullBlock) {
        super(properties, fullBlock);
        this.registerDefaultState(this.defaultBlockState().setValue(LAYERS, 1).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        int layers = state.getValue(LAYERS);
        double height = Math.min(15.0, layers * 1.875);
        return Block.box(0.0, 0.0, 0.0, 16.0, height, 16.0);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction dir, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (dir == Direction.UP && neighborState.isSolid()) {
            return Blocks.DIRT.defaultBlockState(); // or farmland if at layer 8
        }
        return state;
    }
}