package com.lithiumcraft.stuff_and_things.events;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = StuffAndThings.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        if (level.isClientSide()) return;

        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack held = player.getItemInHand(hand);
        Block sourceBlock = state.getBlock();
        Block targetBlock = null;

        // Waxing logic
        if (held.is(Items.HONEYCOMB)) {
            if (sourceBlock == ModBlocks.THATCH_BLOCK.get()) {
                targetBlock = ModBlocks.WAXED_THATCH_BLOCK.get();
            } else if (sourceBlock == ModBlocks.AGED_THATCH_BLOCK.get()) {
                targetBlock = ModBlocks.WAXED_AGED_THATCH_BLOCK.get();
            }

            if (targetBlock != null) {
                BlockState newState = targetBlock.defaultBlockState();
                if (sourceBlock instanceof RotatedPillarBlock) {
                    newState = newState.setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
                }

                level.setBlock(pos, newState, 3);

                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.WAX_ON, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                            5, 0.2, 0.2, 0.2, 0.01);
                }

                level.playSound(null, pos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);

                if (!player.isCreative()) {
                    held.shrink(1);
                }

                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
                return;
            }
        }

        // Scraping logic
        if (held.is(ItemTags.AXES)) {
            if (sourceBlock == ModBlocks.WAXED_THATCH_BLOCK.get()) {
                targetBlock = ModBlocks.THATCH_BLOCK.get();
            } else if (sourceBlock == ModBlocks.WAXED_AGED_THATCH_BLOCK.get()) {
                targetBlock = ModBlocks.AGED_THATCH_BLOCK.get();
            }

            if (targetBlock != null) {
                BlockState newState = targetBlock.defaultBlockState();
                if (sourceBlock instanceof RotatedPillarBlock) {
                    newState = newState.setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
                }

                level.setBlock(pos, newState, 3);

                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.WAX_OFF, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                            5, 0.2, 0.2, 0.2, 0.01);
                }

                level.playSound(null, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);

                if (!player.isCreative()) {
                    EquipmentSlot slot = hand == InteractionHand.MAIN_HAND
                            ? EquipmentSlot.MAINHAND
                            : EquipmentSlot.OFFHAND;

                    held.hurtAndBreak(1, player, slot);
                }

                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }

    }

}
