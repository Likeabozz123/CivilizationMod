package xyz.gamars.civilization.network.data;

public class ClientAgeData {

    private static int age;

    public static void set(int age) {
        ClientAgeData.age = age;
    }

    public static int getAge() {
        return age;
    }
}
