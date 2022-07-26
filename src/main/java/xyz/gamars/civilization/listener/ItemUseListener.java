package xyz.gamars.civilization.listener;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.init.ItemInit;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketSyncHydrationToClient;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class ItemUseListener {

    @SubscribeEvent
    public static void onUseItem(LivingEntityUseItemEvent.Finish event) {
        /* checking if server side */
        if (!event.getEntity().getLevel().isClientSide()) {
            ServerPlayer player = (ServerPlayer) event.getEntity();
            ItemStack item = event.getItem();

            
            /* checks if the item consumed is a potion */
            /* todo update so that it slowly increments the hydration  rather then immediately adding it*/
            if (item.is(Items.POTION) || item.is(Items.MILK_BUCKET) || item.is(ItemInit.WINE.get()) || item.is(ItemInit.BEER.get()) || item.is(ItemInit.AMBROSIA.get())) {
                player.getCapability(CivCapabilities.HYDRATION).ifPresent(hydration -> {
                    /* add hydration to player after consuming potion */
                    hydration.addHydration(10, player);
                });
            }
        }
    }

}
