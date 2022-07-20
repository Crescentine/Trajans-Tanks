package com.crescentine.trajanstanks.entity.tanks.tiger;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TigerTankModel extends AnimatedGeoModel<TigerTankEntity>
{
    public ResourceLocation getModelResource(TigerTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/tiger.geo.json");
    }

    public ResourceLocation getTextureResource(TigerTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/texture2.png");
    }

    public ResourceLocation getAnimationResource(TigerTankEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/tiger.animation.json");
    }
}