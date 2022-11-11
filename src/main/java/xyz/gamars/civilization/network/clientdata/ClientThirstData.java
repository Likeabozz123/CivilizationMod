package xyz.gamars.civilization.network.clientdata;

public class ClientThirstData {

    private static int thirst;

    public static void set(int thirst) {
        ClientThirstData.thirst = thirst;
    }

    public static int getThirst() {
        return thirst;
    }


}
