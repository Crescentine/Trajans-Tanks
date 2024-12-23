package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class CruiserMk1Model extends GeoModel<CruiserMk1Entity> {
    public ResourceLocation getModelResource(CruiserMk1Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/cruiser_mk1.geo.json");
    }

    public ResourceLocation getTextureResource(CruiserMk1Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/cruiser_mk1.png");
    }

    public ResourceLocation getAnimationResource(CruiserMk1Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/cruiser_mk1_animation.json");
    }
    @Override
    public void setCustomAnimations(CruiserMk1Entity animatable, long instanceId, AnimationState<CruiserMk1Entity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone main = this.getAnimationProcessor().getBone("Body");
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
            turret.setRotY((float) -Math.toRadians(animatable.getLastPlayerYHeadRot()));
        }
    }

}
