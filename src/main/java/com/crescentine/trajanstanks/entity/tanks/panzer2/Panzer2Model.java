package com.crescentine.trajanstanks.entity.tanks.panzer2;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.world.NoteBlockEvent;
import software.bernie.example.entity.GeoExampleEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class Panzer2Model extends AnimatedGeoModel<Panzer2Entity>
{
    public ResourceLocation getModelLocation(Panzer2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/tank.geo.json");
    }

    public ResourceLocation getTextureLocation(Panzer2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/texture.png");
    }

    public ResourceLocation getAnimationFileLocation(Panzer2Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/tank.animation.json");
    }
    /*
    @Override
    public void setLivingAnimations(Panzer2Entity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone turret = this.getAnimationProcessor().getBone("TopPart");
        Entity rider = entity.getControllingPassenger();
        if (entity.isVehicle() && rider instanceof Player) {
           turret.setRotationY((float)-Math.toRadians(rider.getYHeadRot() - entity.getYRot()));
        }
    } */
}
