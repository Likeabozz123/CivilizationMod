package xyz.gamars.civilization.entities.barbarian;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BarbarianModel extends AnimatedGeoModel<BarbarianEntity> {

    @Override
    public ResourceLocation getModelResource(BarbarianEntity object) {
        return BarbarianEntity.GEO_PATH;
    }

    @Override
    public ResourceLocation getTextureResource(BarbarianEntity object) {
        return BarbarianEntity.TEXTURE_PATH;
    }

    @Override
    public ResourceLocation getAnimationResource(BarbarianEntity animatable) {
        return BarbarianEntity.ANIMATION_PATH;
    }

}
