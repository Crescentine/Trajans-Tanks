package com.crescentine.trajanstanks.entity.tank.panzer2;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Panzer2Model extends AnimatedGeoModel<Panzer2Entity>
{
    public ResourceLocation getModelLocation(Panzer2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/tank.geo.json");
    }

    public ResourceLocation getTextureLocation(Panzer2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/texture.png");
    }

    public ResourceLocation getAnimationFileLocation(Panzer2Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/tank.animation.json");
    }
}
