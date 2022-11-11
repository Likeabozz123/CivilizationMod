package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.HelperMethods;
import xyz.gamars.civilization.libs.VNameGenerator.generator.CombinatorialGenerator;

public class TribeImpl implements IImpl {

    public static final String NBT_KEY_TRIBE_NAME = "tribe";
    private String tribeName = generateTribeName(HelperMethods.generateRandomNum(4, 10));

    public String getTribe() {
        return tribeName;
    }

    public void setTribe(String tribeName) {
        this.tribeName = tribeName;
    }

    public void resetTribe() {
        tribeName = generateTribeName(HelperMethods.generateRandomNum(4, 10));
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

    public String generateTribeName(int length) {
        final var beginnings = new String[] { "th", "bo", "ja", "fu" };
        final var middles = new String[] { "la", "su", "dhu", "li", "da", "zk", "fr"};
        final var endings = new String[] { "r", "t", "gh", "or", "al", "ar", "is" };
        final var generator = new CombinatorialGenerator(beginnings, middles, endings);
        return generator.generate(length);
    }

}
