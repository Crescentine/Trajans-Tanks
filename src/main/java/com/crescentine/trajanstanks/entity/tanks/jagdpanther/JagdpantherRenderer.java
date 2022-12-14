package com.crescentine.trajanstanks.entity.tanks.jagdpanther;

import com.crescentine.trajanstanks.entity.tanks.archer.ArcherEntity;
import com.crescentine.trajanstanks.entity.tanks.archer.ArcherModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.ExtendedGeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class JagdpantherRenderer extends ExtendedGeoEntityRenderer<JagdpantherEntity> {
    public JagdpantherRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new JagdpantherModel());
        this.shadowRadius = 0.7F;
    }
    @Override
    public void render(GeoModel model, JagdpantherEntity animatable, float partialTick, RenderType type, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.render(model, animatable, partialTick, type, poseStack, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        if (animatable.getFuelAmount() > 0 && model.getBone("Deco").isPresent() && animatable.isVehicle() && animatable.isMoving()) {
            animatable.getCommandSenderWorld().addParticle(ParticleTypes.LARGE_SMOKE,
                    model.getBone("Deco").get().getWorldPosition().x,
                    model.getBone("Deco").get().getWorldPosition().y + 0.8,
                    model.getBone("Deco").get().getWorldPosition().z,
                    (animatable.getRandom().nextGaussian() * 0.0003D), -animatable.getRandom().nextGaussian() * 0.0003D,
                    (animatable.getRandom().nextGaussian() * 0.0003D));
        }
    }

    @Override
    public float getHeightScale(JagdpantherEntity entity) {
            return 0.9f;
    }

    @Override
    public float getWidthScale(JagdpantherEntity animatable) {
        return 0.9f;
    }

    @Override
    protected boolean isArmorBone(GeoBone bone) {
        return false;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected ResourceLocation getTextureForBone(String boneName, JagdpantherEntity animatable) {
        return null;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected ItemStack getHeldItemForBone(String boneName, JagdpantherEntity animatable) {
        return null;
    }

    @Override
    protected ItemTransforms.TransformType getCameraTransformForItemAtBone(ItemStack stack, String boneName) {
        return null;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected BlockState getHeldBlockForBone(String boneName, JagdpantherEntity animatable) {
        return null;
    }

    @Override
    protected void preRenderItem(PoseStack poseStack, ItemStack stack, String boneName, JagdpantherEntity animatable, IBone bone) {

    }

    @Override
    protected void preRenderBlock(PoseStack poseStack, BlockState state, String boneName, JagdpantherEntity animatable) {

    }

    @Override
    protected void postRenderItem(PoseStack poseStack, ItemStack stack, String boneName, JagdpantherEntity animatable, IBone bone) {

    }

    @Override
    protected void postRenderBlock(PoseStack poseStack, BlockState state, String boneName, JagdpantherEntity animatable) {

    }
}