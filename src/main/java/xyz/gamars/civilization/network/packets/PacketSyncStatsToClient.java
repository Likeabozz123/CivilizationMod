package xyz.gamars.civilization.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import xyz.gamars.civilization.capabilities.impl.StatImpl;
import xyz.gamars.civilization.network.clientdata.ClientStatsData;

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

    public PacketSyncStatsToClient(StatImpl stat) {
        this.maxHealth = stat.getMaxHealth();
        this.intelligence = stat.getIntelligence();
        this.wisdom = stat.getWisdom();
        this.racism = stat.getWisdom();
        this.charisma = stat.getCharisma();
        this.strength = stat.getStrength();
        this.speed = stat.getSpeed();
        this.stamina = stat.getStamina();
        this.gender = stat.getGender();
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
