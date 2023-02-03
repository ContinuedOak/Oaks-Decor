package net.mcreator.oaksdecor.procedures;

import net.minecraft.world.entity.Entity;

public class MinecratRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		sourceentity.startRiding(entity);
	}
}
