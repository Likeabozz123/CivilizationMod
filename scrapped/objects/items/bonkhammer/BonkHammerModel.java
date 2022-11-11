package xyz.gamars.civilization.objects.items.bonkhammer;

import net.minecraft.resources.ResourceLocation;
import software.bernie.example.item.JackInTheBoxItem;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import xyz.gamars.civilization.Civilization;

public class BonkHammerModel extends AnimatedGeoModel<BonkHammerItem> {
    @Override
    public ResourceLocation getModelResource(BonkHammerItem object) {
        return new ResourceLocation(Civilization.MOD_ID, "geo/bonk_hammer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BonkHammerItem object) {
        return new ResourceLocation(Civilization.MOD_ID, "textures/item/bonk_hammer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BonkHammerItem animatable) {
        return new ResourceLocation(Civilization.MOD_ID, "animations/bonk_hammer.animation.json");
    }
}
