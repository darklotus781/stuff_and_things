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
        add("creativetab.stuff_and_things_layered_blocks", "Stuff and Things Layered Blocks");
        add("creativetab.stuff_and_things_slabs", "Stuff and Things Slab Blocks");

        // Dynamically add layered block names
         LayeredBlocks.getAllBlocks().forEach(holder -> {
             String name = holder.getId().getPath();
             add("block." + StuffAndThings.MOD_ID + "." + name, formatDisplayName(name));
         });

        SlabBlocks.getSlabBlocks().forEach(holder -> {
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
