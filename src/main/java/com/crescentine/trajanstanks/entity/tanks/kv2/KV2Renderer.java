package com.crescentine.trajanstanks.entity.tanks.kv2;

import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.particles.ParticleTypes;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class KV2Renderer extends GeoEntityRenderer<KV2Entity> {
    public KV2Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new KV2Model());
        this.shadowRadius = 0.7F;
    }
    @Override
    public void render(GeoModel model, KV2Entity animatable, float partialTick, RenderType type, PoseStack poseStack, @javax.annotation.Nullable MultiBufferSource bufferSource, @javax.annotation.Nullable VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.render(model, animatable, partialTick, type, poseStack, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        if (animatable.getFuelAmount() > 0 && model.getBone("engine").isPresent() && animatable.isVehicle() && animatable.isMoving()) {
            animatable.getCommandSenderWorld().addParticle(ParticleTypes.LARGE_SMOKE,
                    model.getBone("engine").get().getWorldPosition().x,
                    model.getBone("engine").get().getWorldPosition().y,
                    model.getBone("engine").get().getWorldPosition().z,
                    (animatable.getRandom().nextGaussian() * 0.0003D), -animatable.getRandom().nextGaussian() * 0.0003D,
                    (animatable.getRandom().nextGaussian() * 0.0003D));
        }
    }
}