package com.crescentine.trajanstanks.block.steelmanufacturer;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.block.turretfactory.TurretFactoryBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SteelManufacturerModel extends AnimatedGeoModel<SteelManufacturerBlockEntity> {
    @Override
    public ResourceLocation getAnimationFileLocation(SteelManufacturerBlockEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/steel_manufacturer.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(SteelManufacturerBlockEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/steel_manufacturer.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SteelManufacturerBlockEntity entity) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/block/steel_manufacturer.png");
    }

}