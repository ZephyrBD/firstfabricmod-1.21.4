package zbd.firstfabricmod.mixin;

import net.minecraft.client.render.RenderLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RenderLayers.class)
public abstract class RenderLayersMixin {
	@Inject(method = "<clinit>", at = @At("RETURN"))
	private static void onBlockInit(CallbackInfo ci) {
	}
}