package com.crescentine.trajanstanks.entity.tanks.luchs;

import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class LuchsEntity extends BaseTankEntity {
    static int shellsUsed = 1;
    public LuchsEntity(EntityType<? extends BaseTankEntity> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.luchs_health.get();
        this.entityData.set(HEALTH, this.health);
        this.speedMultiplier = TankModConfig.luchs_speed.get();
        this.shootingCooldown = TankModConfig.luchs_shot_cooldown.get();
        this.armor = 3.0;
        this.healAmount = TankModConfig.luchs_heal_amount.get();
        this.maxFuel = TankModConfig.luchs_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = false;
        this.canUseArmorPiercing = false;
        this.canUseHighExplosive = false;
        this.canUseStandard = true;
        this.showFuel = true;
        this.speedMultiplier = 0.6f;
        this.tankItem = TankModItems.LUCHS_ITEM.get();
    }
    protected <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.xo != this.getX() || this.zo != this.getZ()) {
            event.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }
    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    /*
    protected void positionRider(Entity p_289552_, Entity.MoveFunction p_289571_) {
        if (this.hasPassenger(p_289552_)) {
            Vec3 vec3 = (new Vec3((double)0.2, 0.0D, 2)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));

            p_289571_.accept(p_289552_, this.getX() + vec3.x, this.getY() + vec3.y, this.getZ() + 2.5);
            super.positionRider(p_289552_, p_289571_);

        }
    }
    */

    protected void positionRider(Entity pPassenger, MoveFunction pCallback) {
        if (this.hasPassenger(pPassenger)) {
            double d0 = this.getY() + this.getPassengersRidingOffset() + pPassenger.getMyRidingOffset();
            pCallback.accept(pPassenger, this.getX(), d0, this.getZ());
        }
    }



}