package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.block.SlabBlocks;
import com.lithiumcraft.stuff_and_things.util.SpecialBlockTextureRegistry;
import com.lithiumcraft.stuff_and_things.util.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

public class ModSlabBlockLootProvider extends BlockLootSubProvider {

    public ModSlabBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        StreamSupport.stream(SlabBlocks.getAllBlocks().spliterator(), false)
                .filter(holder -> !SpecialBlockTextureRegistry.SILK_TOUCH_ONLY_PATHS.contains(holder.getId().getPath()))
                .forEach(holder -> {
                    Block block = holder.get();
                    add(block, createSlabDropTable(block));
                });

        StreamSupport.stream(SlabBlocks.getAllBlocks().spliterator(), false)
                .filter(holder -> SpecialBlockTextureRegistry.SILK_TOUCH_ONLY_PATHS.contains(holder.getId().getPath()))
                .forEach(holder -> {
                    Block block = holder.get();
                    add(block, createSlabDropTableWithSilkTouchOrWrench(block));
                });
    }

    private LootItemCondition.Builder hasWrench() {
        return MatchTool.toolMatches(ItemPredicate.Builder.item()
                .of(ModTags.Items.WRENCHES)
        );
    }

    private LootTable.Builder createSlabDropTable(Block block) {
        LootTable.Builder table = LootTable.lootTable();
        LootPool.Builder pool = LootPool.lootPool()
                .add(LootItem.lootTableItem(block)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                .add(LootItem.lootTableItem(block)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP))))
                .add(LootItem.lootTableItem(block)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM))))
                .setRolls(ConstantValue.exactly(1));

        return table.withPool(pool);
    }

    private LootTable.Builder createSlabDropTableWithSilkTouchOrWrench(Block block) {
        LootTable.Builder table = LootTable.lootTable();
        LootItemCondition.Builder condition = hasSilkTouch().or(hasWrench());

        LootPool.Builder pool = LootPool.lootPool()
                .when(condition)
                .add(LootItem.lootTableItem(block)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                .add(LootItem.lootTableItem(block)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP))))
                .add(LootItem.lootTableItem(block)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM))))
                .setRolls(ConstantValue.exactly(1));

        return table.withPool(pool);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> result = new ArrayList<>();
        for (DeferredHolder<Block, ? extends SlabBlock> holder : SlabBlocks.getAllBlocks()) {
            result.add(holder.get());
        }
        return result;
    }
}
