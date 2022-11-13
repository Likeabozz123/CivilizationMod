package xyz.gamars.civilization.objects.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TooltipItem extends Item {

    public final String tooltip;

    public TooltipItem(Properties pProperties, String tooltip) {
        super(pProperties);
        this.tooltip = tooltip;
    }
    public TooltipItem(Properties pProperties) {
        super(pProperties);
        this.tooltip = "";
    }


    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.literal(tooltip));
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
