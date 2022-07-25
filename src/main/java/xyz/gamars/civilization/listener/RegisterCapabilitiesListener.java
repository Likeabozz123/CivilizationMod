package xyz.gamars.civilization.listener;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.capabilities.impl.AgeImpl;
import xyz.gamars.civilization.capabilities.impl.StatImpl;
import xyz.gamars.civilization.capabilities.impl.ThirstImpl;
import xyz.gamars.civilization.capabilities.impl.TribeImpl;
import xyz.gamars.civilization.capabilities.provider.AgeProvider;
import xyz.gamars.civilization.capabilities.provider.StatProvider;
import xyz.gamars.civilization.capabilities.provider.ThirstProvider;
import xyz.gamars.civilization.capabilities.provider.TribeProvider;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class RegisterCapabilitiesListener {

    // create a capability template? with events preattached?

    // maybe combine age and stats?

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player) {
            // create an automated for loop to prevent rewriting the same code

            // AGE
            if (!event.getObject().getCapability(CivCapabilities.AGE).isPresent()) {
                event.addCapability(AgeProvider.IDENTIFIER, new AgeProvider());
            }
            // TRIBE
            if (!event.getObject().getCapability(CivCapabilities.TRIBE).isPresent()) {
                event.addCapability(TribeProvider.IDENTIFIER, new TribeProvider());
            }
            // THIRST
            if (!event.getObject().getCapability(CivCapabilities.THIRST).isPresent()) {
                event.addCapability(ThirstProvider.IDENTIFIER, new ThirstProvider());
            }
            // STATS
            if (!event.getObject().getCapability(CivCapabilities.STATS).isPresent()) {
                event.addCapability(StatProvider.IDENTIFIER, new StatProvider());
            }


        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().reviveCaps();
            // create an automated for loop to prevent rewriting the same code

            // AGE
            event.getOriginal().getCapability(CivCapabilities.AGE).ifPresent(originalAge -> {
                originalAge.printAge(event.getOriginal());
                event.getEntity().getCapability(CivCapabilities.AGE).ifPresent(newAge -> {
                    newAge.setAge(originalAge.getAge());
                });
            });
            // TRIBE
            event.getOriginal().getCapability(CivCapabilities.TRIBE).ifPresent(originalTribe -> {
                originalTribe.printTribe(event.getOriginal());
                event.getEntity().getCapability(CivCapabilities.TRIBE).ifPresent(newTribe -> {
                    newTribe.setTribe(originalTribe.getTribe());
                });
            });
            // THIRST
            event.getOriginal().getCapability(CivCapabilities.THIRST).ifPresent(originalThirst -> {
                originalThirst.printThirst(event.getOriginal());
                event.getEntity().getCapability(CivCapabilities.THIRST).ifPresent(newThirst -> {
                    newThirst.setThirst(originalThirst.getThirst());
                });
            });
            // STATS
            event.getOriginal().getCapability(CivCapabilities.STATS).ifPresent(originalStats -> {
                // originalTribe.printThirst(event.getOriginal());
                event.getEntity().getCapability(CivCapabilities.STATS).ifPresent(newStats -> {
                    newStats.setMaxHealth(originalStats.getMaxHealth());
                    newStats.setIntelligence(originalStats.getIntelligence());
                    newStats.setCharisma(originalStats.getCharisma());
                    newStats.setStrength(originalStats.getStrength());
                    newStats.setSpeed(originalStats.getSpeed());
                    newStats.setStamina(originalStats.getStamina());
                    newStats.setGender(originalStats.getGender());
                    newStats.setWisdom(originalStats.getWisdom());
                    newStats.setRacism(originalStats.getRacism());
                });
            });
        }
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(AgeImpl.class);
        event.register(TribeImpl.class);
        event.register(ThirstImpl.class);
        event.register(StatImpl.class);
    }

}
