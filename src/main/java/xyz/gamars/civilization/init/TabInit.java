package xyz.gamars.civilization.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/* creative tabs */
public class TabInit {


    public static final CreativeModeTab ITEMS_TAB = new CreativeModeTab("items_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.DEBUG_ITEM.get());
        }
    };

    public static final CreativeModeTab BLOCKS_TAB = new CreativeModeTab("blocks_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.SAKURA_LOG.get());
        }
    };

    public static final CreativeModeTab ARMOR_TAB = new CreativeModeTab("armor_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.AIR);
        }
    };

    public static final CreativeModeTab TOOLS_TAB = new CreativeModeTab("tools_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.AIR);
        }
    };

    public static final CreativeModeTab FOODS_TAB = new CreativeModeTab("foods_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.AIR);
        }
    };

    public static final CreativeModeTab ADVANCED_BLOCKS_TAB = new CreativeModeTab("advanced_blocks_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.AIR);
        }
    };

    public static final CreativeModeTab ADVANCED_ITEMS_TAB = new CreativeModeTab("advanced_items_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.AIR);
        }
    };


}
