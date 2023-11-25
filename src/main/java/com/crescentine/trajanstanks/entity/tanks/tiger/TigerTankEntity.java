package com.crescentine.trajanstanks.entity.tanks.tiger;

import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class TigerTankEntity extends BaseTankEntity {
    public TigerTankEntity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.speedMultiplier = TankModConfig.tiger_speed.get();
        this.health = TankModConfig.tiger_health.get();
        this.shootingCooldown = TankModConfig.tiger_shot_cooldown.get();
        this.armor = 5.0;
        this.healAmount = TankModConfig.tiger_heal_amount.get();
        this.maxFuel = TankModConfig.tiger_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = true;
        this.canUseArmorPiercing = true;
        this.canUseHighExplosive = true;
        this.canUseStandard = true;
        this.showFuel = true;
    }
    protected <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.getLimbSwingAmount() > 0.1F) {
            event.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllers.add(new AnimationController<>(this, "shoot_controller", state -> PlayState.STOP).triggerableAnim("shoot", RawAnimation.begin().then("shoot", Animation.LoopType.PLAY_ONCE)));

    }
}