package xyz.gamars.civilization.entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.entities.barbarian.BarbarianEntity;
import xyz.gamars.civilization.entities.playerlike.PlayerLikeEntity;

public class CivEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITIY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Civilization.MOD_ID);

    public static final RegistryObject<EntityType<PlayerLikeEntity>> PLAYER_LIKE = ENTITIY_TYPES.register("player_like",
            () -> EntityType.Builder.of(PlayerLikeEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8F) // HITBOX MODEL
                    .build(new ResourceLocation(Civilization.MOD_ID, "player_like").toString()));
    public static final RegistryObject<EntityType<BarbarianEntity>> BARBARIAN = ENTITIY_TYPES.register("barbarian",
            () -> EntityType.Builder.of(BarbarianEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8F) // HITBOX MODEL
                    .build(new ResourceLocation(Civilization.MOD_ID, "barbarian").toString()));

}
