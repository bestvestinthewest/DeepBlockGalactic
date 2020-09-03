package cowsbeforeplows.deepblockgalactic.objects.items;

import javax.annotation.Nonnull;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class FlareGun extends Item{

	public FlareGun(Properties properties) {
		super(properties);
	}
	
	 @Override
	 public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, @Nonnull Hand hand) {
		 		 
		 
		 return super.onItemRightClick(world, player, hand);
	 }

}
