package com.crescentine.trajanstanks.entity.tanks.somua;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SomuaS35Renderer extends GeoEntityRenderer<SomuaS35Entity> {
    public SomuaS35Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new SomuaS35Model());
        this.shadowRadius = 0.7F;
    }

}