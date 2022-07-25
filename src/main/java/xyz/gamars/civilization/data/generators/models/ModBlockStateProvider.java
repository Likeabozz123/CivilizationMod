package xyz.gamars.civilization.data.generators.models;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import xyz.gamars.civilization.Civilization;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Civilization.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {


    }

    @NotNull
    @Override
    public String getName() {
        return "Civilization : Block State";
    }



}
