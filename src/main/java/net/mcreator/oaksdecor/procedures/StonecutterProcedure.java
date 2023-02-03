package net.mcreator.oaksdecor.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

import net.mcreator.oaksdecor.init.OaksDecorModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StonecutterProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(OaksDecorModGameRules.DOESSTONECUTTERHURT) == true) {
			if (!(entity instanceof Villager)) {
				if ((world.getBlockState(new BlockPos(x, y - 0.5, z))).getBlock() == Blocks.STONECUTTER) {
					if (entity instanceof LivingEntity _entity)
						_entity.hurt(new DamageSource("stonecutter").bypassArmor(), 4);
				}
			}
		}
	}
}
