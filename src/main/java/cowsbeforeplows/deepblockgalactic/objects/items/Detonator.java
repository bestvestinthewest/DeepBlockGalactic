package cowsbeforeplows.deepblockgalactic.objects.items;


import cowsbeforeplows.deepblockgalactic.entities.SatchelChargeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class Detonator extends Item {

	public Detonator(Properties properties) {
		super(properties);
		
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		AxisAlignedBB search = new AxisAlignedBB(playerIn.getPosX() - 64, playerIn.getPosY() - 64, playerIn.getPosZ() - 64, playerIn.getPosX() + 64, playerIn.getPosY() + 64, playerIn.getPosZ() + 64);
		
		worldIn.getEntitiesWithinAABB(SatchelChargeEntity.class, search).stream().filter(e -> e.getThrower() == playerIn)
			.forEach(SatchelChargeEntity::explode);
		
		return ActionResult.resultSuccess(itemstack);
	
	}
}
