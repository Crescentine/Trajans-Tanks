package com.crescentine.trajanstanks.entity.artillery.qf6;

import com.crescentine.trajanscore.basetank.BaseATEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class QF6Entity extends BaseATEntity {
    public QF6Entity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.qf6_health.get();
        this.speedMultiplier = 0;
        this.shootingCooldown = TankModConfig.qf6_cooldown.get();
        this.canUseArmorPiercing = true;
        this.canUseAPCR = true;
        this.canUseHeat = false;
        this.canUseHighExplosive = false;
        this.canUseStandard = false;
    }
    @Override
    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
    @Override
    public double getPassengersRidingOffset() {
        return 0.6;
    }
}