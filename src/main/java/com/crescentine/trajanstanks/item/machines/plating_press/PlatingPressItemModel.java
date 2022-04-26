package com.crescentine.trajanstanks.item.machines.plating_press;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.block.platingpress.PlatingPressBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlatingPressItemModel extends AnimatedGeoModel<PlatingPressItem> {
    @Override
    public ResourceLocation getAnimationFileLocation(PlatingPressItem animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/plating_press.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(PlatingPressItem animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/plating_press.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(PlatingPressItem entity) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/block/plating_press.png");
    }

}