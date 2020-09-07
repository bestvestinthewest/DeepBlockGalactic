package cowsbeforeplows.deepblockgalactic.entities;

import cowsbeforeplows.deepblockgalactic.init.BlockInit;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FlareBoltEntity extends AbstractArrowEntity {

	private final Item item;
	private boolean isLit;
	private int timeLit;
	private BlockPos pos;
	public FlareBoltEntity.PickupStatus pickupStatus = FlareBoltEntity.PickupStatus.DISALLOWED;


	public FlareBoltEntity(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
		super(ModEntityTypes.FLARE_BOLT_ENTITY.get(), worldIn);
		this.item = ItemInit.FLARE_BOLT.get();
		this.timeLit = 0;
	}
	
	public FlareBoltEntity(LivingEntity shooter, World world, Item item) {
		super(ModEntityTypes.FLARE_BOLT_ENTITY.get(), world);
		this.item = item;
		this.isLit = false;
		this.timeLit = 0;

	}

	@Override
	public ItemStack getArrowStack() {
		return new ItemStack(item);
	}
	
	
	@Override
	public void tick() {
		super.tick();
		
		if (this.inGround && isLit == false) {
			pos = new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ());
			
			if (this.world.isAirBlock(pos)) {
				this.world.setBlockState(pos, BlockInit.FLARE_BLOCK.get().getDefaultState());
				isLit = true;
			}
		}
		
		else if (isLit) {
			this.timeLit++;
			if (timeLit > 2400) {
				this.world.removeBlock(pos, false);
				this.isLit = false;
				this.remove();
			}
		}
	}
	
	@Override
	public void func_225516_i_() {
	}
	
	@Override
	public IPacket<?> createSpawnPacket(){
		
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
