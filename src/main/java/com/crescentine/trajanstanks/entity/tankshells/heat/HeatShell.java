package com.crescentine.trajanstanks.entity.tankshells.heat;

import com.crescentine.trajanscore.item.TrajansCoreItems;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.TankModEntityTypes;
import com.crescentine.trajanstanks.entity.tankshells.base.BaseShell;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class HeatShell extends BaseShell {
    public HeatShell(EntityType<HeatShell> entityType, Level world) {
        super(entityType, world);
        damage = TankModConfig.heatShellDamage.get();
        explosionRadius = TankModConfig.heatShellExplosionRadius.get();
        fire = true;
    }
    public HeatShell(EntityType<HeatShell> entityType, double x, double y, double z, Level world) {
        super(TankModEntityTypes.HEAT_SHELL.get(), x, y, z, world);
        damage = TankModConfig.heatShellDamage.get();
        explosionRadius = TankModConfig.heatShellExplosionRadius.get();
        fire = true;
    }

    public HeatShell(LivingEntity player, Level world) {
        super(TankModEntityTypes.HEAT_SHELL.get(), player, world);
        damage = TankModConfig.heatShellDamage.get();
        explosionRadius = TankModConfig.heatShellExplosionRadius.get();
        fire = true;
    }
    @Override
    protected Item getDefaultItem() {
        return TrajansCoreItems.HEAT_SHELL.get();
    }

}