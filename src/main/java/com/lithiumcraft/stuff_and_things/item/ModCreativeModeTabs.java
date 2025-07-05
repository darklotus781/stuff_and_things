package com.lithiumcraft.stuff_and_things.item;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StuffAndThings.MOD_ID);

//    public static final Supplier<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TABS.register("stuff_and_things_blocks",
//            () -> CreativeModeTab.builder()
//                    .icon(() -> new ItemStack(ModBlocks.MUD_BLOCK.get())) // Update to any main block
//                    .title(Component.translatable("creativetab.stuff_and_things_blocks"))
//                    .displayItems((parameters, output) -> {
//                        // Add full blocks here
//                        output.accept(ModBlocks.MUD_BLOCK.get());
//                        // TODO: Add more when applicable
//                    }).build());

    public static final Supplier<CreativeModeTab> LAYERED_BLOCKS_TAB = CREATIVE_MODE_TABS.register("stuff_and_things_layered_blocks",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(LayeredBlocks.GRASS_BLOCK_LAYERS_BLOCK.get()))
                    .title(Component.translatable("creativetab.stuff_and_things.layered_blocks"))
                    .displayItems((parameters, output) -> {
                        LayeredBlocks.getAllBlocks().forEach(layered -> output.accept(layered.get()));
                    }).build());

    public static final Supplier<CreativeModeTab> SLABS_TAB = CREATIVE_MODE_TABS.register("stuff_and_things_slabs",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(SlabBlocks.GRASS_BLOCK_SLAB.get())) // Replace with real slab block later
                    .title(Component.translatable("creativetab.stuff_and_things.slabs"))
                    .displayItems((parameters, output) -> {
                        SlabBlocks.getSlabBlocks().forEach(slab -> output.accept(slab.get()));
                    }).build());

    public static final Supplier<CreativeModeTab> MISC_TAB = CREATIVE_MODE_TABS.register("stuff_and_things_lights",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.BLUE_LIGHT_BLOCK.get())) // Replace with a real item
                    .title(Component.translatable("creativetab.stuff_and_things.lights"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.WHITE_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.ORANGE_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.MAGENTA_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.LIGHT_BLUE_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.YELLOW_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.LIME_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.PINK_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.GRAY_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.LIGHT_GRAY_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.CYAN_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.PURPLE_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.BLUE_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.BROWN_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.GREEN_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.RED_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.BLACK_LIGHT_BLOCK.get());

                        output.accept(ModBlocks.WHITE_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.ORANGE_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.YELLOW_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.LIME_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.PINK_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.GRAY_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.CYAN_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.PURPLE_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.BLUE_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.BROWN_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.GREEN_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.RED_GLASS_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.BLACK_GLASS_LIGHT_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
