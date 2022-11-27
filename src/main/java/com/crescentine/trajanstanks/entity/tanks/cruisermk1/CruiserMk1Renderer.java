package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanstanks.entity.tanks.archer.ArcherEntity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Model;
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
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.ExtendedGeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CruiserMk1Renderer extends ExtendedGeoEntityRenderer<CruiserMk1Entity> {
    public CruiserMk1Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new CruiserMk1Model());
        this.shadowRadius = 0.7F;
    }


    @Override
    public float getHeightScale(CruiserMk1Entity entity) {
        return 1.0f;
    }

    @Override
    protected boolean isArmorBone(GeoBone bone) {
        return false;
    }

    @Override
    public float getWidthScale(CruiserMk1Entity entity) {
        return 1.0f;
    }

    @Nullable
    @Override
    protected ResourceLocation getTextureForBone(String boneName, CruiserMk1Entity currentEntity) {
        return null;
    }
    @Nullable
    @Override
    protected ItemStack getHeldItemForBone(String boneName, CruiserMk1Entity currentEntity) {
        return null;
    }
    @Override
    protected ItemTransforms.TransformType getCameraTransformForItemAtBone(ItemStack boneItem, String boneName) {
        return null;
    }
    @Nullable
    @Override
    protected BlockState getHeldBlockForBone(String boneName, CruiserMk1Entity currentEntity) {
        return null;
    }
    @Override
    protected void preRenderItem(PoseStack matrixStack, ItemStack item, String boneName, CruiserMk1Entity currentEntity, IBone bone) {
    }

    @Override
    protected void preRenderBlock(PoseStack matrixStack, BlockState block, String boneName, CruiserMk1Entity currentEntity) {
    }
    @Override
    protected void postRenderItem(PoseStack matrixStack, ItemStack item, String boneName, CruiserMk1Entity currentEntity, IBone bone) {
    }

    @Override
    protected void postRenderBlock(PoseStack matrixStack, BlockState block, String boneName, CruiserMk1Entity currentEntity) {
    }
    @Override
    public void renderRecursively(GeoBone bone, PoseStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.renderRecursively(bone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
    @Override
    public void render(GeoModel model, CruiserMk1Entity animatable, float partialTick, RenderType type, PoseStack poseStack, @javax.annotation.Nullable MultiBufferSource bufferSource, @javax.annotation.Nullable VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.render(model, animatable, partialTick, type, poseStack, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        if (animatable.getFuelAmount() > 0 && model.getBone("Engine").isPresent() && animatable.isVehicle() && animatable.isMoving()) {
            animatable.getCommandSenderWorld().addParticle(ParticleTypes.LARGE_SMOKE,
                    model.getBone("Engine").get().getWorldPosition().x,
                    model.getBone("Engine").get().getWorldPosition().y + 0.8,
                    model.getBone("Engine").get().getWorldPosition().z,
                    (animatable.getRandom().nextGaussian() * 0.0003D), -animatable.getRandom().nextGaussian() * 0.0003D,
                    (animatable.getRandom().nextGaussian() * 0.0003D));
        }
    }
}