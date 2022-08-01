package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class TemperatureImpl implements IImpl {


    public static String NBT_KEY_TEMPERATURE = "temperature";

    private double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void incrementTemperature() {
        temperature += 0.5;
    }

    public void incrementTill(double goalTemp) {
        if (temperature < goalTemp) {
            incrementTemperature();
        }
    }

    public void decrementTemperature() {
        temperature -= 0.5;
    }

    public void decrementTill(double goalTemp) {
        if (temperature > goalTemp) {
            decrementTemperature();
        }
    }

    public void adjustTempTo(double goalTemp) {
        if (temperature < goalTemp) {
            incrementTill(goalTemp);
        } else if (temperature > goalTemp) {
            decrementTill(goalTemp);
        }
    }

    @Override
    public void print(Player player) {
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Temperature: " + temperature);
    }

    @Override
    public String getText(Player player) {
        return player.getDisplayName().getString() + "'s Temperature: " + temperature;
    }
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putDouble(NBT_KEY_TEMPERATURE, temperature);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        temperature = compoundTag.getDouble(NBT_KEY_TEMPERATURE);
    }
}
