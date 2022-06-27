package com.crescentine.trajanstanks.entity.tanks.panzer2;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class Panzer2Entity extends BaseTankEntity {
    public Panzer2Entity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.panzer2_health.get();
        this.speed = TankModConfig.panzer2_speed.get();
        this.shootingCooldown = TankModConfig.panzer2_shot_cooldown.get();
        this.armor = 3.0;
        this.healAmount = TankModConfig.panzer2_heal_amount.get();
        this.maxFuel = TankModConfig.panzer_2_maxfuel.get() * 20;
    }
    @Override
    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tank.walking", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

   /* @Override
    public boolean canBeControlledByRider() {
        if (TankModClient.startMoving.isDown()) {
            return true;
        }
        return false;
    }
  @Override
    public boolean shoot(Player player, BaseTankEntity tank, Level world) {
        ItemStack itemStack = ItemStack.EMPTY;
        Player playerEntity = (Player) player;
        Panzer2Entity tankEntity = (Panzer2Entity) tank;
        for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
            ItemStack stack = playerEntity.getInventory().getItem(i);
            if (stack.getItem() == TankModItems.SHELL_ITEM.get() && stack.getCount() >= 1) {
                itemStack = stack;
                break;
            }
        }

        if (time < shootingCooldown) {
            player.sendMessage(new TextComponent("Please wait " + (shootingCooldown - time) / 20 + " s !").withStyle(ChatFormatting.AQUA, ChatFormatting.BOLD), Util.NIL_UUID);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (itemStack.isEmpty()) {
            player.sendMessage(new TextComponent("You don't have any ammo!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), Util.NIL_UUID);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (getFuelAmount() < 1 && TankModConfig.fuelSystemEnabled.get()) {
            player.sendMessage(new TextComponent("You don't have any fuel!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), Util.NIL_UUID);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (!itemStack.isEmpty()) {
            ShellEntity shellEntity = new ShellEntity(tankEntity, world);
            shellEntity.shootFromRotation(player, tank.getXRot(),  tank.getYRot(), 0.0F, 2.5F, 0F);
            world.addFreshEntity(shellEntity);
            itemStack.shrink(1);
            shootingAnimation = true;
        }
        time = 0;
        shootingAnimation = false;
        return true;
    } */
}