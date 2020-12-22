package cowsbeforeplows.deepblockgalactic.init;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.entities.EPCChargedEntity;
import cowsbeforeplows.deepblockgalactic.entities.EPCNormalEntity;
import cowsbeforeplows.deepblockgalactic.entities.FlareBoltEntity;
import cowsbeforeplows.deepblockgalactic.entities.FlareEntity;
import cowsbeforeplows.deepblockgalactic.entities.ImpactAxeEntity;
import cowsbeforeplows.deepblockgalactic.entities.SatchelChargeEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, DeepBlockGalactic.MOD_ID);
	
	
	//Support Tool Entities
	public static final RegistryObject<EntityType<SatchelChargeEntity>> SATCHEL_CHARGE_ENTITY = ENTITY_TYPES.register("satchel_charge", () -> EntityType.Builder.<SatchelChargeEntity>create(SatchelChargeEntity::new, EntityClassification.MISC).size(1.5f, 1.5f).build("satchel_charge"));
	public static final RegistryObject<EntityType<FlareBoltEntity>> FLARE_BOLT_ENTITY = ENTITY_TYPES.register("flare_bolt", () -> EntityType.Builder.<FlareBoltEntity>create(FlareBoltEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("flare_bolt"));
	public static final RegistryObject<EntityType<ImpactAxeEntity>> IMPACT_AXE_ENTITY = ENTITY_TYPES.register("impact_axe", () -> EntityType.Builder.<ImpactAxeEntity>create(ImpactAxeEntity::new, EntityClassification.MISC).size(1.0f, 1.0f).build("impact_axe"));
	public static final RegistryObject<EntityType<EPCChargedEntity>> EPC_CHARGED_ENTITY = ENTITY_TYPES.register("epc_charged", () -> EntityType.Builder.<EPCChargedEntity>create(EPCChargedEntity::new, EntityClassification.MISC).size(10.0f, 10.0f).build("epc_charged"));
	public static final RegistryObject<EntityType<EPCNormalEntity>> EPC_NORMAL_ENTITY = ENTITY_TYPES.register("epc_normal", () -> EntityType.Builder.<EPCNormalEntity>create(EPCNormalEntity::new, EntityClassification.MISC).size(1.0f, 1.0f).build("epc_normal"));
//	public static final RegistryObject<EntityType<HookEntity>> HOOK_ENTITY = ENTITY_TYPES.register("hook_entity", () -> EntityType.Builder.create(HookEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).build(new ResourceLocation(DeepBlockGalactic.MOD_ID, "hook_entity").toString()));
	public static final RegistryObject<EntityType<FlareEntity>> FLARE_ENTITY = ENTITY_TYPES.register("flare", () -> EntityType.Builder.<FlareEntity>create(FlareEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build("flare"));
	
}
