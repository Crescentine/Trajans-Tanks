package com.crescentine.trajanstanks.entity.tanks.t34;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class T34Entity extends BaseTankEntity {
    public T34Entity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.t34_health.get();
        this.speed = TankModConfig.t34_speed.get();
        this.shootingCooldown = TankModConfig.t34_shot_cooldown.get();
        this.armor = 4.0;
        this.healAmount = TankModConfig.t34_heal_amount.get();
        this.maxFuel = TankModConfig.t34_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = true;
        this.canUseArmorPiercing = true;
        this.canUseHighExplosive = true;
        this.canUseStandard = true;
    }
    @Override
    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
}
