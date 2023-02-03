package net.mcreator.oaksdecor.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.oaksdecor.network.OaksDecorModVariables;
import net.mcreator.oaksdecor.init.OaksDecorModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Cake10kProProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level, event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (OaksDecorModVariables.WorldVariables.get(world).Cake == true) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(OaksDecorModBlocks.CAKE_10_K.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			OaksDecorModVariables.WorldVariables.get(world).Cake = false;
			OaksDecorModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
