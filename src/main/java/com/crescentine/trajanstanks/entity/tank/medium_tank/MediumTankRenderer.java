package com.crescentine.trajanstanks.entity.tank.medium_tank;

import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntity;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MediumTankRenderer extends GeoEntityRenderer<MediumTankEntity> {
    public MediumTankRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new MediumTankModel());
        this.shadowRadius = 0.7F;
    }
}