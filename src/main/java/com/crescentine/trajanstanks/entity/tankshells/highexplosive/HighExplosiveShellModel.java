package com.crescentine.trajanstanks.entity.tankshells.highexplosive;

import com.crescentine.trajanscore.TrajansCoreMod;
import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tankshells.standard.StandardShell;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HighExplosiveShellModel extends AnimatedGeoModel<HighExplosiveShell> {
    @Override
    public ResourceLocation getModelResource(HighExplosiveShell object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/he_shell.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(HighExplosiveShell object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/he_shell.png");
    }
    @Override
    public ResourceLocation getAnimationResource(HighExplosiveShell animatable) {
        return new ResourceLocation(TrajansCoreMod.MOD_ID, "animations/he_shell.animation.json");
    }
}
