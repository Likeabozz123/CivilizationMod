package xyz.gamars.civilization.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.capabilities.CivCapabilities;

import java.util.function.Supplier;

public class PacketPrintAge {

    public PacketPrintAge() {

    }

    public PacketPrintAge(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are server side
            ServerPlayer player = ctx.getSender();
            player.getCapability(CivCapabilities.AGE).ifPresent(age -> {
                age.print(player);
            });
        });
        return true;
    }
}
