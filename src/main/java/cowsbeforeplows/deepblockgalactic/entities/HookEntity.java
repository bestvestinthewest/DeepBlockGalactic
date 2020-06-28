package cowsbeforeplows.deepblockgalactic.entities;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class HookEntity extends Entity {
	
	private static final HashMap<LivingEntity, HookEntity> hooks = new HashMap<>();
	private static final DataParameter<Float> LENGTH = EntityDataManager.createKey(HookEntity.class, DataSerializers.FLOAT);
    private static final DataParameter<Byte> STATE = EntityDataManager.createKey(HookEntity.class, DataSerializers.BYTE);
    
    private ItemStack itemstack;
	
	private LivingEntity shooter;

	public HookEntity(EntityType<?> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}
	
    public static HookEntity getHook(LivingEntity entity) {
        return hooks.get(entity);
    }

	@Override
	protected void registerData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readAdditional(CompoundNBT compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeAdditional(CompoundNBT compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		// TODO Auto-generated method stub
		return null;
	}

}
