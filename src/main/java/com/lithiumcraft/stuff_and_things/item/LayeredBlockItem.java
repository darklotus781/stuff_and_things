package com.lithiumcraft.stuff_and_things.item;

import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
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
                BlockState newState = layersBlock.getFullBlock().defaultBlockState();
                level.setBlock(pos, newState, Block.UPDATE_ALL);
                playPlaceSound(level, pos, newState, player);
                // Show default block particle on the client as visual feedback
                if (level.isClientSide) {
                    BlockParticleOption particle = new BlockParticleOption(ParticleTypes.BLOCK, newState);
                    RandomSource random = level.getRandom();

                    for (int x = 0; x < 4; ++x) {
                        for (int y = 0; y < 4; ++y) {
                            for (int z = 0; z < 4; ++z) {
                                double px = pos.getX() + (x + 0.5) / 4.0;
                                double py = pos.getY() + (y + 0.5) / 4.0;
                                double pz = pos.getZ() + (z + 0.5) / 4.0;

                                double dx = px - pos.getX() - 0.5;
                                double dy = py - pos.getY() - 0.5;
                                double dz = pz - pos.getZ() - 0.5;

                                level.addParticle(particle, px, py, pz, dx, dy, dz);
                            }
                        }
                    }
                }
                if (!player.getAbilities().instabuild) stack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
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
