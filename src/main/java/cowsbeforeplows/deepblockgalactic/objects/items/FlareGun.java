package cowsbeforeplows.deepblockgalactic.objects.items;

import javax.annotation.Nonnull;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FlareGun extends Item{

	public FlareGun(Properties properties) {
		super(properties);
	}
	
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, @Nonnull Hand hand) {
		 
		 
		 
		 return super.onItemRightClick(world, player, hand);
	 }

}
