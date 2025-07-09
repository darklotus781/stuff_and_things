package com.lithiumcraft.stuff_and_things.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.common.FarmlandWaterManager;

public class FarmLayerBlock extends PathLayerBlock {
    public static final IntegerProperty MOISTURE;
    public static final int MAX_MOISTURE = 7;

    public FarmLayerBlock(Properties properties, Block fullBlock) {
        super(properties, fullBlock);
        this.registerDefaultState(this.defaultBlockState().setValue(LAYERS, 1).setValue(WATERLOGGED, false).setValue(MOISTURE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LAYERS});
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

        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (state.canBeHydrated(level, pos, level.getFluidState(blockpos), blockpos)) {
                return true;
            }
        }
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
                level.setBlock(pos, state.setValue(MOISTURE, moisture - 1), 2);
            }
        } else if (moisture < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        }
    }

    static {
        MOISTURE = BlockStateProperties.MOISTURE;
    }
}
