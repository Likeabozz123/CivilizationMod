package xyz.gamars.civilization.network.clientdata;

public class ClientTribeData {

    private static String tribeName;

    public static void set(String tribeName) {
        ClientTribeData.tribeName = tribeName;
    }

    public static String getTribeName() {
        return tribeName;
    }

}
