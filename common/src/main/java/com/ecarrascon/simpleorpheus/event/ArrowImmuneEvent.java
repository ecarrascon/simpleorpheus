package com.ecarrascon.simpleorpheus.event;


import com.ecarrascon.simpleorpheus.SimpleOrpheus;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;


public class ArrowImmuneEvent implements EntityEvent.LivingHurt {

    @Override
    public EventResult hurt(LivingEntity entity, DamageSource source, float amount) {
        if (SimpleOrpheus.CONFIG_VALUES.getPower().matches(".*(?:protect|both).*")) {
            if (entity instanceof Player) {
                if (source.is(DamageTypes.ARROW)) {
                    return EventResult.interruptFalse();
                }
            }
        }
        return EventResult.pass();
    }
}
