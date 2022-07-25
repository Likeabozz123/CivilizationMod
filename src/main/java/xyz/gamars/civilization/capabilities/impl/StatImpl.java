package xyz.gamars.civilization.capabilities.impl;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class StatImpl implements INBTSerializable<CompoundTag> {

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
    private int maxHealth;
    private int intelligence;
    private int wisdom;
    private int racism;
    private int charisma;
    private int strength;
    private int speed;
    private int stamina;
    private String gender = "";

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
}
