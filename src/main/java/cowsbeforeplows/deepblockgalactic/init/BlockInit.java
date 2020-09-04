package cowsbeforeplows.deepblockgalactic.init;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.objects.blocks.FlareBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, DeepBlockGalactic.MOD_ID);
	
	//Hoxxes IV Ores
	public static final RegistryObject<Block> NITRA_ORE = BLOCKS.register("nitra_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.0f, 3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(9)));
	public static final RegistryObject<Block> MORKITE_ORE = BLOCKS.register("morkite_ore", 
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.0f, 3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(7)));
	public static final RegistryObject<Block> GOLD_ORE = BLOCKS.register("gold_ore", 
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(3)));
	
	//Flare
	public static final RegistryObject<FlareBlock> FLARE_BLOCK = BLOCKS.register("flare_block",
			() -> new FlareBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.2f).lightValue(15).doesNotBlockMovement())); 
	
	
}
