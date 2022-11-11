package com.crescentine.trajanstanks.entity.tanks.kv2;

import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class KV2Entity extends BaseTankEntity {
    public KV2Entity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.kv2_health.get();
        this.speed = TankModConfig.kv2_speed.get();
        this.shootingCooldown = TankModConfig.kv2_shot_cooldown.get();
        this.armor = 5.0;
        this.healAmount = TankModConfig.kv2_heal_amount.get();
        this.maxFuel = TankModConfig.kv2_maxfuel.get() * 20;
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

    @Override
    public boolean shouldRiderSit() {
        return false;
    }
}
