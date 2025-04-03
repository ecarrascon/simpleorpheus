package com.ecarrascon.simpleorpheus.mixin;


import com.ecarrascon.simpleorpheus.SimpleOrpheus;
import com.ecarrascon.simpleorpheus.registry.RegistriesMod;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerCopyFromMixin {

    // KeepInventory when Orpheus Lyre in inventory, "PlayerEntityDropInventoryMixin" makes that items not being dropped
	@Redirect(method = "restoreFrom", at = @At(value = "INVOKE", target = "net/minecraft/world/level/GameRules.getBoolean(Lnet/minecraft/world/level/GameRules$Key;)Z", ordinal = 0))
	private boolean redirectCopyFromCondition(GameRules instance, GameRules.Key<GameRules.BooleanValue> rule, ServerPlayer oldPlayer, boolean alive) {
        return ((ServerPlayer) (Object) this).serverLevel().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)
                || (oldPlayer.getInventory().contains(RegistriesMod.ORPHEUS_ITEM.get().getDefaultInstance())
                && SimpleOrpheus.CONFIG_VALUES.getPower().matches(".*(?:keep|both).*"));

    }

}
