package com.lithiumcraft.stuff_and_things.block;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StuffAndThings.MOD_ID);

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

    public static final DeferredBlock<Block> HOT_COAL_BLOCK = registerBlock("hot_coal_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> COMPRESSED_COAL_BLOCK = registerBlock("compressed_coal_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> HOT_COMPRESSED_COAL_BLOCK = registerBlock("hot_compressed_coal_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)));
    public static final DeferredBlock<Block> OLD_THATCH_BLOCK = registerBlock("old_thatch_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<WaxedThatchBlock> WAXED_THATCH_BLOCK = registerBlock("waxed_thatch_block",
            () -> new WaxedThatchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<WaxedAgedThatchBlock> WAXED_AGED_THATCH_BLOCK = registerBlock("waxed_aged_thatch_block",
            () -> new WaxedAgedThatchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<ThatchBlock> THATCH_BLOCK = registerBlock("thatch_block",
            () -> new ThatchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).randomTicks()));
    public static final DeferredBlock<AgedThatchBlock> AGED_THATCH_BLOCK = registerBlock("aged_thatch_block",
            () -> new AgedThatchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).randomTicks()));
    public static final DeferredBlock<Block> MULCH_BLOCK = registerBlock("mulch_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> COMPRESSED_MULCH_BLOCK = registerBlock("compressed_mulch_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> AGED_COMPRESSED_MULCH_BLOCK = registerBlock("aged_compressed_mulch_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> HOT_AGED_COMPRESSED_MULCH_BLOCK = registerBlock("hot_aged_compressed_mulch_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<GrateBlock> IRON_GRATE_BLOCK = registerBlock("iron_grate_block",
            () -> new GrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<GrateBlock> INDUSTRIAL_IRON_GRATE_BLOCK = registerBlock("industrial_iron_grate_block",
            () -> new GrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<GrateBlock> ANDESITE_GRATE_BLOCK = registerBlock("andesite_grate_block",
            () -> new GrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> IRON_PLATING_BLOCK = registerBlock("iron_plating_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

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
