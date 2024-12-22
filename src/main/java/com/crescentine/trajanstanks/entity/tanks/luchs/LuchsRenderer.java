package com.crescentine.trajanstanks.entity.tanks.luchs;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LuchsRenderer extends GeoEntityRenderer<LuchsEntity> {
    public LuchsRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new LuchsModel());
        this.shadowRadius = 0.7F;
    }
  //Broken + for GeckoLib 3
  /* @Override
    public void render(GeoModel model, Panzer2Entity animatable, float partialTick, RenderType type, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.render(model, animatable, partialTick, type, poseStack, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        if (animatable.getFuelAmount() > 0 && model.getBone("Engine").isPresent() && animatable.isVehicle() && animatable.isMoving()) {
            animatable.getCommandSenderWorld().addParticle(ParticleTypes.LARGE_SMOKE,
                    model.getBone("Engine").get().getWorldPosition().x,
                    model.getBone("Engine").get().getWorldPosition().y + 0.8,
                    model.getBone("Engine").get().getWorldPosition().z,
                    (animatable.getRandom().nextGaussian() * 0.0003D), -animatable.getRandom().nextGaussian() * 0.0003D,
                    (animatable.getRandom().nextGaussian() * 0.0003D));
                    }
        } */


}