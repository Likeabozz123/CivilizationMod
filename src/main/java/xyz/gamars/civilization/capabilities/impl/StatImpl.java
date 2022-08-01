package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketSyncStatsToClient;

import java.util.HashMap;
import java.util.Random;

public class StatImpl implements IImpl {

    public static final String NBT_KEY_MAX_HEALTH = "max_health";
    public static final String NBT_KEY_INTELLIGENCE = "intelligence";
    public static final String NBT_KEY_WISDOM = "wisdom";
    public static final String NBT_KEY_RACISM = "racism";
    public static final String NBT_KEY_CHARISMA = "charisma";
    public static final String NBT_KEY_STRENGTH = "strength";
    public static final String NBT_KEY_SPEED = "speed";
    public static final String NBT_KEY_STAMINA = "stamina";
    public static final String NBT_KEY_GENDER = "gender";
    public static final String NBT_KEY_STATS = "stats";
    private int maxHealth = generateRandomInt(10, 30);
    private int intelligence = generateRandomInt(10, 30);
    private int wisdom = generateRandomInt(10, 30);
    private int racism = generateRandomInt(10, 30);
    private int charisma = generateRandomInt(10, 30);
    private int strength = generateRandomInt(10, 30);
    private int speed = generateRandomInt(10, 30);
    private int stamina = generateRandomInt(10, 30);
    private String gender = randomGender();

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getRacism() {
        return racism;
    }

    public void setRacism(int racism) {
        this.racism = racism;
    }

    public void resetStats() {
        maxHealth = generateRandomInt(10, 40);
        intelligence = generateRandomInt(10, 30);
        wisdom = generateRandomInt(10, 30);
        racism = generateRandomInt(10, 30);
        charisma = generateRandomInt(10, 30);
        strength = generateRandomInt(10, 30);
        speed = generateRandomInt(10, 30);
        stamina = generateRandomInt(10, 30);
        gender = randomGender();
    }

    public void syncStats(ServerPlayer player) {
        player.getCapability(CivCapabilities.STATS).ifPresent(stat -> {
            NetworkHandler.sendToPlayer(new PacketSyncStatsToClient(
                    stat.getMaxHealth(),
                    stat.getIntelligence(),
                    stat.getWisdom(),
                    stat.getRacism(),
                    stat.getCharisma(),
                    stat.getStrength(),
                    stat.getSpeed(),
                    stat.getStamina(),
                    stat.getGender()), (ServerPlayer) player);
        });
    }

    public void update(ServerPlayer player) {
        player.getCapability(CivCapabilities.STATS).ifPresent(stat -> {
            player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(stat.getMaxHealth());
        });
    }

    @Override
    public void print(Player player) {
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Max Health: " + maxHealth);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Intelligence: " + intelligence);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Wisdom: " + wisdom);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Racism: " + racism);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Charisma: " + charisma);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Strength: " + strength);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Speed: " + speed);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Stamina: " + stamina);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Gender: " + gender);
    }

    @Override
    public String getText(Player player) {
        return "Use StatImpl#getStatText instead";
    }

    public HashMap<String, String> getStatText(Player player) {
        HashMap<String, String> statText = new HashMap<>();
        statText.put("max_health", player.getDisplayName().getString() + "'s Max Health: " + maxHealth);
        statText.put("intelligence", player.getDisplayName().getString() + "'s Intelligence: " + intelligence);
        statText.put("wisdom", player.getDisplayName().getString() + "'s Wisdom: " + wisdom);
        statText.put("racism", player.getDisplayName().getString() + "'s Racism: " + racism);
        statText.put("charisma", player.getDisplayName().getString() + "'s Charisma: " + charisma);
        statText.put("strength", player.getDisplayName().getString() + "'s Strength: " + strength);
        statText.put("speed", player.getDisplayName().getString() + "'s Speed: " + speed);
        statText.put("stamina", player.getDisplayName().getString() + "'s Stamina: " + stamina);
        statText.put("stamina", player.getDisplayName().getString() + "'s Gender: " + gender);
        return statText;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt(NBT_KEY_MAX_HEALTH, maxHealth);
        compoundTag.putInt(NBT_KEY_INTELLIGENCE, intelligence);
        compoundTag.putInt(NBT_KEY_WISDOM, wisdom);
        compoundTag.putInt(NBT_KEY_RACISM, racism);
        compoundTag.putInt(NBT_KEY_CHARISMA, charisma);
        compoundTag.putInt(NBT_KEY_STRENGTH, strength);
        compoundTag.putInt(NBT_KEY_SPEED, speed);
        compoundTag.putInt(NBT_KEY_STAMINA, stamina);
        compoundTag.putString(NBT_KEY_GENDER, gender);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        maxHealth = compoundTag.getInt(NBT_KEY_MAX_HEALTH);
        intelligence = compoundTag.getInt(NBT_KEY_INTELLIGENCE);
        wisdom = compoundTag.getInt(NBT_KEY_WISDOM);
        racism = compoundTag.getInt(NBT_KEY_RACISM);
        charisma = compoundTag.getInt(NBT_KEY_CHARISMA);
        strength = compoundTag.getInt(NBT_KEY_STRENGTH);
        speed = compoundTag.getInt(NBT_KEY_SPEED);
        stamina = compoundTag.getInt(NBT_KEY_STAMINA);
        gender = compoundTag.getString(NBT_KEY_GENDER);

    }

    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static String randomGender() {
        Random random = new Random();
        if ((random.nextInt(3 - 1) + 1) == 1) {
            return "male";
        } else {
            return "female";
        }
    }


}
