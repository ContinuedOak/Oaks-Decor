
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oaksdecor.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.oaksdecor.client.gui.GuideBookHomeGUIScreen;
import net.mcreator.oaksdecor.client.gui.GoatHornDisplayScreen;
import net.mcreator.oaksdecor.client.gui.GameRuleGUIScreen;
import net.mcreator.oaksdecor.client.gui.DrawsScreen;
import net.mcreator.oaksdecor.client.gui.CrateUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OaksDecorModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(OaksDecorModMenus.DRAWS.get(), DrawsScreen::new);
			MenuScreens.register(OaksDecorModMenus.GUIDE_BOOK_HOME_GUI.get(), GuideBookHomeGUIScreen::new);
			MenuScreens.register(OaksDecorModMenus.GAME_RULE_GUI.get(), GameRuleGUIScreen::new);
			MenuScreens.register(OaksDecorModMenus.CRATE_UI.get(), CrateUIScreen::new);
			MenuScreens.register(OaksDecorModMenus.GOAT_HORN_DISPLAY.get(), GoatHornDisplayScreen::new);
		});
	}
}
