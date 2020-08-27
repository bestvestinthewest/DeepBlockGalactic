package cowsbeforeplows.deepblockgalactic.init;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.objects.items.BlackoutStout;
import cowsbeforeplows.deepblockgalactic.objects.items.Detonator;
import cowsbeforeplows.deepblockgalactic.objects.items.Drill;
import cowsbeforeplows.deepblockgalactic.objects.items.FlareGun;
import cowsbeforeplows.deepblockgalactic.objects.items.GrapplingHook;
import cowsbeforeplows.deepblockgalactic.objects.items.ImpactAxe;
import cowsbeforeplows.deepblockgalactic.objects.items.SatchelCharge;
import cowsbeforeplows.deepblockgalactic.objects.items.EPC;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemTier;
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
	public static final RegistryObject<FlareGun> FLARE_GUN = ITEMS.register("flare_gun", () -> new FlareGun(new Item.Properties().group(DeepBlockGalactic.TAB).maxStackSize(1)));
	public static final RegistryObject<ImpactAxe> IMPACT_AXE = ITEMS.register("impact_axe", () -> new ImpactAxe(new Item.Properties().group(DeepBlockGalactic.TAB).maxStackSize(8)));
	public static final RegistryObject<EPC> EPC = ITEMS.register("epc", () -> new EPC(new Item.Properties().group(DeepBlockGalactic.TAB).maxStackSize(1)));
	public static final RegistryObject<Drill> DRILL = ITEMS.register("drill", () -> new Drill(ItemTier.DIAMOND, 6, 2.8f, new Item.Properties().group(DeepBlockGalactic.TAB)));
	
	
	// Minerals
	public static final RegistryObject<Item> NITRA = ITEMS.register("nitra", () -> new Item(new Item.Properties().group(DeepBlockGalactic.TAB)));
	public static final RegistryObject<Item> MORKITE = ITEMS.register("morkite", () -> new Item(new Item.Properties().group(DeepBlockGalactic.TAB)));
	public static final RegistryObject<Item> GOLD = ITEMS.register("gold", () -> new Item(new Item.Properties().group(DeepBlockGalactic.TAB)));
	
	//Beer
	public static final RegistryObject<BlackoutStout> BLACKOUT_STOUT = ITEMS.register("blackout_stout", () -> new BlackoutStout(new Item.Properties().group(DeepBlockGalactic.TAB)));
	public static final RegistryObject<Item> EMPTY_MUG = ITEMS.register("empty_mug", () -> new Item(new Item.Properties().group(DeepBlockGalactic.TAB)));
	

	//Misc
	public static final RegistryObject<Item> EPC_SHOT = ITEMS.register("epc_shot", () -> new Item(new Item.Properties()));
}
