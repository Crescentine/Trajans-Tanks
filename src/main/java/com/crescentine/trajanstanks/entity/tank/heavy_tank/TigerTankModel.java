package com.crescentine.trajanstanks.entity.tank.heavy_tank;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TigerTankModel extends AnimatedGeoModel<TigerTankEntity>
{
    public ResourceLocation getModelLocation(TigerTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/heavytank.geo.json");
    }

    public ResourceLocation getTextureLocation(TigerTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/texture2.png");
    }

    public ResourceLocation getAnimationFileLocation(TigerTankEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/heavytank.animation.json");
    }
}