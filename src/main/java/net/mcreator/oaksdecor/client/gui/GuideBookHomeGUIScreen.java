
package net.mcreator.oaksdecor.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.oaksdecor.world.inventory.GuideBookHomeGUIMenu;
import net.mcreator.oaksdecor.network.OaksDecorModVariables;
import net.mcreator.oaksdecor.network.GuideBookHomeGUIButtonMessage;
import net.mcreator.oaksdecor.OaksDecorMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GuideBookHomeGUIScreen extends AbstractContainerScreen<GuideBookHomeGUIMenu> {
	private final static HashMap<String, Object> guistate = GuideBookHomeGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GuideBookHomeGUIScreen(GuideBookHomeGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 256;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("oaks_decor:textures/screens/guide_book_home_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Oaks Decor Guide", 4, 5, -12829636);
		this.font.draw(poseStack, "" + (OaksDecorModVariables.MapVariables.get(world).version) + "", 220, 7, -12779776);
		this.font.draw(poseStack, "Mod Created:", 10, 16, -12829636);
		this.font.draw(poseStack, "Feb 13, 2022", 82, 16, -12829636);
		this.font.draw(poseStack, "Last Updated:", 10, 25, -12829636);
		this.font.draw(poseStack, "Jan 22, 2023", 82, 25, -12829636);
		this.font.draw(poseStack, "YouTube.com/c/ContinuedOak", 10, 52, -12829636);
		this.font.draw(poseStack, "Twitter.com/continuedOak", 10, 43, -12829636);
		this.font.draw(poseStack, "Mod:", 199, 7, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 79, 67, 20, Component.literal("Gamerules"), e -> {
			if (true) {
				OaksDecorMod.PACKET_HANDLER.sendToServer(new GuideBookHomeGUIButtonMessage(0, x, y, z));
				GuideBookHomeGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 106, 67, 20, Component.literal("Coming"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 133, 67, 20, Component.literal("Soon"), e -> {
		}));
	}
}
