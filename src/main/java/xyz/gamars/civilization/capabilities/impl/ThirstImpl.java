package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

public class ThirstImpl implements INBTSerializable<CompoundTag> {

    public static final String NBT_KEY_THIRST = "thirst";
    private int thirst = 100;

    public int getThirst() {
        return this.thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void addAge(int thirst) {
        this.thirst += thirst;
    }

    public void resetThirst() {
        this.thirst = 100;
    }

    public void printThirst(Player player) {
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Thirst: " + thirst);
    }

    public String getThirstText(Player player) {
        return player.getDisplayName().getString() + "'s Thirst: " + thirst;
    }


    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt(NBT_KEY_THIRST, thirst);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        thirst = compoundTag.getInt(NBT_KEY_THIRST);
    }
}
