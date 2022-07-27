package xyz.gamars.civilization.objects.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DebugItem extends Item {

    public DebugItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (player.isCrouching()) {
            if (!level.isClientSide()) {

            }
        } else {
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
                // Minecraft.getInstance().setScreen(new NPCScreen());
            }
        }
        return super.use(level, player, hand);
    }


}
