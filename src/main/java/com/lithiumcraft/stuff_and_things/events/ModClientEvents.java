package com.lithiumcraft.stuff_and_things.events;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import com.lithiumcraft.stuff_and_things.util.SpecialBlockTextureRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = StuffAndThings.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((state, world, pos, tintIndex) -> {
            if (tintIndex != 0) return -1;
            if (world != null && pos != null) {
                return BiomeColors.getAverageGrassColor(world, pos);
            } else {
                return GrassColor.get(0.5D, 1.0D);
            }
        }, LayeredBlocks.GRASS_BLOCK_LAYERS_BLOCK.get(), SlabBlocks.GRASS_BLOCK_SLAB.get());
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, tintIndex) -> {
            if (!(stack.getItem() instanceof BlockItem blockItem)) return -1;
            BlockState state = blockItem.getBlock().defaultBlockState();
            return event.getBlockColors().getColor(state, null, null, tintIndex);
        }, LayeredBlocks.GRASS_BLOCK_LAYERS_BLOCK.get().asItem(), SlabBlocks.GRASS_BLOCK_SLAB.get().asItem());
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Handle Layered Blocks
            LayeredBlocks.getAllBlocks().forEach(holder -> {
                String baseName = holder.getId().getPath().replace("_layers_block", "");
                var tex = SpecialBlockTextureRegistry.getTextureSet(baseName);

                Block block = holder.get();
                if (tex != null) {
                    if (tex.useTranslucent()) {
                        ItemBlockRenderTypes.setRenderLayer(block, RenderType.translucent());
                    } else if (tex.useCutout()) {
                        ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout());
                    }
                }
            });

            // Handle Slab Blocks
            SlabBlocks.getSlabBlocks().forEach(holder -> {
                String baseName = holder.getId().getPath().replace("_slab", "");
                var tex = SpecialBlockTextureRegistry.getTextureSet(baseName);

                Block block = holder.get();
                if (tex != null && tex.useTranslucent()) {
                    ItemBlockRenderTypes.setRenderLayer(block, RenderType.translucent());
                }
            });
        });
    }
}
