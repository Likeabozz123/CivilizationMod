package xyz.gamars.civilization.entities.playerlike;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import xyz.gamars.civilization.Civilization;

import java.util.Map;

public class PlayerLikeRenderer extends GeoEntityRenderer<PlayerLikeEntity> {


    public PlayerLikeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PlayerLikeModel());
        this.shadowRadius = 0.5f;
    }


    public static final Map<PlayerLikeVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(PlayerLikeVariant.class), (p_114874_) -> {
                p_114874_.put(PlayerLikeVariant.DEFAULT,
                        new ResourceLocation(Civilization.MOD_ID, "textures/entity/player_like/likeabozz123.png"));
                p_114874_.put(PlayerLikeVariant.JEFFCHICKEN13,
                        new ResourceLocation(Civilization.MOD_ID, "textures/entity/player_like/jeffchicken13.png"));
                p_114874_.put(PlayerLikeVariant.HEROBRINE,
                        new ResourceLocation(Civilization.MOD_ID, "textures/entity/player_like/herobrine.png"));
            });

    @Override
    public ResourceLocation getTextureLocation(PlayerLikeEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(PlayerLikeEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if(animatable.isBaby()) {
            stack.scale(0.4F, 0.4F, 0.4F);
        } else {
            stack.scale(0.95f, 0.95f, 0.95f); // ACTUAL SCALE OF MODEL
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
