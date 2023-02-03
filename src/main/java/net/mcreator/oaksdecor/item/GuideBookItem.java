
package net.mcreator.oaksdecor.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.oaksdecor.procedures.OpenGuideBookProcedure;
import net.mcreator.oaksdecor.init.OaksDecorModTabs;

public class GuideBookItem extends Item {
	public GuideBookItem() {
		super(new Item.Properties().tab(OaksDecorModTabs.TAB_OAKS_DECOR).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		OpenGuideBookProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}
