package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanscore.entity.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CruiserMk1Entity extends BaseTankEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    private final int cooldown = TankModConfig.cruisermk1_shot_cooldown.get();
    private int time = cooldown;

    public CruiserMk1Entity(EntityType<?> entityType, Level world) {
        super((EntityType<? extends Pig>) entityType, world);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Pig.createLivingAttributes()
                .add(Attributes.ARMOR, 3.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10.0D)
                .add(Attributes.FOLLOW_RANGE, 0.0D);
    }

        private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
            if (event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
                return PlayState.CONTINUE;
            }
            return PlayState.STOP;
}
        @Override
        public void registerControllers(AnimationData animationData) {
            animationData.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
        //    animationData.addAnimationController(new AnimationController<>(this, "controller", 0, this::shootPredicate));
        }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_, MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_, @Nullable CompoundTag p_146750_) {
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(TankModConfig.cruisermk1_health.get());
        this.setHealth(TankModConfig.cruisermk1_health.get().floatValue());
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    double speed = TankModConfig.cruisermk1_speed.get();
        float speedFloat = (float)speed;
        @Override
        public float getSteeringSpeed() {
            if (TankModClient.startMoving.isDown()) {
                return speedFloat;
            }
            return 0.0f;
        }
        @Override
        public boolean canBeControlledByRider() {
            return true;
        }

        @Override
        public AnimationFactory getFactory() {
            return this.factory;
        }
        @Override
        protected boolean isImmobile() {
            return false;
        }
    @Override
    public InteractionResult interactAt(Player player, Vec3 hitPos, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.is(Items.IRON_BLOCK)) {
            this.heal(10.0f);
            itemstack.shrink(1);
            return InteractionResult.SUCCESS;
        }
        player.startRiding(this, true);
        return InteractionResult.FAIL;
    }

    static int shellsUsed = 1;
        public void tick() {
            super.tick();

            if (time < cooldown) time++;
        }

        public boolean shoot(Player player, CruiserMk1Entity tank, Level world) {
            ItemStack itemStack = ItemStack.EMPTY;
            Player playerEntity = (Player) player;
            CruiserMk1Entity tankEntity = (CruiserMk1Entity) tank;
            for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
                ItemStack stack = playerEntity.getInventory().getItem(i);
                if (stack.getItem() == TankModItems.SHELL_ITEM.get() && stack.getCount() >= shellsUsed) {
                    itemStack = stack;
                    break; }
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
                ShellEntity shellEntity = new ShellEntity(tankEntity, world);
                shellEntity.shootFromRotation(tankEntity, tankEntity.getXRot(), tankEntity.getYRot(), 0.0F, 2.0F, 0F);
                world.addFreshEntity(shellEntity);
                itemStack.shrink(shellsUsed);
            }
            time = 0;
            return true;
        }
    }