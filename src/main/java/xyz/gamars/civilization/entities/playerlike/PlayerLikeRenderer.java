package xyz.gamars.civilization.entities.playerlike;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import xyz.gamars.civilization.Civilization;

public class PlayerLikeRenderer extends GeoEntityRenderer<PlayerLikeEntity> {


    public PlayerLikeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PlayerLikeModel());
        this.shadowRadius = 0.5f;
    }


    @Override
    public ResourceLocation getTextureLocation(PlayerLikeEntity instance) {
        return new ResourceLocation(Civilization.MOD_ID, "textures/entity/player_like/likeabozz123.png");
    }

    @Override
    public RenderType getRenderType(PlayerLikeEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.95f, 0.95f, 0.95f); // ACTUAL SCALE OF MODEL
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
