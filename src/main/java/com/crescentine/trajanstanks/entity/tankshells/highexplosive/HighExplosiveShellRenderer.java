package com.crescentine.trajanstanks.entity.tankshells.highexplosive;

import com.crescentine.trajanstanks.entity.tankshells.standard.StandardShell;
import com.crescentine.trajanstanks.entity.tankshells.standard.StandardShellModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class HighExplosiveShellRenderer extends GeoProjectilesRenderer<HighExplosiveShell> {
    public HighExplosiveShellRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new HighExplosiveShellModel());
        this.shadowRadius = 0.2F;
    }
}