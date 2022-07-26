package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.HelperMethods;
import xyz.gamars.civilization.capabilities.CivCapabilities;

import java.util.HashMap;
import java.util.Random;

/**
 * The type Stat.
 */
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
    private int maxHealth = HelperMethods.generateRandomNum(10, 30);
    private int intelligence = HelperMethods.generateRandomNum(10, 30);
    private int wisdom = HelperMethods.generateRandomNum(10, 30);
    private int racism = HelperMethods.generateRandomNum(10, 30);
    private int charisma = HelperMethods.generateRandomNum(10, 30);
    private int strength = HelperMethods.generateRandomNum(10, 30);
    private int speed = HelperMethods.generateRandomNum(10, 30);
    private int stamina = HelperMethods.generateRandomNum(10, 30);
    private String gender = randomGender();

    /**
     * Gets max health.
     *
     * @return the max health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Sets max health.
     *
     * @param maxHealth the max health
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Gets intelligence.
     *
     * @return the intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Sets intelligence.
     *
     * @param intelligence the intelligence
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Gets charisma.
     *
     * @return the charisma
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * Sets charisma.
     *
     * @param charisma the charisma
     */
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    /**
     * Gets strength.
     *
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets strength.
     *
     * @param strength the strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Gets stamina.
     *
     * @return the stamina
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Sets stamina.
     *
     * @param stamina the stamina
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets wisdom.
     *
     * @return the wisdom
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * Sets wisdom.
     *
     * @param wisdom the wisdom
     */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * Gets racism.
     *
     * @return the racism
     */
    public int getRacism() {
        return racism;
    }

    /**
     * Sets racism.
     *
     * @param racism the racism
     */
    public void setRacism(int racism) {
        this.racism = racism;
    }


    /**
     * Add max health.
     *
     * @param maxHealth the max health
     */
    public void addMaxHealth(int maxHealth) {
        this.maxHealth += maxHealth;
    }

    /**
     * Add intelligence.
     *
     * @param intelligence the intelligence
     */
    public void addIntelligence(int intelligence) {
        this.intelligence += intelligence;
    }

    /**
     * Add wisdom.
     *
     * @param wisdom the wisdom
     */
    public void addWisdom(int wisdom) {
        this.wisdom += wisdom;
    }

    /**
     * Add racism.
     *
     * @param racism the racism
     */
    public void addRacism(int racism) {
        this.racism += racism;
    }

    /**
     * Add charisma.
     *
     * @param charisma the charisma
     */
    public void addCharisma(int charisma) {
        this.charisma += charisma;
    }

    /**
     * Add strength.
     *
     * @param strength the strength
     */
    public void addStrength(int strength) {
        this.strength += strength;
    }

    /**
     * Add speed.
     *
     * @param speed the speed
     */
    public void addSpeed(int speed) {
        this.speed += speed;
    }

    /**
     * Add stamina.
     *
     * @param stamina the stamina
     */
    public void addStamina(int stamina) {
        this.stamina += stamina;
    }

    /**
     * Reset stats.
     */
    public void resetStats() {
        maxHealth = HelperMethods.generateRandomNum(10, 40);
        intelligence = HelperMethods.generateRandomNum(10, 30);
        wisdom = HelperMethods.generateRandomNum(10, 30);
        racism = HelperMethods.generateRandomNum(10, 30);
        charisma = HelperMethods.generateRandomNum(10, 30);
        strength = HelperMethods.generateRandomNum(10, 30);
        speed = HelperMethods.generateRandomNum(10, 30);
        stamina = HelperMethods.generateRandomNum(10, 30);
        gender = randomGender();
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

    /**
     * Gets stat text.
     *
     * @param player the player
     * @return the stat text
     */
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

    public static String randomGender() {
        Random random = new Random();
        if ((random.nextInt(3 - 1) + 1) == 1) {
            return "male";
        } else {
            return "female";
        }
    }


}
