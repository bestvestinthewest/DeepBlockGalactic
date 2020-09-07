package cowsbeforeplows.deepblockgalactic.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.client.render.FlareBoltRenderer;
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
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SATCHEL_CHARGE_ENTITY.get(), renderManagerIn -> new SpriteRenderer<>(renderManagerIn, Minecraft.getInstance().getItemRenderer(), 1.5f, false));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.IMPACT_AXE_ENTITY.get(), renderManagerIn -> new SpriteRenderer<>(renderManagerIn, Minecraft.getInstance().getItemRenderer(), 1.0f, false));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EPC_NORMAL_ENTITY.get(), renderManagerIn -> new SpriteRenderer<>(renderManagerIn, Minecraft.getInstance().getItemRenderer(), 1.0f, false));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EPC_CHARGED_ENTITY.get(), renderManagerIn -> new SpriteRenderer<>(renderManagerIn, Minecraft.getInstance().getItemRenderer(), 3.0f, false));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FLARE_ENTITY.get(), renderManagerIn -> new SpriteRenderer<>(renderManagerIn, Minecraft.getInstance().getItemRenderer(), 1.0f, false));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FLARE_BOLT_ENTITY.get(), FlareBoltRenderer::new);
		
		LOGGER.debug("Deep Block Galactic Client Mod Event Subscriber has been set up!");
	}
}
