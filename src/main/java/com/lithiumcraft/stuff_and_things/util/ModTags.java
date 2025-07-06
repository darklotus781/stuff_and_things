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
        public static final TagKey<Block> WRENCHABLE = createTag("create", "wrench_pickup");
        public static final TagKey<Block> FRAMEABLE = createTag("framedblocks", "frameable");
        public static final TagKey<Block> MULCH = createTag("mulch");
        public static final TagKey<Block> COAL = createTag("coal");
        public static final TagKey<Block> THATCH = createTag("thatch");
        public static final TagKey<Block> PLATING = createTag("plating");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, name));
        }

        private static TagKey<Block> createTag(String namespace, String key) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, key));
        }
    }

    public static class Items {
        public static final TagKey<Item> WRENCHES = createTag("wrenches");
        public static final TagKey<Item> ANDESITE_ALLOY_INGOTS = createTag("c", "ingots/andesite_alloy");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, name));
        }

        private static TagKey<Item> createTag(String namespace, String key) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, key));
        }
    }
}
