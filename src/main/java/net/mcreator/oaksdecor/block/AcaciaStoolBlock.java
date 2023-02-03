
package net.mcreator.oaksdecor.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class AcaciaStoolBlock extends Block implements SimpleWaterloggedBlock

{
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public AcaciaStoolBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.7f, 6.5f).noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {

		return switch (state.getValue(FACING)) {
			default ->
				Shapes.or(box(2, 5, 2, 14, 6, 14), box(3, 0, 3, 5, 5, 5), box(12.7, 2.25, 5, 12.75, 3.7, 11), box(3.25, 2.25, 5, 4.75, 3.75, 11),
						box(5, 2.25, 3.25, 11, 3.75, 4.75), box(4.9, 2.25, 11.3, 11, 3.7, 12.75), box(3, 0, 11, 5, 5, 13), box(11, 0, 11, 13, 5, 13));
			case NORTH ->
				Shapes.or(box(2, 5, 2, 14, 6, 14), box(11, 0, 11, 13, 5, 13), box(3.25, 2.25, 5, 3.3, 3.7, 11), box(11.25, 2.25, 5, 12.75, 3.75, 11),
						box(5, 2.25, 11.25, 11, 3.75, 12.75), box(5, 2.25, 3.25, 11.1, 3.7, 4.7), box(11, 0, 3, 13, 5, 5), box(3, 0, 3, 5, 5, 5));
			case EAST ->
				Shapes.or(box(2, 5, 2, 14, 6, 14), box(3, 0, 11, 5, 5, 13), box(5, 2.25, 3.25, 11, 3.7, 3.3), box(5, 2.25, 11.25, 11, 3.75, 12.75),
						box(3.25, 2.25, 5, 4.75, 3.75, 11), box(11.3, 2.25, 5, 12.75, 3.7, 11.1), box(11, 0, 11, 13, 5, 13), box(11, 0, 3, 13, 5, 5));
			case WEST ->
				Shapes.or(box(2, 5, 2, 14, 6, 14), box(11, 0, 3, 13, 5, 5), box(5, 2.25, 12.7, 11, 3.7, 12.75), box(5, 2.25, 3.25, 11, 3.75, 4.75),
						box(11.25, 2.25, 5, 12.75, 3.75, 11), box(3.25, 2.25, 4.9, 4.7, 3.7, 11), box(3, 0, 3, 5, 5, 5), box(3, 0, 11, 5, 5, 13));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos,
			BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 15;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
