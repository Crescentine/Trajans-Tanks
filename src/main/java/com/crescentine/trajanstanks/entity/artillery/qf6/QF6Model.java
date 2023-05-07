package com.crescentine.trajanstanks.entity.artillery.qf6;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.artillery.pak40.Pak40Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class QF6Model extends GeoModel<QF6Entity>
{
    public ResourceLocation getModelResource(QF6Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/qf6.geo.json");
    }

    public ResourceLocation getTextureResource(QF6Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/qf6.png");
    }

    public ResourceLocation getAnimationResource(QF6Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/qf6.json");
    }
}