package xyz.gamars.civilization.world.feature;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.RootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class CivTreeConfig implements FeatureConfiguration {

    public static final Codec<CivTreeConfig> CODEC = RecordCodecBuilder.create((codec) -> {
        return codec.group(BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter((config) -> {
            return config.trunkProvider;
        }), TrunkPlacer.CODEC.fieldOf("trunk_placer").forGetter((config) -> {
            return config.trunkPlacer;
        }), BlockStateProvider.CODEC.fieldOf("foliage_provider").forGetter((config) -> {
            return config.foliageProvider;
        }), FoliagePlacer.CODEC.fieldOf("foliage_placer").forGetter((config) -> {
            return config.foliagePlacer;
        }), RootPlacer.CODEC.optionalFieldOf("root_placer").forGetter((config) -> {
            return config.rootPlacer;
        }), BlockStateProvider.CODEC.fieldOf("dirt_provider").forGetter((config) -> {
            return config.dirtProvider;
        }), FeatureSize.CODEC.fieldOf("minimum_size").forGetter((config) -> {
            return config.minimumSize;
        }), TreeDecorator.CODEC.listOf().fieldOf("decorators").forGetter((config) -> {
            return config.decorators;
        }), Codec.BOOL.fieldOf("ignore_vines").orElse(false).forGetter((config) -> {
            return config.ignoreVines;
        }), Codec.BOOL.fieldOf("force_dirt").orElse(false).forGetter((config) -> {
            return config.forceDirt;
        })).apply(codec, CivTreeConfig::new);
    });

    public final BlockStateProvider trunkProvider;
    public final BlockStateProvider dirtProvider;
    public final TrunkPlacer trunkPlacer;
    public final BlockStateProvider foliageProvider;
    public final FoliagePlacer foliagePlacer;
    public final Optional<RootPlacer> rootPlacer;
    public final FeatureSize minimumSize;
    public final List<TreeDecorator> decorators;
    public final boolean ignoreVines;
    public final boolean forceDirt;

    protected CivTreeConfig(BlockStateProvider p_225457_, TrunkPlacer p_225458_, BlockStateProvider p_225459_, FoliagePlacer p_225460_, Optional<RootPlacer> p_225461_, BlockStateProvider p_225462_, FeatureSize p_225463_, List<TreeDecorator> p_225464_, boolean p_225465_, boolean p_225466_) {
        this.trunkProvider = p_225457_;
        this.trunkPlacer = p_225458_;
        this.foliageProvider = p_225459_;
        this.foliagePlacer = p_225460_;
        this.rootPlacer = p_225461_;
        this.dirtProvider = p_225462_;
        this.minimumSize = p_225463_;
        this.decorators = p_225464_;
        this.ignoreVines = p_225465_;
        this.forceDirt = p_225466_;
    }

    public static class CivTreeBuilder {
        public final BlockStateProvider trunkProvider;
        private final TrunkPlacer trunkPlacer;
        public final BlockStateProvider foliageProvider;
        private final FoliagePlacer foliagePlacer;
        private final Optional<RootPlacer> rootPlacer;
        private BlockStateProvider dirtProvider;
        private final FeatureSize minimumSize;
        private List<TreeDecorator> decorators = ImmutableList.of();
        private boolean ignoreVines;
        private boolean forceDirt;

        public CivTreeBuilder(BlockStateProvider p_225481_, TrunkPlacer p_225482_, BlockStateProvider p_225483_, FoliagePlacer p_225484_, Optional<RootPlacer> p_225485_, FeatureSize p_225486_) {
            this.trunkProvider = p_225481_;
            this.trunkPlacer = p_225482_;
            this.foliageProvider = p_225483_;
            this.dirtProvider = BlockStateProvider.simple(Blocks.DIRT);
            this.foliagePlacer = p_225484_;
            this.rootPlacer = p_225485_;
            this.minimumSize = p_225486_;
        }

        public CivTreeBuilder(BlockStateProvider pTrunkProvider, TrunkPlacer pTrunkPlacer, BlockStateProvider pFoliageProvider, FoliagePlacer pFoliagePlacer, FeatureSize pMinimumSize) {
            this(pTrunkProvider, pTrunkPlacer, pFoliageProvider, pFoliagePlacer, Optional.empty(), pMinimumSize);
        }

        public CivTreeBuilder dirt(BlockStateProvider pDirtProvider) {
            this.dirtProvider = pDirtProvider;
            return this;
        }

        public CivTreeBuilder decorators(List<TreeDecorator> pDecorators) {
            this.decorators = pDecorators;
            return this;
        }

        public CivTreeBuilder ignoreVines() {
            this.ignoreVines = true;
            return this;
        }

        public CivTreeBuilder forceDirt() {
            this.forceDirt = true;
            return this;
        }

        public CivTreeConfig build() {
            return new CivTreeConfig(this.trunkProvider, this.trunkPlacer, this.foliageProvider, this.foliagePlacer, this.rootPlacer, this.dirtProvider, this.minimumSize, this.decorators, this.ignoreVines, this.forceDirt);
        }
    }

}
