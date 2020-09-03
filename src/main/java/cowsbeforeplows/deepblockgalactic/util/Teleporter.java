package cowsbeforeplows.deepblockgalactic.util;

import java.util.function.Function;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

public class Teleporter implements ITeleporter {
	private double x;
	private double y;
	private double z;

	public Teleporter(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
		Entity repositionedEntity = repositionEntity.apply(false);
		repositionedEntity.setPositionAndUpdate(x, y, z);
		return repositionedEntity;
	}
	
	public static void teleportEntity(Entity entity, DimensionType type, BlockPos blockPos) {
        teleportEntity(entity, type, blockPos.getX() + 0.5, blockPos.getY() + 0.75, blockPos.getZ() + 0.5);
    }
	
	public static void teleportEntity(Entity entity, DimensionType type, double x, double y, double z) {
	        Teleporter simpleTeleporter = new Teleporter(x, y, z);
	        entity.changeDimension(type, simpleTeleporter);
	}
	
	public static void toSpaceRig(PlayerEntity playerEntity) {
		if(playerEntity.world instanceof ServerWorld) {
			
		}
    }
	

}
