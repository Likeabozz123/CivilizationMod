package xyz.gamars.civilization.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.network.clientdata.ClientHydrationData;

import java.util.function.Supplier;

public class PacketSyncHydrationToClient {

    private final int hydration;

    public PacketSyncHydrationToClient(int hydration) {
        this.hydration = hydration;
    }

    public PacketSyncHydrationToClient(FriendlyByteBuf buf) {
        this.hydration = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(hydration);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are client side.
            // Be very careful not to access client-only classes here! (like Minecraft) because
            // this packet needs to be available server-side too
            ClientHydrationData.set(hydration);
        });
        return true;
    }

}
