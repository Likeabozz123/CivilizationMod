package xyz.gamars.civilization.listener;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.data.generators.tags.CivTags;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketSyncAgeToClient;
import xyz.gamars.civilization.network.packets.PacketSyncTempToClient;

/**
 * The type Tick listeners.
 */
@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class TickListeners {

    /* keeps track of ticks and days passed */
    private static int serverTickCounter = 0;
    private static int levelTickCounter = 0;
    private static int daysPassed = 0;

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {

        serverTickCounter--;
        if (serverTickCounter <= 0) {
            /* resets tick counter to 10 seconds */
            serverTickCounter = 200;
            for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
                /* decrement thirst for when player is sprinting and updates the client */
                if (player.isSprinting()) {
                    player.getCapability(CivCapabilities.HYDRATION).ifPresent(thirst -> {
                        thirst.decrementHydration(player);
                    });
                }
            }
        }

        /* update daysPassed counter every in-game day */
        if (event.phase == TickEvent.Phase.END && event.getServer().overworld().getDayTime() % 24000L == 0L) {
            daysPassed++;
            System.out.println("New Day, " + daysPassed);

            /* if 3 days have passed reset counter, and increment every player's age */
            if (daysPassed >= 3) {
                daysPassed = 0;
                for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
                    player.getCapability(CivCapabilities.AGE).ifPresent(age -> {
                        age.addAge(1, player);
                        age.print(player);

                        /* if the player has reached their limit kill them and reset their age and max age */
                        if (age.isOld()) {
                            player.kill();
                            age.resetAge(player);
                            age.resetMaxAge();
                        }
                    });
                }
            }
        }
    }

    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        if (event.level.isClientSide()) {
            return;
        }
        if (event.phase == TickEvent.Phase.START) {
            return;
        }

        levelTickCounter--;
        if (levelTickCounter <= 0) {
            /* reset counter to 1 second */
            levelTickCounter = 20;
            Level level = event.level;
            for (Player player : event.level.players()) {
                // Biome biome = level.getBiome(player.blockPosition()).get();
                boolean extremelyColdBiome = level.getBiome(player.blockPosition()).is(CivTags.Biomes.EXTREMELY_COLD_BIOME);
                boolean coldBiome = level.getBiome(player.blockPosition()).is(CivTags.Biomes.COLD_BIOME);
                boolean coolBiome = level.getBiome(player.blockPosition()).is(CivTags.Biomes.COOL_BIOME);
                boolean warmBiome = level.getBiome(player.blockPosition()).is(CivTags.Biomes.WARM_BIOME);
                boolean hotBiome = level.getBiome(player.blockPosition()).is(CivTags.Biomes.HOT_BIOME);
                boolean extremelyHotBiome = level.getBiome(player.blockPosition()).is(CivTags.Biomes.EXTREMELY_HOT_BIOME);

                /* update players temperature depending on their biome and update the client */
                if (player instanceof ServerPlayer) {
                    ServerPlayer serverPlayer = (ServerPlayer) player;
                    player.getCapability(CivCapabilities.TEMPERATURE).ifPresent(temperature -> {
                        if (extremelyColdBiome) {
                            temperature.adjustTempTo(30 + armorModifiers(serverPlayer), serverPlayer);
                        }
                        if (coldBiome) {
                            temperature.adjustTempTo(50 + armorModifiers(serverPlayer), serverPlayer);
                        }
                        if (coolBiome) {
                            temperature.adjustTempTo(70 + armorModifiers(serverPlayer), serverPlayer);
                        }
                        if (warmBiome) {
                            temperature.adjustTempTo(80 + armorModifiers(serverPlayer), serverPlayer);
                        }
                        if (hotBiome) {
                            temperature.adjustTempTo(90 + armorModifiers(serverPlayer), serverPlayer);
                        }
                        if (extremelyHotBiome) {
                            temperature.adjustTempTo(100 + armorModifiers(serverPlayer), serverPlayer);
                        }

                        /* when player is too hot, increase the thirst, and after a certain point they start burning up */
                        if (temperature.getTemperature() >= 90) {
                            // PLAYER IS HOT
                            // INCREASE HYDRATION
                            // IF WAY TOO HOT THEN MAKE THE PLAYER START BURNING
                        }

                        /* when player is too cold, they slow down, and if too slow, they freeze */
                        if (temperature.getTemperature() <= 65) {
                            // PLAYER IS COLD
                            // MAKE THE PLAYER A BIT MORE STAGNANT
                            // IF WAY TOO COLD, START TO FREEZE THE PLAYER
                        }
                    });
                }
            }
        }
    }


    /**
     * Calculates the armor offset to the temperature
     *
     * @param player the player
     * @return the temperature offset
     */
    public static double armorModifiers(Player player) {

        // check with tags instead of manually each one

        // COOL ARMOR
        // WARM ARMOR
        // HOT ARMOR

        double modifier = 0;

        for (int i = 0; i < 4; i++) {
            double coolArmor = player.getInventory().getArmor(i).is(CivTags.Items.COOL_ARMOR) ? -2.5 : 0;
            double warmArmor = player.getInventory().getArmor(i).is(CivTags.Items.WARM_ARMOR) ? 2.5 : 0;
            double hotArmor = player.getInventory().getArmor(i).is(CivTags.Items.HOT_ARMOR) ? 5 : 0;

            modifier += coolArmor + warmArmor + hotArmor;
        }

        return modifier;
    }
}
