package cowsbeforeplows.deepblockgalactic.entities;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class SatchelChargeEntity extends ProjectileItemEntity {


	public SatchelChargeEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public SatchelChargeEntity(World worldIn, PlayerEntity playerIn) {
		super(ModEntityTypes.SATCHEL_CHARGE_ENTITY.get(), worldIn);
		this.explode();
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		DeepBlockGalactic.LOGGER.debug("C4 Has Landed");

		if (result.getType() == RayTraceResult.Type.BLOCK){
			this.setVelocity(0, 0, 0);

		}
	}

	public void explode() {
		float f = 7.0F;
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), f, Explosion.Mode.BREAK);
	}
	

	@OnlyIn(Dist.CLIENT)
	private IParticleData makeParticle() {
		ItemStack itemstack = this.func_213882_k();
		return (IParticleData)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, itemstack));
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			IParticleData iparticledata = this.makeParticle();

			for(int i = 0; i < 8; ++i) {
				this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}


	@Override
	protected Item getDefaultItem() {
		return ItemInit.SATCHEL_CHARGE.get();
	}
	
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
