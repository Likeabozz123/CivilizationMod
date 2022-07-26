package xyz.gamars.civilization.data.generators;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.init.BlockInit;
import xyz.gamars.civilization.init.CivEntityTypes;
import xyz.gamars.civilization.init.ItemInit;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(DataGenerator gen, String locale) {
        super(gen, Civilization.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {

        /* creative tabs */
        addCreativeTab("items_tab", "Items Tab");
        addCreativeTab("blocks_tab", "Blocks Tab");
        addCreativeTab("armor_tab", "Armor Tab");
        addCreativeTab("tools_tab", "Tools Tab");
        addCreativeTab("foods_tab", "Foods Tab");
        addCreativeTab("drinks_tab", "Drinks Tab");
        addCreativeTab("advanced_blocks_tab", "Advanced Blocks Tab");
        addCreativeTab("advanced_items_tab", "Advanced Items Tab");

        /* sakura */
        add(BlockInit.SAKURA_LOG.get(), "Sakura Log");
        add(BlockInit.SAKURA_WOOD.get(), "Sakura Wood");
        add(BlockInit.SAKURA_LEAVES.get(), "Sakura Leaves");
        add(BlockInit.DEAD_SAKURA_LEAVES.get(), "Dead Sakura Leaves");
        add(BlockInit.FLOWERING_SAKURA_LEAVES_OVERLAY.get(), "Flowering Sakura Leaves");
        add(BlockInit.SAKURA_VINES.get(), "Sakura Vines");
        add(BlockInit.SAKURA_SAPLING.get(), "Sakura Sapling");

        /* dev items */
        add(ItemInit.DEBUG_ITEM.get(), "Debug Item");
        add(ItemInit.BONK_HAMMER.get(), "Bonk Hammer");
        add(ItemInit.LONG_RANGE_BONK_HAMMER.get(), "Long Range Bonk Hammer");

        /* drinks */
        add(ItemInit.WINE.get(), "Wine");
        add(ItemInit.BEER.get(), "Beer");
        add(ItemInit.AMBROSIA.get(), "Ambrosia");

        /* foods */
        add(ItemInit.GRASSHOPPER.get(), "Grasshopper");
        add(ItemInit.COOKED_GRASSHOPPER.get(), "Cooked Grasshopper");
        add(ItemInit.STRAWBERRY.get(), "Strawberry");
        add(ItemInit.WALNUT.get(), "Walnut");
        add(ItemInit.CHESTNUT.get(), "Chestnut");
        add(ItemInit.GRAPES.get(), "Grapes");
        add(ItemInit.BLUEBERRY.get(), "Blueberry");
        add(ItemInit.BANANA.get(), "Banana");
        add(ItemInit.COCONUT.get(), "Coconut");
        add(ItemInit.SMALL_CRAB.get(), "Small Crab");
        add(ItemInit.CRAB.get(), "Crab");
        add(ItemInit.LARVA.get(), "Larva");

        /* caveman era items */
        add(ItemInit.ROCK.get(), "Rock");

        /* spawn eggs */
        add(ItemInit.PLAYER_LIKE_SPAWN_EGG.get(), "Player Spawn Egg");
        add(ItemInit.BARBARIAN_SPAWN_EGG.get(), "Barbarian Spawn Egg");

        /* entity types */
        add(CivEntityTypes.PLAYER_LIKE.get(), "PlayerLike");
        add(CivEntityTypes.BARBARIAN.get(), "Barbarian");

    }

    /*public LanguageProvider addItem (String id, String name) {
        id.toUpperCase();
        return add(ItemInit.id.get(), name);
    }*/

    public void addCreativeTab(String id, String name) {
        add("itemGroup." + id, name);
    }

    private void addArmor(String armorMaterial) {
        String upperCaseArmorMaterial = armorMaterial.substring(0, 1).toUpperCase() + armorMaterial.substring(1);
        add("item." + Civilization.MOD_ID +"." + armorMaterial + "_helmet", upperCaseArmorMaterial + " Helmet");
        add("item." + Civilization.MOD_ID +"." + armorMaterial + "_chestplate", upperCaseArmorMaterial + " Chestplate");
        add("item." + Civilization.MOD_ID +"." + armorMaterial + "_leggings", upperCaseArmorMaterial + " Leggings");
        add("item." + Civilization.MOD_ID +"." + armorMaterial + "_boots", upperCaseArmorMaterial + " Boots");
    }

    private void addTools(String toolMaterial) {
        String upperCaseToolMaterial = toolMaterial.substring(0, 1).toUpperCase() + toolMaterial.substring(1);
        add("item." + Civilization.MOD_ID +"." + toolMaterial + "_pickaxe", upperCaseToolMaterial + " Pickaxe");
        add("item." + Civilization.MOD_ID +"." + toolMaterial + "_axe", upperCaseToolMaterial + " Axe");
        add("item." + Civilization.MOD_ID +"." + toolMaterial + "_shovel", upperCaseToolMaterial + " Shovel");
        add("item." + Civilization.MOD_ID +"." + toolMaterial + "_sword", upperCaseToolMaterial + " Sword");
        add("item." + Civilization.MOD_ID +"." + toolMaterial + "_hoe", upperCaseToolMaterial + " Hoe");
        add("item." + Civilization.MOD_ID +"." + toolMaterial + "_hoe", upperCaseToolMaterial + " Hoe");
    }



    @Override
    public String getName() {
        return "Civilization : Language";
    }
}
