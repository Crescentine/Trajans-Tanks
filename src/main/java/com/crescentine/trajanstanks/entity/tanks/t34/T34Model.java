package com.crescentine.trajanstanks.entity.tanks.t34;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class T34Model extends AnimatedGeoModel<T34Entity>
{
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
    public void setLivingAnimations(T34Entity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone turret = this.getAnimationProcessor().getBone("Turret");
        Entity rider = entity.getControllingPassenger();
        if (entity.isVehicle() && rider instanceof Player) {
            turret.setRotationY((float)-Math.toRadians(rider.getYHeadRot() - entity.getYRot()));
        }
    }
}