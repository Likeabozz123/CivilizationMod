package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

public class TribeImpl implements INBTSerializable<CompoundTag> {


    public static final String NBT_KEY_TRIBE_NAME = "tribe";
    private String tribeName = "TribeName";

    public String getTribe() {
        return tribeName;
    }

    public void setTribe(String tribeName) {
        this.tribeName = tribeName;
    }

    public void printTribe(Player player) {
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Tribe: " + tribeName);
    }

    public String getTribeText(Player player) {
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
}
