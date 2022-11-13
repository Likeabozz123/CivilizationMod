package xyz.gamars.civilization.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.RequestOpenInteractionScreen;
import xyz.gamars.civilization.objects.entities.CivMob;

/* npc screen that displays when interacting with a npc */
public class NPCScreen extends Screen {

    private Player player;
    private CivMob civMob;

/*  DEPRECATED
    public NPCScreen() {
        super(Component.translatable("screen." + Civilization.MOD_ID + ".main_interaction"));
    }
*/

    public NPCScreen(Player player, CivMob civMob) {
        super(Component.translatable("screen." + Civilization.MOD_ID + ".main_interaction"));
        this.player = player;
        this.civMob = civMob;
    }

    @Override
    protected void init() {

        /* buttons for the npc screen */
        addRenderableWidget(new Button(555, 10, 80, 20, Component.literal("Interact"), button -> {
            // OPEN INTERACTION SCREEN
            openInteractionMenu();
            if (civMob != null) {
                civMob.setTalkingPlayer(player);
            }
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
            // setStayAtPosition(false);
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

    /* when the screen is closed */
    @Override
    public void removed() {
        super.removed();
        if (civMob != null) {
            this.civMob.setTalkingPlayer(null);
            System.out.println("No longer talking to player");
        }
    }

    /* opens the interaction menu with the mob and player  */
    public void openInteractionMenu() {
        // getMinecraft().setScreen(new InteractionScreen(this.player, this.civMob));
        NetworkHandler.sendToServer(new RequestOpenInteractionScreen(this.player, this.civMob));
    }

    /* prevents the game from pausing when interacting with npc */
    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
