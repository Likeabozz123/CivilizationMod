package xyz.gamars.civilization.helper;

import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.interfaces.IAge;

public class AgeHelper {

    public static IAge getAge(Player player) {
        return Impl.INSTANCE.getAge(player);
    }

    public static class Impl {
        public static IAgeHelper INSTANCE = null;

        public interface IAgeHelper {
            IAge getAge(Player player);
        }
    }

}
