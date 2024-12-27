package com.crescentine.trajanstanks.entity.tanks.m4sherman;

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

public class M4ShermanEntity extends BaseTankEntity {
    public M4ShermanEntity(EntityType<? extends BaseTankEntity> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.m4sherman_health.get();
        this.entityData.set(HEALTH, this.health);
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
        this.tankItem = TankModItems.M4SHERMAN_ITEM.get();
    }

    protected <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (!this.getPersistentData().contains("prevYaw")) {
            this.getPersistentData().putFloat("prevYaw", this.getYRot());
        }
        float prevYaw = this.getPersistentData().getFloat("prevYaw");
        float currentYaw = this.getYRot();


        if (this.xo != this.getX() || this.zo != this.getZ() || prevYaw != currentYaw) {
            event.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            this.getPersistentData().putFloat("prevYaw", currentYaw);

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
}
