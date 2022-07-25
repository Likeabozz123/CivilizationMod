package xyz.gamars.civilization.entities.playerlike;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import xyz.gamars.civilization.Civilization;

public class PlayerLikeModel extends AnimatedGeoModel<PlayerLikeEntity> {

    @Override
    public ResourceLocation getModelResource(PlayerLikeEntity object) {
        return new ResourceLocation(Civilization.MOD_ID, "geo/player_like_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlayerLikeEntity object) {
        return new ResourceLocation(Civilization.MOD_ID, "textures/entity/player_like/likeabozz123.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PlayerLikeEntity animatable) {
        return new ResourceLocation(Civilization.MOD_ID, "animations/player_like_entity.animation.json");
    }
}
