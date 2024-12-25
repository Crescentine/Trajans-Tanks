package com.crescentine.trajanstanks.entity.tanks.m4sherman;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class M4ShermanModel extends GeoModel<M4ShermanEntity> {
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
    public void setCustomAnimations(M4ShermanEntity animatable, long instanceId, AnimationState<M4ShermanEntity> animationState) {
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
            turret.setRotY((float) -Math.toRadians(animatable.getLastPlayerYHeadRot()));


        }
    }
}
