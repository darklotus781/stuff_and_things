package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import com.lithiumcraft.stuff_and_things.util.ModTags;
import com.lithiumcraft.stuff_and_things.util.SpecialBlockTextureRegistry;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

public class ModLayeredBlockLootProvider extends BlockLootSubProvider {

    public ModLayeredBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        StreamSupport.stream(LayeredBlocks.getAllBlocks().spliterator(), false)
                .filter(holder -> !SpecialBlockTextureRegistry.SILK_TOUCH_ONLY_PATHS.contains(holder.getId().getPath()))
                .forEach(holder -> {
                    Block block = holder.get();
                    add(block, createLayeredDropTable(block, 8));
                });

        StreamSupport.stream(LayeredBlocks.getAllBlocks().spliterator(), false)
                .filter(holder -> SpecialBlockTextureRegistry.SILK_TOUCH_ONLY_PATHS.contains(holder.getId().getPath()))
                .forEach(holder -> {
                    Block block = holder.get();
                    add(block, createLayeredDropTableWithWrenchOrSilk(block, 8));
                });
    }

    private LootItemCondition.Builder hasWrench() {
        return MatchTool.toolMatches(ItemPredicate.Builder.item()
                .of(ModTags.Items.WRENCHES));
    }

    private LootTable.Builder createLayeredDropTable(Block block, int maxLayers) {
        LootTable.Builder table = LootTable.lootTable();

        for (int i = 1; i <= maxLayers; i++) {
            LootPool.Builder pool = LootPool.lootPool()
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                    .hasProperty(LayersBlock.LAYERS, i)))
                    .add(applyExplosionDecay(block,
                            LootItem.lootTableItem(block)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(i)))))
                    .setRolls(ConstantValue.exactly(1));

            table.withPool(pool);
        }

        return table;
    }

    private LootTable.Builder createLayeredDropTableWithWrenchOrSilk(Block block, int maxLayers) {
        LootTable.Builder table = LootTable.lootTable();

        for (int i = 1; i <= maxLayers; i++) {
            LootPool.Builder pool = LootPool.lootPool()
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                    .hasProperty(LayersBlock.LAYERS, i)))
                    .when(this.hasSilkTouch().or(this.hasWrench()))
                    .add(applyExplosionDecay(block,
                            LootItem.lootTableItem(block)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(i)))))
                    .setRolls(ConstantValue.exactly(1));

            table.withPool(pool);
        }

        return table;
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> result = new ArrayList<>();
        for (DeferredHolder<Block, LayersBlock> holder : LayeredBlocks.getAllBlocks()) {
            result.add(holder.get()); // implicitly returns Block
        }
        return result;
    }
}
