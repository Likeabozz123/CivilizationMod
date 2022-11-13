package xyz.gamars.civilization.entities.barbarian;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.entities.goals.FocusPlayerGoal;
import xyz.gamars.civilization.entities.goals.StopMovingGoal;
import xyz.gamars.civilization.gui.NPCScreen;
import xyz.gamars.civilization.network.NetworkHandler;
import xyz.gamars.civilization.network.packets.PacketOpenNPCScreen;
import xyz.gamars.civilization.network.packets.RequestNPCScreen;
import xyz.gamars.civilization.objects.entities.CivMob;

public class BarbarianEntity extends CivMob {

    private AnimationFactory factory = new AnimationFactory(this);
    public static ResourceLocation TEXTURE_PATH = new ResourceLocation(Civilization.MOD_ID, "textures/entity/barbarian/caveman1.png");
    public static ResourceLocation ANIMATION_PATH = new ResourceLocation(Civilization.MOD_ID, "animations/barbarian_entity.animation.json");
    public static ResourceLocation GEO_PATH = new ResourceLocation(Civilization.MOD_ID, "geo/barbarian_entity.geo.json");

    private String walkAnimation = "animation.barbarian_entity.walk";
    private String idleAnimation = "animation.barbarian_entity.idle";

    private Player talkingPlayer;
    private final CivMob civMob = this;

    public BarbarianEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);

    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0F)
                .add(Attributes.ATTACK_SPEED, 2.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .build();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation(walkAnimation, true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation(idleAnimation, true));
        return PlayState.CONTINUE;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new StopMovingGoal(this));
        this.goalSelector.addGoal(1, new FocusPlayerGoal(this));
        this.goalSelector.addGoal(2, new FloatGoal(this));
        this.goalSelector.addGoal(3, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(7, (new HurtByTargetGoal(this)).setAlertOthers());
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
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

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND) {
            if (player.level.isClientSide()) {
                NetworkHandler.sendToServer(new RequestNPCScreen(player, this.civMob));
            }
            if (!player.level.isClientSide()) {
                setTalkingPlayer(player); // if player exists, then change the goal of the entity to look at player, when screen is closed change the talking player to null
            }
        }
        return super.mobInteract(player, hand);
    }

}
