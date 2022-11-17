package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.data.generators.tags.CivTags;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketSyncTempToClient;

public class TemperatureImpl implements IImpl {


    public static String NBT_KEY_TEMPERATURE = "temperature";
    private double temperature;

    /**
     * Gets temperature.
     *
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Sets temperature.
     *
     * @param temperature the temperature
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Sets temperature & sends a packet to update client side data.
     *
     * @param temperature the temperature
     * @param player      the player
     */
    public void setTemperature(double temperature, ServerPlayer player) {
        this.temperature = temperature;
        NetworkHandler.sendToPlayer(new PacketSyncTempToClient(getTemperature()), player);
    }

    /**
     * Increment temperature.
     */
    public void incrementTemperature() {
        temperature += 0.5;
    }

    /**
     * Increment temperature & sends a packet to update client side data .
     *
     * @param player the player
     */
    public void incrementTemperature(ServerPlayer player) {
        temperature += 0.5;
        NetworkHandler.sendToPlayer(new PacketSyncTempToClient(getTemperature()), player);
    }

    /**
     * Increment till goal temp.
     *
     * @param goalTemp the goal temp
     */
    public void incrementTill(double goalTemp) {
        if (temperature < goalTemp) {
            incrementTemperature();
        }
    }

    /**
     * Increment till goal temp & sends a packet to update client side data.
     *
     * @param goalTemp the goal temp
     * @param player   the player
     */
    public void incrementTill(double goalTemp, ServerPlayer player) {
        if (temperature < goalTemp) {
            incrementTemperature(player);
        }
    }

    /**
     * Decrement temperature by 0.5.
     */
    public void decrementTemperature() {
        temperature -= 0.5;
    }

    /**
     * Decrement temperature & sends a packet to update client side data.
     *
     * @param player the player
     */
    public void decrementTemperature(ServerPlayer player) {
        temperature -= 0.5;
        NetworkHandler.sendToPlayer(new PacketSyncTempToClient(getTemperature()), player);
    }

    /**
     * Decrement till goal temp.
     *
     * @param goalTemp the goal temp
     */
    public void decrementTill(double goalTemp) {
        if (temperature > goalTemp) {
            decrementTemperature();
        }
    }

    /**
     * Decrement till goal temp & sends a packet to update client side data.
     *
     * @param goalTemp the goal temp
     * @param player   the player
     */
    public void decrementTill(double goalTemp, ServerPlayer player) {
        if (temperature > goalTemp) {
            decrementTemperature(player);
        }
    }

    /**
     * Adjust temp to goal temp.
     *
     * @param goalTemp the goal temp
     */
    public void adjustTempTo(double goalTemp) {
        if (temperature < goalTemp) {
            incrementTill(goalTemp);
        } else if (temperature > goalTemp) {
            decrementTill(goalTemp);
        }
    }

    /**
     * Adjust temp to goal temp & sends a packet to update client side data.
     *
     * @param goalTemp the goal temp
     * @param player   the player
     */
    public void adjustTempTo(double goalTemp, ServerPlayer player) {
        if (temperature < goalTemp) {
            incrementTill(goalTemp, player);
        } else if (temperature > goalTemp) {
            decrementTill(goalTemp, player);
        }
    }

    /**
     * Calculates the armor offset to the temperature
     *
     * @param player the player
     * @return the temperature offset
     */
    public double getArmorModifiers(Player player) {

        // check with tags instead of manually each one

        // COOL ARMOR
        // WARM ARMOR
        // HOT ARMOR

        double modifier = 0;

        for (int i = 0; i < 4; i++) {
            double coolArmor = player.getInventory().getArmor(i).is(CivTags.Items.COOL_ARMOR) ? -2.5 : 0;
            double warmArmor = player.getInventory().getArmor(i).is(CivTags.Items.WARM_ARMOR) ? 2.5 : 0;
            double hotArmor = player.getInventory().getArmor(i).is(CivTags.Items.HOT_ARMOR) ? 5 : 0;

            modifier += coolArmor + warmArmor + hotArmor;
        }

        return modifier;
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
