package xyz.gamars.civilization.data.generators.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.civilization.Civilization;

public class ModBiomeTags extends BiomeTagsProvider {

    public ModBiomeTags(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, Civilization.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(CivTags.Biomes.EXTREMELY_COLD_BIOME)
                .add(Biomes.SNOWY_PLAINS)
                .add(Biomes.ICE_SPIKES)
                .add(Biomes.SNOWY_TAIGA)
                .add(Biomes.SNOWY_BEACH)
                .add(Biomes.GROVE)
                .add(Biomes.SNOWY_SLOPES)
                .add(Biomes.JAGGED_PEAKS)
                .add(Biomes.FROZEN_PEAKS)
                .add(Biomes.FROZEN_RIVER)
                .add(Biomes.FROZEN_OCEAN)
                .add(Biomes.DEEP_FROZEN_OCEAN)
                ;

        tag(CivTags.Biomes.COLD_BIOME)
                .add(Biomes.WINDSWEPT_HILLS)
                .add(Biomes.WINDSWEPT_GRAVELLY_HILLS)
                .add(Biomes.WINDSWEPT_FOREST)
                .add(Biomes.TAIGA)
                .add(Biomes.OLD_GROWTH_PINE_TAIGA)
                .add(Biomes.OLD_GROWTH_SPRUCE_TAIGA)
                .add(Biomes.STONY_SHORE)
                .add(Biomes.COLD_OCEAN)
                .add(Biomes.DEEP_COLD_OCEAN)
                ;

        tag(CivTags.Biomes.COOL_BIOME)
                .add(Biomes.OCEAN)
                .add(Biomes.DEEP_OCEAN)
                .add(Biomes.THE_END)
                .add(Biomes.SMALL_END_ISLANDS)
                .add(Biomes.END_MIDLANDS)
                .add(Biomes.END_HIGHLANDS)
                .add(Biomes.END_BARRENS)
                ;

        tag(CivTags.Biomes.WARM_BIOME)
                .add(Biomes.PLAINS)
                .add(Biomes.SUNFLOWER_PLAINS)
                .add(Biomes.FOREST)
                .add(Biomes.FLOWER_FOREST)
                .add(Biomes.BIRCH_FOREST)
                .add(Biomes.OLD_GROWTH_BIRCH_FOREST)
                .add(Biomes.DARK_FOREST)
                .add(Biomes.SWAMP)
                .add(Biomes.MANGROVE_SWAMP)
                .add(Biomes.JUNGLE)
                .add(Biomes.SPARSE_JUNGLE)
                .add(Biomes.BAMBOO_JUNGLE)
                .add(Biomes.BEACH)
                .add(Biomes.MUSHROOM_FIELDS)
                .add(Biomes.MEADOW)
                .add(Biomes.STONY_PEAKS)
                .add(Biomes.RIVER)
                .add(Biomes.LUKEWARM_OCEAN)
                .add(Biomes.DEEP_LUKEWARM_OCEAN)
        ;

        tag(CivTags.Biomes.HOT_BIOME)
                .add(Biomes.DESERT)
                .add(Biomes.SAVANNA)
                .add(Biomes.SAVANNA_PLATEAU)
                .add(Biomes.WINDSWEPT_SAVANNA)
                .add(Biomes.BADLANDS)
                .add(Biomes.WOODED_BADLANDS)
                .add(Biomes.ERODED_BADLANDS)
                .add(Biomes.DEEP_DARK)
                .add(Biomes.DRIPSTONE_CAVES)
                .add(Biomes.LUSH_CAVES)
                .add(Biomes.WARM_OCEAN)
        ;

        tag(CivTags.Biomes.EXTREMELY_HOT_BIOME)
                .add(Biomes.NETHER_WASTES)
                .add(Biomes.SOUL_SAND_VALLEY)
                .add(Biomes.CRIMSON_FOREST)
                .add(Biomes.WARPED_FOREST)
                .add(Biomes.BASALT_DELTAS)
                ;

    }

    @Override
    public String getName() {
        return "Civilization : Biome Tags";
    }
}
