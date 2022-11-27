package com.crescentine.trajanstanks.entity.tanks.tiger;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TigerTankModel extends AnimatedGeoModel<TigerTankEntity>
{
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
    public void setLivingAnimations(TigerTankEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone turret = this.getAnimationProcessor().getBone("turret");
        Entity rider = entity.getControllingPassenger();
        if (entity.isVehicle() && rider instanceof Player) {
            turret.setRotationY((float)-Math.toRadians(rider.getYHeadRot() - entity.getYRot()));
        }
    }
}