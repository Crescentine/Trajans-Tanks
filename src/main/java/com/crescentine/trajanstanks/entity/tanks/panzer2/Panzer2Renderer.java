package com.crescentine.trajanstanks.entity.tanks.panzer2;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class Panzer2Renderer extends GeoEntityRenderer<Panzer2Entity> {
    public Panzer2Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Panzer2Model());
        this.shadowRadius = 0.7F;
    }

    @Override
    public void renderRecursively(GeoBone bone, PoseStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if (bone.getName().equals("TopPart")) { // TopPart is the name of the bone you to set the item to attach too. Please see Note
            stack.pushPose();
            stack.scale(1.0f, 1.0f, 1.0f);
            stack.popPose();
            bufferIn = rtb.getBuffer(RenderType.entityTranslucent(whTexture));
        }
            super.renderRecursively(bone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}