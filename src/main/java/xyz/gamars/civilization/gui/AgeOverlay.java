package xyz.gamars.civilization.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import xyz.gamars.civilization.network.data.ClientAgeData;
import xyz.gamars.civilization.network.data.ClientTempData;


public class AgeOverlay implements IGuiOverlay {

    @Override
    public void render(ForgeGui gui, PoseStack poseStack, float partialTick, int width, int height) {
        String age = "Age: " + ClientAgeData.getAge();
        String temperature = "Temperature: " + ClientTempData.getTemperature();
        int x = 10;
        int y = 10;
        gui.getFont().draw(poseStack, age, x, y, 0xffffffff);
        gui.getFont().draw(poseStack, temperature, x, (y * 2) + 2, 0xffffffff);
    }
}
