package xyz.gamars.civilization.objects.items.bonkhammer;

import software.bernie.example.item.JackInTheBoxItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class BonkHammerRenderer extends GeoItemRenderer<BonkHammerItem> {

    public BonkHammerRenderer() {
        super(new BonkHammerModel());
    }
}
