package com.crescentine.trajanstanks.entity.tanks.t34;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class T34Model extends GeoModel<T34Entity> {
    public ResourceLocation getModelResource(T34Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/t34.geo.json");
    }

    public ResourceLocation getTextureResource(T34Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/t34.png");
    }

    public ResourceLocation getAnimationResource(T34Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/t34.animation.json");
    }
    @Override
    public void setCustomAnimations(T34Entity animatable, long instanceId, AnimationState<T34Entity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone turret = this.getAnimationProcessor().getBone("turret");
        Entity rider = animatable.getControllingPassenger();
        if (animatable.isVehicle() && rider instanceof Player) {
            turret.setRotY((float) -Math.toRadians(rider.getYHeadRot() - animatable.getYRot()));
        }
    }
}