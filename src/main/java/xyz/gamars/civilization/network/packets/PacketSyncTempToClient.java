package xyz.gamars.civilization.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.network.data.ClientTempData;

import java.util.function.Supplier;

public class PacketSyncTempToClient {

    private final double temperature;

    public PacketSyncTempToClient(double temperature) {
        this.temperature = temperature;
    }

    public PacketSyncTempToClient(FriendlyByteBuf buf) {
        this.temperature = buf.readDouble();
    }


    public void toBytes(FriendlyByteBuf buf) {
        buf.writeDouble(temperature);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are client side.
            // Be very careful not to access client-only classes here! (like Minecraft) because
            // this packet needs to be available server-side too
            ClientTempData.set(temperature);
        });
        return true;
    }


}
