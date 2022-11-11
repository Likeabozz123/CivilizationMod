package xyz.gamars.civilization.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.data.generators.ModLangProvider;
import xyz.gamars.civilization.data.generators.ModRecipeProvider;
import xyz.gamars.civilization.data.generators.loottables.ModLootTableProvider;
import xyz.gamars.civilization.data.generators.models.ModBlockStateProvider;
import xyz.gamars.civilization.data.generators.models.ModItemModelProvider;
import xyz.gamars.civilization.data.generators.tags.ModBiomeTags;
import xyz.gamars.civilization.data.generators.tags.ModBlockTags;
import xyz.gamars.civilization.data.generators.tags.ModItemTags;

/* data generators */
@Mod.EventBusSubscriber(modid = Civilization.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData (GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if(event.includeServer()) {
            generator.addProvider(true, new ModRecipeProvider(generator));
            generator.addProvider(true, new ModLootTableProvider(generator));
            ModBlockTags blockTags = new ModBlockTags(generator, existingFileHelper);
            generator.addProvider(true, blockTags);
            generator.addProvider(true, new ModItemTags(generator, blockTags, existingFileHelper));
            generator.addProvider(true, new ModBiomeTags(generator, existingFileHelper));
        }

        if(event.includeClient()) {
            generator.addProvider(true, new ModBlockStateProvider(generator, existingFileHelper));
            generator.addProvider(true, new ModItemModelProvider(generator, existingFileHelper));
            generator.addProvider(true, new ModLangProvider(generator, "en_us"));
        }

    }

}
