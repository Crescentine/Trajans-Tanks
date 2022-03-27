package com.crescentine.trajanstanks.entity.tank.medium_tank;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MediumTankModel extends AnimatedGeoModel<MediumTankEntity>
{
    public ResourceLocation getModelLocation(MediumTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/t34.geo.json");
    }

    public ResourceLocation getTextureLocation(MediumTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/t34.png");
    }

    public ResourceLocation getAnimationFileLocation(MediumTankEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/t34.animation.json");
    }
}