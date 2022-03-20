package com.crescentine.trajanstanks.entity;

import com.crescentine.trajanstanks.TankModClient;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.loading.FMLEnvironment;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BaseTankEntity extends Pig {
    public BaseTankEntity(EntityType<?> entityType, Level world) {
        super((EntityType<? extends Pig>) entityType, world);
    }
    @Override
    public void thunderHit(ServerLevel p_29473_, LightningBolt p_29474_) { }

    @Override
    public boolean rideableUnderWater() {
        return false;
    }

    @Override
    protected int calculateFallDamage(float fallDistance, float damageMultiplier) {
        return 0;
    }

    @Override
    public int getMaxFallDistance() {
        return 30;
    }

    @Override
    public boolean canBeControlledByRider() {
        if (!FMLEnvironment.dist.isClient()) {
            return true;
        }
        if (TankModClient.STARTMOVING.isDown()) {
            return true;
        }
        return false;
    }
    @Override

    protected void removePassenger(Entity entity) {
        super.removePassenger(entity);
    }

    @Override
    public boolean requiresCustomPersistence() {
        return true;
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    protected void registerGoals() { }

    @Override
    protected boolean shouldPassengersInheritMalus() {
        return true;
    }

    @Override
    public void stopRiding() {
        super.stopRiding();
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    public Pig getBreedOffspring(ServerLevel p_149001_, AgeableMob p_149002_) {
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.MINECART_RIDING;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.GENERIC_EXPLODE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ARMOR_EQUIP_IRON;
    }

    @Override
    protected SoundEvent getSwimSplashSound() {
        return SoundEvents.PLAYER_SPLASH;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.GENERIC_SWIM;
    }
}
