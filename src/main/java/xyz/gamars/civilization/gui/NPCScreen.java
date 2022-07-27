package xyz.gamars.civilization.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.objects.entities.CivMob;

public class NPCScreen extends Screen {

    private Player player;
    private CivMob civMob;

    public NPCScreen() {
        super(Component.translatable("screen." + Civilization.MOD_ID + ".main_interaction"));
    } // ONLY HERE FOR DEV PURPOSES GET RID OF LATER, AND USE THE OTHER CONSTRUCTOR WITH THE PARAMETERS TO PROPERLY CREATE LOGIC

    public NPCScreen(Player player, CivMob civMob) {
        super(Component.translatable("screen." + Civilization.MOD_ID + ".main_interaction"));
        this.player = player;
        this.civMob = civMob;
    }

    @Override
    protected void init() {

        addRenderableWidget(new Button(555, 10, 80, 20, Component.literal("Interact"), button -> {
            // OPEN INTERACTION SCREEN
            openInteractionMenu(player, civMob);
            civMob.setTalkingPlayer(player);
        }));
        addRenderableWidget(new Button(555, 32, 80, 20, Component.literal("Follow Me"), button -> {
            // CODE HERE
            // followPlayer(this.player); // entity follows player
        }));
        addRenderableWidget(new Button(555, 54, 80, 20, Component.literal("Stay Here"), button -> {
            // CODE HERE
            // setStayAtPosition(true);
        }));
        addRenderableWidget(new Button(555, 76, 80, 20, Component.literal("Move Freely"), button -> {
            // CODE HERE
            // setStayAtPosition(true);
        }));
        addRenderableWidget(new Button(555, 98, 80, 20, Component.literal("Trade"), button -> {
            // CODE HERE
            // openTradeMenu();
        }));
        addRenderableWidget(new Button(555, 120, 80, 20, Component.literal("Set Home"), button -> {
            // CODE HERE
            // setHomeAtLoc();
        }));
        addRenderableWidget(new Button(555, 142, 80, 20, Component.literal("Special"), button -> {
            // CODE HERE
            // openSpecialMenu();
        }));


    }

    @Override
    public void removed() {
        super.removed();
        this.civMob.setTalkingPlayer(null);
    }



    public void openInteractionMenu(Player player, CivMob civMob) {
        minecraft.setScreen(new InteractionScreen(player, civMob));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
