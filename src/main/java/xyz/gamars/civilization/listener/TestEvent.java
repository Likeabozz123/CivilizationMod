package xyz.gamars.civilization.listener;


import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketSyncAgeToClient;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class TestEvent {

    /* damage living entity event */
    @SubscribeEvent
    public static void hurtEntity(LivingDamageEvent event) {
        if (!event.getEntity().getLevel().isClientSide()) {
            if (event.getSource().getEntity() instanceof Player) {
                ServerPlayer player = (ServerPlayer) event.getSource().getEntity();
                player.getCapability(CivCapabilities.AGE).ifPresent(age -> {
                    age.addAge(1, player);
                    age.print(player);
                    player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
                });

            }
        }
    }

}
