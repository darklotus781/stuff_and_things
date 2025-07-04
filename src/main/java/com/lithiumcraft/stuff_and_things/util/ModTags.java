package com.lithiumcraft.stuff_and_things.util;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> LAYER_BLOCKS = createTag("layer_blocks");
        public static final TagKey<Block> SLABS = createTag("slabs");
        public static final TagKey<Block> LIGHT_BLOCKS = createTag("light_blocks");
        public static final TagKey<Block> GRATES = createTag("grates");
        public static final TagKey<Block> TRANSLUCENT = createTag("render/translucent");
        public static final TagKey<Block> EMISSIVE = createTag("render/emissive");
        public static final TagKey<Block> CUTOUT = createTag("render/cutout");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, name));
        }
    }

    public static class Items {
//        public static final TagKey<Item> SKY_STONE_BLOCK = createTag("sky_stone_block");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, name));
        }
    }
}
