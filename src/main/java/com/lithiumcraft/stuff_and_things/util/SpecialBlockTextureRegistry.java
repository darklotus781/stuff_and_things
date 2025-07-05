package com.lithiumcraft.stuff_and_things.util;

import java.util.List;
import java.util.Map;

public class SpecialBlockTextureRegistry {

    public static final List<String> VANILLA_COLORS = List.of(
            "white", "orange", "magenta", "light_blue", "yellow", "lime",
            "pink", "gray", "light_gray", "cyan", "purple", "blue",
            "brown", "green", "red", "black"
    );

    public record TextureSet(String top, String bottom, String side, String overlay, String particle, boolean cutout,
                             boolean translucent) {
        public boolean useCutout() {
            return cutout;
        }

        public boolean useTranslucent() {
            return translucent;
        }
    }

    public static final Map<String, TextureSet> SPECIAL_TEXTURES = Map.ofEntries(
            Map.entry("crimson_nylium", tex("crimson_nylium", "netherrack", "crimson_nylium_side", "crimson_nylium_side", "dirt", false, false)),
            Map.entry("warped_nylium", tex("warped_nylium", "netherrack", "warped_nylium_side", "warped_nylium_side", "dirt", false, false)),
            Map.entry("muddy_mangrove_roots", tex("muddy_mangrove_roots_top", "muddy_mangrove_roots_top", "muddy_mangrove_roots_side", "muddy_mangrove_roots_side", "muddy_mangrove_roots_top", false, false)),
            Map.entry("mycelium", tex("mycelium_top", "dirt", "mycelium_side", "mycelium_side", "dirt", true, false)),
            Map.entry("podzol", tex("podzol_top", "dirt", "podzol_side", "podzol_side", "dirt", true, false)),
            Map.entry("grass_block", tex("grass_block_top", "dirt", "grass_block_side", "grass_block_side_overlay", "dirt", true, false)),
            Map.entry("dirt_path", tex("dirt_path", "dirt", "dirt_path_side", "dirt_path_side", "dirt", false, false)),
            Map.entry("smooth_red_sandstone", tex("red_sandstone_top", "red_sandstone_top", "red_sandstone_top", "red_sandstone_top", "red_sandstone_top", false, false)),
            Map.entry("smooth_sandstone", tex("sandstone_top", "sandstone_top", "sandstone_top", "sandstone_top", "sandstone_top", false, false)),
            Map.entry("white_stained_glass", tex("white_stained_glass", "white_stained_glass", "white_stained_glass", null, "white_stained_glass", false, true)),
            Map.entry("light_gray_stained_glass", tex("light_gray_stained_glass", "light_gray_stained_glass", "light_gray_stained_glass", null, "light_gray_stained_glass", false, true)),
            Map.entry("gray_stained_glass", tex("gray_stained_glass", "gray_stained_glass", "gray_stained_glass", null, "gray_stained_glass", false, true)),
            Map.entry("black_stained_glass", tex("black_stained_glass", "black_stained_glass", "black_stained_glass", null, "black_stained_glass", false, true)),
            Map.entry("brown_stained_glass", tex("brown_stained_glass", "brown_stained_glass", "brown_stained_glass", null, "brown_stained_glass", false, true)),
            Map.entry("red_stained_glass", tex("red_stained_glass", "red_stained_glass", "red_stained_glass", null, "red_stained_glass", false, true)),
            Map.entry("orange_stained_glass", tex("orange_stained_glass", "orange_stained_glass", "orange_stained_glass", null, "orange_stained_glass", false, true)),
            Map.entry("yellow_stained_glass", tex("yellow_stained_glass", "yellow_stained_glass", "yellow_stained_glass", null, "yellow_stained_glass", false, true)),
            Map.entry("lime_stained_glass", tex("lime_stained_glass", "lime_stained_glass", "lime_stained_glass", null, "lime_stained_glass", false, true)),
            Map.entry("green_stained_glass", tex("green_stained_glass", "green_stained_glass", "green_stained_glass", null, "green_stained_glass", false, true)),
            Map.entry("cyan_stained_glass", tex("cyan_stained_glass", "cyan_stained_glass", "cyan_stained_glass", null, "cyan_stained_glass", false, true)),
            Map.entry("light_blue_stained_glass", tex("light_blue_stained_glass", "light_blue_stained_glass", "light_blue_stained_glass", null, "light_blue_stained_glass", false, true)),
            Map.entry("blue_stained_glass", tex("blue_stained_glass", "blue_stained_glass", "blue_stained_glass", null, "blue_stained_glass", false, true)),
            Map.entry("purple_stained_glass", tex("purple_stained_glass", "purple_stained_glass", "purple_stained_glass", null, "purple_stained_glass", false, true)),
            Map.entry("magenta_stained_glass", tex("magenta_stained_glass", "magenta_stained_glass", "magenta_stained_glass", null, "magenta_stained_glass", false, true)),
            Map.entry("pink_stained_glass", tex("pink_stained_glass", "pink_stained_glass", "pink_stained_glass", null, "pink_stained_glass", false, true)),
            Map.entry("glass", tex("glass", "glass", "glass", null, "glass", false, true))
    );

    private static TextureSet tex(String top, String bottom, String side, String overlay, String particle, boolean cutout, boolean translucent) {
        return new TextureSet(
                "minecraft:block/" + top,
                "minecraft:block/" + bottom,
                "minecraft:block/" + side,
                overlay != null ? "minecraft:block/" + overlay : null,
                particle != null ? "minecraft:block/" + particle : null,
                cutout,
                translucent
        );
    }

    public static TextureSet getTextureSet(String baseName) {
        return SPECIAL_TEXTURES.get(baseName);
    }

    public static boolean isCutout(String baseName) {
        TextureSet set = getTextureSet(baseName);
        return set != null && set.cutout(); // this now works
    }

    public static boolean hasCustomTextures(String baseName) {
        return SPECIAL_TEXTURES.containsKey(baseName);
    }
}
