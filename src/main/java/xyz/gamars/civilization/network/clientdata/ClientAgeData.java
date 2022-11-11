package xyz.gamars.civilization.network.clientdata;

public class ClientAgeData {

    private static int age;

    public static void set(int age) {
        ClientAgeData.age = age;
    }

    public static int getAge() {
        return age;
    }
}
