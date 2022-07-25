package xyz.gamars.civilization.interfaces;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

public interface IAge{

    /**
     * Gets the age value and returns it
     * @return The age value
     */
    int getAge();

    /**
     * Gets the max age value and returns it
     * @return The max age value
     */
    int getMaxAge();

    /**
     * Sets the age value
     * @param age
     */
    void setAge(int age);

    /**
     * Adds to age value
     * @param age
     */
    void addAge(int age);

    /**
     * Gets whether the player is old
     * @return Whether player is old
     */
    boolean isOld();

    void resetAge();

    void printAge(Player player);


}
