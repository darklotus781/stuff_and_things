package com.lithiumcraft.stuff_and_things.util;

import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;

public class PlantingSupportUtil {
    public static boolean isInvalidPlantSupport(LevelReader level, BlockPos pos) {
        BlockState below = level.getBlockState(pos.below());

        if (below.getBlock() instanceof LayersBlock layers) {
            if (below.getValue(LayersBlock.LAYERS) < 8) {
                return true;
            }
        }

        if (below.hasProperty(SlabBlock.TYPE)) {
            SlabType type = below.getValue(SlabBlock.TYPE);
            if (type != SlabType.TOP && type != SlabType.DOUBLE) {
                return true;
            }
        }

        return false;
    }
}
