package xyz.gamars.civilization.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.objects.gui.CustomImageButton;

public class TestGui extends Screen {

    public TestGui() {
        super(Component.translatable("screen." + Civilization.MOD_ID + ".menu"));
    }

    @Override
    protected void init() {
        int width = this.width;
        int height = this.height;
        int x = this.width / 2;
        int y = this.height / 2;

        addRenderableWidget(new CustomImageButton(0, 0, 200, 30, 0, 0, 30, Component.literal("Test Button"), new ResourceLocation(Civilization.MOD_ID, "textures/gui/test_gui/widgets.png"), 200, 60, pButton -> System.out.println("Pressed Button")));
        // addRenderableOnly(new ImageButton(0, 50, 128, 128, 0, 0, 0, new ResourceLocation(Civilization.MOD_ID, "textures/gui/test_gui/emoji.png"), 128, 128, button -> {}));

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public static void open() {
        Minecraft.getInstance().setScreen(new TestGui());
    }
}
