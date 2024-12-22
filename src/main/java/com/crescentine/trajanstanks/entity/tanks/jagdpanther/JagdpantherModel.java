package com.crescentine.trajanstanks.entity.tanks.jagdpanther;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.archer.ArcherEntity;
import com.crescentine.trajanstanks.entity.tanks.kv2.KV2Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class JagdpantherModel extends GeoModel<JagdpantherEntity> {
    public ResourceLocation getModelResource(JagdpantherEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/jag.geo.json");
    }

    public ResourceLocation getTextureResource(JagdpantherEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/jag.png");
    }

    public ResourceLocation getAnimationResource(JagdpantherEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/jag.json");
    }


    @Override
    public void setCustomAnimations(JagdpantherEntity animatable, long instanceId, AnimationState<JagdpantherEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone main = this.getAnimationProcessor().getBone("Body");


        main.setRotY(0f);
        if (animatable.getControllingPassenger()!=null) {
            Entity rider = animatable.getControllingPassenger();
            if (animatable.isVehicle()) {

                main.setRotY((float) Math.toRadians(-animatable.getYRot()));



            }
        } else {
            main.setRotY((float) Math.toRadians(-animatable.getYRot()));
        }
    }
}
