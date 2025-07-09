package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.*;
import com.lithiumcraft.stuff_and_things.item.ModItems;
import com.lithiumcraft.stuff_and_things.util.SpecialBlockTextureRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StuffAndThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        LayeredBlocks.getAllItems().forEach(this::layeredBlockItem);
        SlabBlocks.getAllItems().forEach(this::slabBlockItem);
        StairBlocks.getAllItems().forEach(this::simpleBlockItem);
        simpleItem(ModItems.CHISEL);
//        registerSlabBlockItems();
//        registerPathLayerBlockItems();
//        registerFarmLayerBlockItems();
    }

//    private void registerPathLayerBlockItems() {
//        for (DeferredBlock<PathLayerBlock> block : LayeredBlocks.getPathBlocks()) {
//            String name = BuiltInRegistries.BLOCK.getKey(block.get()).getPath();
//            withExistingParent(name, modLoc("block/" + name + "_1")); // Use the full layer model
//        }
//    }
//
//    private void registerFarmLayerBlockItems() {
//        for (DeferredBlock<FarmLayerBlock> block : LayeredBlocks.getFarmBlocks()) {
//            String name = BuiltInRegistries.BLOCK.getKey(block.get()).getPath();
//            withExistingParent(name, modLoc("block/" + name + "_1")); // Use the full layer model
//        }
//    }

    private ItemModelBuilder layeredBlockItem(DeferredHolder<Item, ?> item) {
        String name = item.getId().getPath(); // e.g., grass_block_layers_block
        String baseName = name.replace("_layers_block", "");

        SpecialBlockTextureRegistry.TextureSet textures = SpecialBlockTextureRegistry.getTextureSet(baseName);

        String suffix = "";
        if (textures != null) {
            if (textures.useTranslucent()) {
                suffix = "_translucent";
            } else if (textures.useCutout()) {
                suffix = "_cutout";
            }
        }

        String parentModel = "block/" + name + "_1" + suffix;
        return withExistingParent(name, modLoc(parentModel).toString());
    }


    private void slabBlockItem(DeferredHolder<Item, ?> item) {
        String name = item.getId().getPath();

        withExistingParent(name, modLoc("block/" + name));
    }

    private void stairBlockItem(DeferredHolder<Item, ?> item) {
        String name = item.getId().getPath();

        withExistingParent(name, modLoc("block/" + name));
    }

    private ItemModelBuilder simpleItem(DeferredHolder<Item, ?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(DeferredHolder<Item, ?> item) {
        return withExistingParent(item.getId().getPath(),
                modLoc("block/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredHolder<Item, ?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(StuffAndThings.MOD_ID, "item/" + item.getId().getPath()));
    }
}
