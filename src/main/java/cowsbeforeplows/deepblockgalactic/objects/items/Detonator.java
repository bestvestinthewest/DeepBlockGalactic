package cowsbeforeplows.deepblockgalactic.objects.items;


import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.entities.SatchelChargeEntity;
import net.minecraft.entity.LivingEntity;
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
		
		try {
			worldIn.getEntitiesWithinAABB(SatchelChargeEntity.class, search).stream().filter(e -> e.getThrower().equals((LivingEntity)playerIn))
			.forEach(SatchelChargeEntity::explode);
		}
		catch (NullPointerException e) {
			DeepBlockGalactic.LOGGER.debug("Detonator Found No Satchel Charges");
		}

		
		return ActionResult.resultSuccess(itemstack);
	}
}
