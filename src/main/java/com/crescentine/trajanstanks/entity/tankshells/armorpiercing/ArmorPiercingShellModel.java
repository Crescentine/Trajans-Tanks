package com.crescentine.trajanstanks.entity.tankshells.armorpiercing;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tankshells.heat.HeatShell;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArmorPiercingShellModel extends AnimatedGeoModel<ArmorPiercingShell> {
    @Override
    public ResourceLocation getModelResource(ArmorPiercingShell object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/armor_piercing.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArmorPiercingShell object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/armor_piercing.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ArmorPiercingShell animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/armor_piercing.animation.json");
    }
}