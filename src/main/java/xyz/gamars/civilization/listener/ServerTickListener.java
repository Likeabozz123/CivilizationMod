package xyz.gamars.civilization.listener;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class ServerTickListener {


    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.getServer().overworld().getDayTime() % 24000L == 0L) {
            System.out.println("New Day");
            for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
                player.getCapability(CivCapabilities.AGE).ifPresent(age -> {
                    age.addAge(1);
                    System.out.println("Age : " + age.getAge());
                    if (age.isOld()) {
                        player.kill();
                        age.resetAge();
                        age.resetMaxAge();
                    }
                });
            }
        }
    }

}
