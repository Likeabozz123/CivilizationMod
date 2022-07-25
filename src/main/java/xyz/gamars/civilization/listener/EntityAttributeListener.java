package xyz.gamars.civilization.listener;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.entities.CivEntityTypes;
import xyz.gamars.civilization.entities.playerlike.PlayerLikeEntity;

@Mod.EventBusSubscriber(modid = Civilization.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributeListener {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(CivEntityTypes.PLAYER_LIKE.get(), PlayerLikeEntity.setAttributes());
    }

}
