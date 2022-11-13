package xyz.gamars.civilization.objects.projectiles;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class BaseItemProjectile extends ThrowableItemProjectile {

    private final Item item;
    private final float damage;

    public BaseItemProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel, Item item, float damage) {
        super(pEntityType, pLevel);
        this.item = item;
        this.damage = damage;
    }

    public BaseItemProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, double pX, double pY, double pZ, Level pLevel, Item item, float damage) {
        super(pEntityType, pX, pY, pZ, pLevel);
        this.item = item;
        this.damage = damage;
    }

    public BaseItemProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, LivingEntity pShooter, Level pLevel, Item item, float damage) {
        super(pEntityType, pShooter, pLevel);
        this.item = item;
        this.damage = damage;
    }

    @Override
    protected Item getDefaultItem() {
        return item;
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), damage);
    }
}
