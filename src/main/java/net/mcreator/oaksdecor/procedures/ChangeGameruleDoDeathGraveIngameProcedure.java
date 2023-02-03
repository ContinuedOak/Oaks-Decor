package net.mcreator.oaksdecor.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.oaksdecor.init.OaksDecorModGameRules;

public class ChangeGameruleDoDeathGraveIngameProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(OaksDecorModGameRules.DODEATHGRAVE) == true) {
			GraveTrueProcedure.execute(world, entity);
		} else if (world.getLevelData().getGameRules().getBoolean(OaksDecorModGameRules.DODEATHGRAVE) == false) {
			GraveFalseProcedure.execute(world, entity);
		}
	}
}
