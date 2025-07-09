package com.lithiumcraft.stuff_and_things.item;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class ChiselItem extends Item {
    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.stuff_and_things.chisel").withStyle(ChatFormatting.GOLD));
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();

        if (! player.isCrouching()) {
            return InteractionResult.PASS;
        }

        if (!state.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "wrench_pickup")))) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide() && player != null) {
            if (state.onDestroyedByPlayer(level, pos, player, false, level.getFluidState(pos))) {
                state.getBlock().playerDestroy(level, player, pos, state, null, context.getItemInHand());
            }
        }

        return InteractionResult.SUCCESS;
    }

}
