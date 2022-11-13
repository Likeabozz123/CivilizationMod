package xyz.gamars.civilization.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.objects.items.*;

/* items */
public class ItemInit {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Civilization.MOD_ID);

    /* dev items */
    public static RegistryObject<Item> DEBUG_ITEM = ITEMS.register("debug_item", () -> new DebugItem(new Item.Properties().tab(TabInit.ITEMS_TAB)));
    public static RegistryObject<Item> BONK_HAMMER = ITEMS.register("bonk_hammer", () -> new BonkHammerItem(new Item.Properties().tab(TabInit.ITEMS_TAB)));
    public static RegistryObject<Item> LONG_RANGE_BONK_HAMMER = ITEMS.register("long_range_bonk_hammer", () -> new LongRangeBonkHammerItem(new Item.Properties().tab(TabInit.ITEMS_TAB)));

    /* caveman era items */
    public static RegistryObject<Item> ROCK = ITEMS.register("rock", () -> new RockItem(new Item.Properties().tab(TabInit.ITEMS_TAB).rarity(Rarity.EPIC)));

    /* foods */
    public static RegistryObject<Item> GRASSHOPPER = ITEMS.register("grasshopper", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).meat().build()), ""));
    public static RegistryObject<Item> COOKED_GRASSHOPPER = ITEMS.register("cooked_grasshopper", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).meat().build()), ""));
    public static RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), ""));
    public static RegistryObject<Item> WALNUT = ITEMS.register("walnut", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build()), ""));
    public static RegistryObject<Item> CHESTNUT = ITEMS.register("chestnut", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build()), ""));
    public static RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build()), ""));
    public static RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build()), ""));
    public static RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), ""));
    public static RegistryObject<Item> COCONUT = ITEMS.register("coconut", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), ""));
    public static RegistryObject<Item> SMALL_CRAB = ITEMS.register("small_crab", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(1).meat().saturationMod(0.2F).build()), ""));
    public static RegistryObject<Item> CRAB = ITEMS.register("crab", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(2).meat().saturationMod(0.2F).build()), ""));
    public static RegistryObject<Item> LARVA = ITEMS.register("larva", () -> new TooltipItem(new Item.Properties().tab(TabInit.FOODS_TAB).food(new FoodProperties.Builder().nutrition(1).meat().saturationMod(0.2F).build()), ""));

    /* drinks */
    public static RegistryObject<Item> WINE = ITEMS.register("wine", () -> new DrinkableItem(new Item.Properties().tab(TabInit.DRINKS_TAB), 32, 0x722F37));
    public static RegistryObject<Item> BEER = ITEMS.register("beer", () -> new DrinkableItem(new Item.Properties().tab(TabInit.DRINKS_TAB), 32,0xf28e1c));
    public static RegistryObject<Item> AMBROSIA = ITEMS.register("ambrosia", () -> new DrinkableItem(new Item.Properties().tab(TabInit.DRINKS_TAB), 3, 0xf28e1c));

    /* spawn eggs */
    public static final RegistryObject<Item> PLAYER_LIKE_SPAWN_EGG = ITEMS.register("player_spawn_egg",
            () -> new ForgeSpawnEggItem(CivEntityTypes.PLAYER_LIKE,0xffffff, 0x00b6ff,
                    new Item.Properties().tab(TabInit.ITEMS_TAB)));
    public static final RegistryObject<Item> BARBARIAN_SPAWN_EGG = ITEMS.register("barbarian_spawn_egg",
            () -> new ForgeSpawnEggItem(CivEntityTypes.BARBARIAN,0xffffff, 0xff3c00,
                    new Item.Properties().tab(TabInit.ITEMS_TAB)));



}
