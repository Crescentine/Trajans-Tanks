package com.crescentine.trajanstanks.entity.tanks.panzer2;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class Panzer2Model extends GeoModel<Panzer2Entity>
{
    public ResourceLocation getModelResource(Panzer2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/pz_ii.geo.json");
    }

    public ResourceLocation getTextureResource(Panzer2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/pz_ii.png");
    }

    public ResourceLocation getAnimationResource(Panzer2Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/tank.animation.json");
    }
    @Override
    public void setCustomAnimations(Panzer2Entity animatable, long instanceId, AnimationState<Panzer2Entity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone main = this.getAnimationProcessor().getBone("hull");
        CoreGeoBone turret = this.getAnimationProcessor().getBone("hull").getChildBones().get(1); //2


        main.setRotY(0f);
        turret.setRotY(0f);
        if (animatable.getControllingPassenger()!=null) {
            Entity rider = animatable.getControllingPassenger();
            if (animatable.isVehicle()) {
                turret.setRotY((float) -Math.toRadians(rider.getYHeadRot()-animatable.getYRot()));

                main.setRotY((float) Math.toRadians(-animatable.getYRot()));




            }
        } else {
            main.setRotY((float) Math.toRadians(-animatable.getYRot()));
            turret.setRotY((float) -Math.toRadians(animatable.getLastPlayerYHeadRot()-animatable.getYRot()));

        }
    }
}