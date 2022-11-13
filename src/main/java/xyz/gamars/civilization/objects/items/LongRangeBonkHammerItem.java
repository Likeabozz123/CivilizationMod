package xyz.gamars.civilization.objects.items;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import xyz.gamars.civilization.HelperMethods;
import xyz.gamars.civilization.objects.projectiles.BonkHammerProjectile;
import xyz.gamars.civilization.objects.projectiles.RockProjectile;

//Bonkhammer but for lazy people that need to throw it
public class LongRangeBonkHammerItem extends SwordItem {

    public LongRangeBonkHammerItem(Properties pProperties) {
        super(Tiers.WOOD, 9001 - 1, 9001 - 4, pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemInHand = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            BonkHammerProjectile bonkHammerProjectile = new BonkHammerProjectile(pPlayer, pLevel);
            bonkHammerProjectile.setItem(itemInHand);
            bonkHammerProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 10.0F, 0);
            pLevel.addFreshEntity(bonkHammerProjectile);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemInHand.shrink(1);
        }




        return InteractionResultHolder.sidedSuccess(itemInHand, pLevel.isClientSide());
    }

}