package com.crescentine.trajanstanks.entity.tank.light_tank;

import com.crescentine.trajanstanks.TankModClient;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.fml.loading.FMLEnvironment;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;

public class TankEntity extends Pig implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    private final int cooldown = 75;

    private int time = cooldown;

    @Override
    public void thunderHit(ServerLevel p_29473_, LightningBolt p_29474_) {

    }


    public TankEntity(EntityType<?> entityType, Level world) {
        super((EntityType<? extends Pig>) entityType, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Pig.createLivingAttributes()
                .add(Attributes.MOVEMENT_SPEED, TankModConfig.light_tank_speed.get())
                .add(Attributes.MAX_HEALTH, 250.0)
                .add(Attributes.ARMOR, 3.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10.0D)
                .add(Attributes.FOLLOW_RANGE, 0.0D);
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tank.walking", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public boolean canStandOnFluid(FluidState fluid) {
        return false;
    }



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
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));

    }


    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    protected void registerGoals() {
    }
//Movement Related


    @Override
    protected boolean shouldPassengersInheritMalus() {
        return true;
    }
/*
    @Override
    public boolean isEffectiveAi() {
        return true;
    } */

    //Movement Related ^


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
    protected boolean isImmobile() {
        return false;
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


    @Override
    public InteractionResult interactAt(Player player, Vec3 hitPos, InteractionHand hand) {
        player.startRiding(this, true);
        return InteractionResult.SUCCESS;
    }

   static int shellsUsed = 1;

 public void tick() {
         super.tick();

         if (time < cooldown) time++;
    }
    public boolean shoot(Player player, Level world) {
        ItemStack itemStack = ItemStack.EMPTY;
        Player playerEntity = (Player) player;
        for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
            ItemStack stack = playerEntity.getInventory().getItem(i);
            if (stack.getItem() == TankModItems.SHELL_ITEM.get() && stack.getCount() >= shellsUsed) {
                itemStack = stack;
                break;
            }
        }

        if (time < cooldown) {
            player.sendMessage(new TextComponent("Please wait " + (cooldown - time) / 20 + " s !").withStyle(ChatFormatting.AQUA), Util.NIL_UUID);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (itemStack.isEmpty()) {
            player.sendMessage(new TextComponent("You don't have any ammo!" ).withStyle(ChatFormatting.RED), Util.NIL_UUID);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
        if (!itemStack.isEmpty()) {
            ShellEntity shellEntity = new ShellEntity(player, world);
            shellEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 0F);

            double distance = 1.0D;

            double x = -Mth.sin((float) (player.getEyeY() / 180.0F * (float) Math.PI)) * distance;
            double z = -Mth.cos((float) (player.getEyeY() / 180.0F * (float) Math.PI)) * distance;


       //     shellEntity.setPos(player.getX() + x, player.getY() - 1.0D, player.getZ() + z);
            shellEntity.setPos(player.getEyePosition());
            world.addFreshEntity(shellEntity);

            itemStack.shrink(shellsUsed);
        }
        time = 0;
            return true;
        }
}

