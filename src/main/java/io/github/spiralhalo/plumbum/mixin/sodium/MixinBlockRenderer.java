package io.github.spiralhalo.plumbum.mixin.sodium;

import io.github.spiralhalo.plumbum.other.AccessBlockRenderer;
import me.jellysquid.mods.sodium.client.render.occlusion.BlockOcclusionCache;
import me.jellysquid.mods.sodium.client.render.pipeline.BlockRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockRenderer.class)
public class MixinBlockRenderer implements AccessBlockRenderer {
    @Shadow
    @Final
    private BlockOcclusionCache occlusionCache;

    @Override
    public BlockOcclusionCache plumbum_getBlockOcclusionCache() {
        return this.occlusionCache;
    }
}
