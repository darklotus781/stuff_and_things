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
        LayeredBlocks.getAllBlocks().forEach(block -> {
            String baseName = block.getId().getPath().replace("_layers_block", "");

            add(block.get(), createLayeredDropTable(block.get()));
        });
//        Set<String> excluded = LayeredBlocks.STAINED_GLASS_LAYERS.keySet();
//
//        StreamSupport.stream(LayeredBlocks.getAllBlocks().spliterator(), false)
//                .filter(block -> !excluded.contains(block.getId().getPath()))
//                .forEach(block -> {
//                    add(block.get(), createLayeredDropTable(block.get()));
//                });
//
//        LayeredBlocks.STAINED_GLASS_LAYERS.values().forEach(holder -> {
//            Block block = holder.get();
//            add(block, silkTouchLayeredDrop(block, 8));
//        });
    }

//    private LootTable.Builder silkTouchLayeredDrop(Block block, int layerCount) {
//        LootTable.Builder table = LootTable.lootTable();
//
//        for (int i = 1; i <= layerCount; i++) {
//            LootItemCondition.Builder stateCondition = LootItemBlockStatePropertyCondition
//                    .hasBlockStateProperties(block)
//                    .setProperties(StatePropertiesPredicate.Builder.properties()
//                            .hasProperty(LayersBlock.LAYERS, i));
//
//            LootItemCondition.Builder silkTouchCondition = MatchTool.toolMatches(ItemPredicate.Builder.item().of(
//                    // this accepts any item that can mine the block with silk touch
//                    // no enchantment check required directly
//                    block.asItem()
//            ));
//
//            table.withPool(
//                    LootPool.lootPool()
//                            .setRolls(ConstantValue.exactly(1))
//                            .when(stateCondition)
//                            .add(LootItem.lootTableItem(block)
//                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(i)))
//                                    .when(silkTouchCondition)
//                            )
//            );
//        }
//
//        return table;
//    }


    private LootTable.Builder createLayeredDropTable(Block block) {
        LootPool.Builder pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1));
        for (int layer = 1; layer <= 8; layer++) {
            pool.add(LootItem.lootTableItem(block)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(layer)))
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                    .hasProperty(LayersBlock.LAYERS, layer)))
            );
        }
        return LootTable.lootTable().withPool(pool);
    }

    protected LootTable.Builder createSilkTouchOnly(Block block, Item item) {
        return createSilkTouchDispatchTable(block, LootItem.lootTableItem(item));
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
