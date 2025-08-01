package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.*;
import com.lithiumcraft.stuff_and_things.util.SpecialBlockTextureRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StuffAndThings.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        generateLayeredBlockStates();
        generateSlabBlockStates();
        generateStairBlockStates();
        generatePathLayerBlockStates();
        generateFarmLayerBlockStates();
        generatePathSlabBlockStates();
        generateFarmSlabBlockStates();

        lightBlockWithItem(ModBlocks.BLUE_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.BLACK_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.BROWN_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.CYAN_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.GRAY_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.GREEN_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.LIGHT_BLUE_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.LIGHT_GRAY_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.LIME_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.MAGENTA_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.ORANGE_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.PINK_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.PURPLE_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.RED_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.WHITE_LIGHT_BLOCK);
        lightBlockWithItem(ModBlocks.YELLOW_LIGHT_BLOCK);

        glassLightBlockWithItem(ModBlocks.BLUE_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.BLACK_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.BROWN_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.CYAN_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.GRAY_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.GREEN_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.LIME_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.MAGENTA_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.ORANGE_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.PINK_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.PURPLE_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.RED_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.WHITE_GLASS_LIGHT_BLOCK);
        glassLightBlockWithItem(ModBlocks.YELLOW_GLASS_LIGHT_BLOCK);
    }

    private void generateFarmSlabBlockStates() {
        slabWithCustomModels(SlabBlocks.FARMLAND_SLAB.get(), "farmland_slab", "_moist");
    }

    private void generatePathSlabBlockStates() {
        slabWithCustomModels(SlabBlocks.DIRT_PATH_SLAB.get(), "dirt_path_slab");
    }

    private void generatePathLayerBlockStates() {
        for (DeferredBlock<PathLayerBlock> block : LayeredBlocks.getPathBlocks()) {
            String baseName = BuiltInRegistries.BLOCK.getKey(block.get()).getPath().replace("_layers_block", "");
            MultiPartBlockStateBuilder builder = getMultipartBuilder(block.get());

            for (int i = 1; i <= 8; i++) {
                builder.part()
                        .modelFile(models().getExistingFile(modLoc("block/" + baseName + "_layers_block_" + i)))
                        .addModel()
                        .condition(LayersBlock.LAYERS, i)
                        .end();
            }
        }
    }

    private void generateFarmLayerBlockStates() {
        for (DeferredBlock<FarmLayerBlock> block : LayeredBlocks.getFarmBlocks()) {
            String baseName = BuiltInRegistries.BLOCK.getKey(block.get()).getPath().replace("_layers_block", "");
            MultiPartBlockStateBuilder builder = getMultipartBuilder(block.get());

            for (int i = 1; i <= 8; i++) {
                // Dry (moisture == 0)
                builder.part()
                        .modelFile(models().getExistingFile(modLoc("block/" + baseName + "_layers_block_" + i)))
                        .addModel()
                        .condition(LayersBlock.LAYERS, i)
                        .condition(FarmLayerBlock.MOISTURE, 0)
                        .end();

                // Moist (moisture > 0)
                for (int moisture = 1; moisture <= 7; moisture++) {
                    builder.part()
                            .modelFile(models().getExistingFile(modLoc("block/" + baseName + "_layers_block_" + i + "_moist")))
                            .addModel()
                            .condition(LayersBlock.LAYERS, i)
                            .condition(FarmLayerBlock.MOISTURE, moisture)
                            .end();
                }
            }
        }
    }



    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void lightBlockWithItem(DeferredBlock<?> deferredBlock) {
        String name = BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath();
        String texturePath = "block/light/" + name; // matches your texture folder layout
        simpleBlockWithItem(deferredBlock.get(), models().cubeAll(name, modLoc(texturePath)));
    }

    private void glassLightBlockWithItem(DeferredBlock<?> deferredBlock) {
        String name = BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath();
        String texturePath = "block/glass/" + name; // matches your texture folder layout
        simpleBlockWithItem(deferredBlock.get(), models().cubeAll(name, modLoc(texturePath)).renderType("minecraft:translucent"));
    }

    private void generateLayeredBlockStates() {
        for (DeferredHolder<Block, LayersBlock> block : LayeredBlocks.getLayerBlocks()) {
            createLayeredBlockState(block);
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

    private void generateStairBlockStates() {
        for (DeferredBlock<StairBlock> stair : StairBlocks.getStairBlocks()) {
            String stairName = stair.getId().getPath();
            String baseName = stairName.replace("_stairs", "");

            if (SpecialBlockTextureRegistry.hasCustomTextures(baseName)) {
                createSlabBlockState(baseName, stair.get());
            } else {
                stairsBlock(stair.get(), baseName, mcLoc("block/" + baseName));
            }
        }
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

    private void slabWithCustomModels(Block block, String baseName) {
        slabWithCustomModels(block, baseName, "");
    }

    private void slabWithCustomModels(Block block, String baseName, String moistSuffix) {
        getVariantBuilder(block).forAllStates(state -> {
            SlabType type = state.getValue(SlabBlock.TYPE);
            boolean isMoist = moistSuffix != null && !moistSuffix.isEmpty() && state.hasProperty(BlockStateProperties.MOISTURE) && state.getValue(BlockStateProperties.MOISTURE) > 0;

            String suffix = isMoist ? moistSuffix : "";
            String modelBase = baseName;

            ResourceLocation bottomModel = modLoc("block/" + modelBase + suffix);
            ResourceLocation topModel = modLoc("block/" + modelBase + "_top" + suffix);
            ResourceLocation fullModel = modLoc("block/" + modelBase + "_full" + suffix);

            return ConfiguredModel.builder()
                    .modelFile(switch (type) {
                        case BOTTOM -> models().getExistingFile(bottomModel);
                        case TOP -> models().getExistingFile(topModel);
                        case DOUBLE -> models().getExistingFile(fullModel);
                    })
                    .build();
        });
    }
}
