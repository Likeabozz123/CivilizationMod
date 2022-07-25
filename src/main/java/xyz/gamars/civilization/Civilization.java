package xyz.gamars.civilization;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import xyz.gamars.civilization.entities.CivEntityTypes;
import xyz.gamars.civilization.entities.playerlike.PlayerLikeEntity;
import xyz.gamars.civilization.entities.playerlike.PlayerLikeRenderer;
import xyz.gamars.civilization.init.ItemInit;

@Mod(Civilization.MOD_ID)
public class Civilization {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "civilization";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Civilization() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus bus = MinecraftForge.EVENT_BUS;

        // Register ourselves for server and other game events we are interested in

        ItemInit.ITEMS.register(modEventBus);
        CivEntityTypes.ENTITIY_TYPES.register(modEventBus);

        modEventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);


        GeckoLib.initialize();
        
    }


    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(CivEntityTypes.PLAYER_LIKE.get(), PlayerLikeRenderer::new);
    }




}
