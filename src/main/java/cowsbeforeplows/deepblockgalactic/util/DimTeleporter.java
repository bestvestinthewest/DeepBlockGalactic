package cowsbeforeplows.deepblockgalactic.util;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class DimTeleporter {
	
	public static void teleportEntity(Entity entity, DimensionType type, BlockPos blockPos) {
        teleportEntity(entity, type, blockPos.getX() + 0.5, blockPos.getY() + 0.75, blockPos.getZ() + 0.5);
    }
	
	public static void teleportEntity(Entity entity, DimensionType type, double x, double y, double z) {
	        Teleporter simpleTeleporter = new Teleporter(x, y, z);
	        entity.changeDimension(type, simpleTeleporter);
	}
	
	public static void toSpaceRig(PlayerEntity playerEntity) {
		teleportEntity(playerEntity, DimensionType.byName(DeepBlockGalactic.SPACE_RIG_TYPE), 4, 74, 4);
		
		if (DimensionManager.getWorld(ServerLifecycleHooks.getCurrentServer(), DimensionType.byName(DeepBlockGalactic.SPACE_RIG_TYPE), false, false) == null) {
			if(!playerEntity.world.isRemote()) {
				ServerWorld serverWorld = (ServerWorld) playerEntity.world;
				TemplateManager templateManager = serverWorld.getStructureTemplateManager();
 				Template template = templateManager.getTemplate(new ResourceLocation(DeepBlockGalactic.MOD_ID + ":space_rig"));
				
				if (template == null) {
					DeepBlockGalactic.LOGGER.debug("Space Rig NBT Not Found!");
				}
				else {
					BlockPos pos = new BlockPos(0, 72, 0);
					PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
							.setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null);
					template.addBlocksToWorld(playerEntity.world, pos.add(0, 1, 0), placementsettings);
				}
			}
			

		}
    }
}
