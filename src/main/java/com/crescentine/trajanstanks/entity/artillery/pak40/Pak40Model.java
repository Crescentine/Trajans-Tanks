package com.crescentine.trajanstanks.entity.artillery.pak40;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Pak40Model extends GeoModel<Pak40Entity>
{
    public ResourceLocation getModelResource(Pak40Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/artillery.geo.json");
    }

    public ResourceLocation getTextureResource(Pak40Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/artillery.png");
    }

    public ResourceLocation getAnimationResource(Pak40Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/artillery_animation.json");
    }
}