package com.crescentine.trajanstanks.entity.tank.heavy_tank;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HeavyTankModel extends AnimatedGeoModel<HeavyTankEntity>
{
    public ResourceLocation getModelLocation(HeavyTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/heavytank.geo.json");
    }

    public ResourceLocation getTextureLocation(HeavyTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/texture2.png");
    }

    public ResourceLocation getAnimationFileLocation(HeavyTankEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/heavytank.animation.json");
    }
}