package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import com.lithiumcraft.stuff_and_things.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Holder;
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
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropWhenSilkTouch(ModBlocks.WHITE_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.LIGHT_GRAY_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.GRAY_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.BLACK_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.BROWN_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.RED_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.ORANGE_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.YELLOW_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.LIME_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.GREEN_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.CYAN_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.LIGHT_BLUE_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.BLUE_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.PURPLE_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.MAGENTA_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.PINK_LIGHT_BLOCK.get());

        dropWhenSilkTouch(ModBlocks.WHITE_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.GRAY_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.BLACK_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.BROWN_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.RED_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.ORANGE_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.YELLOW_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.LIME_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.GREEN_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.CYAN_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.BLUE_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.PURPLE_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get());
        dropWhenSilkTouch(ModBlocks.PINK_GLASS_LIGHT_BLOCK.get());
    }

    protected LootTable.Builder createSilkTouchOnly(Block block, Item item) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .when(this.hasSilkTouch())
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(item))
                );
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
