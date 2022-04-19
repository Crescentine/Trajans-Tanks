package com.crescentine.trajanstanks.entity.tanks.t34;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class T34Model extends AnimatedGeoModel<T34Entity>
{
    public ResourceLocation getModelLocation(T34Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/t34.geo.json");
    }

    public ResourceLocation getTextureLocation(T34Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/t34.png");
    }

    public ResourceLocation getAnimationFileLocation(T34Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/t34.animation.json");
    }
}