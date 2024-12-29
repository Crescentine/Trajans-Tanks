package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.client.player.Input;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class CruiserMk1Entity extends BaseTankEntity {
    public CruiserMk1Entity(EntityType<? extends BaseTankEntity> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.light_tank_health.get();
        this.entityData.set(HEALTH, this.health);
        this.speedMultiplier = TankModConfig.cruisermk1_speed.get();
        this.shootingCooldown = TankModConfig.cruisermk1_shot_cooldown.get();
        this.armor = 3.0;
        this.healAmount = TankModConfig.cruisermk1_heal_amount.get();
        this.maxFuel = TankModConfig.cruisermk1_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = false;
        this.canUseArmorPiercing = false;
        this.canUseHighExplosive = false;
        this.canUseStandard = true;
        this.showFuel = true;
       // this.speedMultiplier = 0.34;
        this.tankItem = TankModItems.CRUISER_MK1_ITEM.get();
    }
    protected <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.xo != this.getX() || this.zo != this.getZ() || this.yRotO != this.getYRot()) {
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
        return TankModItems.CRUISER_MK1_ITEM.get();
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