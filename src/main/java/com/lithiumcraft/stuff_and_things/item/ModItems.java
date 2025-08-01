package com.lithiumcraft.stuff_and_things.item;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StuffAndThings.MOD_ID);

    public static final DeferredItem<Item> NETHERITE_DUST = ITEMS.register("netherite_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UNPROCESSED_NETHERITE_DUST = ITEMS.register("unprocessed_netherite_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ROUGH_DIAMOND = ITEMS.register("rough_diamond",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<ChiselItem> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
