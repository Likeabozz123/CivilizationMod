package xyz.gamars.civilization.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.data.ClientAgeData;
import xyz.gamars.civilization.network.packets.PacketSyncAgeToClient;


public class AgeOverlay implements IGuiOverlay{

    @Override
    public void render(ForgeGui gui, PoseStack poseStack, float partialTick, int width, int height) {
        String toDisplay = "Age: " + ClientAgeData.getAge();
        int x = 10;
        int y = 10;
        gui.getFont().draw(poseStack, toDisplay, x, y, 0xffffffff);
    }
}
