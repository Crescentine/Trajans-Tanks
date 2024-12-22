package com.crescentine.trajanstanks.entity.tanks.tiger;

import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class TigerTankEntity extends BaseTankEntity {
    public TigerTankEntity(EntityType<? extends BaseTankEntity> entityType, Level world) {
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
        if (this.xo != this.getX() || this.zo != this.getZ()) {
            event.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }
    protected <E extends GeoAnimatable> PlayState attackPredicate(AnimationState<E> event) {
        if (event.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            event.getController().setAnimation(RawAnimation.begin().then("shoot", Animation.LoopType.PLAY_ONCE));



        }
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    @Override
    protected Item getItem() {
        return TankModItems.TIGER_ITEM.get();
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