package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Model;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CruiserMk1Renderer extends GeoEntityRenderer<CruiserMk1Entity> {
    public CruiserMk1Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new CruiserMk1Model());
        this.shadowRadius = 0.7F;
    }
}