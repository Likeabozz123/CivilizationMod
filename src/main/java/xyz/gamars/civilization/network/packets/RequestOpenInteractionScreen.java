package xyz.gamars.civilization.network.packets;

import com.google.common.graph.Network;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.gui.InteractionScreen;
import xyz.gamars.civilization.gui.NPCScreen;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.objects.entities.CivMob;

import java.util.function.Supplier;

public class RequestOpenInteractionScreen {

    private Player player;
    private CivMob civMob;

    public RequestOpenInteractionScreen(Player player, CivMob civMob) {
        this.player = player;
        this.civMob = civMob;
    }

    public RequestOpenInteractionScreen(FriendlyByteBuf buf) {

    }


    public void toBytes(FriendlyByteBuf buf) {

    }


    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are server side.
            // Be very careful not to access server-only classes here! because
            // this packet needs to be available client-side too

            NetworkHandler.sendToPlayer(new PacketOpenInteractionScreen(player, civMob), ctx.getSender());
        });
        return true;
    }

}
