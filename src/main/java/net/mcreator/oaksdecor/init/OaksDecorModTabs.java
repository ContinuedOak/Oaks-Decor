
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oaksdecor.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class OaksDecorModTabs {
	public static CreativeModeTab TAB_OAKS_DECOR;
	public static CreativeModeTab TAB_FURNITURE;

	public static void load() {
		TAB_OAKS_DECOR = new CreativeModeTab("taboaks_decor") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(OaksDecorModBlocks.ACACIA_BOOKSHELF.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_FURNITURE = new CreativeModeTab("tabfurniture") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(OaksDecorModBlocks.MANGROVE_CHAIR.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
