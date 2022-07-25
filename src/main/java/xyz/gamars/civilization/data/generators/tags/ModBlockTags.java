package xyz.gamars.civilization.data.generators.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.civilization.Civilization;

public class ModBlockTags extends BlockTagsProvider {
    public ModBlockTags(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator,  Civilization.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }

    @Override
    public String getName() {
        return "Civilization : Block Tags";
    }
}
