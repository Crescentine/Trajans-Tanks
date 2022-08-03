package com.crescentine.trajanstanks.entity.tankshells.standard;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class StandardShellRenderer extends GeoProjectilesRenderer<StandardShell> {
    public StandardShellRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new StandardShellModel());
        this.shadowRadius = 0.2F;
    }
}