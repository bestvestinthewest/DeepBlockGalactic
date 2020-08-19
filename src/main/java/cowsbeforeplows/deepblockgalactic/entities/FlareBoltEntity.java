package cowsbeforeplows.deepblockgalactic.entities;

import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class FlareBoltEntity extends ProjectileItemEntity {

	public FlareBoltEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public FlareBoltEntity(PlayerEntity playerIn, World worldIn) {
		super(ModEntityTypes.FLARE_BOLT_ENTITY.get(), playerIn, worldIn);
	}
	
	@Override
	protected Item getDefaultItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		// TODO Auto-generated method stub
		
	}

}
