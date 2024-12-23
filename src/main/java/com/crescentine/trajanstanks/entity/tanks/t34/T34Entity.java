package com.crescentine.trajanstanks.entity.tanks.t34;

import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class T34Entity extends BaseTankEntity {
    public T34Entity(EntityType<? extends BaseTankEntity> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.t34_health.get();
        this.speedMultiplier = TankModConfig.t34_speed.get();
        this.shootingCooldown = TankModConfig.t34_shot_cooldown.get();
        this.armor = 4.0;
        this.healAmount = TankModConfig.t34_heal_amount.get();
        this.maxFuel = TankModConfig.t34_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = true;
        this.canUseArmorPiercing = true;
        this.canUseHighExplosive = true;
        this.canUseStandard = true;
        this.showFuel = true;
        this.tankItem = TankModItems.T34_ITEM.get();
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
        controllers.add(new AnimationController<>(this, "shoot_controller", state -> PlayState.STOP).triggerableAnim("shoot", RawAnimation.begin().then("shoot", Animation.LoopType.PLAY_ONCE)));
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }
}
