package com.crescentine.trajanstanks.entity.tank.light_tank;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TankEntityModel extends AnimatedGeoModel<TankEntity>
{
    public ResourceLocation getModelLocation(TankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/tank.geo.json");
    }

    public ResourceLocation getTextureLocation(TankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/texture.png");
    }

    public ResourceLocation getAnimationFileLocation(TankEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/tank.animation.json");
    }
}
