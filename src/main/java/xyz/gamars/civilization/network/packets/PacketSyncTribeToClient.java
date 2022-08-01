package xyz.gamars.civilization.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.network.data.ClientTribeData;

import java.util.function.Supplier;

public class PacketSyncTribeToClient {

    private final String tribeName;

    public PacketSyncTribeToClient(String tribeName) {
        this.tribeName = tribeName;
    }

    public PacketSyncTribeToClient(FriendlyByteBuf buf) {
        this.tribeName = buf.readUtf();
    }


    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(tribeName);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are client side.
            // Be very careful not to access client-only classes here! (like Minecraft) because
            // this packet needs to be available server-side too
            ClientTribeData.set(tribeName);
        });
        return true;
    }


}
