package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.block.ModBlocks;
import com.lithiumcraft.stuff_and_things.item.ModItems;
import com.lithiumcraft.stuff_and_things.util.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
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

        dropWhenSilkTouchOrWrenched(ModBlocks.WHITE_GLASS_LIGHT_BLOCK.get());
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

        dropSelf(ModBlocks.THATCH_BLOCK.get());
        dropSelf(ModBlocks.AGED_THATCH_BLOCK.get());
        dropSelf(ModBlocks.WAXED_THATCH_BLOCK.get());
        dropSelf(ModBlocks.WAXED_AGED_THATCH_BLOCK.get());
        dropSelf(ModBlocks.OLD_THATCH_BLOCK.get());
        dropSelf(ModBlocks.MULCH_BLOCK.get());
        dropSelf(ModBlocks.COMPRESSED_MULCH_BLOCK.get());
        dropSelf(ModBlocks.AGED_COMPRESSED_MULCH_BLOCK.get());
        dropSelf(ModBlocks.HOT_AGED_COMPRESSED_MULCH_BLOCK.get());
        dropSelf(ModBlocks.HOT_COAL_BLOCK.get());
        dropSelf(ModBlocks.COMPRESSED_COAL_BLOCK.get());
        dropSelf(ModBlocks.HOT_COMPRESSED_COAL_BLOCK.get());

        dropSelf(ModBlocks.ANDESITE_GRATE_BLOCK.get());
        dropSelf(ModBlocks.IRON_GRATE_BLOCK.get());
        dropSelf(ModBlocks.INDUSTRIAL_IRON_GRATE_BLOCK.get());
        dropSelf(ModBlocks.IRON_PLATING_BLOCK.get());
    }

    protected LootItemCondition.Builder hasWrench() {
        return MatchTool.toolMatches(ItemPredicate.Builder.item()
                .of(ModTags.Items.WRENCHES)
        );
    }

    protected LootTable.Builder createSilkTouchOrWrenchDispatchTable(Block block, LootPoolEntryContainer.Builder<?> fallback) {
        return createSelfDropDispatchTable(block, hasSilkTouch().or(hasWrench()), fallback);
    }

    protected void dropWhenSilkTouchOrWrenched(Block block) {
        this.add(block, createSilkTouchOrWrenchDispatchTable(block, LootItem.lootTableItem(Items.AIR).setWeight(0))); // No actual drop
    }


//    protected LootTable.Builder createSilkTouchOnly(Block block, Item item) {
//        return LootTable.lootTable()
//                .withPool(LootPool.lootPool()
//                        .when(this.hasSilkTouch())
//                        .setRolls(ConstantValue.exactly(1.0F))
//                        .add(LootItem.lootTableItem(item))
//                );
//    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
