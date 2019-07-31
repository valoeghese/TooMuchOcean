package tk.valoeghese.toomuchocean.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.biome.layer.AddIslandLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import tk.valoeghese.toomuchocean.TMOUtils;
import tk.valoeghese.toomuchocean.TooMuchOcean;

@Mixin(value = AddIslandLayer.class, priority = 500)
public class MixinAddIslandLayer {
	
	@Inject(at = @At("HEAD"), method = "sample", cancellable = true)
	private void sample(LayerRandomnessSource rand, int int_1, int int_2, int int_3, int int_4, int centreBiome, CallbackInfoReturnable<Integer> info) {
		info.setReturnValue(TMOUtils.isShallowOcean(centreBiome) && TMOUtils.isShallowOcean(int_1) && TMOUtils.isShallowOcean(int_2) && TMOUtils.isShallowOcean(int_4) && TMOUtils.isShallowOcean(int_3) && TMOUtils.chance(rand, TooMuchOcean.config.replacementChance) ? 1 : centreBiome);
	}
	
}

