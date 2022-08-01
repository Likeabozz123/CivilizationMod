package xyz.gamars.civilization.capabilities.impl;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

import java.util.Random;

public class AgeImpl implements IImpl {

    private int AGE_LIMIT = 100;
    private int AGE_MIN = 50;

    public static final String NBT_KEY_AGE = "age";
    public static final String NBT_KEY_MAX_AGE = "max_age";
    public static final String NBT_KEY_DAYS_PASSED = "days_passed";
    private int age = 1;
    private int maxAge = generateRandomAge(AGE_MIN, AGE_LIMIT);

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addAge(int age) {
        this.age += age;
    }

    public void resetAge() {
        this.age = 1;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public void addMaxAge(int maxAge) {
        this.maxAge += maxAge;
    }

    public void resetMaxAge() {
        this.maxAge = generateRandomAge(AGE_MIN, AGE_LIMIT);
    }

    public boolean isOld() {
        return age >= maxAge * 0.7;
    }

    @Override
    public void print(Player player) {
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Age: " + age);
        LogUtils.getLogger().info(player.getDisplayName().getString() + "'s Max Age: " + maxAge);
    }

    @Override
    public String getText(Player player) {
        return player.getDisplayName().getString() + "'s Age: " + age;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt(NBT_KEY_AGE, age);
        compoundTag.putInt(NBT_KEY_MAX_AGE, maxAge);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        age = compoundTag.getInt(NBT_KEY_AGE);
        maxAge = compoundTag.getInt(NBT_KEY_MAX_AGE);
    }

    private int generateRandomAge(int minAge, int maxAge) {
        Random random = new Random();
        return random.nextInt(maxAge - minAge) + minAge;
    }

}
