package zbd.firstfabricmod.mixin;

import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zbd.firstfabricmod.item.ModItems;

@Mixin(ItemModelGenerator.class)
public abstract class ItemModelRenderMixin {
	@Shadow public abstract void registerWithInHandModel(Item item);

	@Inject(method = "register()V", at = @At("HEAD"))
	public void register(CallbackInfo ci) {
//		this.registerWithInHandModel(ModItems.PLATE);
	}
}