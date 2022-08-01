package xyz.gamars.civilization.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.entities.CivEntityTypes;
import xyz.gamars.civilization.objects.items.DebugItem;

public class ItemInit {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Civilization.MOD_ID);

    public static RegistryObject<Item> DEBUG_ITEM = ITEMS.register("debug_item", () -> new DebugItem(new Item.Properties().tab(Tabinit.ITEMS_TAB)));
    public static final RegistryObject<Item> PLAYER_LIKE_SPAWN_EGG = ITEMS.register("player_spawn_egg",
            () -> new ForgeSpawnEggItem(CivEntityTypes.PLAYER_LIKE,0xffffff, 0x00b6ff,
                    new Item.Properties().tab(Tabinit.ITEMS_TAB)));
    public static final RegistryObject<Item> BARBARIAN_SPAWN_EGG = ITEMS.register("barbarian_spawn_egg",
            () -> new ForgeSpawnEggItem(CivEntityTypes.BARBARIAN,0xffffff, 0xff3c00,
                    new Item.Properties().tab(Tabinit.ITEMS_TAB)));

}
