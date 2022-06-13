package net.fabricmc.ctf.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.ctf.CookedTropicalFishMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

@Mixin(net.minecraft.block.piston.PistonHandler.class)
public class JamBlockMixin {
    @Inject(method = "isBlockSticky(Lnet/minecraft/block/BlockState;)Z", at = @At("HEAD"), cancellable = true)
    private static void injected(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.isOf(CookedTropicalFishMod.GLOW_BERRY_BLOCK)) cir.setReturnValue(true);
    }

    @Inject(method = "isAdjacentBlockStuck(Lnet/minecraft/block/BlockState;Lnet/minecraft/block/BlockState;)Z", at = @At("HEAD"), cancellable = true)
    private static void injected(BlockState state, BlockState adjacentState, CallbackInfoReturnable<Boolean> cir) {
        if (state.isOf(CookedTropicalFishMod.GLOW_BERRY_BLOCK)) {
            if (adjacentState.isOf(Blocks.HONEY_BLOCK) || adjacentState.isOf(Blocks.SLIME_BLOCK)) {
                cir.setReturnValue(false);
            }
        }
        if (adjacentState.isOf(CookedTropicalFishMod.GLOW_BERRY_BLOCK)) {
            if (state.isOf(Blocks.HONEY_BLOCK) || state.isOf(Blocks.SLIME_BLOCK)) {
                cir.setReturnValue(false);
            }
        }
    }
}
