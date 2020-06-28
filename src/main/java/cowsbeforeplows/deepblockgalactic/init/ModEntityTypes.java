package cowsbeforeplows.deepblockgalactic.init;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.entities.HookEntity;
import cowsbeforeplows.deepblockgalactic.entities.SatchelChargeEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, DeepBlockGalactic.MOD_ID);
	
	
	//Support Tool Entities
	public static final RegistryObject<EntityType<SatchelChargeEntity>> SATCHEL_CHARGE_ENTITY = ENTITY_TYPES.register("satchel_charge", () -> EntityType.Builder.<SatchelChargeEntity>create(SatchelChargeEntity::new, EntityClassification.MISC).size(0.25f, 0.25f).build("satchel_charge"));
//	public static final RegistryObject<EntityType<HookEntity>> HOOK_ENTITY = ENTITY_TYPES.register("hook_entity", () -> EntityType.Builder.create(HookEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).build(new ResourceLocation(DeepBlockGalactic.MOD_ID, "hook_entity").toString()));
	
	
}
