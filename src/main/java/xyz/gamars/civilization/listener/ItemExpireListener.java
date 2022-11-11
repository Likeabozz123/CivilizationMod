package xyz.gamars.civilization.listener;

import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.init.ItemInit;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID)
public class ItemExpireListener {

    /* item expire listener */
    @SubscribeEvent
    public static void onItemExpire(ItemExpireEvent event) {
        if (event.getEntity().getItem().is(ItemInit.DEBUG_ITEM.get())) {
            System.out.println("Item expired");
        }
    }


}
