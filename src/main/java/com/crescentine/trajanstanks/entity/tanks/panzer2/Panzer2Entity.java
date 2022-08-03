package com.crescentine.trajanstanks.entity.tanks.panzer2;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanscore.item.TrajansCoreItems;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.entity.tankshells.apcr.APCRShell;
import com.crescentine.trajanstanks.entity.tankshells.armorpiercing.ArmorPiercingShell;
import com.crescentine.trajanstanks.entity.tankshells.heat.HeatShell;
import com.crescentine.trajanstanks.entity.tankshells.highexplosive.HighExplosiveShell;
import com.crescentine.trajanstanks.entity.tankshells.standard.StandardShell;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class Panzer2Entity extends BaseTankEntity {
    static int shellsUsed = 1;
    public Panzer2Entity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.panzer2_health.get();
        this.speed = TankModConfig.panzer2_speed.get();
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
    }

    @Override
    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tank.walking", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
    public boolean canBeControlled() {
        return this.level.isClientSide && TankModClient.START_MOVING.isDown();
    }
    @Override
    public boolean shoot(Player player, BaseTankEntity tank, Level world) {
        Player playerEntity = (Player) player;
        ItemStack itemStack = ItemStack.EMPTY;
        BaseTankEntity tankEntity = (BaseTankEntity) tank;
        for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
            ItemStack stack = playerEntity.getInventory().offhand.get(i);
            if (stack.getCount() >= shellsUsed) {
                itemStack = stack;
                break;
            }
            player.displayClientMessage(Component.literal("You don't have any ammo!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
        }
        if (time < shootingCooldown) {
            player.displayClientMessage(Component.literal("Please wait " + (shootingCooldown - time) / 20 + " s !").withStyle(ChatFormatting.AQUA, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (getFuelAmount() < 1 && TankModConfig.fuelSystemEnabled.get()) {
            player.displayClientMessage(Component.literal("You don't have any fuel!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (!AMMO.test(itemStack)) {
            player.displayClientMessage(Component.literal("You don't have any ammo!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }

        if (itemStack.is(TrajansCoreItems.STANDARD_SHELL.get()) && canUseStandard) {
            StandardShell shellEntity = new StandardShell(tankEntity, world);
            shellEntity.shootFromRotation(tankEntity, tankEntity.getXRot(), tankEntity.getYRot(), 0.0F, 3.5F, 0F);
            world.addFreshEntity(shellEntity);
            itemStack.shrink(shellsUsed);
        }
        if (itemStack.is(TrajansCoreItems.STANDARD_SHELL.get()) && !canUseStandard) {
            player.displayClientMessage(Component.literal("Shell Type disabled with this vehile!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }

        if (itemStack.is(TrajansCoreItems.ARMOR_PIERCING_SHELL.get()) && canUseArmorPiercing) {
            ArmorPiercingShell shellEntity = new ArmorPiercingShell(tankEntity, world);
            shellEntity.shootFromRotation(tankEntity, tankEntity.getXRot(), tankEntity.getYRot(), 0.0F, 3.5F, 0F);
            world.addFreshEntity(shellEntity);
            itemStack.shrink(shellsUsed);
        }
        if (itemStack.is(TrajansCoreItems.ARMOR_PIERCING_SHELL.get()) && !canUseArmorPiercing) {
            player.displayClientMessage(Component.literal("Shell Type disabled with this vehicle!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }

        if (itemStack.is(TrajansCoreItems.HIGH_EXPLOSIVE_SHELL.get()) && canUseHighExplosive) {
            HighExplosiveShell shellEntity = new HighExplosiveShell(tankEntity, world);
            shellEntity.shootFromRotation(tankEntity, tankEntity.getXRot(), tankEntity.getYRot(), 0.0F, 3.5F, 0F);
            world.addFreshEntity(shellEntity);
            itemStack.shrink(shellsUsed);
        }
        if (itemStack.is(TrajansCoreItems.HIGH_EXPLOSIVE_SHELL.get()) && !canUseHighExplosive) {
            player.displayClientMessage(Component.literal("Shell Type disabled with this vehicle!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }

        if (itemStack.is(TrajansCoreItems.HEAT_SHELL.get()) && canUseHeat) {
            HeatShell shellEntity = new HeatShell(tankEntity, world);
            shellEntity.shootFromRotation(tankEntity, tankEntity.getXRot(), tankEntity.getYRot(), 0.0F, 3.5F, 0F);
            world.addFreshEntity(shellEntity);
            itemStack.shrink(shellsUsed);
        }
        if (itemStack.is(TrajansCoreItems.HEAT_SHELL.get()) && !canUseHeat) {
            player.displayClientMessage(Component.literal("Shell Type disabled with this vehicle!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }

        if (itemStack.is(TrajansCoreItems.APCR_SHELL.get()) && canUseAPCR) {
            APCRShell shellEntity = new APCRShell(tankEntity, world);
            shellEntity.shootFromRotation(tankEntity, tankEntity.getXRot(), tankEntity.getYRot(), 0.0F, 3.5F, 0F);
            world.addFreshEntity(shellEntity);
            itemStack.shrink(shellsUsed);
        }
        if (itemStack.is(TrajansCoreItems.APCR_SHELL.get()) && !canUseAPCR) {
            player.displayClientMessage(Component.literal("Shell Type disabled with this vehicle!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        time = 0;
        return true;
    }
}