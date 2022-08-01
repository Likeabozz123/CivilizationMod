package xyz.gamars.civilization.capabilities.impl;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

public interface IImpl extends INBTSerializable<CompoundTag> {

    // void copyFrom(IImpl source);
    void print(Player player);
    String getText(Player player);

}
