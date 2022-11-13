package xyz.gamars.civilization.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.entities.barbarian.BarbarianEntity;
import xyz.gamars.civilization.entities.playerlike.PlayerLikeEntity;
import xyz.gamars.civilization.objects.projectiles.RockProjectile;

/* entity types */
/* don't forget to render the entity types inside the main class */
public class CivEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Civilization.MOD_ID);


    /* projectiles */
    public static final RegistryObject<EntityType<RockProjectile>> ROCK = ENTITY_TYPES.register("rock_projectile",
            () -> EntityType.Builder.<RockProjectile>of(RockProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4).updateInterval(10)
                    .build(new ResourceLocation(Civilization.MOD_ID, "rock_projectile").toString()));

    /* npc like entities */
    public static final RegistryObject<EntityType<PlayerLikeEntity>> PLAYER_LIKE = ENTITY_TYPES.register("player_like",
            () -> EntityType.Builder.of(PlayerLikeEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8F) // HITBOX MODEL
                    .build(new ResourceLocation(Civilization.MOD_ID, "player_like").toString()));
    public static final RegistryObject<EntityType<BarbarianEntity>> BARBARIAN = ENTITY_TYPES.register("barbarian",
            () -> EntityType.Builder.of(BarbarianEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8F) // HITBOX MODEL
                    .build(new ResourceLocation(Civilization.MOD_ID, "barbarian").toString()));

}
