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
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		if (!worldIn.isRemote) {
			HookEntity hook = HookEntity.getHook(playerIn);
			if (hook != null) {
//				hook.reel();
			}
			
			else {
//				hook = new EntityHook(EntityType<>, worldIn, playerIn, itemstack);
				playerIn.getEntityWorld().addEntity(hook);
				
			}
		}
		
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}

}
