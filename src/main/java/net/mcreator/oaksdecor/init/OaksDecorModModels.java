
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oaksdecor.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.oaksdecor.client.model.Modelseat;
import net.mcreator.oaksdecor.client.model.Modelminecart;
import net.mcreator.oaksdecor.client.model.ModelKAtiesHat;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class OaksDecorModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelseat.LAYER_LOCATION, Modelseat::createBodyLayer);
		event.registerLayerDefinition(Modelminecart.LAYER_LOCATION, Modelminecart::createBodyLayer);
		event.registerLayerDefinition(ModelKAtiesHat.LAYER_LOCATION, ModelKAtiesHat::createBodyLayer);
	}
}
