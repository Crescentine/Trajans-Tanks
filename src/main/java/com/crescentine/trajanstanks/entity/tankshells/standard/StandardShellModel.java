package com.crescentine.trajanstanks.entity.tankshells.standard;

import com.crescentine.trajanscore.TrajansCoreMod;
import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StandardShellModel extends AnimatedGeoModel<StandardShell> {
    @Override
    public ResourceLocation getModelResource(StandardShell object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/standard_shell.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(StandardShell object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/standard_shell.png");
    }
    @Override
    public ResourceLocation getAnimationResource(StandardShell animatable) {
        return new ResourceLocation(TrajansCoreMod.MOD_ID, "animations/standard_shell.animation.json");
    }
}
