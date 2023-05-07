package com.crescentine.trajanstanks.entity.tanks.m4sherman;

import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class M4ShermanEntity extends BaseTankEntity {
    public M4ShermanEntity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.m4sherman_health.get();
        this.speedMultiplier = TankModConfig.m4sherman_speed.get();
        this.shootingCooldown = TankModConfig.m4sherman_shot_cooldown.get();
        this.armor = 4.0;
        this.healAmount = TankModConfig.m4sherman_heal_amount.get();
        this.maxFuel = TankModConfig.m4sherman_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = true;
        this.canUseArmorPiercing = true;
        this.canUseHighExplosive = true;
        this.canUseStandard = true;
        this.showFuel = true;
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
}
