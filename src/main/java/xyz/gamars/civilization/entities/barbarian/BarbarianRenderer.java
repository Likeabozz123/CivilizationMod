package xyz.gamars.civilization.entities.barbarian;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BarbarianRenderer extends GeoEntityRenderer<BarbarianEntity> {

    public BarbarianRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BarbarianModel());
        this.shadowRadius = 0.5f;
    }


    @Override
    public ResourceLocation getTextureLocation(BarbarianEntity instance) {
        return BarbarianEntity.TEXTURE_PATH;
    }

    @Override
    public RenderType getRenderType(BarbarianEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.95f, 0.95f, 0.95f); // ACTUAL SCALE OF MODEL
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}
