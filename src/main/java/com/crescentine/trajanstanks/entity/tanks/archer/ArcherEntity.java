package com.crescentine.trajanstanks.entity.tanks.archer;

import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class ArcherEntity extends BaseTankEntity {
    public ArcherEntity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.archer_health.get();
        this.speed = TankModConfig.archer_speed.get();
        this.shootingCooldown = TankModConfig.archer_shot_cooldown.get();
        this.armor = 5.0;
        this.healAmount = TankModConfig.archer_heal_amount.get();
        this.maxFuel = TankModConfig.archer_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = true;
        this.canUseHeat = false;
        this.canUseArmorPiercing = false;
        this.canUseHighExplosive = false;
        this.canUseStandard = false;
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
