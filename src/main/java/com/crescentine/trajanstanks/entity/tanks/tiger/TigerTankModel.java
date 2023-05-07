package com.crescentine.trajanstanks.entity.tanks.tiger;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.loading.json.raw.Bone;
import software.bernie.geckolib.model.GeoModel;

public class TigerTankModel extends GeoModel<TigerTankEntity> {
    public ResourceLocation getModelResource(TigerTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/tiger.geo.json");
    }

    public ResourceLocation getTextureResource(TigerTankEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/texture2.png");
    }

    public ResourceLocation getAnimationResource(TigerTankEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/tiger.animation.json");
    }

    @Override
    public void setCustomAnimations(TigerTankEntity animatable, long instanceId, AnimationState<TigerTankEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone turret = this.getAnimationProcessor().getBone("turret");
        Entity rider = animatable.getControllingPassenger();
        if (animatable.isVehicle() && rider instanceof Player) {
            turret.setRotY((float) -Math.toRadians(rider.getYHeadRot() - animatable.getYRot()));
        }
    }
}