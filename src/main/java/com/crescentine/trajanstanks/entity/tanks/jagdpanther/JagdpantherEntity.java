package com.crescentine.trajanstanks.entity.tanks.jagdpanther;

import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class JagdpantherEntity extends BaseTankEntity {
    public JagdpantherEntity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.jagdpanther_health.get();
        this.speedMultiplier = TankModConfig.jagdpanther_speed.get();
        this.shootingCooldown = TankModConfig.jagdpanther_shot_cooldown.get();
        this.armor = 5.0;
        this.healAmount = TankModConfig.jagdpanther_heal_amount.get();
        this.maxFuel = TankModConfig.jagdpanther_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = true;
        this.canUseHeat = false;
        this.canUseArmorPiercing = false;
        this.canUseHighExplosive = false;
        this.canUseStandard = false;
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
    }
}