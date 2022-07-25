package xyz.gamars.civilization.objects.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.gui.TestGui;

public class DebugItem extends Item {

    public DebugItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
/*
            if (player.isCrouching()) {
                player.getCapability(CivCapabilities.AGE).ifPresent(age -> {
                    age.printAge(player);
                    System.out.println("Max age : " + age.getMaxAge());
                    player.displayClientMessage(Component.literal(age.getAgeText(player)).withStyle(ChatFormatting.AQUA), true);
                });
            }
            if (!player.isCrouching()) {
                player.getCapability(CivCapabilities.AGE).ifPresent(age -> {
                    age.addAge(10);
                    age.printAge(player);
                    player.displayClientMessage(Component.literal(age.getAgeText(player)).withStyle(ChatFormatting.AQUA), true);
                });
            }
*/
        } else {
            TestGui.open();
        }
        return super.use(level, player, hand);
    }


}
