package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CruiserMk1Model extends AnimatedGeoModel<CruiserMk1Entity> {
    public ResourceLocation getModelLocation(CruiserMk1Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/cruisermk1.geo.json");
    }

    public ResourceLocation getTextureLocation(CruiserMk1Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/cruisermk1.png");
    }

    public ResourceLocation getAnimationFileLocation(CruiserMk1Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/cruisermk1.animation.json");
    }
}
