package cowsbeforeplows.deepblockgalactic.init;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeepBlockGalactic.MOD_ID);

	public static final RegistryObject<SoundEvent> AXE_IMPACT_BLOCK = SOUNDS.register("entity.impact_axe.axe_impact_block",
			() -> new SoundEvent(new ResourceLocation(DeepBlockGalactic.MOD_ID, "entity.impact_axe.axe_impact_block")));
	
	public static final RegistryObject<SoundEvent> AXE_IMPACT_ENTITY = SOUNDS.register("entity.impact_axe.axe_impact_entity",
			() -> new SoundEvent(new ResourceLocation(DeepBlockGalactic.MOD_ID, "entity.impact_axe.axe_impact_entity")));
	
	public static final RegistryObject<SoundEvent> AXE_THROW = SOUNDS.register("item.impact_axe.axe_throw",
			() -> new SoundEvent(new ResourceLocation(DeepBlockGalactic.MOD_ID, "item.impact_axe.axe_throw")));
	
	public static final RegistryObject<SoundEvent> SATCHEL_CHARGE_BEEP = SOUNDS.register("entity.satchel_charge.beep",
			() -> new SoundEvent(new ResourceLocation(DeepBlockGalactic.MOD_ID, "entity.satchel_charge.beep")));
	
	public static final RegistryObject<SoundEvent> DETONATOR = SOUNDS.register("item.detonator.detonate", 
			() -> new SoundEvent(new ResourceLocation(DeepBlockGalactic.MOD_ID, "item.detonator.detonate")));
	
	public static final RegistryObject<SoundEvent> FLARE_GUN_SHOT = SOUNDS.register("item.flare_gun.shoot",
			() -> new SoundEvent(new ResourceLocation(DeepBlockGalactic.MOD_ID, "item.flare_gun.shoot")));
}
