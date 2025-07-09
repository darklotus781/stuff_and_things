package com.lithiumcraft.stuff_and_things.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.neoforged.neoforge.common.FarmlandWaterManager;

public class FarmSlabBlock extends PathSlabBlock {
    public static final IntegerProperty MOISTURE;

    public FarmSlabBlock(Properties properties, Block fullBlock) {
        super(properties, fullBlock);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)).setValue(WATERLOGGED, false).setValue(MOISTURE, 0));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TYPE});
        builder.add(new Property[]{MOISTURE});
        builder.add(new Property[]{WATERLOGGED});
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState defaultState = super.getStateForPlacement(context);

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        boolean isWet = isNearWater(level, pos) || level.isRainingAt(pos.above());
        int moisture = isWet ? 7 : 0;

        return defaultState.setValue(BlockStateProperties.MOISTURE, moisture);
    }

    private static boolean isNearWater(LevelReader level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);

        // Explicitly check for waterlogged
        if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED)) {
            return true;
        }

        // Check surroundings for hydration
        for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (state.canBeHydrated(level, pos, level.getFluidState(blockpos), blockpos)) {
                return true;
            }
        }

        // Fallback to water ticket (used by flowing water)
        if (!level.isClientSide()) {
            return FarmlandWaterManager.hasBlockWaterTicket(level, pos);
        }

        return false;
    }


    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int moisture = state.getValue(MOISTURE);

        if (!isNearWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (moisture > 0) {
                System.out.print("Decreasing Moisture Level from " + moisture + " to " + (moisture - 1) + "at" + pos);
                level.setBlock(pos, state.setValue(MOISTURE, moisture - 1), 2);
            }
        } else if (moisture < 7) {
            System.out.print("Increasing Moisture Level from " + moisture + " to 7 at" + pos);
            level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        }
    }

    static {
        MOISTURE = BlockStateProperties.MOISTURE;
    }
}
