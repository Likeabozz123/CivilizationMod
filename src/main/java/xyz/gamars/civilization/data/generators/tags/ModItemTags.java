package xyz.gamars.civilization.data.generators.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.civilization.Civilization;

public class ModItemTags extends ItemTagsProvider {
    public ModItemTags(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, Civilization.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {


    }

    @Override
    public String getName() {
        return "Civilization : Item Tags";
    }
}
