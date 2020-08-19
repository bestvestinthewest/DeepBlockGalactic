package cowsbeforeplows.deepblockgalactic.objects.items;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.entities.EPCChargedEntity;
import cowsbeforeplows.deepblockgalactic.entities.EPCNormalEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class EPC extends Item {

	public EPC(Properties properties) {
		super(properties);
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;

			int useDuration = this.getUseDuration(stack) - timeLeft;

			if (useDuration < 10) {
				if (!worldIn.isRemote) {
					EPCNormalEntity epcNormal = new EPCNormalEntity(worldIn, playerIn);
					epcNormal.setPosition(playerIn.getPosX(), playerIn.getPosY() + 1.5D, playerIn.getPosZ());
					epcNormal.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0, 1.0f, 0.0f);
					worldIn.addEntity(epcNormal);				
				}

				playerIn.getCooldownTracker().setCooldown(this, 4);
			}

			else if (useDuration > 10 && useDuration <= 60) {
				if (!worldIn.isRemote) {
					EPCChargedEntity epcCharged = new EPCChargedEntity(worldIn, playerIn);
					epcCharged.setPosition(playerIn.getPosX(), playerIn.getPosY() + 1.5D, playerIn.getPosZ());
					epcCharged.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0, 0.25f, 0.0f);
					worldIn.addEntity(epcCharged);
				}
			}

			else {
				//Play overheated
				DeepBlockGalactic.LOGGER.debug("Overheated by " + useDuration);
				return;
			}

			DeepBlockGalactic.LOGGER.debug("Time left on EPC:" + useDuration);


		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		playerIn.setActiveHand(handIn);
		return ActionResult.resultSuccess(itemstack);
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}
	
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

}
