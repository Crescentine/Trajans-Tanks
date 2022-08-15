package com.crescentine.trajanstanks.entity.tanks.archer;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArcherModel extends AnimatedGeoModel<ArcherEntity> {
    public ResourceLocation getModelResource(ArcherEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/archer.geo.json");
    }

    public ResourceLocation getTextureResource(ArcherEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/archer.png");
    }

    public ResourceLocation getAnimationResource(ArcherEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/archer_animation.json");
    }
}
