package com.lithiumcraft.stuff_and_things;

import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import com.lithiumcraft.stuff_and_things.item.LayeredBlockItem;
import com.lithiumcraft.stuff_and_things.item.ModCreativeModeTabs;
import com.lithiumcraft.stuff_and_things.item.ModItems;
import com.lithiumcraft.stuff_and_things.util.ModTags;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import org.slf4j.Logger;

@Mod(StuffAndThings.MOD_ID)
public class StuffAndThings {
    public static final String MOD_ID = "stuff_and_things";
    public static final Logger LOGGER = LogUtils.getLogger();

    public StuffAndThings(IEventBus modEventBus, ModContainer modContainer) {
//        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        LayeredBlocks.register(modEventBus);
        SlabBlocks.register(modEventBus);

        ModItems.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);
    }

//    private void commonSetup(final FMLCommonSetupEvent event) {
//        // Some common setup code
//    }
//
//    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        //
//    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event) {
//        // Do something when the server starts
//    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
//    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//    public class ClientModEvents {
//        //
//    }

}
