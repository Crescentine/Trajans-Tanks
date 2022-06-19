package com.crescentine.trajanstanks.entity.tanks.panzer2;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class Panzer2Entity extends BaseTankEntity {
    public Panzer2Entity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.panzer2_health.get();
        this.speed = TankModConfig.panzer2_speed.get();
        this.shootingCooldown = TankModConfig.panzer2_shot_cooldown.get();
        this.armor = 3.0;
        this.healAmount = TankModConfig.panzer2_heal_amount.get();
        this.tankName = "panzer2";
    }
    @Override
    protected <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tank.walking", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
}