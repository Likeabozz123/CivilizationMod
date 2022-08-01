package xyz.gamars.civilization.network.data;

public class ClientStatsData {
    private static int maxHealth;
    private static int intelligence;
    private static int wisdom;
    private static int racism;
    private static int charisma;
    private static int strength;
    private static int speed;
    private static int stamina;
    private static String gender;

    public static void set(int maxHealth, int intelligence, int wisdom, int racism, int charisma, int strength, int speed, int stamina, String gender) {
        ClientStatsData.maxHealth = maxHealth;
        ClientStatsData.intelligence = intelligence;
        ClientStatsData.wisdom = wisdom;
        ClientStatsData.racism = racism;
        ClientStatsData.charisma = charisma;
        ClientStatsData.strength = strength;
        ClientStatsData.speed = speed;
        ClientStatsData.stamina = stamina;
        ClientStatsData.gender = gender;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getRacism() {
        return racism;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStamina() {
        return stamina;
    }

    public String getGender() {
        return gender;
    }
}
