package com.crescentine.trajanstanks.entity.tanks.luchs;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class LuchsModel extends GeoModel<LuchsEntity>
{
    public ResourceLocation getModelResource(LuchsEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/luchs.geo.json");
    }

    public ResourceLocation getTextureResource(LuchsEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/luchs.png");
    }

    public ResourceLocation getAnimationResource(LuchsEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/luchs_animation.json");
    }
    @Override
    public void setCustomAnimations(LuchsEntity animatable, long instanceId, AnimationState<LuchsEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone main = this.getAnimationProcessor().getBone("hull");
        CoreGeoBone turret = this.getAnimationProcessor().getBone("turret");


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
            turret.setRotY((float) -Math.toRadians(animatable.getLastPlayerYHeadRot()));

        }
    }
}