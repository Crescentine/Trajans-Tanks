package com.crescentine.trajanstanks.entity.tanks.panzer2;

import com.crescentine.trajanscore.example_tank.ExampleTankEntity;
import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankEntity;
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
        return new ResourceLocation(TankMod.MOD_ID, "geo/tank.geo.json");
    }

    public ResourceLocation getTextureResource(Panzer2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/texture.png");
    }

    public ResourceLocation getAnimationResource(Panzer2Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/tank.animation.json");
    }
    @Override
    public void setCustomAnimations(Panzer2Entity animatable, long instanceId, AnimationState<Panzer2Entity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone turret = this.getAnimationProcessor().getBone("TopPart");
        turret.setRotY(0);
        if (animatable.hasControllingPassenger()) {
            Entity rider = animatable.getControllingPassenger();
            if (animatable.isVehicle() && rider instanceof Player player && player.level().isClientSide() && animatable.hasControllingPassenger()) {
                turret.setRotY((float) -Math.toRadians(rider.getYHeadRot() - animatable.getYRot()));
            }
        }
    }
}