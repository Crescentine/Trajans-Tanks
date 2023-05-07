package com.crescentine.trajanstanks.entity.artillery.qf6;

import com.crescentine.trajanstanks.entity.artillery.pak40.Pak40Entity;
import com.crescentine.trajanstanks.entity.artillery.pak40.Pak40Model;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class QF6Renderer extends GeoEntityRenderer<QF6Entity> {
    public QF6Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new QF6Model());
        this.shadowRadius = 0.7F;
    }
}
