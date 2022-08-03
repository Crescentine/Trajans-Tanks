package com.crescentine.trajanstanks.entity.tanks.tiger;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class TigerTankEntity extends BaseTankEntity {
    public TigerTankEntity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.speed = TankModConfig.tiger_speed.get();
        this.health = TankModConfig.tiger_health.get();
        this.shootingCooldown = TankModConfig.tiger_shot_cooldown.get();
        this.armor = 5.0;
        this.healAmount = TankModConfig.tiger_heal_amount.get();
        this.maxFuel = TankModConfig.tiger_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = true;
        this.canUseArmorPiercing = true;
        this.canUseHighExplosive = true;
        this.canUseStandard = true;
    }
    @Override
    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.getLimbSwingAmount() > 0.1F) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
}