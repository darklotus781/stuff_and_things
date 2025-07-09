package com.lithiumcraft.stuff_and_things.mixin;

import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public class CropBlockMixin {

    @Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
    private void stuffAndThings$allowCustomFarmland(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockPos below = pos.below();
        BlockState soil = level.getBlockState(below);
        Block block = soil.getBlock();
        String className = block.getClass().getName();

        // Support: FarmLayerBlock with 8 layers
        if (className.equals("com.lithiumcraft.stuff_and_things.block.FarmLayerBlock")
                && soil.hasProperty(LayersBlock.LAYERS)
                && soil.getValue(LayersBlock.LAYERS) == 8) {
            cir.setReturnValue(true);
            return;
        }

//        // Support: FarmSlabBlock with top or double slab
//        if (className.equals("com.lithiumcraft.stuff_and_things.block.FarmSlabBlock")
//                && soil.hasProperty(BlockStateProperties.SLAB_TYPE)) {
//            SlabType type = soil.getValue(BlockStateProperties.SLAB_TYPE);
//            if (type == SlabType.TOP || type == SlabType.DOUBLE) {
//                cir.setReturnValue(true);
//            }
//        }
    }
}

