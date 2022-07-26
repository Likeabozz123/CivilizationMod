package xyz.gamars.civilization.objects.projectiles;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.gamars.civilization.init.CivEntityTypes;
import xyz.gamars.civilization.init.ItemInit;

public class RockProjectile extends ThrowableItemProjectile {

    public RockProjectile(EntityType<? extends RockProjectile> entityType, Level level) {
        super(entityType, level);
    }


    public RockProjectile(double pX, double pY, double pZ, Level pLevel) {
        super(CivEntityTypes.ROCK.get(), pX, pY, pZ, pLevel);
    }

    public RockProjectile(LivingEntity pShooter, Level pLevel) {
        super(CivEntityTypes.ROCK.get(), pShooter, pLevel);
    }



    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)3);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.ROCK.get();
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }
}
