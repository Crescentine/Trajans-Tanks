package com.crescentine.trajanstanks.entity.tankshells.highexplosive;

import com.crescentine.trajanscore.item.TrajansCoreItems;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.TankModEntityTypes;
import com.crescentine.trajanstanks.entity.tankshells.base.BaseShell;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class HighExplosiveShell extends BaseShell {
    public HighExplosiveShell(EntityType<HighExplosiveShell> entityType, Level world) {
        super(entityType, world);
        damage = TankModConfig.highExplosiveShellDamage.get();
        explosionRadius = TankModConfig.highExplosiveShellExplosionRadius.get();
        fire = false;
    }
    public HighExplosiveShell(EntityType<HighExplosiveShell> entityType, double x, double y, double z, Level world) {
        super(TankModEntityTypes.HEAT_SHELL.get(), x, y, z, world);
        damage = TankModConfig.highExplosiveShellDamage.get();
        explosionRadius = TankModConfig.highExplosiveShellExplosionRadius.get();
        fire = false;
    }

    public HighExplosiveShell(LivingEntity player, Level world) {
        super(TankModEntityTypes.HEAT_SHELL.get(), player, world);
        damage = TankModConfig.highExplosiveShellDamage.get();
        explosionRadius = TankModConfig.highExplosiveShellExplosionRadius.get();
        fire = false;
    }
    @Override
    protected Item getDefaultItem() {
        return TrajansCoreItems.HEAT_SHELL.get();
    }

}