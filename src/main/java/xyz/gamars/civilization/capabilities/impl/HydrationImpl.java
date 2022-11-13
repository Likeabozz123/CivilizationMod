package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketSyncHydrationToClient;

public class HydrationImpl implements IImpl {

    public static final String NBT_KEY_HYDRATION = "hydration";
    private int hydration = 100;

    /**
     * Gets hydration.
     *
     * @return the hydration
     */
    public int getHydration() {
        return this.hydration;
    }

    /**
     * Sets hydration.
     *
     * @param hydration the hydration
     */
    public void setHydration(int hydration) {
        this.hydration = hydration;
    }

    /**
     * Sets hydration & sends a packet to update client side data
     *
     * @param thirst the thirst
     * @param player the player
     */
    public void setHydration(int thirst, ServerPlayer player) {
        this.hydration = thirst;
        NetworkHandler.sendToPlayer(new PacketSyncHydrationToClient(getHydration()), player);
    }


    /**
     * Add hydration.
     *
     * @param thirst the thirst
     */
    public void addHydration(int thirst) {
        if (this.hydration + thirst < 100) {
            this.hydration += thirst;
        } else {
            this.hydration = 100;
        }
    }


    /**
     * Add hydration & sends a packet to update client side data
     *
     * @param thirst the thirst
     * @param player the player
     */
    public void addHydration(int thirst, ServerPlayer player) {
        if (this.hydration + thirst < 100) {
            this.hydration += thirst;
        } else {
            this.hydration = 100;
        }
        NetworkHandler.sendToPlayer(new PacketSyncHydrationToClient(getHydration()), player);
    }

    /**
     * Reset hydration.
     */
    public void resetHydration() {
        this.hydration = 100;
    }


    /**
     * Reset hydration & sends a packet to update client side data
     *
     * @param player the player
     */
    public void resetHydration(ServerPlayer player) {
        this.hydration = 100;
        NetworkHandler.sendToPlayer(new PacketSyncHydrationToClient(getHydration()), player);
    }


    /**
     * Increment hydration.
     */
    public void incrementHydration() {
        hydration++;
    }


    /**
     * Increment hydration & sends a packet to update the client side data
     *
     * @param player the player
     */
    public void incrementHydration(ServerPlayer player) {
        hydration++;
        NetworkHandler.sendToPlayer(new PacketSyncHydrationToClient(getHydration()), player);
    }

    /**
     * Decrement hydration.
     */
    public void decrementHydration() {
        if(hydration > 0) {
            hydration--;
        }
    }


    /**
     * Decrement hydration & sends a packet to update the client side data
     *
     * @param player the player
     */
    public void decrementHydration(ServerPlayer player) {
        if(hydration > 0) {
            hydration--;
            NetworkHandler.sendToPlayer(new PacketSyncHydrationToClient(getHydration()), player);
        }
    }

    /**
     * Prints the player's current hydration
     * */
    @Override
    public void print(Player player) {
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Hydration: " + hydration);
    }

    /**
     * @return the string of how much hydration the player currently has
     * */
    @Override
    public String getText(Player player) {
        return player.getDisplayName().getString() + "'s Hydration: " + hydration;
    }

    /**
     * saves the hydration onto the player
     * */
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt(NBT_KEY_HYDRATION, hydration);
        return compoundTag;
    }

    /**
     * loads saved hydration back onto the player
     * */
    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        hydration = compoundTag.getInt(NBT_KEY_HYDRATION);
    }




}
