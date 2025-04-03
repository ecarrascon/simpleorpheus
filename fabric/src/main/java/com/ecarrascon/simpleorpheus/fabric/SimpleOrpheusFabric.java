package com.ecarrascon.simpleorpheus.fabric;

import net.fabricmc.api.ModInitializer;

import com.ecarrascon.simpleorpheus.SimpleOrpheus;

public final class SimpleOrpheusFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        SimpleOrpheus.init();
    }
}
