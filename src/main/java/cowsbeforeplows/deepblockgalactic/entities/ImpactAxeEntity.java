package cowsbeforeplows.deepblockgalactic.entities;

import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import cowsbeforeplows.deepblockgalactic.init.SoundInit;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ImpactAxeEntity extends ProjectileItemEntity {
	
	private boolean hasImpacted;

	public ImpactAxeEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
		super(type, worldIn);
		this.hasImpacted = false;
	}
	
	public ImpactAxeEntity(World worldIn, PlayerEntity playerIn) {
		super(ModEntityTypes.IMPACT_AXE_ENTITY.get(), worldIn);
		this.hasImpacted = false;
	}

	@Override
	public void onCollideWithPlayer(PlayerEntity entityIn) {
		
		if (!this.world.isRemote && this.hasImpacted) {
			if (entityIn.abilities.isCreativeMode) {
				 entityIn.onItemPickup(this, 1);
		         this.remove();
			}
			else {
				 entityIn.onItemPickup(this, 1);
				 this.entityDropItem(new ItemStack(ItemInit.IMPACT_AXE.get()));
				 this.remove();
			}
		}
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.getType() == RayTraceResult.Type.ENTITY) {
			Entity entity = ((EntityRayTraceResult)result).getEntity();
			entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 8.0f);
			
			this.playSound(SoundInit.AXE_IMPACT_ENTITY.get(), 0.25f, 1.0f);
			
			if(!this.world.isRemote()) {
		         this.world.setEntityState(this, (byte)3);
			     this.remove();
			}
		}
		
		
		if (result.getType() == RayTraceResult.Type.BLOCK) {
			this.hasImpacted = true;
		
			this.playSound(SoundInit.AXE_IMPACT_BLOCK.get(), 0.25f, 1.0f);

			if (!this.world.isRemote()) {
				this.setVelocity(0, 0, 0);
				this.setNoGravity(true);
			}
		}
	}
	
	@Override
	protected Item getDefaultItem() {
		return ItemInit.IMPACT_AXE.get();
	}
	
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
