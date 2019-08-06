package tk.valoeghese.toomuchocean.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.biome.layer.ContinentLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import tk.valoeghese.toomuchocean.TMOUtils;
import tk.valoeghese.toomuchocean.TooMuchOcean;

@Mixin(value = ContinentLayer.class, priority = 500)
public class MixinContinentLayer {
	
	@Inject(at = @At("HEAD"), method = "sample", cancellable = true)
	private void sample(LayerRandomnessSource rand, int x, int z, CallbackInfoReturnable<Integer> info) {
		if (TooMuchOcean.config.alwaysContinentAtOrigin && x == 0 && z == 0) {
			info.setReturnValue(1);
		} else {
			info.setReturnValue(TMOUtils.chance(rand, TooMuchOcean.config.continentChance) ? 1 : 0);
		}
	}
	
}

