package com.lithiumcraft.stuff_and_things;

import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import com.lithiumcraft.stuff_and_things.item.ModCreativeModeTabs;
import com.lithiumcraft.stuff_and_things.item.ModItems;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

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
