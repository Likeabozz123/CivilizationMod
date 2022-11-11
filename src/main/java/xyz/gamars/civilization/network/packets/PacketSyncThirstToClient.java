package xyz.gamars.civilization.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.network.clientdata.ClientThirstData;

import java.util.function.Supplier;

public class PacketSyncThirstToClient {

    private final int thirst;

    public PacketSyncThirstToClient(int thirst) {
        this.thirst = thirst;
    }

    public PacketSyncThirstToClient(FriendlyByteBuf buf) {
        this.thirst = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(thirst);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are client side.
            // Be very careful not to access client-only classes here! (like Minecraft) because
            // this packet needs to be available server-side too
            ClientThirstData.set(thirst);
        });
        return true;
    }

}
