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
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KV2Renderer extends GeoEntityRenderer<KV2Entity> {
    public KV2Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new KV2Model());
        this.shadowRadius = 0.7F;
    }
}