package cowsbeforeplows.deepblockgalactic.objects.items;

import cowsbeforeplows.deepblockgalactic.entities.SatchelChargeEntity;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class SatchelCharge extends Item{

	public SatchelCharge(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
	    worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
	    playerIn.getCooldownTracker().setCooldown(this, 20);
	    
		if (!worldIn.isRemote) {
	         SatchelChargeEntity satchelChargeEntity = new SatchelChargeEntity(worldIn, playerIn);
	         satchelChargeEntity.setItem(itemstack);
	         satchelChargeEntity.setPosition(playerIn.getPosX(), playerIn.getPosY() + 1.5D, playerIn.getPosZ());
	         satchelChargeEntity.shoot(playerIn.rotationPitch, playerIn.rotationYaw, 2.0F, 0.5F, 0.25F);
	         worldIn.addEntity(satchelChargeEntity);
	      }
		
		 playerIn.addStat(Stats.ITEM_USED.get(this));
	     
		 if (!playerIn.abilities.isCreativeMode) {
	    	 itemstack.shrink(1);
	    	 if (!playerIn.inventory.hasItemStack(new ItemStack(ItemInit.DETONATOR.get()))) {
		    	 playerIn.inventory.addItemStackToInventory(new ItemStack(ItemInit.DETONATOR.get()));
	    	 }
	     }
		
		return ActionResult.resultSuccess(itemstack);
	}

}
