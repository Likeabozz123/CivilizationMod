package xyz.gamars.civilization.data.generators;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.init.ItemInit;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(DataGenerator gen, String locale) {
        super(gen, Civilization.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {

        add(ItemInit.DEBUG_ITEM.get(), "Debug Item");
        add(ItemInit.PLAYER_LIKE_SPAWN_EGG.get(), "Player Spawn Egg");

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
    }




    @Override
    public String getName() {
        return "Civilization : Language";
    }
}
