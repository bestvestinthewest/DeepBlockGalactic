package cowsbeforeplows.deepblockgalactic.objects.items;


import java.util.List;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.entities.SatchelChargeEntity;
import cowsbeforeplows.deepblockgalactic.init.SoundInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class Detonator extends Item {

	public Detonator(Properties properties) {
		super(properties);

	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);


		AxisAlignedBB search = new AxisAlignedBB(playerIn.getPosX() - 64, playerIn.getPosY() - 64, playerIn.getPosZ() - 64, playerIn.getPosX() + 64, playerIn.getPosY() + 64, playerIn.getPosZ() + 64);

		List<SatchelChargeEntity> charges = worldIn.getEntitiesWithinAABB(SatchelChargeEntity.class, search);
		
		worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundInit.DETONATOR.get(), SoundCategory.BLOCKS, 0.4f, 1.0f);
		
		for(SatchelChargeEntity charge: charges) {
			if (playerIn.getUniqueID() == charge.getOwner())
				charge.explode();
		}

		if (charges.isEmpty()) {
			return ActionResult.resultFail(itemstack);
		}
		
		else {
			
			if (!playerIn.abilities.isCreativeMode) {
				return ActionResult.resultConsume(itemstack);
			}
			
			return ActionResult.resultSuccess(itemstack);
		}
	}
}
