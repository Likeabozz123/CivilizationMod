package xyz.gamars.civilization.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import xyz.gamars.civilization.Civilization;

public class TestGui extends Screen {

    public TestGui() {
        super(Component.translatable("screen." + Civilization.MOD_ID + ".menu"));
    }

    @Override
    protected void init() {
        int x = this.width / 2;
        int y = this.height / 2;

        addRenderableWidget(new Button(0, 0, 160, 20, Component.literal("Test Button"), button -> System.out.println("Pressed Button")));
    }

    public static void open() {
        Minecraft.getInstance().setScreen(new TestGui());
    }
}
