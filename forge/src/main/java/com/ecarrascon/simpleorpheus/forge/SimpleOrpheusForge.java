package com.ecarrascon.simpleorpheus.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.ecarrascon.simpleorpheus.SimpleOrpheus;

@Mod(SimpleOrpheus.MOD_ID)
public final class SimpleOrpheusForge {
    public SimpleOrpheusForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(SimpleOrpheus.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        SimpleOrpheus.init();
    }
}
