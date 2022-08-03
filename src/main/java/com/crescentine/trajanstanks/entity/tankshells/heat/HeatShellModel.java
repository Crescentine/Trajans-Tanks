package com.crescentine.trajanstanks.entity.tankshells.heat;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HeatShellModel extends AnimatedGeoModel<HeatShell> {
    @Override
    public ResourceLocation getModelResource(HeatShell object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/heat_shell.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HeatShell object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/heat_shell.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HeatShell animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/heat_shell.animation.json");
    }
}