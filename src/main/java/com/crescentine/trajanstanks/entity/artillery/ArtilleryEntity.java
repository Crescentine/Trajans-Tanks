package com.crescentine.trajanstanks.entity.artillery;

import com.crescentine.trajanscore.entity.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.shell.ArtilleryShell;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ArtilleryEntity extends BaseTankEntity implements IAnimatable {
    private final int cooldown = TankModConfig.mounted_gun_shot_cooldown.get();
    private int time = cooldown;
    public ArtilleryEntity(EntityType<?> entityType, Level world) {
        super((EntityType<? extends Pig>) entityType, world);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Pig.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 200.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.00f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10.0D)
                .add(Attributes.FOLLOW_RANGE, 0.0D);
    }
    private final AnimationFactory factory = new AnimationFactory(this);

    @Override
    protected boolean isImmobile() {
        return false;
    }

    @Override
    public boolean canBeControlledByRider() {
        return true;
    }

    @Override
    public float getSteeringSpeed() {
        return 0.0f;
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 hitPos, InteractionHand hand) {
        player.startRiding(this, true);
        return InteractionResult.SUCCESS;
    }
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_, MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_, @Nullable CompoundTag p_146750_) {
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(TankModConfig.mounted_gun_health.get());
        this.setHealth(TankModConfig.mounted_gun_health.get().floatValue());
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }
    @Override
    public void registerControllers(AnimationData data) {

    }
    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    static int ammoUsed = 1;

    public void tick() {
        super.tick();

        if (time < cooldown) time++;
    }
    public boolean shoot(Player player, Level world) {
        ItemStack itemStack = ItemStack.EMPTY;
        Player playerEntity = (Player) player;
        for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
            ItemStack stack = playerEntity.getInventory().getItem(i);
            if (stack.getItem() == TankModItems.ARTILLERY_SHELL_ITEM.get() && stack.getCount() >= ammoUsed) {
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
            ArtilleryShell artilleryShell = new ArtilleryShell(player, world);
            artilleryShell.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 0F);

            double distance = 1.0D;

            double x = -Mth.sin((float) (player.getEyeY() / 180.0F * (float) Math.PI)) * distance;
            double z = -Mth.cos((float) (player.getEyeY() / 180.0F * (float) Math.PI)) * distance;

            artilleryShell.setPos(player.getEyePosition());
            world.addFreshEntity(artilleryShell);
            itemStack.shrink(ammoUsed);
        }
        time = 0;
        return true;
    }
}
