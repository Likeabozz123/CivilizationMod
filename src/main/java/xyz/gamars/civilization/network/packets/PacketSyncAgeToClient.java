package xyz.gamars.civilization.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.network.data.ClientAgeData;

import java.util.function.Supplier;

public class PacketSyncAgeToClient {

    private final int age;

    public PacketSyncAgeToClient(int age) {
        this.age = age;
    }

    public PacketSyncAgeToClient(FriendlyByteBuf buf) {
        this.age = buf.readInt();
    }


    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(age);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are client side.
            // Be very careful not to access client-only classes here! (like Minecraft) because
            // this packet needs to be available server-side too
            ClientAgeData.set(age);
        });
        return true;
    }
}
