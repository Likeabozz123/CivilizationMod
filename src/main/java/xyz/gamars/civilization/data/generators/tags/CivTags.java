package xyz.gamars.civilization.data.generators.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import xyz.gamars.civilization.Civilization;

public class CivTags {

    public static final class Blocks {
        // public static final TagKey<Block> EXAMPLE_TAG = mod("example_tag");

        private static TagKey<Block> forge(String path) {
            return BlockTags.create(new ResourceLocation("forge", path));
        }

        private static TagKey<Block> mod(String path) {
            return BlockTags.create(new ResourceLocation(Civilization.MOD_ID, path));
        }
    }

    public static final class Items {
        // public static final TagKey<Item> EXAMPLE_TAG = mod("example_tag");

        public static final TagKey<Item> COOL_ARMOR = mod("cool_armor");
        public static final TagKey<Item> WARM_ARMOR = mod("warm_armor");
        public static final TagKey<Item> HOT_ARMOR = mod("hot_armor");

        private static TagKey<Item> forge(String path) {
            return ItemTags.create(new ResourceLocation("forge", path));
        }

        private static TagKey<Item> mod(String path) {
            return ItemTags.create(new ResourceLocation(Civilization.MOD_ID, path));
        }
    }

    public static final class Biomes {
        // public static final TagKey<Item> EXAMPLE_TAG = mod("example_tag");

        public static final TagKey<Biome> EXTREMELY_COLD_BIOME = mod("extremely_cold_biome");
        public static final TagKey<Biome> COLD_BIOME = mod("cold_biome");
        public static final TagKey<Biome> COOL_BIOME = mod("cool_biome");
        public static final TagKey<Biome> WARM_BIOME = mod("warm_biome");
        public static final TagKey<Biome> HOT_BIOME = mod("hot_biome");
        public static final TagKey<Biome> EXTREMELY_HOT_BIOME = mod("extremely_hot_biome");

        private static TagKey<Biome> forge(String path) {
            return create(new ResourceLocation("forge", path));
        }

        private static TagKey<Biome> mod(String path) {
            return create(new ResourceLocation(Civilization.MOD_ID, path));
        }

        public static TagKey<Biome> create(final ResourceLocation name) {
            return TagKey.create(Registry.BIOME_REGISTRY, name);
        }
    }





}
