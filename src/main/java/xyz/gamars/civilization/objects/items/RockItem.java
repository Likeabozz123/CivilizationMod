package xyz.gamars.civilization.objects.items;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import xyz.gamars.civilization.HelperMethods;
import xyz.gamars.civilization.objects.projectiles.RockProjectile;

//Rock that can be thrown
public class RockItem extends SnowballItem {

    public RockItem(Properties properties) {
        super(properties);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemInHand = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.GRAVEL_HIT, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            RockProjectile rockProjectile = new RockProjectile(pPlayer, pLevel);
            rockProjectile.setItem(itemInHand);
            rockProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.0F + HelperMethods.generateRandomNum(0.05f, 0.2f), 1.0F);
            pLevel.addFreshEntity(rockProjectile);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemInHand.shrink(1);
        }




        return InteractionResultHolder.sidedSuccess(itemInHand, pLevel.isClientSide());
    }

}