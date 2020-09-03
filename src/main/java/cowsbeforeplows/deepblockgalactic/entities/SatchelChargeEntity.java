package cowsbeforeplows.deepblockgalactic.entities;

import java.util.UUID;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import cowsbeforeplows.deepblockgalactic.init.SoundInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class SatchelChargeEntity extends ProjectileItemEntity {

	private UUID thrower;
	
	public SatchelChargeEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public SatchelChargeEntity(World worldIn, PlayerEntity playerIn) {
		super(ModEntityTypes.SATCHEL_CHARGE_ENTITY.get(), worldIn);
		this.thrower = playerIn.getUniqueID();
	}
	
	public SatchelChargeEntity(World worldIn, double x, double y, double z) {
		super(ModEntityTypes.SATCHEL_CHARGE_ENTITY.get(), x, y, z, worldIn);
	}

	public void handleStatusUpdate(byte id) {
		if (this.world.isRemote()) {
			if (id == 3) {
				IParticleData iparticledata = this.makeParticle();

				for(int i = 0; i < 8; ++i) {
					this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
	
	private IParticleData makeParticle() {
			ItemStack itemstack = this.func_213882_k();
			return (IParticleData)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, itemstack));
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.getType() == RayTraceResult.Type.BLOCK){
			this.setVelocity(0, 0, 0);
			this.setNoGravity(true);
		}
	}
	
	@Override
	public void tick() {
		super.tick();

		if (!this.world.isRemote() && ticksExisted % 10 == 0) {
			this.playSound(SoundInit.SATCHEL_CHARGE_BEEP.get(), 0.05f, 1.0f);
		}
	}
	
    public UUID getOwner() {
    	return this.thrower;
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    
	public void explode() {
		float f = 7.0F;
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), f, false, Explosion.Mode.BREAK);
		this.remove();
	}
	
	protected Item getDefaultItem() {
		return ItemInit.SATCHEL_CHARGE.get();
	}
}
