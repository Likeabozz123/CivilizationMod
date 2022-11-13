package xyz.gamars.civilization.network.clientdata;

public class ClientHydrationData {

    private static int hydration;

    public static void set(int hydration) {
        ClientHydrationData.hydration = hydration;
    }

    public static int getHydration() {
        return hydration;
    }


}
