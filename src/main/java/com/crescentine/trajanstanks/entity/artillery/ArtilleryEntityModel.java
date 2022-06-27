package com.crescentine.trajanstanks.entity.artillery;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArtilleryEntityModel extends AnimatedGeoModel<ArtilleryEntity>
{
    public ResourceLocation getModelLocation(ArtilleryEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/artillery.geo.json");
    }

    public ResourceLocation getTextureLocation(ArtilleryEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/artillery.png");
    }

    public ResourceLocation getAnimationFileLocation(ArtilleryEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/artillery_animation.json");
    }
}