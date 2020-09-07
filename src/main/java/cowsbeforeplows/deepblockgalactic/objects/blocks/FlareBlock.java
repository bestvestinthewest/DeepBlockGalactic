package cowsbeforeplows.deepblockgalactic.objects.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

public class FlareBlock extends Block implements IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	public FlareBlock(Properties properties) {
		super(properties);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
	}

	@Override
	public float getAmbientOcclusionLightValue(BlockState state, @Nonnull IBlockReader world, @Nonnull BlockPos pos) {
		return 1.0F;
	}
	
	@Override
    public boolean isSideInvisible(BlockState state, BlockState adjacentState, Direction side) {
        return true;
    }
	
	@Override
	@Nonnull
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
    	return VoxelShapes.empty();
    }
	
	@Override
    public boolean propagatesSkylightDown(BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos)
    {
        return state.getFluidState().isEmpty();
    }
	
	@Override
    public boolean isReplaceable(BlockState state, @Nonnull BlockItemUseContext useContext)
    {
        return true;
    }

	@Nonnull
    @Override
    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

	@Nonnull
    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState neighborState, IWorld world, BlockPos pos, BlockPos neighborPos)
    {
        if (state.get(WATERLOGGED))
        {
            world.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.updatePostPlacement(state, facing, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx)
    {
        return super.getStateForPlacement(ctx).with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getPos()).getFluid() == Fluids.WATER);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(WATERLOGGED);
    }



}
