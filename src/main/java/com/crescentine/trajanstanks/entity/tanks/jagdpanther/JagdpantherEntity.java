package com.crescentine.trajanstanks.entity.tanks.jagdpanther;

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

public class JagdpantherEntity extends BaseTankEntity {
    public JagdpantherEntity(EntityType<? extends BaseTankEntity> entityType, Level world) {
        super(entityType, world);
        this.isTD=true;
        this.health = TankModConfig.heavy_tank_health.get();
        this.entityData.set(HEALTH, this.health);
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
        this.tankItem = TankModItems.JAGDPANTHER_ITEM.get();
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
    protected Item getItem() {
        return TankModItems.JAGDPANTHER_ITEM.get();
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if(getHealth()<=0) {
            kill();
            dropItem();
        }

        return super.hurt(pSource, pAmount);
    }

    protected void dropItem() {
        ItemStack itemStack = getItemStack();
        spawnAtLocation(itemStack);
    }
}