package xyz.gamars.civilization.listener;


import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class TestEvent {

    @SubscribeEvent
    public static void hurtEntity(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player) {
            Player player = (Player) event.getSource().getEntity();
            player.getCapability(CivCapabilities.AGE).ifPresent(age -> {
                age.addAge(1);
                System.out.println(player.getDisplayName().getString() + "'s Age : " + age.getAge());
                player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0D);
            });

        }
    }

}
