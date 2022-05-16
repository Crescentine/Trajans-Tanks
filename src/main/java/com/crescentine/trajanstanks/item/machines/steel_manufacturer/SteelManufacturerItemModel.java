package com.crescentine.trajanstanks.item.machines.steel_manufacturer;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.block.steelmanufacturer.SteelManufacturerBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SteelManufacturerItemModel extends AnimatedGeoModel<SteelManufacturerItem> {
    @Override
    public ResourceLocation getAnimationFileLocation(SteelManufacturerItem animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/steel_manufacturer.animation.json");
    }
    @Override
    public ResourceLocation getModelLocation(SteelManufacturerItem animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/steel_manufacturer.geo.json");
    }
    @Override
    public ResourceLocation getTextureLocation(SteelManufacturerItem entity) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/block/steel_manufacturer.png");
    }

}