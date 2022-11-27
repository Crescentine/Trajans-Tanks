package com.crescentine.trajanstanks.entity.tanks.tiger;


import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.ExtendedGeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TigerTankRenderer extends ExtendedGeoEntityRenderer<TigerTankEntity> {
    public TigerTankRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new TigerTankModel());
        this.shadowRadius = 0.7F;
    }

    @Override
    public float getHeightScale(TigerTankEntity entity) {
        return 1.1f;
    }

    @Override
    protected boolean isArmorBone(GeoBone bone) {
        return false;
    }

    @Override
    public float getWidthScale(TigerTankEntity entity) {
        return 1.1f;
    }

    @Nullable
    @Override
    protected ResourceLocation getTextureForBone(String boneName, TigerTankEntity currentEntity) {
        return null;
    }

    @Nullable
    @Override
    protected ItemStack getHeldItemForBone(String boneName, TigerTankEntity currentEntity) {
        return null;
    }

    @Override
    protected ItemTransforms.TransformType getCameraTransformForItemAtBone(ItemStack boneItem, String boneName) {
        return null;
    }

    @Nullable
    @Override
    protected BlockState getHeldBlockForBone(String boneName, TigerTankEntity currentEntity) {
        return null;
    }

    @Override
    protected void preRenderItem(PoseStack matrixStack, ItemStack item, String boneName, TigerTankEntity currentEntity, IBone bone) {
    }

    @Override
    protected void preRenderBlock(PoseStack matrixStack, BlockState block, String boneName, TigerTankEntity currentEntity) {
    }

    @Override
    protected void postRenderItem(PoseStack matrixStack, ItemStack item, String boneName, TigerTankEntity currentEntity, IBone bone) {
    }

    @Override
    protected void postRenderBlock(PoseStack matrixStack, BlockState block, String boneName, TigerTankEntity currentEntity) {
    }
}