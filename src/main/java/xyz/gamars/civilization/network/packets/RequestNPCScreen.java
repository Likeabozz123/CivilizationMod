package xyz.gamars.civilization.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.objects.entities.CivMob;

import java.util.function.Supplier;

public class RequestNPCScreen {

    private Player player;
    private CivMob civMob;

    public RequestNPCScreen(Player player, CivMob civMob) {
        this.player = player;
        this.civMob = civMob;
    }

    public RequestNPCScreen(FriendlyByteBuf buf) {

    }


    public void toBytes(FriendlyByteBuf buf) {

    }


    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are server side.
            // Be very careful not to access server-only classes here! because
            // this packet needs to be available client-side too

            NetworkHandler.sendToPlayer(new PacketOpenNPCScreen(player, civMob), ctx.getSender());
        });
        return true;
    }

}
