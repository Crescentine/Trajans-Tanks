package com.crescentine.trajanstanks.entity.tanks.m4sherman;

import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Model;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.ExtendedGeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class M4ShermanRenderer extends ExtendedGeoEntityRenderer<M4ShermanEntity> {
    public M4ShermanRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new M4ShermanModel());
        this.shadowRadius = 0.7F;
    }

    @Override
    protected float getHeightScale(M4ShermanEntity entity) {
        return 1.2F;
    }

    @Override
    protected boolean isArmorBone(GeoBone bone) {
        return false;
    }

    @Override
    protected float getWidthScale(M4ShermanEntity entity) {
        return 1.2f;
    }

    @Nullable
    @Override
    protected ResourceLocation getTextureForBone(String boneName, M4ShermanEntity currentEntity) {
        return null;
    }
    @Nullable
    @Override
    protected ItemStack getHeldItemForBone(String boneName, M4ShermanEntity currentEntity) {
        return null;
    }
    @Override
    protected ItemTransforms.TransformType getCameraTransformForItemAtBone(ItemStack boneItem, String boneName) {
        return null;
    }
    @Nullable
    @Override
    protected BlockState getHeldBlockForBone(String boneName, M4ShermanEntity currentEntity) {
        return null;
    }
    @Override
    protected void preRenderItem(PoseStack matrixStack, ItemStack item, String boneName, M4ShermanEntity currentEntity, IBone bone) {
    }
    @Override
    protected void preRenderBlock(BlockState block, String boneName, M4ShermanEntity currentEntity) {
    }
    @Override
    protected void postRenderItem(PoseStack matrixStack, ItemStack item, String boneName, M4ShermanEntity currentEntity, IBone bone) {
    }
    @Override
    protected void postRenderBlock(BlockState block, String boneName, M4ShermanEntity currentEntity) {
    }

    @Override
    public void renderRecursively(GeoBone bone, PoseStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.renderRecursively(bone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}