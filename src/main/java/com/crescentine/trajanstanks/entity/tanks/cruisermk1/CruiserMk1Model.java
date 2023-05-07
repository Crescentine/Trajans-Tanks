package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.archer.ArcherEntity;
import com.crescentine.trajanstanks.entity.tanks.kv2.KV2Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
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
        CoreGeoBone turret = this.getAnimationProcessor().getBone("turret");
        Entity rider = animatable.getControllingPassenger();
        if (animatable.isVehicle() && rider instanceof Player) {
            turret.setRotY((float) -Math.toRadians(rider.getYHeadRot() - animatable.getYRot()));
        }
    }
}
