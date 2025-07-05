package com.lithiumcraft.stuff_and_things.block;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(StuffAndThings.MOD_ID);

    public static final DeferredBlock<Block> BLUE_LIGHT_BLOCK = registerBlock("blue_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> BROWN_LIGHT_BLOCK = registerBlock("brown_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> CYAN_LIGHT_BLOCK = registerBlock("cyan_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> GRAY_LIGHT_BLOCK = registerBlock("gray_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> BLACK_LIGHT_BLOCK = registerBlock("black_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> GREEN_LIGHT_BLOCK = registerBlock("green_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> LIGHT_BLUE_LIGHT_BLOCK = registerBlock("light_blue_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> LIGHT_GRAY_LIGHT_BLOCK = registerBlock("light_gray_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> LIME_LIGHT_BLOCK = registerBlock("lime_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> MAGENTA_LIGHT_BLOCK = registerBlock("magenta_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> ORANGE_LIGHT_BLOCK = registerBlock("orange_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> PINK_LIGHT_BLOCK = registerBlock("pink_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> PURPLE_LIGHT_BLOCK = registerBlock("purple_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> RED_LIGHT_BLOCK = registerBlock("red_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> WHITE_LIGHT_BLOCK = registerBlock("white_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> YELLOW_LIGHT_BLOCK = registerBlock("yellow_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(s -> 15)));

    public static final DeferredBlock<Block> BLUE_GLASS_LIGHT_BLOCK = registerBlock("blue_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> BROWN_GLASS_LIGHT_BLOCK = registerBlock("brown_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> CYAN_GLASS_LIGHT_BLOCK = registerBlock("cyan_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> GRAY_GLASS_LIGHT_BLOCK = registerBlock("gray_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> BLACK_GLASS_LIGHT_BLOCK = registerBlock("black_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> GREEN_GLASS_LIGHT_BLOCK = registerBlock("green_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> LIGHT_BLUE_GLASS_LIGHT_BLOCK = registerBlock("light_blue_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> LIGHT_GRAY_GLASS_LIGHT_BLOCK = registerBlock("light_gray_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> LIME_GLASS_LIGHT_BLOCK = registerBlock("lime_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> MAGENTA_GLASS_LIGHT_BLOCK = registerBlock("magenta_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> ORANGE_GLASS_LIGHT_BLOCK = registerBlock("orange_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> PINK_GLASS_LIGHT_BLOCK = registerBlock("pink_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> PURPLE_GLASS_LIGHT_BLOCK = registerBlock("purple_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> RED_GLASS_LIGHT_BLOCK = registerBlock("red_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> WHITE_GLASS_LIGHT_BLOCK = registerBlock("white_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));
    public static final DeferredBlock<Block> YELLOW_GLASS_LIGHT_BLOCK = registerBlock("yellow_glass_light_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(s -> 15)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
