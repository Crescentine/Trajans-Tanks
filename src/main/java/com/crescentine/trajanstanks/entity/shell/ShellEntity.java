package com.crescentine.trajanstanks.entity.shell;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.TankModEntityTypes;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.network.NetworkHooks;

@SuppressWarnings("EntityConstructor")
public class ShellEntity extends ThrowableItemProjectile {
    public ShellEntity(EntityType<ShellEntity> entityType, Level world) {
        super(entityType, world);
    }

    public ShellEntity(double x, double y, double z, Level world) {
        super(TankModEntityTypes.SHELL.get(), x, y, z, world);
    }

    public ShellEntity(LivingEntity player, Level world) {
        super(TankModEntityTypes.SHELL.get(), player, world);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return TankModItems.SHELL_ITEM.get();
    }

    @Override
    protected void onHit(HitResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) { // checks if the world is client
            this.level.broadcastEntityEvent(this, (byte) 3); // particle?
            if (!level.isClientSide) {
                level.explode(this, getX(), getY(), getZ(), 3, Explosion.BlockInteraction.DESTROY);
                this.kill();
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.playSound(SoundEvents.GENERIC_EXPLODE, 2F, 1F);
        if (entity instanceof LivingEntity) {
            entity.hurt(DamageSource.thrown(this, this.getOwner()), (float) (TankModConfig.shell_damage.get() * 1.0f));
            entity.playSound(SoundEvents.GENERIC_EXPLODE, 2F, 1F);

        }
    }
}