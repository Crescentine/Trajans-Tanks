package com.crescentine.trajanstanks.entity.tanks.basetank;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class BaseTankEntity extends Pig {
    public int shootingCooldown = 60;
    public int time;
    static int shellsUsed = 1;
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
        if (TankModClient.startMoving.isDown()) {
            return true;
        }
        return false;
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
    public boolean startRiding(Entity p_21396_, boolean p_21397_) {
        this.time = 0;
        return super.startRiding(p_21396_, p_21397_);
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

    public void tick() {
        super.tick();

        if (time < shootingCooldown) time++;
    }

    public boolean shoot(Player player, BaseTankEntity tank, Level world) {
        ItemStack itemStack = ItemStack.EMPTY;
        Player playerEntity = (Player) player;
        BaseTankEntity tankEntity = (BaseTankEntity) tank;
        for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
            ItemStack stack = playerEntity.getInventory().getItem(i);
            if (stack.getItem() == TankModItems.SHELL_ITEM.get() && stack.getCount() >= shellsUsed) {
                itemStack = stack;
                break;
            }
        }

        if (time < shootingCooldown) {
            player.sendMessage(new TextComponent("Please wait " + (shootingCooldown - time) / 20 + " s !").withStyle(ChatFormatting.AQUA), Util.NIL_UUID);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (itemStack.isEmpty()) {
            player.sendMessage(new TextComponent("You don't have any ammo!" ).withStyle(ChatFormatting.RED), Util.NIL_UUID);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (!itemStack.isEmpty()) {
            ShellEntity shellEntity = new ShellEntity(tankEntity, world);
            shellEntity.shootFromRotation(tankEntity, tankEntity.getXRot(), tankEntity.getYRot(), 0.0F, 2.0F, 0F);
            world.addFreshEntity(shellEntity);
            itemStack.shrink(shellsUsed);
        }
        time = 0;
        return true;
    }
}
