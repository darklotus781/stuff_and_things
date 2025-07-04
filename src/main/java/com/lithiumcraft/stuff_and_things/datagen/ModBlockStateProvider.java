package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import com.lithiumcraft.stuff_and_things.util.SpecialBlockTextureRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Map;
import java.util.Set;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StuffAndThings.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        generateLayeredBlockStates();
//        generateLayeredBlockStates(LayeredBlocks.STAINED_GLASS_LAYERS);
        generateSlabBlockStates();
    }

    private void generateLayeredBlockStates() {
        for (DeferredHolder<Block, LayersBlock> block : LayeredBlocks.getAllBlocks()) {
            createLayeredBlockState(block);
        }
    }

    private void generateLayeredBlockStates(Map<String, DeferredBlock<LayersBlock>> blocks) {
        for (Map.Entry<String, DeferredBlock<LayersBlock>> entry : blocks.entrySet()) {
            createLayeredBlockState(entry.getValue());
        }
    }

    private void createLayeredBlockState(DeferredHolder<Block, LayersBlock> blockHolder) {
        Block block = blockHolder.get();
        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
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

        VariantBlockStateBuilder builder = getVariantBuilder(block);

        for (int layer = 1; layer <= 7; layer++) {
            String modelName = name + "_" + layer + suffix;
            builder.partialState().with(LayersBlock.LAYERS, layer)
                    .modelForState()
                    .modelFile(models().getExistingFile(modLoc("block/" + modelName)))
                    .addModel();
        }

        // Layer 8 uses the full block model from Minecraft
        String fullBlockModelName = name + "_8" + suffix;
        builder.partialState().with(LayersBlock.LAYERS, 8)
                .modelForState()
                .modelFile(models().getExistingFile(modLoc("block/" + fullBlockModelName)))
                .addModel();
    }


    private void generateSlabBlockStates() {
        for (DeferredBlock<SlabBlock> slab : SlabBlocks.getSlabBlocks()) {
            String slabName = slab.getId().getPath();
            String baseName = slabName.replace("_slab", "");

            if (SpecialBlockTextureRegistry.hasCustomTextures(baseName)) {
                createSlabBlockState(baseName, slab.get());
            } else {
                slabBlock(slab.get(), mcLoc("block/" + baseName), mcLoc("block/" + baseName));
            }
        }
    }

    private void createSlabBlockState(String baseName, Block slabBlock) {
        String slabName = baseName + "_slab";
        SpecialBlockTextureRegistry.TextureSet textures = SpecialBlockTextureRegistry.getTextureSet(baseName);

        String suffix = textures.cutout() ? "_cutout" : "";
        String pathPrefix = "block/slab";

        BlockModelBuilder bottom = models().getBuilder(slabName)
                .parent(new ModelFile.UncheckedModelFile(modLoc(pathPrefix + suffix)))
                .texture("bottom", textures.bottom().toString())
                .texture("top", textures.top().toString())
                .texture("side", textures.side().toString());

        BlockModelBuilder top = models().getBuilder(slabName + "_top")
                .parent(new ModelFile.UncheckedModelFile(modLoc(pathPrefix + "_top" + suffix)))
                .texture("bottom", textures.bottom().toString())
                .texture("top", textures.top().toString())
                .texture("side", textures.side().toString());

        BlockModelBuilder full = models().getBuilder(slabName + "_full")
                .parent(new ModelFile.UncheckedModelFile(modLoc(pathPrefix + "_full" + suffix)))
                .texture("bottom", textures.bottom().toString())
                .texture("top", textures.top().toString())
                .texture("side", textures.side().toString());

        if (textures.overlay() != null) {
            bottom.texture("overlay", textures.overlay().toString());
            top.texture("overlay", textures.overlay().toString());
            full.texture("overlay", textures.overlay().toString());
        }

        if (textures.particle() != null) {
            bottom.texture("particle", textures.particle().toString());
            top.texture("particle", textures.particle().toString());
            full.texture("particle", textures.particle().toString());
        }

        getVariantBuilder(slabBlock)
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).modelForState().modelFile(bottom).addModel()
                .partialState().with(SlabBlock.TYPE, SlabType.TOP).modelForState().modelFile(top).addModel()
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).modelForState().modelFile(full).addModel();
    }
}
