
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oaksdecor.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OaksDecorModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DODEATHGRAVE = GameRules.register("doDeathGrave", GameRules.Category.PLAYER,
			GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> ONEKPARTY = GameRules.register("oneKParty", GameRules.Category.DROPS,
			GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> UPDATETEXT = GameRules.register("updateText", GameRules.Category.UPDATES,
			GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> DOESSTONECUTTERHURT = GameRules.register("doesStonecutterHurt",
			GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
}
