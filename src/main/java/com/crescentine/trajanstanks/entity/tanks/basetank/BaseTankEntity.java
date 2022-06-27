package com.crescentine.trajanstanks.entity.tanks.basetank;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BaseTankEntity extends Pig implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    public double healAmount = 0;
    public double speed = 0;
    private static final EntityDataAccessor<Integer> FUEL_AMOUNT = SynchedEntityData.defineId(BaseTankEntity.class, EntityDataSerializers.INT);
    public int shootingCooldown = 60;
    public int time;
    public double armor = 0;
    static int shellsUsed = 1;
    public double health = 0;
    public double coalFuelAmount = TankModConfig.coalFuelAmount.get();
    public double lavaFuelAmount = TankModConfig.lavaFuelAmount.get();
    public double maxFuel = 12000.00;
    public boolean shootingAnimation;
    double d0 = this.random.nextGaussian() * 0.03D;
    double d1 = this.random.nextGaussian() * 0.03D;
    double d2 = this.random.nextGaussian() * 0.03D;
    private static final Ingredient COAL_FUEL = Ingredient.of(Items.COAL, Items.CHARCOAL);
    private static final Ingredient LAVA_FUEL = Ingredient.of(Items.LAVA_BUCKET);

    public BaseTankEntity(EntityType<?> entityType, Level world) {
        super((EntityType<? extends Pig>) entityType, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Pig.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 250.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10.0D)
                .add(Attributes.FOLLOW_RANGE, 0.0D);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 hitPos, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Inventory inventory = player.getInventory();
        if (itemstack.is(Items.IRON_BLOCK)) {
            this.heal((float) healAmount);
            itemstack.shrink(1);
            this.level.addParticle(ParticleTypes.FLAME, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
            return InteractionResult.SUCCESS;
        }
        if (COAL_FUEL.test(itemstack) && getFuelAmount() < maxFuel && TankModConfig.fuelSystemEnabled.get()) {
            addFuel((int) coalFuelAmount * 20);
            itemstack.shrink(1);
            this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX() + 1.0D, this.getY() + 1.0D, this.getZ(), d0, d1, d2);
            return InteractionResult.SUCCESS;
        }
        if (LAVA_FUEL.test(itemstack) && getFuelAmount() < maxFuel && TankModConfig.fuelSystemEnabled.get()) {
            addFuel((int) lavaFuelAmount * 20);
            itemstack.shrink(1);
            player.setItemInHand(hand, new ItemStack(Items.BUCKET));
            this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX() + 1.0D, this.getY() + 1.0D, this.getZ(), d0, d1, d2);
            return InteractionResult.SUCCESS;
        }
        player.startRiding(this, true);
        return InteractionResult.FAIL;
    }

    @Override
    protected boolean canAddPassenger(Entity p_20354_) {
        return !this.isVehicle();
    }

    @Override
    public void thunderHit(ServerLevel p_29473_, LightningBolt p_29474_) {
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
        return true;
    }

    @Override
    protected boolean isImmobile() {
        return true;
    }

    @Override
    public float getSteeringSpeed() {
        if (TankModConfig.fuelSystemEnabled.get() && TankModClient.startMoving.isDown() && getFuelAmount() > 0) {
            return (float) speed;
        }
        if (TankModClient.startMoving.isDown() && !TankModConfig.fuelSystemEnabled.get()) {
            return (float) speed;
        }
        return 0.0f;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_, MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_, @Nullable CompoundTag p_146750_) {
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((float) health);
        this.getAttribute(Attributes.ARMOR).setBaseValue(armor);
        this.setHealth((float) health);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
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
    protected void registerGoals() {
    }

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

    @Override
    public void tick() {
        super.tick();
        age++;
        if (time < shootingCooldown) time++;
        fuelTick();
        if (this.isVehicle() && this.age % 10 == 0 && getFuelAmount() > 0) {
            this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX() + 1.0D, this.getY() + 1.0D, this.getZ(), d0, d1, d2);
            this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX() + 1.0D, this.getY() + 1.0D, this.getZ(), d0, d1, d2);
        }
    }

    protected void fuelTick() {
        int fuel = getFuelAmount();
        if (this.isVehicle() && fuel > 0 && TankModClient.startMoving.isDown()) {
            removeFuel(1);
        }
    }

    private void removeFuel(int amount) {
        int fuel = getFuelAmount();
        int newFuel = fuel - amount;
        setFuelAmount(newFuel);
    }

    private void addFuel(int amount) {
        int fuel = getFuelAmount();
        int newFuel = fuel + amount;
        setFuelAmount((newFuel));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(FUEL_AMOUNT, 0);
    }

    public void setFuelAmount(int fuel) {
        this.entityData.set(FUEL_AMOUNT, fuel);
    }

    public int getFuelAmount() {
        return this.entityData.get(FUEL_AMOUNT);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        setFuelAmount(pCompound.getInt("fuel"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("fuel", getFuelAmount());
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
            shellEntity.shootFromRotation(tankEntity, tankEntity.getXRot(), tankEntity.getYRot(), 0.0F, 2.0F, 0F);
            world.addFreshEntity(shellEntity);
            itemStack.shrink(shellsUsed);
            shootingAnimation = true;
        }
        time = 0;
        shootingAnimation = false;
        return true;
    }

    public boolean fuelLeft(Player player) {
        double fuel = getFuelAmount();
        if (fuel < 1200 && fuel > 1 && TankModConfig.fuelSystemEnabled.get()) {
            player.sendMessage(new TextComponent("Low fuel! Amount of time before fuel runs out " + fuel / 20 + " seconds or " + String.format("%.2f", fuel / 1200) + " minutes ").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), Util.NIL_UUID);
            return true;
        }
        if (fuel > 1200 && TankModConfig.fuelSystemEnabled.get()) {
            player.sendMessage(new TextComponent("The amount of fuel remaining: " + fuel / 20 + " seconds, or " + String.format("%.2f", fuel / 1200) + " minutes ").withStyle(ChatFormatting.BLUE, ChatFormatting.BOLD), Util.NIL_UUID);
            return true;
        }
        if (getFuelAmount() < 1 && TankModConfig.fuelSystemEnabled.get()) {
            player.sendMessage(new TextComponent("No fuel remaining!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), Util.NIL_UUID);
            return true;
        }
        if (!TankModConfig.fuelSystemEnabled.get()) {
            player.sendMessage(new TextComponent("Fuel is not enabled! Enable fuel in the config, or contact your server administrator.").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), Util.NIL_UUID);
            return true;
        }
        return false;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }
}
