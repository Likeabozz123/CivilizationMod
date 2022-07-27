package xyz.gamars.civilization.objects.entities;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CivMob extends Animal implements IAnimatable {

    private AnimationFactory factory;
    private Player talkingPlayer;

    public CivMob(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.factory = new AnimationFactory(this);
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        return PlayState.CONTINUE;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public static AttributeSupplier setAttributes() {
        return null;
    }

    public boolean isTalking() {
        return this.talkingPlayer != null;
    }

    public void setTalkingPlayer(Player player) {
        this.talkingPlayer = player;
    }

    public Player getTalkingPlayer() {
        return this.talkingPlayer;
    }


}
