package xyz.gamars.civilization.network.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.gui.InteractionScreen;
import xyz.gamars.civilization.objects.entities.CivMob;

import java.util.function.Supplier;

public class PacketOpenInteractionScreen {

    private Player player;
    private CivMob civMob;

    public PacketOpenInteractionScreen(Player player, CivMob civMob) {
        this.player = player;
        this.civMob = civMob;
    }

    public PacketOpenInteractionScreen(FriendlyByteBuf buf) {

    }


    public void toBytes(FriendlyByteBuf buf) {

    }


    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are client side.
            // Be very careful not to access client-only classes here! (like Minecraft) because
            // this packet needs to be available client-side too
            DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> PacketOpenInteractionScreen.openScreen(player, civMob));

        });
        ctx.setPacketHandled(true);
        return true;
    }

    public static DistExecutor.SafeRunnable openScreen(Player player, CivMob civMob) {

        return new DistExecutor.SafeRunnable() {
            @Override
            public void run() {
                Minecraft.getInstance().setScreen(new InteractionScreen(player, civMob));

            }
        };
    }

}
