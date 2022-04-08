package com.crescentine.trajanstanks.entity.tank.light_tank;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class Panzer2Renderer extends GeoEntityRenderer<Panzer2Entity> {
    public Panzer2Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Panzer2Model());
        this.shadowRadius = 0.7F;
    }
}