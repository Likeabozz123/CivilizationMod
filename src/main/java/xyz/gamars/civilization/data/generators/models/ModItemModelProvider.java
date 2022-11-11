package xyz.gamars.civilization.data.generators.models;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.init.BlockInit;
import xyz.gamars.civilization.init.ItemInit;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Civilization.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));

        // withExistingParent(ItemInit.TEST_ITEM.get().getRegistryName().getPath(), modLoc("item/test_item"));

        builder(ItemInit.DEBUG_ITEM, itemHandheld);
        // builder(ItemInit.BONK_HAMMER, itemGenerated);

        spawnEggBuilder(ItemInit.PLAYER_LIKE_SPAWN_EGG, itemGenerated);
        spawnEggBuilder(ItemInit.BARBARIAN_SPAWN_EGG, itemGenerated);
        blockBuilder(BlockInit.SAKURA_LOG);
        blockBuilder(BlockInit.SAKURA_WOOD);
        blockBuilder(BlockInit.SAKURA_LEAVES);
        blockBuilder(BlockInit.DEAD_SAKURA_LEAVES);
        blockBuilder(BlockInit.SAKURA_SAPLING, itemGenerated);
        blockBuilder(BlockInit.SAKURA_VINES, itemGenerated);
        blockBuilder(BlockInit.FLOWERING_SAKURA_LEAVES_OVERLAY, itemGenerated);

    }

    private ItemModelBuilder builder(String name, ModelFile parent) {
        return getBuilder(name).parent(parent).texture("layer0", "item/" + name);
    }

    private ItemModelBuilder builder(RegistryObject item, ModelFile parent) {
        String itemName = item.getId().toString().split(":")[1];
        return getBuilder(itemName).parent(parent).texture("layer0", "item/" + itemName);
    }

    private ItemModelBuilder spawnEggBuilder(RegistryObject item, ModelFile parent) {
        String itemName = item.getId().toString().split(":")[1];
        return getBuilder(itemName).parent(parent).texture("layer0", "item/spawn_egg").texture("layer1", "item/spawn_egg_overlay");
    }

    private ItemModelBuilder blockBuilder(String name) {
        return withExistingParent(name, modLoc("block/" + name));
    }

    private ItemModelBuilder blockBuilder(RegistryObject item) {
        String itemName = item.getId().toString().split(":")[1];
        return withExistingParent(itemName, modLoc("block/" + itemName));
    }

    private ItemModelBuilder blockBuilder(RegistryObject item, ModelFile parent) {
        String itemName = item.getId().toString().split(":")[1];
        return getBuilder(itemName).parent(parent).texture("layer0", "block/" + itemName);
    }


    private void armorBuilder(String armorMaterial, ModelFile parent) {
        builder(armorMaterial + "_helmet", parent);
        builder(armorMaterial + "_chestplate", parent);
        builder(armorMaterial + "_leggings", parent);
        builder(armorMaterial + "_boots", parent);
    }

    private void toolBuilder(String toolMaterial, ModelFile parent) {
        builder(toolMaterial + "_pickaxe", parent);
        builder(toolMaterial + "_axe", parent);
        builder(toolMaterial + "_shovel", parent);
        builder(toolMaterial + "_sword", parent);
        builder(toolMaterial + "_hoe", parent);
    }

    private ItemModelBuilder blockBuilder(String name, ModelFile parent) {
        return getBuilder(name).parent(parent).texture("layer0", "block/" + name);
    }

    @NotNull
    @Override
    public String getName() {
        return "Civilization : Item Models";
    }
}
