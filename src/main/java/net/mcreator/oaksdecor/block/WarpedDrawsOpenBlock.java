
package net.mcreator.oaksdecor.block;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oaksdecor.world.inventory.DrawsMenu;
import net.mcreator.oaksdecor.procedures.WarpedClosingProcedure;
import net.mcreator.oaksdecor.init.OaksDecorModBlocks;
import net.mcreator.oaksdecor.block.entity.WarpedDrawsOpenBlockEntity;

import java.util.List;
import java.util.Collections;

import io.netty.buffer.Unpooled;

public class WarpedDrawsOpenBlock extends Block
		implements

			EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public WarpedDrawsOpenBlock() {
		super(BlockBehaviour.Properties.of(Material.NETHER_WOOD).sound(SoundType.STEM).strength(0.7999999999999999f, 5.5f).noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
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
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(OaksDecorModBlocks.WARPED_DRAWS_CLOSED.get()));
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayer player) {
			NetworkHooks.openScreen(player, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Warped Draws ");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new DrawsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();

		WarpedClosingProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new WarpedDrawsOpenBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof WarpedDrawsOpenBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof WarpedDrawsOpenBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
