package cowsbeforeplows.deepblockgalactic.init;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.objects.items.BlackoutStout;
import cowsbeforeplows.deepblockgalactic.objects.items.Detonator;
import cowsbeforeplows.deepblockgalactic.objects.items.GrapplingHook;
import cowsbeforeplows.deepblockgalactic.objects.items.SatchelCharge;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DeepBlockGalactic.MOD_ID);
	
	//Support Tools
	public static final RegistryObject<GrapplingHook> GRAPPLING_HOOK = ITEMS.register("grappling_hook", () -> new GrapplingHook(new Item.Properties().group(DeepBlockGalactic.TAB).maxStackSize(1)));
	public static final RegistryObject<SatchelCharge> SATCHEL_CHARGE = ITEMS.register("satchel_charge", () -> new SatchelCharge(new Item.Properties().group(DeepBlockGalactic.TAB).maxStackSize(4)));
	public static final RegistryObject<Detonator> DETONATOR = ITEMS.register("detonator", () -> new Detonator(new Item.Properties().group(DeepBlockGalactic.TAB).maxStackSize(1)));
	
	// Minerals
	public static final RegistryObject<Item> NITRA = ITEMS.register("nitra", () -> new Item(new Item.Properties().group(DeepBlockGalactic.TAB)));
	public static final RegistryObject<Item> MORKITE = ITEMS.register("morkite", () -> new Item(new Item.Properties().group(DeepBlockGalactic.TAB)));
	public static final RegistryObject<Item> GOLD = ITEMS.register("gold", () -> new Item(new Item.Properties().group(DeepBlockGalactic.TAB)));
	
	//Beer
	public static final RegistryObject<BlackoutStout> BLACKOUT_STOUT = ITEMS.register("blackout_stout", () -> new BlackoutStout(new Item.Properties().group(DeepBlockGalactic.TAB)));
	public static final RegistryObject<Item> EMPTY_MUG = ITEMS.register("empty_mug", () -> new Item(new Item.Properties().group(DeepBlockGalactic.TAB)));
	

	
}
