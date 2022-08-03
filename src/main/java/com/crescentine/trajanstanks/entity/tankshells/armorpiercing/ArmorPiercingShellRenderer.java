package com.crescentine.trajanstanks.entity.tankshells.armorpiercing;

import com.crescentine.trajanstanks.entity.tankshells.heat.HeatShell;
import com.crescentine.trajanstanks.entity.tankshells.heat.HeatShellModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class ArmorPiercingShellRenderer extends GeoProjectilesRenderer<ArmorPiercingShell> {
    public ArmorPiercingShellRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ArmorPiercingShellModel());
        this.shadowRadius = 0.2F;
    }
}