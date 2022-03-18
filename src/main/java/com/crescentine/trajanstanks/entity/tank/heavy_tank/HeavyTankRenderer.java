package com.crescentine.trajanstanks.entity.tank.heavy_tank;


import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntity;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HeavyTankRenderer extends GeoEntityRenderer<HeavyTankEntity> {
    public HeavyTankRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new HeavyTankModel());
        this.shadowRadius = 0.7F;
    }
}