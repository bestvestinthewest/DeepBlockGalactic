package cowsbeforeplows.deepblockgalactic.util;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.init.DimInit;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = DeepBlockGalactic.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
		if (DimensionType.byName(DeepBlockGalactic.SPACE_RIG_TYPE) == null) {
			DimensionManager.registerDimension(DeepBlockGalactic.SPACE_RIG_TYPE, DimInit.SPACE_RIG.get(), null, true);
		}
		
		DeepBlockGalactic.LOGGER.debug("Dimenions Registered");
	}
}
