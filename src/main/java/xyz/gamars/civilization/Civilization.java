package xyz.gamars.civilization;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;
import xyz.gamars.civilization.entities.barbarian.BarbarianRenderer;
import xyz.gamars.civilization.entities.playerlike.PlayerLikeRenderer;
import xyz.gamars.civilization.init.BlockInit;
import xyz.gamars.civilization.init.CivEntityTypes;
import xyz.gamars.civilization.init.ItemInit;
import xyz.gamars.civilization.network.NetworkHandler;

@Mod(Civilization.MOD_ID)
public class Civilization {
    /* mod id to reference everywhere else */
    public static final String MOD_ID = "civilization";

    /* main mod constructor */
    public Civilization() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        /* registers items from the ItemInit class */
        ItemInit.ITEMS.register(modEventBus);

        /* registers block from the BlockInit class */
        BlockInit.BLOCKS.register(modEventBus);

        /* registers entity types from CivEntityTypes class */
        CivEntityTypes.ENTITY_TYPES.register(modEventBus);

        /* adds clientSetup to global listeners */
        modEventBus.addListener(this::clientSetup);

        /* adds commonSetup to global listeners */
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        GeckoLib.initialize();
        
    }


    private void clientSetup(final FMLClientSetupEvent event) {
        /* register entity renderers */
        EntityRenderers.register(CivEntityTypes.PLAYER_LIKE.get(), PlayerLikeRenderer::new);
        EntityRenderers.register(CivEntityTypes.BARBARIAN.get(), BarbarianRenderer::new);

        EntityRenderers.register(CivEntityTypes.ROCK.get(), ThrownItemRenderer::new);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        /* registers the network handler */
        NetworkHandler.register();

    }



}
