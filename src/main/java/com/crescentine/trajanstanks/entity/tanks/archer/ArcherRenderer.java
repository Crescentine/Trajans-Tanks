package com.crescentine.trajanstanks.entity.tanks.archer;

import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.particles.ParticleTypes;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class ArcherRenderer extends GeoEntityRenderer<ArcherEntity> {
    public ArcherRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ArcherModel());
        this.shadowRadius = 0.7F;
    }
}