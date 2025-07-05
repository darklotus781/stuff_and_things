package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.block.LayeredBlocks;
import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ModSlabBlockLootProvider extends BlockLootSubProvider {

    public ModSlabBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        SlabBlocks.getSlabBlocks().forEach(deferred -> {
            Block block = deferred.get();
            add(block, createSlabItemTable(block));
        });

//        SlabBlocks.STAINED_GLASS_SLABS.values().forEach(holder -> {
//            Block block = holder.get();
//            this.add(block, createSilkTouchOnly(block, block.asItem()));
//        });
    }

    protected LootTable.Builder createSlabItemTable(Block slab) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(
                                LootItem.lootTableItem(slab)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(slab)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))
                        )
                        .add(
                                LootItem.lootTableItem(slab)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(slab)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP)))
                        )
                        .add(
                                LootItem.lootTableItem(slab)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(slab)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM)))
                        )
                );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SlabBlocks.getSlabBlocks().stream()
                .map(DeferredHolder::get)
                .collect(Collectors.toSet());
    }
}
