package cowsbeforeplows.deepblockgalactic.entities;

import cowsbeforeplows.deepblockgalactic.init.BlockInit;
import cowsbeforeplows.deepblockgalactic.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlareBoltEntity extends AbstractArrowEntity {

	private final Item item;
	private boolean isLit;
	private BlockPos flareBlockPos;

	
	public FlareBoltEntity(LivingEntity shooter, World world, Item item) {
		super(ModEntityTypes.FLARE_BOLT_ENTITY.get(), world);
		this.item = item;
		this.isLit = false;
	}

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(item);
	}
	
	@Override
	public void tick() {
		super.tick();
		
		if (this.inGround && isLit == false) {
			flareBlockPos = new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ());
			this.world.setBlockState(flareBlockPos, BlockInit.FLARE_BLOCK.get().getDefaultState());
			isLit = true;
		}
	}
	

}
