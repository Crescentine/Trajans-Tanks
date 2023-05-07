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
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import javax.annotation.Nullable;

public class JagdpantherRenderer extends GeoEntityRenderer<JagdpantherEntity> {
    public JagdpantherRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new JagdpantherModel());
        this.shadowRadius = 0.7F;
    }
    @Override
    public GeoEntityRenderer<JagdpantherEntity> withScale(float scale) {
        return super.withScale(0.9f);
    }
}