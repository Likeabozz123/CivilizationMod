package xyz.gamars.civilization.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.network.data.ClientStatsData;

import java.util.function.Supplier;

public class PacketSyncStatsToClient {

    private final int maxHealth;
    private final int intelligence;
    private final int wisdom;
    private final int racism;
    private final int charisma;
    private final int strength;
    private final int speed;
    private final int stamina;
    private final String gender;

    public PacketSyncStatsToClient(int maxHealth, int intelligence, int wisdom, int racism, int charisma, int strength, int speed, int stamina, String gender) {
        this.maxHealth = maxHealth;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.racism = racism;
        this.charisma = charisma;
        this.strength = strength;
        this.speed = speed;
        this.stamina = stamina;
        this.gender = gender;
    }

    public PacketSyncStatsToClient(FriendlyByteBuf buf) {
        this.maxHealth = buf.readInt();
        this.intelligence = buf.readInt();
        this.wisdom = buf.readInt();
        this.racism = buf.readInt();
        this.charisma = buf.readInt();
        this.strength = buf.readInt();
        this.speed = buf.readInt();
        this.stamina = buf.readInt();
        this.gender = buf.readUtf();
    }


    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(maxHealth);
        buf.writeInt(intelligence);
        buf.writeInt(wisdom);
        buf.writeInt(racism);
        buf.writeInt(charisma);
        buf.writeInt(strength);
        buf.writeInt(speed);
        buf.writeInt(stamina);
        buf.writeUtf(gender);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are client side.
            // Be very careful not to access client-only classes here! (like Minecraft) because
            // this packet needs to be available server-side too
            ClientStatsData.set(maxHealth, intelligence, wisdom, racism, charisma, strength, speed, stamina, gender);
        });
        return true;
    }
}
