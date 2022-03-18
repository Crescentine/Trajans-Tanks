package com.crescentine.trajanstanks.entity.artillery;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ArtilleryEntityRenderer extends GeoEntityRenderer<ArtilleryEntity> {
        public ArtilleryEntityRenderer(EntityRendererProvider.Context renderManagerIn) {
            super(renderManagerIn, new ArtilleryEntityModel());
            this.shadowRadius = 0.7F;
        }
    }
