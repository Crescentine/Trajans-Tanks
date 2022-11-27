package com.crescentine.trajanstanks.entity.tanks.m4sherman;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class M4ShermanModel extends AnimatedGeoModel<M4ShermanEntity> {
    public ResourceLocation getModelResource(M4ShermanEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/m4_sherman.geo.json");
    }

    public ResourceLocation getTextureResource(M4ShermanEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/m4_sherman.png");
    }

    public ResourceLocation getAnimationResource(M4ShermanEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/m4_sherman_animation.json");
    }
    @Override
    public void setCustomAnimations(M4ShermanEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        IBone turret = this.getAnimationProcessor().getBone("turret");
        Entity rider = animatable.getControllingPassenger();
        if (animatable.isVehicle() && rider instanceof Player) {
            turret.setRotationY((float) -Math.toRadians(rider.getYHeadRot() - animatable.getYRot()));
        }
    }
}