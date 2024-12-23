package com.crescentine.trajanstanks.entity.tanks.somua;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class SomuaS35Model extends GeoModel<SomuaS35Entity> {
    public ResourceLocation getModelResource(SomuaS35Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/somua_s35.geo.json");
    }

    public ResourceLocation getTextureResource(SomuaS35Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/somua_s35.png");
    }

    public ResourceLocation getAnimationResource(SomuaS35Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/somua_s35.json");
    }
    @Override
    public void setCustomAnimations(SomuaS35Entity animatable, long instanceId, AnimationState<SomuaS35Entity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone main = this.getAnimationProcessor().getBone("Mainbody");
        CoreGeoBone turret = this.getAnimationProcessor().getBone("Turret");


        main.setRotY(0f);
        turret.setRotY(0f);
        if (animatable.getControllingPassenger()!=null) {
            Entity rider = animatable.getControllingPassenger();
            if (animatable.isVehicle()) {
                turret.setRotY((float) -Math.toRadians(rider.getYHeadRot()));

                main.setRotY((float) Math.toRadians(-animatable.getYRot()));



            }
        } else {
            main.setRotY((float) Math.toRadians(-animatable.getYRot()));

        }
    }
}
