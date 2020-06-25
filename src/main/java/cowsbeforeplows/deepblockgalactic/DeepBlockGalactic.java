package cowsbeforeplows.deepblockgalactic;

import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("deepblockgalactic")
public class DeepBlockGalactic {

	public static final String MOD_ID = "deepblockgalactic";
	public static DeepBlockGalactic instance;
	
	
	
	public DeepBlockGalactic() {
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        ItemInit.ITEMS.register(modEventBus);
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registy = event.getRegistry();
		
	}
	
	private void setup(final FMLCommonSetupEvent event) {
	    
	}

	private void doClientStuff(final FMLClientSetupEvent event) {

	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}
}
