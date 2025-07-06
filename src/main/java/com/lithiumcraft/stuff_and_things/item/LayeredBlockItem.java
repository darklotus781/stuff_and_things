package com.lithiumcraft.stuff_and_things.item;

import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class LayeredBlockItem extends BlockItem {
    public LayeredBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        Direction face = context.getClickedFace();
        BlockState clickedState = level.getBlockState(pos);

        if (clickedState.getBlock() instanceof LayersBlock layersBlock) {
            if (clickedState.getBlock() != this.getBlock())
                return InteractionResult.FAIL;

            int layers = clickedState.getValue(LayersBlock.LAYERS);

            if (layers < 7) {
                BlockState newState = clickedState.setValue(LayersBlock.LAYERS, layers + 1);
                level.setBlock(pos, newState, Block.UPDATE_ALL);
                playPlaceSound(level, pos, newState, player);
                if (!player.getAbilities().instabuild) stack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if (layers == 7) {
                // max → create new block with layers=8
                BlockState newState = clickedState.setValue(LayersBlock.LAYERS, 8);
                level.setBlock(pos, newState, Block.UPDATE_ALL);
                playPlaceSound(level, pos, newState, player);
                if (!player.getAbilities().instabuild) stack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if (layers == 8 && face == Direction.UP) {
                // Let vanilla handle placing a new block on top
                return super.useOn(context);
            } else {
                return InteractionResult.FAIL;
            }
        }


        return super.useOn(context);
    }

    private void playPlaceSound(Level level, BlockPos pos, BlockState state, Player player) {
        SoundType sound = state.getSoundType();
        level.playSound(
                player,
                pos,
                sound.getPlaceSound(),
                SoundSource.BLOCKS,
                (sound.getVolume() + 1.0F) / 2.0F,
                sound.getPitch() * 0.8F
        );
    }

}
