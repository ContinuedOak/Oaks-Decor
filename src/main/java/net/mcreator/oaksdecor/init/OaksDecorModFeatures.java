
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oaksdecor.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.oaksdecor.world.features.plants.SittingSkeletonUnusedFeature;
import net.mcreator.oaksdecor.world.features.plants.SandCastleFeature;
import net.mcreator.oaksdecor.world.features.plants.Pebbles2Feature;
import net.mcreator.oaksdecor.world.features.plants.Pebbles1Feature;
import net.mcreator.oaksdecor.world.features.ores.WarpedBlackstoneBricksFeature;
import net.mcreator.oaksdecor.world.features.ores.TrappedSculkJawsFeature;
import net.mcreator.oaksdecor.world.features.ores.NetherrackBricksFeature;
import net.mcreator.oaksdecor.world.features.ores.CrimsonBlackstoneBricksFeature;
import net.mcreator.oaksdecor.OaksDecorMod;

@Mod.EventBusSubscriber
public class OaksDecorModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, OaksDecorMod.MODID);
	public static final RegistryObject<Feature<?>> CRIMSON_BLACKSTONE_BRICKS = REGISTRY.register("crimson_blackstone_bricks",
			CrimsonBlackstoneBricksFeature::feature);
	public static final RegistryObject<Feature<?>> WARPED_BLACKSTONE_BRICKS = REGISTRY.register("warped_blackstone_bricks",
			WarpedBlackstoneBricksFeature::feature);
	public static final RegistryObject<Feature<?>> NETHERRACK_BRICKS = REGISTRY.register("netherrack_bricks", NetherrackBricksFeature::feature);
	public static final RegistryObject<Feature<?>> TRAPPED_SCULK_JAWS = REGISTRY.register("trapped_sculk_jaws", TrappedSculkJawsFeature::feature);
	public static final RegistryObject<Feature<?>> SKELETON_TRAPS = REGISTRY.register("skeleton_traps", SittingSkeletonUnusedFeature::feature);
	public static final RegistryObject<Feature<?>> PEBBLES_1 = REGISTRY.register("pebbles_1", Pebbles1Feature::feature);
	public static final RegistryObject<Feature<?>> PEBBLES_2 = REGISTRY.register("pebbles_2", Pebbles2Feature::feature);
	public static final RegistryObject<Feature<?>> SAND_CASTLE = REGISTRY.register("sand_castle", SandCastleFeature::feature);
}
