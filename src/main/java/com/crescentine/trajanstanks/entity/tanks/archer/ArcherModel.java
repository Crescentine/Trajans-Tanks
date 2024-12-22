package com.crescentine.trajanstanks.entity.tanks.archer;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.jagdpanther.JagdpantherEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class ArcherModel extends GeoModel<ArcherEntity> {
    public ResourceLocation getModelResource(ArcherEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/archer.geo.json");
    }

    public ResourceLocation getTextureResource(ArcherEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/archer.png");
    }

    public ResourceLocation getAnimationResource(ArcherEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/archer_animation.json");
    }

    @Override
    public void setCustomAnimations(ArcherEntity animatable, long instanceId, AnimationState<ArcherEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone main = this.getAnimationProcessor().getBone("hull");


        main.setRotY(0);
        if (animatable.getControllingPassenger()!=null) {
            Entity rider = animatable.getControllingPassenger();
            if (animatable.isVehicle()) {

                main.setRotY((float) -Math.toRadians(animatable.getYRot()));



            }
        } else {
            main.setRotY((float) -Math.toRadians(animatable.getYRot()));
        }
    }
}
