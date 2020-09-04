package cowsbeforeplows.deepblockgalactic.objects.items;

import cowsbeforeplows.deepblockgalactic.entities.HookEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class GrapplingHook extends Item{

	public GrapplingHook(Properties properties) {
		super(properties);
		
	}
	
	public ActionResult<ItemStack> onItemRightClicK(World worldIn, PlayerEntity playerIn, Hand handIn) {

		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}

}
