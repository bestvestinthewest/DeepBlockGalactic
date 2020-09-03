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
}
