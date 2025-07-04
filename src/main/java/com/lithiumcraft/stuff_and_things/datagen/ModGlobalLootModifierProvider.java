package com.lithiumcraft.stuff_and_things.datagen;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, StuffAndThings.MOD_ID);
    }

    @Override
    protected void start() {
//        this.add("catalyst_activator_wand_gem_from_abandoned_mineshafts",
//                new AddItemModifier(new LootItemCondition[]{
//                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build(),
//                        LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.ACTIVATOR_WAND_GEM.get()));
//
//        this.add("catalyst_activator_wand_shaft_from_warden",
//                new AddItemModifier(new LootItemCondition[]{
//                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/warden")).build(),
//                        LootItemRandomChanceCondition.randomChance(0.25f).build()}, ModItems.ACTIVATOR_WAND_SHAFT.get()));
    }
}
