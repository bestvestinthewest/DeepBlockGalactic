package cowsbeforeplows.deepblockgalactic.entities;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EPCNormalEntity extends ProjectileItemEntity {

	
	public EPCNormalEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public EPCNormalEntity(World worldIn, PlayerEntity playerIn) {
		super(ModEntityTypes.EPC_NORMAL_ENTITY.get(), worldIn);
		this.setNoGravity(true);
	}

	
	@Override
	protected void onImpact(RayTraceResult result) {
		
		if (result.getType() == RayTraceResult.Type.ENTITY) {
			Entity entity = ((EntityRayTraceResult)result).getEntity();
			
			if (entity instanceof EPCChargedEntity) {
				DeepBlockGalactic.LOGGER.debug("Impacted");
			}
			
			else {
				entity.attackEntityFrom(DamageSource.causeIndirectDamage(this, this.getThrower()), 2.0f);
			}
			
			if(!this.world.isRemote()) { 
		         this.world.setEntityState(this, (byte)3);
			     this.remove();
			}
		}
		
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte)3);
			this.remove();
		}
	}
	

	@Override
	protected Item getDefaultItem() {
		return ItemInit.EPC_SHOT.get();
	}
	
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
