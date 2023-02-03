
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oaksdecor.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.oaksdecor.OaksDecorMod;

public class OaksDecorModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, OaksDecorMod.MODID);
	public static final RegistryObject<SoundEvent> DRAWS_CLOSED = REGISTRY.register("draws_closed",
			() -> new SoundEvent(new ResourceLocation("oaks_decor", "draws_closed")));
	public static final RegistryObject<SoundEvent> DRAWS_OPEN = REGISTRY.register("draws_open",
			() -> new SoundEvent(new ResourceLocation("oaks_decor", "draws_open")));
	public static final RegistryObject<SoundEvent> COMPLETED_TASK = REGISTRY.register("completed_task",
			() -> new SoundEvent(new ResourceLocation("oaks_decor", "completed_task")));
	public static final RegistryObject<SoundEvent> ALARM_CLOCK_ON = REGISTRY.register("alarm_clock_on",
			() -> new SoundEvent(new ResourceLocation("oaks_decor", "alarm_clock_on")));
}
