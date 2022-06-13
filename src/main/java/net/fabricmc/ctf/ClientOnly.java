package net.fabricmc.ctf;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(value = EnvType.CLIENT)
public class ClientOnly implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(CookedTropicalFishMod.GLOW_BERRY_BLOCK, RenderLayer.getTranslucent());
    }
    
}
