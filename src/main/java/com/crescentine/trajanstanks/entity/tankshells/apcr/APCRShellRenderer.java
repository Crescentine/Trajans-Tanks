package com.crescentine.trajanstanks.entity.tankshells.apcr;

import com.crescentine.trajanstanks.entity.tankshells.armorpiercing.ArmorPiercingShell;
import com.crescentine.trajanstanks.entity.tankshells.armorpiercing.ArmorPiercingShellModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class APCRShellRenderer extends GeoProjectilesRenderer<APCRShell> {
    public APCRShellRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new APCRShellModel());
        this.shadowRadius = 0.2F;
    }
}