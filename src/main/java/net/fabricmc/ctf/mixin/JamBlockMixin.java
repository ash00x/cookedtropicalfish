package net.fabricmc.ctf.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.ctf.CookedTropicalFishMod;
import net.minecraft.block.BlockState;

@Mixin(net.minecraft.block.piston.PistonHandler.class)
public class JamBlockMixin {
    @Inject(method = "isBlockSticky(Lnet/minecraft/block/BlockState;)Z", at = @At("RETURN"), cancellable = true)
    private static void injected(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(cir.getReturnValue() || state.isOf(CookedTropicalFishMod.GLOW_BERRY_BLOCK));
    }
}
