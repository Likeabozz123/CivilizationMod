package xyz.gamars.civilization.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import xyz.gamars.civilization.network.clientdata.ClientAgeData;
import xyz.gamars.civilization.network.clientdata.ClientTempData;
import xyz.gamars.civilization.network.clientdata.ClientHydrationData;

/* stats overlay */
public class StatsOverlay implements IGuiOverlay {

    /* renders their stats and displays them in the top left corner */
    @Override
    public void render(ForgeGui gui, PoseStack poseStack, float partialTick, int width, int height) {
        String age = "Age: " + ClientAgeData.getAge();
        String temperature = "Temperature: " + ClientTempData.getTemperature();
        String hydration = "Hydration: " + ClientHydrationData.getHydration();
        int x = 10;
        int y = 10;
        gui.getFont().draw(poseStack, age, x, y, 0xffffffff);
        gui.getFont().draw(poseStack, temperature, x, (y * 2) + 2, 0xffffffff);
        gui.getFont().draw(poseStack, hydration, x, (y * 3) + 2, 0xffffffff);
    }
}
