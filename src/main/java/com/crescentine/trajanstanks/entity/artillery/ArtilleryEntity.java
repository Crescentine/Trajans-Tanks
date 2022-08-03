package com.crescentine.trajanstanks.entity.artillery;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.shell.ArtilleryShell;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.shadowed.fasterxml.jackson.databind.ser.Serializers;

public class ArtilleryEntity extends BaseTankEntity {
    private final int cooldown = TankModConfig.mounted_gun_shot_cooldown.get();
    private int artilleryShootingAnimation;
    private int time = cooldown;
    public ArtilleryEntity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.mounted_gun_health.get();
        this.speed = 0;
        this.armored = false;
    }
    @Override
    public InteractionResult interactAt(Player player, Vec3 hitPos, InteractionHand hand) {
        player.startRiding(this, true);
        return InteractionResult.SUCCESS;
    }
    public void tick() {
        super.tick();

        if (time < cooldown) time++;
    }
    @Override
    public boolean shoot(Player player, BaseTankEntity tank, Level world) {
        ItemStack itemStack = ItemStack.EMPTY;
        Player playerEntity = (Player) player;
        for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
            ItemStack stack = playerEntity.getInventory().getItem(i);
            if (stack.getItem() == TankModItems.ARTILLERY_SHELL_ITEM.get() && stack.getCount() >= 1) {
                itemStack = stack;
                break;
            }
        }
        if (time < cooldown) {
            player.displayClientMessage(Component.literal("Please wait " + (cooldown - time) / 20 + " s !").withStyle(ChatFormatting.AQUA), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (itemStack.isEmpty()) {
            player.displayClientMessage(Component.literal("You don't have any ammo!" ).withStyle(ChatFormatting.RED), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (!itemStack.isEmpty()) {
            ArtilleryShell artilleryShell = new ArtilleryShell(player, world);
            artilleryShell.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0f, 0F);

            artilleryShell.setPos(this.getEyePosition());
            world.addFreshEntity(artilleryShell);
            itemStack.shrink(1);
        }
        time = 0;
        artilleryShootingAnimation = 0;
        return true;
    }
    @Override
    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        }
        if (artilleryShootingAnimation == 1) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("shooting_test", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public double getPassengersRidingOffset() {
        return 0.3;
    }
}
