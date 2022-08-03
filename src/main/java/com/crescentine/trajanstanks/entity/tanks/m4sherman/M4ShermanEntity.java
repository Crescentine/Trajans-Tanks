package com.crescentine.trajanstanks.entity.tanks.m4sherman;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class M4ShermanEntity extends BaseTankEntity {
    public M4ShermanEntity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.m4sherman_health.get();
        this.speed = TankModConfig.m4sherman_speed.get();
        this.shootingCooldown = TankModConfig.m4sherman_shot_cooldown.get();
        this.armor = 4.0;
        this.healAmount = TankModConfig.m4sherman_heal_amount.get();
        this.maxFuel = TankModConfig.m4sherman_maxfuel.get() * 20;
        this.armored = true;
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
