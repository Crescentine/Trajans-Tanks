package com.crescentine.trajanstanks.entity.tanks.kv2;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.m4sherman.M4ShermanEntity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class KV2Model extends GeoModel<KV2Entity>
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
    public void setCustomAnimations(KV2Entity animatable, long instanceId, AnimationState<KV2Entity> animationState) {
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
        }
    }
}