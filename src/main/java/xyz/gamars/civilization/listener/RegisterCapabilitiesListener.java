package xyz.gamars.civilization.listener;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.capabilities.impl.*;
import xyz.gamars.civilization.capabilities.provider.*;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class RegisterCapabilitiesListener {

    // create a capability template? with events preattached?
    // maybe combine age and stats?

    /* attaches capabilities to player */
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player) {
            // AGE
            attachCapability(event, CivCapabilities.AGE, AgeProvider.IDENTIFIER, new AgeProvider());
            // TRIBE
            attachCapability(event, CivCapabilities.TRIBE, TribeProvider.IDENTIFIER, new TribeProvider());
            // THIRST
            attachCapability(event, CivCapabilities.THIRST, ThirstProvider.IDENTIFIER, new ThirstProvider());
            // STATS
            attachCapability(event, CivCapabilities.STATS, StatsProvider.IDENTIFIER, new StatsProvider());
            // TEMPERATURE
            attachCapability(event, CivCapabilities.TEMPERATURE, TemperatureProvider.IDENTIFIER, new TemperatureProvider());

        }
    }

    /* updates capability data when player clones (respawns/joins) */
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().reviveCaps();
            // create an automated for loop to prevent rewriting the same code

            // make method to simplify it down

            // AGE
            event.getOriginal().getCapability(CivCapabilities.AGE).ifPresent(original -> {
                original.print(event.getOriginal());
                event.getEntity().getCapability(CivCapabilities.AGE).ifPresent(neww -> {
                    neww.setAge(original.getAge());
                });
            });
            // TRIBE
            event.getOriginal().getCapability(CivCapabilities.TRIBE).ifPresent(originalTribe -> {
                originalTribe.print(event.getOriginal());
                event.getEntity().getCapability(CivCapabilities.TRIBE).ifPresent(newTribe -> {
                    newTribe.setTribe(originalTribe.getTribe());
                });
            });
            // THIRST
            event.getOriginal().getCapability(CivCapabilities.THIRST).ifPresent(originalThirst -> {
                originalThirst.print(event.getOriginal());
                event.getEntity().getCapability(CivCapabilities.THIRST).ifPresent(newThirst -> {
                    newThirst.setThirst(originalThirst.getThirst());
                });
            });
            // TEMPERATURE
            event.getOriginal().getCapability(CivCapabilities.TEMPERATURE).ifPresent(originalThirst -> {
                originalThirst.print(event.getOriginal());
                event.getEntity().getCapability(CivCapabilities.TEMPERATURE).ifPresent(newThirst -> {
                    newThirst.setTemperature(originalThirst.getTemperature());
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

    /* register capabilities */
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(AgeImpl.class);
        event.register(TribeImpl.class);
        event.register(ThirstImpl.class);
        event.register(StatImpl.class);
        event.register(TemperatureImpl.class);
    }

    /* attach capability method */
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event, Capability<?> capability, ResourceLocation identifier, ICapabilityProvider provider) {
        /* makes sure that the player doesn't already have the capability */
        if (!event.getObject().getCapability(capability).isPresent()) {
            event.addCapability(identifier, provider);
        }
    }

}
