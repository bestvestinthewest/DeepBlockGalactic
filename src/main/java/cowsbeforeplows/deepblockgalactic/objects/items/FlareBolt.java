package cowsbeforeplows.deepblockgalactic.objects.items;

import cowsbeforeplows.deepblockgalactic.entities.FlareBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FlareBolt extends ArrowItem {

	public FlareBolt(Properties builder) {
		super(builder);
	}
	
	@Override
	public FlareBoltEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		FlareBoltEntity boltEntity = new FlareBoltEntity(shooter, worldIn, this);
		boltEntity.setDamage(0.5);
		return boltEntity;
	}

}
