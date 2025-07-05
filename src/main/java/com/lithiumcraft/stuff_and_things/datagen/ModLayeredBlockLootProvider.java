package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.LayersBlock;
import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ModLayeredBlockLootProvider extends BlockLootSubProvider {

    public ModLayeredBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
//        LayeredBlocks.getAllBlocks().forEach(block -> {
//            String baseName = block.getId().getPath().replace("_layers_block", "");
//
//            add(block.get(), createLayeredDropTable(block.get()));
//        });

        Set<String> excluded = LayeredBlocks.STAINED_GLASS_LAYERS.keySet();

        StreamSupport.stream(LayeredBlocks.getAllBlocks().spliterator(), false)
                .filter(holder -> !excluded.contains(holder.getId().getPath()))
                .forEach(holder -> {
                    Block block = holder.get();
                    add(block, createLayeredDropTable(block, 8));
                });

        LayeredBlocks.STAINED_GLASS_LAYERS.values().forEach(holder -> {
            Block block = holder.get();
            add(block, createSilkTouchLayeredDrop(block, 8));
        });
    }

    private LootTable.Builder createSilkTouchLayeredDrop(Block block, int maxLayers) {
        LootTable.Builder table = LootTable.lootTable();

        for (int i = 1; i <= maxLayers; i++) {
            LootPool.Builder pool = LootPool.lootPool()
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                    .hasProperty(LayersBlock.LAYERS, i)))
                    .when(this.hasSilkTouch())
                    .add(applyExplosionDecay(block,
                            LootItem.lootTableItem(block)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(i)))))
                    .setRolls(ConstantValue.exactly(1));

            table.withPool(pool);
        }

        return table;
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

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> result = new ArrayList<>();
        for (DeferredHolder<Block, LayersBlock> holder : LayeredBlocks.getAllBlocks()) {
            result.add(holder.get()); // implicitly returns Block
        }
        return result;
    }
}
