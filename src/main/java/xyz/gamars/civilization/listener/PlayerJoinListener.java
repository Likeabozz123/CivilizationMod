package xyz.gamars.civilization.listener;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketSyncAgeToClient;
import xyz.gamars.civilization.network.packets.PacketSyncStatsToClient;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class PlayerJoinListener {

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        ServerPlayer player = (ServerPlayer) event.getEntity();
        player.getCapability(CivCapabilities.STATS).ifPresent(stat -> {
            player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(stat.getMaxHealth());
            NetworkHandler.sendToPlayer(new PacketSyncStatsToClient(
                    stat.getMaxHealth(),
                    stat.getIntelligence(),
                    stat.getWisdom(),
                    stat.getRacism(),
                    stat.getCharisma(),
                    stat.getStrength(),
                    stat.getSpeed(),
                    stat.getStamina(),
                    stat.getGender()), player);
        });
        player.getCapability(CivCapabilities.AGE).ifPresent(age -> {
            NetworkHandler.sendToPlayer(new PacketSyncAgeToClient(age.getAge()), player);
        });
    }


}
