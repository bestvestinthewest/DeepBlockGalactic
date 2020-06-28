package cowsbeforeplows.deepblockgalactic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cowsbeforeplows.deepblockgalactic.init.BlockInit;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("deepblockgalactic")
@Mod.EventBusSubscriber(modid = DeepBlockGalactic.MOD_ID, bus = Bus.MOD)
public class DeepBlockGalactic {

	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "deepblockgalactic";
	public static DeepBlockGalactic instance;
	
	
	
	public DeepBlockGalactic() {
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
        
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(TAB);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

		LOGGER.debug("DBG BlockItems Registered");
	}
	
	private void setup(final FMLCommonSetupEvent event) {
	    
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}
	
	public static final ItemGroup TAB = new ItemGroup("dbgtab") {
	    @Override
	    public ItemStack createIcon(){
	        return new ItemStack(BlockInit.NITRA_ORE.get());
	    }
	};
}
