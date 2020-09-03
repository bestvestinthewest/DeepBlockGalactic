package cowsbeforeplows.deepblockgalactic.init;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.world.SpaceRigChunkGen;
import cowsbeforeplows.deepblockgalactic.world.dim.SpaceRigDim;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimInit {

	public static final DeferredRegister<ModDimension> DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, DeepBlockGalactic.MOD_ID);
	public static final DeferredRegister<ChunkGeneratorType<?, ?>> CHUNKS_GEN = new DeferredRegister<>(ForgeRegistries.CHUNK_GENERATOR_TYPES, DeepBlockGalactic.MOD_ID);
	
	
	public static final RegistryObject<ModDimension> SPACE_RIG = DIMENSIONS.register("space_rig", () -> ModDimension.withFactory(SpaceRigDim::new));
	
	public static final RegistryObject<ChunkGeneratorType<GenerationSettings, SpaceRigChunkGen>> RIG_CHUNK = CHUNKS_GEN.register("rig_chunk", () -> new ChunkGeneratorType<>(SpaceRigChunkGen::new, false, GenerationSettings::new));
}
