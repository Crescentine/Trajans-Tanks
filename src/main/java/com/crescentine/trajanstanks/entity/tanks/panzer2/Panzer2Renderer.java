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
}