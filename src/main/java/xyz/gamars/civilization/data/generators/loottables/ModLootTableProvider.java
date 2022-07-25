package xyz.gamars.civilization.data.generators.loottables;

import net.minecraft.data.DataGenerator;

public class ModLootTableProvider extends BaseLootTableProvider {

    public ModLootTableProvider(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
   }

    @Override
    public String getName() {
        return "Civilization : Loot Tables";
    }
}
