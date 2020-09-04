package cowsbeforeplows.deepblockgalactic.entities;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.init.BlockInit;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FlareEntity extends ProjectileItemEntity {

	
	private boolean isLit;
	private int timeLit;
	private BlockPos flareBlockPos;
	
	public FlareEntity(World worldIn, LivingEntity livingEntityIn) {
		super(ModEntityTypes.FLARE_ENTITY.get(), livingEntityIn, worldIn);
		this.isLit = false;
	}
	
	public FlareEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
		super(type, worldIn);
		this.isLit = false;
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.getType() == RayTraceResult.Type.BLOCK){
			this.setVelocity(0, 0, 0);
			flareBlockPos = new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ());
			this.world.setBlockState(flareBlockPos, BlockInit.FLARE_BLOCK.get().getDefaultState());
			isLit = true;
		}
	}
	
	@Override
	public void tick() {
		super.tick();		
		if (isLit) {
			this.timeLit++;
			if (timeLit > 600) {
				this.world.removeBlock(flareBlockPos, false);
				this.isLit = false;
				this.remove();
			}
		}		
	}
	
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    
	
	@Override
	protected Item getDefaultItem() {
		return ItemInit.FLARE.get();
	}

}
