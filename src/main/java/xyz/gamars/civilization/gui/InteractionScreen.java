package xyz.gamars.civilization.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.objects.entities.CivMob;

/* screen for interacting with npc */
public class InteractionScreen extends Screen {

    private Player player;
    private CivMob civMob;

    public InteractionScreen(Player player, CivMob civMob) {
        super(Component.translatable("screen." + Civilization.MOD_ID + ".interaction"));
        this.player = player;
        this.civMob = civMob;
    }

    @Override
    protected void init() {
        addRenderableWidget(new Button(555, 10, 80, 20, Component.literal("Chat"), button -> {
            // CODE HERE
            // calculate chance of chat "landing" on the npc, ex if the interaction goes positive or not based on other factors
            // send npc feedback to player depending on response of the chat message
            // increase or decrease reputation with npc
            // save reputation to the npc itself, with capabilities and save based on player uuid
        }));
        addRenderableWidget(new Button(555, 32, 80, 20, Component.literal("Joke"), button -> {
            // CODE HERE
        }));
        addRenderableWidget(new Button(555, 54, 80, 20, Component.literal("Gift"), button -> {
            // CODE HERE
        }));
        addRenderableWidget(new Button(555, 76, 80, 20, Component.literal("Shake Hand"), button -> {
            // CODE HERE
        }));
        addRenderableWidget(new Button(555, 98, 80, 20, Component.literal("Tell Story"), button -> {
            // CODE HERE
        }));
        addRenderableWidget(new Button(555, 120, 80, 20, Component.literal("Flirt"), button -> {
            // CODE HERE
        }));
        addRenderableWidget(new Button(555, 142, 80, 20, Component.literal("Hug"), button -> {
            // CODE HERE
        }));
        addRenderableWidget(new Button(555, 164, 80, 20, Component.literal("Kiss"), button -> {
            // CODE HERE
        }));
    }

    @Override
    public void removed() {
        super.removed();
        if(this.civMob != null) {
            this.civMob.setTalkingPlayer(null);
        }
    }

}
