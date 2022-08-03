package com.crescentine.trajanstanks.entity.tankshells.standard;

import com.crescentine.trajanscore.item.TrajansCoreItems;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.TankModEntityTypes;
import com.crescentine.trajanstanks.entity.tankshells.base.BaseShell;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import software.bernie.geckolib3.core.IAnimatable;

public class StandardShell extends BaseShell {
    public StandardShell(EntityType<StandardShell> entityType, Level world) {
        super(entityType, world);
        damage = TankModConfig.standardShellDamage.get();
        explosionRadius = TankModConfig.standardShellExplosionRadius.get();
        fire = false;
    }
    public StandardShell(EntityType<?> entityType, double x, double y, double z, Level world) {
        super(TankModEntityTypes.STANDARD_SHELL.get(), x, y, z, world);
        damage = TankModConfig.standardShellDamage.get();
        explosionRadius = TankModConfig.standardShellExplosionRadius.get();
        fire = false;
    }

    public StandardShell(LivingEntity player, Level world) {
        super(TankModEntityTypes.STANDARD_SHELL.get(), player, world);
        damage = TankModConfig.standardShellDamage.get();
        explosionRadius = TankModConfig.standardShellExplosionRadius.get();
        fire = false;
    }

    @Override
    protected Item getDefaultItem() {
        return TrajansCoreItems.STANDARD_SHELL.get();
    }

}
