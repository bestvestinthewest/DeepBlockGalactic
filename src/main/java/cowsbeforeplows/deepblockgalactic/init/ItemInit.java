package cowsbeforeplows.deepblockgalactic.init;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DeepBlockGalactic.MOD_ID);

	
	
	// Minerals
	public static final RegistryObject<Item> NITRA = ITEMS.register("nitra", () -> new Item(new Item.Properties().maxStackSize(80).group(ItemGroup.MISC)));
	public static final RegistryObject<Item> MORKITE = ITEMS.register("morkite", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> GOLD = ITEMS.register("gold", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

	
	

}
