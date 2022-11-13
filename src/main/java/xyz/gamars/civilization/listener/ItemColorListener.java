package xyz.gamars.civilization.listener;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.objects.items.DrinkableItem;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemColorListener {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event){
        DrinkableItem.DRINKABLE_ITEMS.forEach(drinkableItem -> {
            event.register((stack, tint) -> drinkableItem.getColor(tint), drinkableItem);
        });
    }

}
