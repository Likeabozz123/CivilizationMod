package xyz.gamars.civilization;

import java.util.Random;

public class HelperMethods {

    /* generates a random number between two numbers */
    public static int generateRandomNum(int minValue, int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue - minValue) + minValue;
    }

}
