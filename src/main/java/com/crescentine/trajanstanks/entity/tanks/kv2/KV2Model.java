package com.crescentine.trajanstanks.entity.tanks.kv2;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KV2Model extends AnimatedGeoModel<KV2Entity>
{
    public ResourceLocation getModelResource(KV2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/kv2.geo.json");
    }

    public ResourceLocation getTextureResource(KV2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/kv2.png");
    }

    public ResourceLocation getAnimationResource(KV2Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/kv2.json");
    }
    @Override
    public void setCustomAnimations(KV2Entity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        IBone turret = this.getAnimationProcessor().getBone("turret");
        Entity rider = animatable.getControllingPassenger();
        if (animatable.isVehicle() && rider instanceof Player) {
            turret.setRotationY((float) -Math.toRadians(rider.getYHeadRot() - animatable.getYRot()));
        }
    }
}