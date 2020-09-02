package cowsbeforeplows.deepblockgalactic.objects.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import cowsbeforeplows.deepblockgalactic.util.IBreakValidator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolItem;
import net.minecraft.network.play.server.SChangeBlockPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Drill extends PickaxeItem {

	public Drill(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean canHarvestBlock(BlockState blockIn) {
		int i = this.getTier().getHarvestLevel();
		if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE || blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.SHOVEL) {
			return i >= blockIn.getHarvestLevel();
		}
		Material material = blockIn.getMaterial();
		return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL || material == Material.EARTH || material == Material.SAND || material == Material.CLAY;
	}

	@Override
	public boolean canPlayerBreakBlockWhileHolding(BlockState state, World world, BlockPos pos, PlayerEntity player) {
		int radius = 1;

		if (player.isCrouching()) {
			radius = 0;
		}

		float originHardness = world.getBlockState(pos).getBlockHardness(null, null);

		if (player.getHeldItemMainhand().canHarvestBlock(world.getBlockState(pos))) {
			this.breakInRadius(world, player, radius, (breakState) -> {
				double hardness = breakState.getBlockHardness(null, null);
				boolean isEffective = player.getHeldItemMainhand().canHarvestBlock(breakState);
				boolean verifyHardness = hardness < originHardness * 5 && hardness > 0;
				return isEffective && verifyHardness;
			}, true);
		}

		return true;
	}

	public void breakInRadius(World world, PlayerEntity player, int radius, IBreakValidator breakValidator, boolean damageTool) {
		if (!world.isRemote) {
			List<BlockPos> brokenBlocks = getBreakBlocks(world, player, radius);
			ItemStack heldItem = player.getHeldItemMainhand();

			for (BlockPos pos : brokenBlocks) {
				BlockState state = world.getBlockState(pos);
				if (breakValidator.canBreak(state)) {
					world.removeBlock(pos, false);
					if (player.abilities.isCreativeMode) {
						if (state.removedByPlayer(world, pos, player, true, state.getFluidState()))
							state.getBlock().onPlayerDestroy(world, pos, state);
					} else {
						heldItem.getItem().onBlockDestroyed(heldItem, world, state, pos, player);
						TileEntity tileEntity = world.getTileEntity(pos);
						state.getBlock().onPlayerDestroy(world, pos, state);
						state.getBlock().harvestBlock(world, player, pos, state, tileEntity, heldItem);
						state.getBlock().dropXpOnBlockBreak((ServerWorld) world, pos, state.getBlock().getExpDrop(state, world, pos, 0, 0));
					}

					world.playEvent(2001, pos, Block.getStateId(state));
					((ServerPlayerEntity) player).connection.sendPacket(new SChangeBlockPacket(world, pos));
				}
			}
			
			if (damageTool) {
				heldItem.damageItem(1, player, playerEntity -> {
				});
			}
		}
	}

	public List<BlockPos> getBreakBlocks(World world, PlayerEntity player, int radius) {
		ArrayList<BlockPos> potentialBrokenBlocks = new ArrayList<>();

		Vec3d eyePosition = player.getEyePosition(1);
		Vec3d rotation = player.getLook(1);
		Vec3d combined = eyePosition.add(rotation.x * 5, rotation.y * 5, rotation.z * 5);

		BlockRayTraceResult rayTraceResult = world.rayTraceBlocks(new RayTraceContext(eyePosition, combined, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, player));

		if (rayTraceResult.getType() == RayTraceResult.Type.BLOCK) {
			Direction.Axis axis = rayTraceResult.getFace().getAxis();
			ArrayList<BlockPos> positions = new ArrayList<>();

			for (int x = -radius; x <= radius; x++) {
				for (int y = -radius; y <= radius; y++) {
					for (int z = -radius; z <= radius; z++) {
						positions.add(new BlockPos(x, y, z));
					}
				}
			}

			BlockPos origin = rayTraceResult.getPos();

			for (BlockPos pos : positions) {
				if (axis == Direction.Axis.Y) {
					if (pos.getY() == 0) {
						potentialBrokenBlocks.add(origin.add(pos));
					}
				} else if (axis == Direction.Axis.X) {
					if (pos.getX() == 0) {
						potentialBrokenBlocks.add(origin.add(pos));
					}
				} else if (axis == Direction.Axis.Z) {
					if (pos.getZ() == 0) {
						potentialBrokenBlocks.add(origin.add(pos));
					}
				}
			}
		}

		return potentialBrokenBlocks;

	}

}
