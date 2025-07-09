package com.lithiumcraft.stuff_and_things.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PathSlabBlock extends SlabBlocks {

    public PathSlabBlock(Properties properties, Block fullBlock) {
        super(properties, fullBlock);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        SlabType type = state.getValue(TYPE);
        return switch (type) {
            case DOUBLE -> Block.box(0, 0, 0, 16, 15, 16);
            case TOP -> Block.box(0, 8, 0, 16, 15, 16); // normal top slab shape
            case BOTTOM -> Block.box(0, 0, 0, 16, 7.5, 16); // not full height, blocks `isFaceSturdy`
        };
    }
}