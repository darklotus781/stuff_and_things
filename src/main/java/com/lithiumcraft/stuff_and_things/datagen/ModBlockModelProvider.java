package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import com.lithiumcraft.stuff_and_things.util.SpecialBlockTextureRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Collection;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StuffAndThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        generateLayeredBlockModels(LayeredBlocks.getAllBlocks());
        generateSlabBlockModels(SlabBlocks.getSlabBlocks());
    }


    private void generateLayeredBlockModels(Iterable<DeferredBlock<LayersBlock>> blocks) {
        for (DeferredHolder<Block, ?> blockHolder : blocks) {
            String blockName = blockHolder.getId().getPath(); // e.g., grass_block_layers_block
            String baseName = blockName.replace("_layers_block", ""); // e.g., grass_block

            SpecialBlockTextureRegistry.TextureSet textures = SpecialBlockTextureRegistry.getTextureSet(baseName);

            // Determine suffix based on texture set
            String suffix = "";
            if (textures != null) {
                if (textures.useTranslucent()) {
                    suffix = "_translucent";
                } else if (textures.useCutout()) {
                    suffix = "_cutout";
                }
            }

            for (int layer = 1; layer <= 7; layer++) {
                String modelName = blockName + "_" + layer + suffix;
                String parentPath = "stuff_and_things:block/layers_block_" + layer + suffix;

                BlockModelBuilder builder = getBuilder(modelName)
                        .parent(new ModelFile.UncheckedModelFile(parentPath));

                if (textures != null) {
                    builder.texture("top", textures.top())
                            .texture("bottom", textures.bottom())
                            .texture("side", textures.side());

                    if (textures.overlay() != null && !textures.overlay().isBlank()) {
                        builder.texture("overlay", textures.overlay());
                    }

                    if (textures.particle() != null && !textures.particle().isBlank()) {
                        builder.texture("particle", textures.particle());
                    } else {
                        builder.texture("particle", textures.top()); // fallback to top
                    }

                } else {
                    String uniform = "minecraft:block/" + baseName;
                    builder.texture("top", uniform)
                            .texture("bottom", uniform)
                            .texture("side", uniform)
                            .texture("overlay", uniform) // safe fallback
                            .texture("particle", uniform);
                }
            }
            String modelName = baseName + "_layers_block_8" + suffix;

            if (textures != null && textures.useCutout()) {
                // Use the base full block as parent — already textured correctly
                getBuilder(modelName)
                        .parent(new ModelFile.UncheckedModelFile("minecraft:block/" + baseName));
                continue;
            }

            // Non-cutout fallback: cube or cube_all
            if (textures != null && textures.hasIndividualFaces()) {
                BlockModelBuilder builder = getBuilder(modelName)
                        .parent(new ModelFile.UncheckedModelFile("minecraft:block/cube"));

                builder.texture("top", textures.top())
                        .texture("bottom", textures.bottom())
                        .texture("side", textures.side());

                if (textures.overlay() != null && !textures.overlay().isBlank()) {
                    builder.texture("overlay", textures.overlay());
                }
                if (textures.particle() != null && !textures.particle().isBlank()) {
                    builder.texture("particle", textures.particle());
                } else {
                    builder.texture("particle", textures.top()); // fallback to top
                }
            } else {
                cubeAll(modelName,
                        safeResource(textures != null ? textures.top() : "minecraft:block/" + baseName));
            }

            continue;
        }
    }

    private ResourceLocation safeResource(String texturePath) {
        String[] split = texturePath.split(":", 2);
        if (split.length == 2) {
            return ResourceLocation.fromNamespaceAndPath(split[0], split[1]);
        } else {
            // Fallback: assume minecraft namespace
            return ResourceLocation.fromNamespaceAndPath("minecraft", split[0]);
        }
    }


    private void generateSlabBlockModels(Collection<DeferredBlock<SlabBlock>> blocks) {
        for (DeferredBlock<SlabBlock> blockHolder : blocks) {
            String blockName = blockHolder.getId().getPath(); // e.g., grass_block_slab
            String baseName = blockName.replace("_slab", ""); // e.g., grass_block

            SpecialBlockTextureRegistry.TextureSet textures = SpecialBlockTextureRegistry.getTextureSet(baseName);

            // Only use _translucent suffix for slab models
            String suffix = "";
            if (textures != null) {
                if (textures.useTranslucent()) {
                    suffix = "_translucent";
                } else if (textures.useCutout()) {
                    suffix = "_cutout";
                }
            }

            String slabModel = "stuff_and_things:block/slab" + suffix;
            String slabTopModel = "stuff_and_things:block/slab_top" + suffix;
            String slabFullModel = "stuff_and_things:block/slab_full" + suffix;

            BlockModelBuilder slabBuilder = getBuilder(blockName).parent(new ModelFile.UncheckedModelFile(slabModel));
            BlockModelBuilder slabTopBuilder = getBuilder(blockName + "_top").parent(new ModelFile.UncheckedModelFile(slabTopModel));
            BlockModelBuilder slabFullBuilder = getBuilder(blockName + "_full").parent(new ModelFile.UncheckedModelFile(slabFullModel));

            if (textures != null) {
                slabBuilder.texture("bottom", textures.bottom())
                        .texture("top", textures.top())
                        .texture("side", textures.side())
                        .texture("particle", textures.particle());
                if (textures.overlay() != null && !textures.overlay().isBlank()) {
                    slabBuilder.texture("overlay", textures.overlay());
                }
                slabTopBuilder.texture("bottom", textures.bottom())
                        .texture("top", textures.top())
                        .texture("side", textures.side())
                        .texture("particle", textures.particle());
                if (textures.overlay() != null && !textures.overlay().isBlank()) {
                    slabTopBuilder.texture("overlay", textures.overlay());
                }
                slabFullBuilder.texture("bottom", textures.bottom())
                        .texture("top", textures.top())
                        .texture("side", textures.side())
                        .texture("particle", textures.particle());
                if (textures.overlay() != null && !textures.overlay().isBlank()) {
                    slabFullBuilder.texture("overlay", textures.overlay());
                }
            } else {
                String uniform = "minecraft:block/" + baseName;
                slabBuilder.texture("bottom", uniform)
                        .texture("top", uniform)
                        .texture("side", uniform);
                slabTopBuilder.texture("bottom", uniform)
                        .texture("top", uniform)
                        .texture("side", uniform);
                slabFullBuilder.texture("bottom", uniform)
                        .texture("top", uniform)
                        .texture("side", uniform);
            }
        }
    }
}
