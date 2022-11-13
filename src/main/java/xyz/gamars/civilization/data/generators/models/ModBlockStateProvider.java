package xyz.gamars.civilization.data.generators.models;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.init.BlockInit;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Civilization.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        /* sakura */
        logBlock(BlockInit.SAKURA_LOG.get());
        axisBlock(BlockInit.SAKURA_WOOD.get(), blockTexture(BlockInit.SAKURA_WOOD.get()), blockTexture(BlockInit.SAKURA_WOOD.get()));
        cutoutBlock(BlockInit.SAKURA_LEAVES.get());
        cutoutBlock(BlockInit.DEAD_SAKURA_LEAVES.get());
        saplingBlock(BlockInit.SAKURA_SAPLING.get(), "sakura_sapling");
        flatBlock(BlockInit.SAKURA_VINES.get());
        flatBlock(BlockInit.FLOWERING_SAKURA_LEAVES_OVERLAY.get());
    }

    @NotNull
    @Override
    public String getName() {
        return "Civilization : Block State";
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    public void cutoutBlock(Block block) {
        simpleBlock(block, models().cubeAll(ForgeRegistries.BLOCKS.getKey(block).getPath(), blockTexture(block)).renderType("cutout"));
    }

    public void saplingBlock(Block block, String id) {
        simpleBlock(block, models().cross(id,modLoc("block/" + id)).renderType("cutout"));
    }

    public void flatBlock(Block block) {
        ModelFile modelFile = models().getBuilder(name(block))
                .ao(false)
                .texture("particle", blockTexture(block))
                .texture("texture", blockTexture(block))
                .element().from(0f,0f, 15.2f).to(16f, 16f, 15.2f).shade(false)
                .face(Direction.SOUTH).uvs(16f, 0f, 0f, 16f).texture("#texture").end()
                .face(Direction.NORTH).uvs(0f, 0f, 16f, 16f).texture("#texture").end() // THIS ONE WON'T APPLY :shrug: IF LATER VISUAL GLITCHES HAPPEN COULD BE DUE TO THIS
                .end()
                .renderType("cutout");

        getVariantBuilder(block)
                .partialState().with(HorizontalDirectionalBlock.FACING, Direction.EAST)
                .modelForState().modelFile(modelFile)
                .rotationY(90).addModel()
                .partialState().with(HorizontalDirectionalBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(modelFile)
                .rotationY(0).addModel()
                .partialState().with(HorizontalDirectionalBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(modelFile)
                .rotationY(180).addModel()
                .partialState().with(HorizontalDirectionalBlock.FACING, Direction.WEST)
                .modelForState().modelFile(modelFile)
                .rotationY(270).addModel();
    }


}
