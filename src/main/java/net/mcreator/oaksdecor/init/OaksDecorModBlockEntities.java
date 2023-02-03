
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oaksdecor.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.oaksdecor.block.entity.WarpedDrawsOpenBlockEntity;
import net.mcreator.oaksdecor.block.entity.WarpedDrawsClosedBlockEntity;
import net.mcreator.oaksdecor.block.entity.WarpedCrateBlockEntity;
import net.mcreator.oaksdecor.block.entity.SpruceDrawsOpenBlockEntity;
import net.mcreator.oaksdecor.block.entity.SpruceDrawsClosedBlockEntity;
import net.mcreator.oaksdecor.block.entity.SpruceCrateBlockEntity;
import net.mcreator.oaksdecor.block.entity.OakDrawsOpenBlockEntity;
import net.mcreator.oaksdecor.block.entity.OakDrawsClosedBlockEntity;
import net.mcreator.oaksdecor.block.entity.OakCrateBlockEntity;
import net.mcreator.oaksdecor.block.entity.MangroveDrawsOpenBlockEntity;
import net.mcreator.oaksdecor.block.entity.MangroveDrawsClosedBlockEntity;
import net.mcreator.oaksdecor.block.entity.MangroveCrateBlockEntity;
import net.mcreator.oaksdecor.block.entity.JungleDrawsOpenBlockEntity;
import net.mcreator.oaksdecor.block.entity.JungleCrateBlockEntity;
import net.mcreator.oaksdecor.block.entity.DarkOakCrateBlockEntity;
import net.mcreator.oaksdecor.block.entity.CrimsonDrawsOpenBlockEntity;
import net.mcreator.oaksdecor.block.entity.CrimsonDrawsClosedBlockEntity;
import net.mcreator.oaksdecor.block.entity.CrimsonCrateBlockEntity;
import net.mcreator.oaksdecor.block.entity.BirchDrawsOpenBlockEntity;
import net.mcreator.oaksdecor.block.entity.BirchDrawsClosedBlockEntity;
import net.mcreator.oaksdecor.block.entity.BirchCrateBlockEntity;
import net.mcreator.oaksdecor.block.entity.AcaciaDrawsOpenBlockEntity;
import net.mcreator.oaksdecor.block.entity.AcaciaDrawsClosedBlockEntity;
import net.mcreator.oaksdecor.block.entity.AcaciaCrateBlockEntity;
import net.mcreator.oaksdecor.OaksDecorMod;

public class OaksDecorModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
			OaksDecorMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_DRAWS_CLOSED = register("acacia_draws_closed",
			OaksDecorModBlocks.ACACIA_DRAWS_CLOSED, AcaciaDrawsClosedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_DRAWS_CLOSED = register("birch_draws_closed", OaksDecorModBlocks.BIRCH_DRAWS_CLOSED,
			BirchDrawsClosedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> OAK_DRAWS_CLOSED = register("oak_draws_closed", OaksDecorModBlocks.OAK_DRAWS_CLOSED,
			OakDrawsClosedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_DRAWS_CLOSED = register("warped_draws_closed",
			OaksDecorModBlocks.WARPED_DRAWS_CLOSED, WarpedDrawsClosedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_DRAWS_CLOSED = register("spruce_draws_closed",
			OaksDecorModBlocks.SPRUCE_DRAWS_CLOSED, SpruceDrawsClosedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_DRAWS_OPEN = register("spruce_draws_open", OaksDecorModBlocks.SPRUCE_DRAWS_OPEN,
			SpruceDrawsOpenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_DRAWS_CLOSED = register("crimson_draws_closed",
			OaksDecorModBlocks.CRIMSON_DRAWS_CLOSED, CrimsonDrawsClosedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_CRATE = register("acacia_crate", OaksDecorModBlocks.ACACIA_CRATE,
			AcaciaCrateBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_CRATE = register("birch_crate", OaksDecorModBlocks.BIRCH_CRATE,
			BirchCrateBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_CRATE = register("crimson_crate", OaksDecorModBlocks.CRIMSON_CRATE,
			CrimsonCrateBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DARK_OAK_CRATE = register("dark_oak_crate", OaksDecorModBlocks.DARK_OAK_CRATE,
			DarkOakCrateBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_CRATE = register("jungle_crate", OaksDecorModBlocks.JUNGLE_CRATE,
			JungleCrateBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_CRATE = register("mangrove_crate", OaksDecorModBlocks.MANGROVE_CRATE,
			MangroveCrateBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> OAK_CRATE = register("oak_crate", OaksDecorModBlocks.OAK_CRATE, OakCrateBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_CRATE = register("spruce_crate", OaksDecorModBlocks.SPRUCE_CRATE,
			SpruceCrateBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_CRATE = register("warped_crate", OaksDecorModBlocks.WARPED_CRATE,
			WarpedCrateBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_DRAWS_OPEN = register("acacia_draws_open", OaksDecorModBlocks.ACACIA_DRAWS_OPEN,
			AcaciaDrawsOpenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_DRAWS_OPEN = register("birch_draws_open", OaksDecorModBlocks.BIRCH_DRAWS_OPEN,
			BirchDrawsOpenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_DRAWS_OPEN = register("crimson_draws_open", OaksDecorModBlocks.CRIMSON_DRAWS_OPEN,
			CrimsonDrawsOpenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_DRAWS_OPEN = register("jungle_draws_open", OaksDecorModBlocks.JUNGLE_DRAWS_OPEN,
			JungleDrawsOpenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_DRAWS_OPEN = register("warped_draws_open", OaksDecorModBlocks.WARPED_DRAWS_OPEN,
			WarpedDrawsOpenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> OAK_DRAWS_OPEN = register("oak_draws_open", OaksDecorModBlocks.OAK_DRAWS_OPEN,
			OakDrawsOpenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_DRAWS_CLOSED = register("mangrove_draws_closed",
			OaksDecorModBlocks.MANGROVE_DRAWS_CLOSED, MangroveDrawsClosedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_DRAWS_OPEN = register("mangrove_draws_open",
			OaksDecorModBlocks.MANGROVE_DRAWS_OPEN, MangroveDrawsOpenBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
