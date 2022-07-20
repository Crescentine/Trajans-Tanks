package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CruiserMk1Model extends AnimatedGeoModel<CruiserMk1Entity> {
    public ResourceLocation getModelResource(CruiserMk1Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/cruiser_mk1.geo.json");
    }

    public ResourceLocation getTextureResource(CruiserMk1Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/cruiser_mk1.png");
    }

    public ResourceLocation getAnimationResource(CruiserMk1Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/cruiser_mk1_animation.json");
    }
}
