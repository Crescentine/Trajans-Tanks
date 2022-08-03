package com.crescentine.trajanstanks.entity.tankshells.apcr;

import com.crescentine.trajanscore.item.TrajansCoreItems;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.TankModEntityTypes;
import com.crescentine.trajanstanks.entity.tankshells.base.BaseShell;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class APCRShell extends BaseShell {
    public APCRShell(EntityType<APCRShell> entityType, Level world) {
        super(entityType, world);
        damage = TankModConfig.APCRShellDamage.get();
        explosionRadius = TankModConfig.APCRShellExplosionRadius.get();
        fire = false;
    }
    public APCRShell(EntityType<APCRShell> entityType, double x, double y, double z, Level world) {
        super(TankModEntityTypes.APCR_SHELL.get(), x, y, z, world);
        damage = TankModConfig.APCRShellDamage.get();
        explosionRadius = TankModConfig.APCRShellExplosionRadius.get();
        fire = false;
    }

    public APCRShell(LivingEntity player, Level world) {
        super(TankModEntityTypes.APCR_SHELL.get(), player, world);
        damage = TankModConfig.APCRShellDamage.get();
        explosionRadius = TankModConfig.APCRShellExplosionRadius.get();
        fire = false;
    }
    @Override
    protected Item getDefaultItem() {
        return TrajansCoreItems.APCR_SHELL.get();
    }

}