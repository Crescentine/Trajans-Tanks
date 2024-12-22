package com.crescentine.trajanstanks.entity.tanks.panzer2;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanscore.item.TrajansCoreItems;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class Panzer2Entity extends BaseTankEntity {
    static int shellsUsed = 1;
    public Panzer2Entity(EntityType<? extends BaseTankEntity> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.panzer2_health.get();
        this.speedMultiplier = TankModConfig.panzer2_speed.get();
        this.shootingCooldown = TankModConfig.panzer2_shot_cooldown.get();
        this.armor = 3.0;
        this.healAmount = TankModConfig.panzer2_heal_amount.get();
        this.maxFuel = TankModConfig.panzer_2_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = false;
        this.canUseArmorPiercing = false;
        this.canUseHighExplosive = false;
        this.canUseStandard = true;
        this.showFuel = true;
        this.speedMultiplier = 0.6f;
    }
    protected <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().then("animation.tank.walking", Animation.LoopType.LOOP));
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

    /*
    protected void positionRider(Entity p_289552_, Entity.MoveFunction p_289571_) {
        if (this.hasPassenger(p_289552_)) {
            Vec3 vec3 = (new Vec3((double)0.2, 0.0D, 2)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));

            p_289571_.accept(p_289552_, this.getX() + vec3.x, this.getY() + vec3.y, this.getZ() + 2.5);
            super.positionRider(p_289552_, p_289571_);

        }
    }
    */

    protected void positionRider(Entity pPassenger, Entity.MoveFunction pCallback) {
        if (this.hasPassenger(pPassenger)) {
            double d0 = this.getY() + this.getPassengersRidingOffset() + pPassenger.getMyRidingOffset();
            pCallback.accept(pPassenger, this.getX(), d0, this.getZ());
        }
    }

    @Override
    public void rideTick() {
        super.rideTick();
    }

    @Override
    protected Item getItem() {
        return TankModItems.PANZER2_ITEM.get();
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