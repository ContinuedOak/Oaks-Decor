package net.mcreator.oaksdecor.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.oaksdecor.init.OaksDecorModBlocks;

public class BookshelfBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem)
				&& (OaksDecorModBlocks.ACACIA_BOOKSHELF.get() == (world.getBlockState(new BlockPos(x, y, z))).getBlock()
						|| OaksDecorModBlocks.BIRCH_BOOKSHELF.get() == (world.getBlockState(new BlockPos(x, y, z))).getBlock()
						|| OaksDecorModBlocks.CRIMSON_BOOKSHELF.get() == (world.getBlockState(new BlockPos(x, y, z))).getBlock()
						|| OaksDecorModBlocks.DARK_OAK_BOOKSHELF.get() == (world.getBlockState(new BlockPos(x, y, z))).getBlock()
						|| OaksDecorModBlocks.JUNGLE_BOOKSHELF.get() == (world.getBlockState(new BlockPos(x, y, z))).getBlock()
						|| OaksDecorModBlocks.SPRUCE_BOOKSHELF.get() == (world.getBlockState(new BlockPos(x, y, z))).getBlock()
						|| OaksDecorModBlocks.WARPED_BOOKSHELF.get() == (world.getBlockState(new BlockPos(x, y, z))).getBlock())) {
			if (world instanceof Level _level && !_level.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BOOK));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof Level _level && !_level.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BOOK));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof Level _level && !_level.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BOOK));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
