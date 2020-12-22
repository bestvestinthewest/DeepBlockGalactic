package cowsbeforeplows.deepblockgalactic.objects.items;

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

public class ImpactAxe extends Item {

	public ImpactAxe(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
	    worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundInit.AXE_THROW.get(), SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
	    playerIn.getCooldownTracker().setCooldown(this, 20);
	    
		if (!worldIn.isRemote) {
	         ImpactAxeEntity impactAxeEntity = new ImpactAxeEntity(worldIn, playerIn);
	         impactAxeEntity.setItem(itemstack);
	         impactAxeEntity.setPosition(playerIn.getPosX(), playerIn.getPosY() + 1.5D, playerIn.getPosZ());
	         impactAxeEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 2.0F, 0.5F, 0.25F);
	         worldIn.addEntity(impactAxeEntity);
	      }
		
		 playerIn.addStat(Stats.ITEM_USED.get(this));
	     
		 if (!playerIn.abilities.isCreativeMode) {
	    	 itemstack.shrink(1);
	     }
		
		return ActionResult.resultSuccess(itemstack);
	}

}
