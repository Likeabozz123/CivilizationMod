package xyz.gamars.civilization.objects.items;

import com.google.common.collect.ImmutableMultimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeMod;
import xyz.gamars.civilization.objects.CivTiers;

/* bonk hammer that does a shit ton of damage */
public class BonkHammerItem extends SwordItem {

    public BonkHammerItem(Properties pProperties) {
        super(Tiers.WOOD, 9001 - 1, 9001 - 4, pProperties);
    }



}
