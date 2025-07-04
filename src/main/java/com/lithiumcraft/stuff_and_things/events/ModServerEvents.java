package com.lithiumcraft.stuff_and_things.events;

import com.lithiumcraft.stuff_and_things.StuffAndThings;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = StuffAndThings.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {
    //
}
