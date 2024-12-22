package com.crescentine.trajanstanks.entity.artillery.pak40;

import com.crescentine.trajanscore.basetank.BaseATEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class Pak40Entity extends BaseATEntity {
    public Pak40Entity(EntityType<? extends BaseATEntity> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.pak40_health.get();
        this.speedMultiplier = 0;
        this.shootingCooldown = TankModConfig.pak40_cooldown.get();
        this.canUseArmorPiercing = true;
        this.canUseAPCR = true;
        this.canUseHeat = false;
        this.canUseHighExplosive = false;
        this.canUseStandard = false;
    }
    protected <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }
    @Override
    public double getPassengersRidingOffset() {
        return 0.3;
    }
}