package com.crescentine.trajanstanks.entity.tanks.archer;

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

public class ArcherEntity extends BaseTankEntity {
    public ArcherEntity(EntityType<? extends BaseTankEntity> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.archer_health.get();
        this.speedMultiplier = TankModConfig.archer_speed.get();
        this.shootingCooldown = TankModConfig.archer_shot_cooldown.get();
        this.armor = 5.0;
        this.healAmount = TankModConfig.archer_heal_amount.get();
        this.maxFuel = TankModConfig.archer_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = true;
        this.canUseHeat = false;
        this.canUseArmorPiercing = false;
        this.canUseHighExplosive = false;
        this.canUseStandard = false;
        this.showFuel = true;
        this.isTD=true;
        this.isOpposite=true;
        this.tankItem = TankModItems.ARCHER_ITEM.get();
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
}
