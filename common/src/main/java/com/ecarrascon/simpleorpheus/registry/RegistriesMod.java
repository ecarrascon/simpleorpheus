package com.ecarrascon.simpleorpheus.registry;

import com.ecarrascon.simpleorpheus.SimpleOrpheus;
import com.ecarrascon.simpleorpheus.event.ArrowImmuneEvent;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RegistriesMod {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SimpleOrpheus.MOD_ID, Registries.ITEM);
    public static final RegistrySupplier<Item> ORPHEUS_ITEM = ITEMS.register("orpheus", () ->
            new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));
    public static void init() {

        ITEMS.register();
        EntityEvent.LIVING_HURT.register(new ArrowImmuneEvent());
    }
}
