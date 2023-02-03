
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oaksdecor.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.oaksdecor.world.inventory.GuideBookHomeGUIMenu;
import net.mcreator.oaksdecor.world.inventory.GoatHornDisplayMenu;
import net.mcreator.oaksdecor.world.inventory.GameRuleGUIMenu;
import net.mcreator.oaksdecor.world.inventory.DrawsMenu;
import net.mcreator.oaksdecor.world.inventory.CrateUIMenu;
import net.mcreator.oaksdecor.OaksDecorMod;

public class OaksDecorModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, OaksDecorMod.MODID);
	public static final RegistryObject<MenuType<DrawsMenu>> DRAWS = REGISTRY.register("draws", () -> IForgeMenuType.create(DrawsMenu::new));
	public static final RegistryObject<MenuType<GuideBookHomeGUIMenu>> GUIDE_BOOK_HOME_GUI = REGISTRY.register("guide_book_home_gui",
			() -> IForgeMenuType.create(GuideBookHomeGUIMenu::new));
	public static final RegistryObject<MenuType<GameRuleGUIMenu>> GAME_RULE_GUI = REGISTRY.register("game_rule_gui",
			() -> IForgeMenuType.create(GameRuleGUIMenu::new));
	public static final RegistryObject<MenuType<CrateUIMenu>> CRATE_UI = REGISTRY.register("crate_ui", () -> IForgeMenuType.create(CrateUIMenu::new));
	public static final RegistryObject<MenuType<GoatHornDisplayMenu>> GOAT_HORN_DISPLAY = REGISTRY.register("goat_horn_display",
			() -> IForgeMenuType.create(GoatHornDisplayMenu::new));
}
