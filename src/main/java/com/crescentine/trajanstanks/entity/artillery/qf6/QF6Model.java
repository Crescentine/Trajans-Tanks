package com.crescentine.trajanstanks.entity.artillery.qf6;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.artillery.pak40.Pak40Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class QF6Model extends GeoModel<QF6Entity>
{
    public ResourceLocation getModelResource(QF6Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/qf6.geo.json");
    }

    public ResourceLocation getTextureResource(QF6Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/qf6.png");
    }

    public ResourceLocation getAnimationResource(QF6Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/qf6.json");
    }


    @Override
    public void setCustomAnimations(QF6Entity animatable, long instanceId, AnimationState<QF6Entity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone gun = this.getAnimationProcessor().getBone("Barrel");
        CoreGeoBone main = this.getAnimationProcessor().getBone("QF_6");
        gun.setRotY(0f);
        main.setRotY(0f);

        if (animatable.getControllingPassenger()!=null) {
            Entity rider = animatable.getControllingPassenger();
            if (animatable.isVehicle()) {
                float elevationAngle = rider.getXRot();
                main.setRotY((float) Math.toRadians(-animatable.getYRot()));

/*                float maxElevation = 9;
                float minElevation = -3;

                if (elevationAngle > maxElevation) {
                    elevationAngle = maxElevation;
                } else if (elevationAngle < minElevation) {
                    elevationAngle = minElevation;
                }

                float targetGunRotZ = (float) Math.toRadians(elevationAngle);

                float lerpFactor = 1;

                gun.setRotX(-targetGunRotZ);*/


            }
        } else {
            main.setRotY((float) Math.toRadians(-animatable.getLastYRot()));
        }
    }
}