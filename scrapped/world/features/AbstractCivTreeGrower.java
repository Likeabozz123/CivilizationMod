package xyz.gamars.civilization.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class AbstractCivTreeGrower<T extends CivTreeConfig> extends Feature<T> {

    public AbstractCivTreeGrower(Codec<T> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<T> context) {
        return false;
    }
}
