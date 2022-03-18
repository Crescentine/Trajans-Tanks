package com.crescentine.trajanstanks.entity.tank.light_tank;

import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntity;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class TankEntityRenderer extends GeoEntityRenderer<TankEntity> {
    public TankEntityRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new TankEntityModel());
        this.shadowRadius = 0.7F;
    }
}