package tk.valoeghese.toomuchocean;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public final class TMOUtils {
	
	private static final int WARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.WARM_OCEAN);
	private static final int LUKEWARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.LUKEWARM_OCEAN);
	private static final int OCEAN_ID = Registry.BIOME.getRawId(Biomes.OCEAN);
	private static final int COLD_OCEAN_ID = Registry.BIOME.getRawId(Biomes.COLD_OCEAN);
	private static final int FROZEN_OCEAN_ID = Registry.BIOME.getRawId(Biomes.FROZEN_OCEAN);
    
	private TMOUtils() {
	}
	
	public static boolean isShallowOcean(int biomeId) {
		return biomeId == WARM_OCEAN_ID || biomeId == LUKEWARM_OCEAN_ID || biomeId == OCEAN_ID || biomeId == COLD_OCEAN_ID || biomeId == FROZEN_OCEAN_ID;
	}
	
	public static boolean chance(LayerRandomnessSource rand, double targetValue) {
		double nextDouble = ((double) rand.nextInt(Integer.MAX_VALUE)) / Integer.MAX_VALUE;
		
		return nextDouble < targetValue;
	}
	
}
