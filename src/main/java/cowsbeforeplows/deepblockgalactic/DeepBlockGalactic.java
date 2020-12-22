package cowsbeforeplows.deepblockgalactic;

import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cowsbeforeplows.deepblockgalactic.init.BiomeInit;
import cowsbeforeplows.deepblockgalactic.init.BlockInit;
import cowsbeforeplows.deepblockgalactic.init.DimInit;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import cowsbeforeplows.deepblockgalactic.init.SoundInit;
import cowsbeforeplows.deepblockgalactic.objects.blocks.FlareBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
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
	
	public static final ResourceLocation SPACE_RIG_TYPE = new ResourceLocation(MOD_ID, "space_rig");
	
	
	public DeepBlockGalactic() {
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
        
		
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        SoundInit.SOUNDS.register(modEventBus);
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			if (block instanceof FlareBlock) {
				final Item.Properties properties = new Item.Properties();
				final BlockItem blockItem = new BlockItem(block, properties);
				blockItem.setRegistryName(block.getRegistryName());
				registry.register(blockItem);
			}
			else {
				final Item.Properties properties = new Item.Properties().group(TAB);
				final BlockItem blockItem = new BlockItem(block, properties);
				blockItem.setRegistryName(block.getRegistryName());
				registry.register(blockItem);
			}
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
