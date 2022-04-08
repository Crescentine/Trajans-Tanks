package com.crescentine.trajanstanks.entity.tank.medium_tank;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class T34Renderer extends GeoEntityRenderer<T34Entity> {
    public T34Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new T34Model());
        this.shadowRadius = 0.7F;
    }
}