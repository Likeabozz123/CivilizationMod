package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class TribeImpl implements IImpl {

    public static final String NBT_KEY_TRIBE_NAME = "tribe";
    private String tribeName = "TribeName";

    public String getTribe() {
        return tribeName;
    }

    public void setTribe(String tribeName) {
        this.tribeName = tribeName;
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
    public void copyFrom(IImpl source) {
        this.tribeName = ((TribeImpl) source).tribeName;
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

}
