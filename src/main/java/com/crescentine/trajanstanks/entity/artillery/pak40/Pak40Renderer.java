package com.crescentine.trajanstanks.entity.artillery.pak40;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class Pak40Renderer extends GeoEntityRenderer<Pak40Entity> {
        public Pak40Renderer(EntityRendererProvider.Context renderManagerIn) {
            super(renderManagerIn, new Pak40Model());
            this.shadowRadius = 0.7F;
        }
    }
