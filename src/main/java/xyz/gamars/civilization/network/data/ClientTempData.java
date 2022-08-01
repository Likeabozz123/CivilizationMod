package xyz.gamars.civilization.network.data;

public class ClientTempData {

    private static double temperature;

    public static void set(double temperature) {
        ClientTempData.temperature = temperature;
    }

    public static double getTemperature() {
        return temperature;
    }

}
