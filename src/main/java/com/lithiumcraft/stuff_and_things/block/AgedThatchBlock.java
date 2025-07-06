package com.lithiumcraft.stuff_and_things.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Random;

public class AgedThatchBlock extends RotatedPillarBlock {
    public static final IntegerProperty DELAY = IntegerProperty.create("delay", 0, 1000);

    public AgedThatchBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AXIS, Direction.Axis.Y)
                .setValue(DELAY, 0));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(DELAY);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int blockAge = (Integer)state.getValue(DELAY);
        if (blockAge < 500) {
            state.setValue(DELAY, blockAge + 1);
            level.setBlock(pos, (BlockState)state.cycle(DELAY), 2);
        } else {
            String thisBlockName = "aged_thatch_block";
            double baseChance = 1.75;
            double multiplier = 3.5;
            int matchingNeighbors = 0;

            for(int xOffset = -1; xOffset <= 1; ++xOffset) {
                for(int yOffset = -1; yOffset <= 1; ++yOffset) {
                    for(int zOffset = -1; zOffset <= 1; ++zOffset) {
                        if (xOffset != 0 || yOffset != 0 || zOffset != 0) {
                            BlockPos neighborPos = pos.offset(xOffset, yOffset, zOffset);
                            BlockState neighborState = level.getBlockState(neighborPos);
                            String neighborName = neighborState.getBlock().asItem().toString();
                            if (neighborName.equals(thisBlockName)) {
                                ++matchingNeighbors;
                            }
                        }
                    }
                }
            }

            double chance = baseChance / Math.pow(multiplier, (double)matchingNeighbors);
            if (random.nextDouble() <= chance) {
                level.setBlock(pos, (BlockState)((Block)ModBlocks.OLD_THATCH_BLOCK.get()).defaultBlockState().setValue(AXIS, (Direction.Axis)state.getValue(AXIS)), 3);
            }
        }

    }
}
