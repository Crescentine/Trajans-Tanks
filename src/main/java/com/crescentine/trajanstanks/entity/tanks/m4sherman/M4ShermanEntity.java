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
        // Store previous rotations (you can use a map to track entities)
        if (!this.getPersistentData().contains("prevYaw")) {
            this.getPersistentData().putFloat("prevYaw", this.getYRot());
        }

        // Get current and previous rotation
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
    }

    @Override
    protected Item getItem() {
        return TankModItems.M4SHERMAN_ITEM.get();
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
