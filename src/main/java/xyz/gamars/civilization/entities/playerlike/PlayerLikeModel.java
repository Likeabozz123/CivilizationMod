package xyz.gamars.civilization.entities.playerlike;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlayerLikeModel extends AnimatedGeoModel<PlayerLikeEntity> {

    @Override
    public ResourceLocation getModelResource(PlayerLikeEntity object) {
        return PlayerLikeEntity.GEO_PATH;
    }

    @Override
    public ResourceLocation getTextureResource(PlayerLikeEntity object) {
        return PlayerLikeRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(PlayerLikeEntity animatable) {
        return PlayerLikeEntity.ANIMATION_PATH;
    }


/*    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(PlayerLikeEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }*/
}
