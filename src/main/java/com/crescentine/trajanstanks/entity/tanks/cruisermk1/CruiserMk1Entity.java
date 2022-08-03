package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import net.minecraft.client.player.Input;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class CruiserMk1Entity extends BaseTankEntity  {
    public CruiserMk1Entity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.cruisermk1_health.get();
        this.speed = TankModConfig.cruisermk1_speed.get();
        this.shootingCooldown = TankModConfig.cruisermk1_shot_cooldown.get();
        this.armor = 3.0;
        this.healAmount = TankModConfig.cruisermk1_heal_amount.get();
        this.maxFuel = TankModConfig.cruisermk1_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = false;
        this.canUseArmorPiercing = false;
        this.canUseHighExplosive = false;
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