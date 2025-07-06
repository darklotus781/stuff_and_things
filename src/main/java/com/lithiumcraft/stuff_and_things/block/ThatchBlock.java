package com.lithiumcraft.stuff_and_things.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Random;

public class ThatchBlock extends RotatedPillarBlock {
    public static final IntegerProperty DELAY = IntegerProperty.create("delay", 0, 1000);

    public ThatchBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(DELAY, 0));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int blockAge = (Integer)state.getValue(DELAY);
        if (blockAge < 50) {
            state.setValue(DELAY, blockAge + 1);
            level.setBlock(pos, (BlockState)state.cycle(DELAY), 2);
        } else {
            String thisBlockName = "thatch_block";
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
                Block aged = ModBlocks.AGED_THATCH_BLOCK.get();
                BlockState base = aged.defaultBlockState();

                if (!base.hasProperty(AgedThatchBlock.DELAY)) {
                    throw new IllegalStateException("AGED_THATCH_BLOCK is missing DELAY property!");
                }

                BlockState newState = base
                        .setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS))
                        .setValue(AgedThatchBlock.DELAY, 0);

                level.setBlock(pos, newState, 3);
            }
        }

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(DELAY);
    }

    public static void debugBlockState(BlockState state) {
        System.out.println("BlockState for " + state.getBlock() + " has properties:");
        for (Property<?> prop : state.getProperties()) {
            System.out.println("- " + prop.getName() + " (" + prop.getClass().getSimpleName() + ")");
        }
    }
}
