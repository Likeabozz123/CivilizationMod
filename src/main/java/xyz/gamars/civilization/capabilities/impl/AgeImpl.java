package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.HelperMethods;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketSyncAgeToClient;

public class AgeImpl implements IImpl {

    private final int AGE_LIMIT = 100;
    private final int AGE_MIN = 50;

    public static final String NBT_KEY_AGE = "age";
    public static final String NBT_KEY_MAX_AGE = "max_age";
    public static final String NBT_KEY_DAYS_PASSED = "days_passed"; // todo save the amount of days passed
    private int age = 1;
    private int maxAge = HelperMethods.generateRandomNum(AGE_MIN, AGE_LIMIT);

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets age & sends a packet to update the client side data
     *
     * @param age    the age
     * @param player the player
     */
    public void setAge(int age, ServerPlayer player) {
        this.age = age;
        NetworkHandler.sendToPlayer(new PacketSyncAgeToClient(getAge()), player);
    }

    /**
     * Add age.
     *
     * @param age the age
     */
    public void addAge(int age) {
        this.age += age;
    }

    /**
     * Add age & sends a packet to update the client side data
     *
     * @param age    the age
     * @param player the player
     */
    public void addAge(int age, ServerPlayer player) {
        this.age += age;
        NetworkHandler.sendToPlayer(new PacketSyncAgeToClient(getAge()), player);
    }

    /**
     * Reset age.
     */
    public void resetAge() {
        this.age = 1;
    }

    /**
     * Reset age & sends a packet to update the client side data 
     *
     * @param player the player
     */
    public void resetAge(ServerPlayer player) {
        this.age = 1;
        NetworkHandler.sendToPlayer(new PacketSyncAgeToClient(getAge()), player);
    }

    /**
     * Gets max age.
     *
     * @return the max age
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * Sets max age.
     *
     * @param maxAge the max age
     */
    // todo make a packet to update the max age of the player
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    /**
     * Add max age.
     *
     * @param maxAge the max age
     */
    public void addMaxAge(int maxAge) {
        this.maxAge += maxAge;
    }

    /**
     * Reset max age.
     */
    public void resetMaxAge() {
        this.maxAge = HelperMethods.generateRandomNum(AGE_MIN, AGE_LIMIT);
    }

    /**
     * If the player has reached 70% of the max age.
     *
     * @return the boolean
     */
    public boolean isOld() {
        return age >= maxAge * 0.7;
    }

    @Override
    public void print(Player player) {
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Age: " + age);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Max Age: " + maxAge);
    }

    @Override
    public String getText(Player player) {
        return player.getDisplayName().getString() + "'s Age: " + age;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt(NBT_KEY_AGE, age);
        compoundTag.putInt(NBT_KEY_MAX_AGE, maxAge);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        age = compoundTag.getInt(NBT_KEY_AGE);
        maxAge = compoundTag.getInt(NBT_KEY_MAX_AGE);
    }

}
