package com.crescentine.trajanstanks.entity.tanks.kv2;

import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class KV2Entity extends BaseTankEntity {
    public KV2Entity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.kv2_health.get();
        this.speedMultiplier = TankModConfig.kv2_speed.get();
        this.shootingCooldown = TankModConfig.kv2_shot_cooldown.get();
        this.armor = 5.0;
        this.healAmount = TankModConfig.kv2_heal_amount.get();
        this.maxFuel = TankModConfig.kv2_maxfuel.get() * 20;
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
    @Override
    public boolean shouldRiderSit() {
        return false;
    }
}
