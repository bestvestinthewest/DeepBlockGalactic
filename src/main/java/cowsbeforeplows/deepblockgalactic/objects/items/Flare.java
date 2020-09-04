package cowsbeforeplows.deepblockgalactic.objects.items;

import cowsbeforeplows.deepblockgalactic.entities.FlareEntity;
import cowsbeforeplows.deepblockgalactic.entities.ImpactAxeEntity;
import cowsbeforeplows.deepblockgalactic.init.SoundInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class Flare extends Item {

	public Flare(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
	    playerIn.getCooldownTracker().setCooldown(this, 40);
	    
		if (!worldIn.isRemote) {
	         FlareEntity flareEntity = new FlareEntity(worldIn, playerIn);
	         flareEntity.setItem(itemstack);
	         flareEntity.setPosition(playerIn.getPosX(), playerIn.getPosY() + 1.5D, playerIn.getPosZ());
	         flareEntity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 2.0F, 0.5F, 0.25F);
	         worldIn.addEntity(flareEntity);
	      }
		
		 playerIn.addStat(Stats.ITEM_USED.get(this));
	     
		 if (!playerIn.abilities.isCreativeMode) {
	    	 itemstack.shrink(1);
	     }
		
		return ActionResult.resultSuccess(itemstack);
	}

}
