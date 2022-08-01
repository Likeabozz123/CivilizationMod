package xyz.gamars.civilization.objects.items;

import com.mojang.logging.LogUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.gamars.civilization.capabilities.CivCapabilities;

import java.util.Arrays;

public class DebugItem extends Item {

    public DebugItem(Properties properties) {
        super(properties);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            if (player.isCrouching()) {
                player.getCapability(CivCapabilities.STATS).ifPresent(stat -> {
                    stat.resetStats();
                    stat.update((ServerPlayer) player);
                });
                player.getCapability(CivCapabilities.TRIBE).ifPresent(stat -> {
                    stat.resetTribe();
                });
            } else {
                LogUtils.getLogger().info("Biome Tag's : " + Arrays.toString(player.level.getBiome(player.blockPosition()).getTagKeys().filter(tagKey -> tagKey.location().getNamespace().equalsIgnoreCase("civilization")).toArray()));
                player.getCapability(CivCapabilities.STATS).ifPresent(stat -> {
                    stat.print(player);
                });
                player.getCapability(CivCapabilities.AGE).ifPresent(age -> {
                    age.print(player);
                });
                player.getCapability(CivCapabilities.TRIBE).ifPresent(age -> {
                    age.print(player);
                });
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public int getEntityLifespan(ItemStack itemStack, Level level) {
        return 20;
    }


}
