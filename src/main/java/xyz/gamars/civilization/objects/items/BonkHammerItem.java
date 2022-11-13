package xyz.gamars.civilization.objects.items;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

/* bonk hammer that does a shit ton of damage */
public class BonkHammerItem extends SwordItem {

    public BonkHammerItem(Properties pProperties) {
        super(Tiers.WOOD, 9001 - 1, 9001 - 4, pProperties);
    }



}
