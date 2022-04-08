package com.crescentine.trajanstanks.entity.tank.heavy_tank;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TigerTankRenderer extends GeoEntityRenderer<TigerTankEntity> {
    public TigerTankRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new TigerTankModel());
        this.shadowRadius = 0.7F;
    }
}