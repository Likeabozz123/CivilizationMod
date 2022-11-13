package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.HelperMethods;
import xyz.gamars.civilization.libs.VNameGenerator.generator.CombinatorialGenerator;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketSyncTribeToClient;

public class TribeImpl implements IImpl {

    public static final String NBT_KEY_TRIBE_NAME = "tribe";
    private String tribeName = generateTribeName(HelperMethods.generateRandomNum(4, 10));

    /**
     * Gets tribe.
     *
     * @return the tribe
     */
    public String getTribe() {
        return tribeName;
    }

    /**
     * Sets tribe.
     *
     * @param tribeName the tribe name
     */
    public void setTribe(String tribeName) {
        this.tribeName = tribeName;
    }

    /**
     * Sets tribe & sends a packet to update client side data.
     *
     * @param tribeName the tribe name
     * @param player    the player
     */
    public void setTribe(String tribeName, ServerPlayer player) {
        this.tribeName = tribeName;
        NetworkHandler.sendToPlayer(new PacketSyncTribeToClient(getTribe()), player);
    }

    /**
     * Reset tribe.
     */
    public void resetTribe() {
        tribeName = generateTribeName(HelperMethods.generateRandomNum(4, 10));
    }

    /**
     * Reset tribe & sends a packet to update client side data.
     *
     * @param player the player
     */
    public void resetTribe(ServerPlayer player) {
        tribeName = generateTribeName(HelperMethods.generateRandomNum(4, 10));
        NetworkHandler.sendToPlayer(new PacketSyncTribeToClient(getTribe()), player);
    }

    @Override
    public void print(Player player) {
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Tribe: " + tribeName);
    }

    @Override
    public String getText(Player player) {
        return player.getDisplayName().getString() + "'s Tribe: " + tribeName;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString(NBT_KEY_TRIBE_NAME, tribeName);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        tribeName = compoundTag.getString(NBT_KEY_TRIBE_NAME);
    }

    /**
     * Generate tribe name string.
     *
     * @author Valkryst
     * @param length the length
     * @return the string
     */
    public String generateTribeName(int length) {
        final var beginnings = new String[] { "th", "bo", "ja", "fu" };
        final var middles = new String[] { "la", "su", "dhu", "li", "da", "zk", "fr"};
        final var endings = new String[] { "r", "t", "gh", "or", "al", "ar", "is" };
        final var generator = new CombinatorialGenerator(beginnings, middles, endings);
        return generator.generate(length);
    }

}
