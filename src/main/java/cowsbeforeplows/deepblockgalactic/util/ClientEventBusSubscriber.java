package cowsbeforeplows.deepblockgalactic.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DeepBlockGalactic.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	private static final Logger LOGGER = LogManager.getLogger(DeepBlockGalactic.MOD_ID + " Client Mod Event Subscriber");
	
	@SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SATCHEL_CHARGE_ENTITY.get(), renderManagerIn -> new SpriteRenderer<>(renderManagerIn, Minecraft.getInstance().getItemRenderer()));
		LOGGER.debug("Deep Block Galactic Client Mod Event Subscriber has been set up!");
	}

}
