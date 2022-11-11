package xyz.gamars.civilization.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.gamars.civilization.Civilization;

import java.util.function.Supplier;

/* blocks */
public class BlockInit {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Civilization.MOD_ID);

    public static RegistryObject<RotatedPillarBlock> SAKURA_LOG = register("sakura_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)),
            new Item.Properties().tab(TabInit.BLOCKS_TAB));
    public static RegistryObject<RotatedPillarBlock> SAKURA_WOOD = register("sakura_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)),
            new Item.Properties().tab(TabInit.BLOCKS_TAB));
    public static RegistryObject<Block> SAKURA_LEAVES = register("sakura_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).noOcclusion()),
            new Item.Properties().tab(TabInit.BLOCKS_TAB));
    public static RegistryObject<Block> DEAD_SAKURA_LEAVES = register("dead_sakura_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).noOcclusion()),
            new Item.Properties().tab(TabInit.BLOCKS_TAB));
    public static RegistryObject<LadderBlock> FLOWERING_SAKURA_LEAVES_OVERLAY = register("flowering_sakura_leaves_overlay",
            () -> new LadderBlock(BlockBehaviour.Properties.of(Material.LEAVES).noOcclusion()),
            new Item.Properties().tab(TabInit.BLOCKS_TAB));
    public static RegistryObject<LadderBlock> SAKURA_VINES = register("sakura_vines",
            () -> new LadderBlock(BlockBehaviour.Properties.of(Material.LEAVES).noOcclusion()),
            new Item.Properties().tab(TabInit.BLOCKS_TAB));
    public static RegistryObject<Block> SAKURA_SAPLING = register("sakura_sapling",
            () -> new SaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.of(Material.LEAVES).noCollission().instabreak()),
            new Item.Properties().tab(TabInit.BLOCKS_TAB));


    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }


}
