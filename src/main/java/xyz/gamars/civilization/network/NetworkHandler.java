package xyz.gamars.civilization.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.network.packets.*;

public class NetworkHandler {

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }
    private static final String PROTOCOL_VERSION = "1.0";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Civilization.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register() {

        /* print age packet */
        INSTANCE.messageBuilder(PacketPrintAge.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PacketPrintAge::new)
                .encoder(PacketPrintAge::toBytes)
                .consumerMainThread(PacketPrintAge::handle)
                .add();

        /* registers syncing packets */
        INSTANCE.messageBuilder(PacketSyncAgeToClient.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PacketSyncAgeToClient::new)
                .encoder(PacketSyncAgeToClient::toBytes)
                .consumerMainThread(PacketSyncAgeToClient::handle)
                .add();
        INSTANCE.messageBuilder(PacketSyncTempToClient.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PacketSyncTempToClient::new)
                .encoder(PacketSyncTempToClient::toBytes)
                .consumerMainThread(PacketSyncTempToClient::handle)
                .add();
        INSTANCE.messageBuilder(PacketSyncStatsToClient.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PacketSyncStatsToClient::new)
                .encoder(PacketSyncStatsToClient::toBytes)
                .consumerMainThread(PacketSyncStatsToClient::handle)
                .add();
        INSTANCE.messageBuilder(PacketSyncTribeToClient.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PacketSyncTribeToClient::new)
                .encoder(PacketSyncTribeToClient::toBytes)
                .consumerMainThread(PacketSyncTribeToClient::handle)
                .add();
        INSTANCE.messageBuilder(PacketSyncThirstToClient.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PacketSyncThirstToClient::new)
                .encoder(PacketSyncThirstToClient::toBytes)
                .consumerMainThread(PacketSyncThirstToClient::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    /* sends a packet to the player */
    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
