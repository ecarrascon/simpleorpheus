package com.ecarrascon.simpleorpheus.mixin;


import com.ecarrascon.simpleorpheus.SimpleOrpheus;
import com.ecarrascon.simpleorpheus.registry.RegistriesMod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerEntityDropInventoryMixin {

	@Inject(method = "dropEquipment", at = @At("HEAD"), cancellable = true)
	private void noEnterTheIfToNotDropTheItems(CallbackInfo info) {
		if (!((Player) (Object) this).level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)
				&& ((Player)(Object)this).getInventory().contains(RegistriesMod.ORPHEUS_ITEM.get().getDefaultInstance())
				&& SimpleOrpheus.CONFIG_VALUES.getPower().matches(".*(?:keep|both).*")) {
			info.cancel();
		}
	}

	@Inject(method = "getExperienceReward", at = @At("HEAD"), cancellable = true)
	private void noEnterTheIfToNotDropTheXp(CallbackInfoReturnable<Integer> cir) {
		if (!((Player) (Object) this).level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)
				&& ((Player) (Object) this).getInventory().contains(RegistriesMod.ORPHEUS_ITEM.get().getDefaultInstance())
				&& SimpleOrpheus.CONFIG_VALUES.getPower().matches(".*(?:keep|both).*")) {
			cir.setReturnValue(0);
			cir.cancel();
		}
	}

}
