package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {

    public ModLangProvider(PackOutput output) {
        super(output, StuffAndThings.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
//        add("block.stuff_and_things.grass_block_layers_block", "Layered Grass Block");
        add("creativetab.stuff_and_things.layered_blocks", "Stuff and Things Layered Blocks");
        add("creativetab.stuff_and_things.slabs", "Stuff and Things Slab Blocks");
        add("creativetab.stuff_and_things.lights", "Stuff and Things Light Blocks");
        add("creativetab.stuff_and_things.items", "Stuff and Things Light Items");

        add("block.stuff_and_things.white_light_block", "White Light Block");
        add("block.stuff_and_things.orange_light_block", "Orange Light Block");
        add("block.stuff_and_things.magenta_light_block", "Magenta Light Block");
        add("block.stuff_and_things.light_blue_light_block", "Light Blue Light Block");
        add("block.stuff_and_things.yellow_light_block", "Yellow Light Block");
        add("block.stuff_and_things.lime_light_block", "Lime Light Block");
        add("block.stuff_and_things.pink_light_block", "Pink Light Block");
        add("block.stuff_and_things.gray_light_block", "Gray Light Block");
        add("block.stuff_and_things.light_gray_light_block", "Light Gray Light Block");
        add("block.stuff_and_things.cyan_light_block", "Cyan Light Block");
        add("block.stuff_and_things.purple_light_block", "Purple Light Block");
        add("block.stuff_and_things.blue_light_block", "Blue Light Block");
        add("block.stuff_and_things.brown_light_block", "Brown Light Block");
        add("block.stuff_and_things.green_light_block", "Green Light Block");
        add("block.stuff_and_things.red_light_block", "Red Light Block");
        add("block.stuff_and_things.black_light_block", "Black Light Block");

        add("block.stuff_and_things.white_glass_light_block", "White Glass Light Block");
        add("block.stuff_and_things.orange_glass_light_block", "Orange Glass Light Block");
        add("block.stuff_and_things.magenta_glass_light_block", "Magenta Glass Light Block");
        add("block.stuff_and_things.light_blue_glass_light_block", "Light Blue Glass Light Block");
        add("block.stuff_and_things.yellow_glass_light_block", "Yellow Glass Light Block");
        add("block.stuff_and_things.lime_glass_light_block", "Lime Glass Light Block");
        add("block.stuff_and_things.pink_glass_light_block", "Pink Glass Light Block");
        add("block.stuff_and_things.gray_glass_light_block", "Gray Glass Light Block");
        add("block.stuff_and_things.light_gray_glass_light_block", "Light Gray Glass Light Block");
        add("block.stuff_and_things.cyan_glass_light_block", "Cyan Glass Light Block");
        add("block.stuff_and_things.purple_glass_light_block", "Purple Glass Light Block");
        add("block.stuff_and_things.blue_glass_light_block", "Blue Glass Light Block");
        add("block.stuff_and_things.brown_glass_light_block", "Brown Glass Light Block");
        add("block.stuff_and_things.green_glass_light_block", "Green Glass Light Block");
        add("block.stuff_and_things.red_glass_light_block", "Red Glass Light Block");
        add("block.stuff_and_things.black_glass_light_block", "Black Glass Light Block");

        add("block.stuff_and_things.mulch_block", "Mulch");
        add("block.stuff_and_things.compressed_mulch_block", "Compressed Mulch");
        add("block.stuff_and_things.aged_compressed_mulch_block", "Aged Compressed Mulch");
        add("block.stuff_and_things.hot_aged_compressed_mulch_block", "Hot Aged Compressed Mulch");
        add("block.stuff_and_things.hot_coal_block", "Hot Coal Block");
        add("block.stuff_and_things.compressed_coal_block", "Compressed Coal Block");
        add("block.stuff_and_things.hot_compressed_coal_block", "Hot Compressed Coal Block");
        add("block.stuff_and_things.thatch_block", "Thatch Block");
        add("block.stuff_and_things.waxed_thatch_block", "Waxed Thatch Block");
        add("block.stuff_and_things.aged_thatch_block", "Aged Thatch Block");
        add("block.stuff_and_things.waxed_aged_thatch_block", "Waxed Aged Thatch Block");
        add("block.stuff_and_things.old_thatch_block", "Old Thatch Block");

        add("block.stuff_and_things.industrial_iron_grate_block", "Industrial Iron Grate Block");
        add("block.stuff_and_things.andesite_grate_block", "Andesite Grate Block");
        add("block.stuff_and_things.iron_grate_block", "Iron Grate Block");
        add("block.stuff_and_things.iron_plating_block", "Block of Iron Plating");

        add("item.stuff_and_things.chisel", "Chisel");
        add("item.stuff_and_things.netherite_dust", "Netherite Dust");
        add("item.stuff_and_things.unprocessed_netherite_dust", "Unprocessed Netherite Dust");
        add("item.stuff_and_things.rough_diamond", "Rough Diamond");

        add("tooltip.stuff_and_things.chisel", "A tool for removing Layers and Slabs");

        // Dynamically add layered block names
        LayeredBlocks.getAllBlocks().forEach(holder -> {
            String name = holder.getId().getPath();
            add("block." + StuffAndThings.MOD_ID + "." + name, formatDisplayName(name));
        });
        SlabBlocks.getAllBlocks().forEach(holder -> {
            String name = holder.getId().getPath();
            add("block." + StuffAndThings.MOD_ID + "." + name, formatDisplayName(name));
        });
    }

    // Optional helper
    private static String formatDisplayName(String name) {
        String[] words = name.split("_");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return result.toString().trim();
    }
}
