
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

import net.mcreator.oaksdecor.init.OaksDecorModBlocks;

import java.util.List;
import java.util.Collections;

public class DarkOakDrawsOpenBlock extends Block implements SimpleWaterloggedBlock

{
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public DarkOakDrawsOpenBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.7999999999999999f, 10f).noOcclusion()
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
			default -> Shapes.or(box(0, 0, 0, 16, 1, 16), box(0, 15, 0, 16, 16, 16), box(0, 1, 1, 16, 15, 16), box(1, 8, 14, 15, 14, 15),
					box(6, 5, 18, 10, 6, 19), box(6, 12, 15, 10, 13, 16), box(0, 0, 0, 16, 16, 16), box(13.5, 2, 14, 14.5, 6, 17),
					box(1.5, 2, 14, 14.7, 6, 17), box(2.5, 3, 14, 13.5, 5, 17));
			case NORTH -> Shapes.or(box(0, 0, 0, 16, 1, 16), box(0, 15, 0, 16, 16, 16), box(0, 1, 0, 16, 15, 15), box(1, 8, 1, 15, 14, 2),
					box(6, 5, -3, 10, 6, -2), box(6, 12, 0, 10, 13, 1), box(0, 0, 0, 16, 16, 16), box(1.5, 2, -1, 2.5, 6, 2),
					box(1.3, 2, -1, 14.5, 6, 2), box(2.5, 3, -1, 13.5, 5, 2));
			case EAST -> Shapes.or(box(0, 0, 0, 16, 1, 16), box(0, 15, 0, 16, 16, 16), box(1, 1, 0, 16, 15, 16), box(14, 8, 1, 15, 14, 15),
					box(18, 5, 6, 19, 6, 10), box(15, 12, 6, 16, 13, 10), box(0, 0, 0, 16, 16, 16), box(14, 2, 1.5, 17, 6, 2.5),
					box(14, 2, 1.3, 17, 6, 14.5), box(14, 3, 2.5, 17, 5, 13.5));
			case WEST -> Shapes.or(box(0, 0, 0, 16, 1, 16), box(0, 15, 0, 16, 16, 16), box(0, 1, 0, 15, 15, 16), box(1, 8, 1, 2, 14, 15),
					box(-3, 5, 6, -2, 6, 10), box(0, 12, 6, 1, 13, 10), box(0, 0, 0, 16, 16, 16), box(-1, 2, 13.5, 2, 6, 14.5),
					box(-1, 2, 1.5, 2, 6, 14.7), box(-1, 3, 2.5, 2, 5, 13.5));
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
		return Collections.singletonList(new ItemStack(OaksDecorModBlocks.DARK_OAK_DRAWS_CLOSED.get()));
	}
}
