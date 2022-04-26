package com.crescentine.trajanstanks.block.platingpress;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlatingPressModel extends AnimatedGeoModel<PlatingPressBlockEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(PlatingPressBlockEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/plating_press.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(PlatingPressBlockEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/plating_press.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(PlatingPressBlockEntity entity) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/block/plating_press.png");
    }

}