package cowsbeforeplows.deepblockgalactic.objects.items;

import javax.annotation.Nonnull;

import cowsbeforeplows.deepblockgalactic.entities.FlareBoltEntity;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import cowsbeforeplows.deepblockgalactic.init.SoundInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class FlareGun extends Item{

	public FlareGun(Properties properties) {
		super(properties);
	}
	
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, @Nonnull Hand hand) {
		 if (!worldIn.isRemote) {
				FlareBoltEntity flareBolt = new FlareBoltEntity(playerIn, worldIn, ItemInit.FLARE_BOLT.get());
				flareBolt.setPosition(playerIn.getPosX(), playerIn.getPosY() + 1.5D, playerIn.getPosZ());
				flareBolt.shoot(playerIn.rotationPitch, playerIn.rotationYaw, 0, 2.5f, 0.0f);
				worldIn.addEntity(flareBolt);	
				worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundInit.FLARE_GUN_SHOT.get(), SoundCategory.PLAYERS, 0.5f, 1.0f);
			}

			playerIn.getCooldownTracker().setCooldown(this, 10);
		
		 return super.onItemRightClick(worldIn, playerIn, hand);
	 }

}
