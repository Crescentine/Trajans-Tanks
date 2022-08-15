package com.crescentine.trajanstanks.entity.tanks.archer;

import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Model;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ArcherRenderer extends GeoEntityRenderer<ArcherEntity> {
    public ArcherRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ArcherModel());
        this.shadowRadius = 0.7F;
    }
}