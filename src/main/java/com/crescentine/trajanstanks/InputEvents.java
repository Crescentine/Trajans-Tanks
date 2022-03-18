package com.crescentine.trajanstanks;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntity;
import com.crescentine.trajanstanks.entity.tank.heavy_tank.HeavyTankEntity;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntity;
import com.crescentine.trajanstanks.packet.ArtilleryInputMessage;
import com.crescentine.trajanstanks.packet.HeavyInputMessage;
import com.crescentine.trajanstanks.packet.TankInputMessage;
import com.crescentine.trajanstanks.packet.TankNetwork;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Pig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = TankMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class InputEvents {
    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc == null || mc.screen != null || mc.level == null) return;
        onInput(mc, event.getKey(), event.getAction());
    }

    private static void onInput(Minecraft mc, int key, int action) {
        if (mc.screen == null && TankModClient.shootkey.consumeClick()) {
            TankNetwork.TANK.sendToServer(new TankInputMessage(key));
            TankNetwork.ARTILLERY.sendToServer(new ArtilleryInputMessage(key));
            TankNetwork.HEAVY_TANK.sendToServer(new HeavyInputMessage(key));
        }
    }
    @SubscribeEvent
    public static void OnTankJoinWorld(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof TankEntity) {
            ((TankEntity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.light_tank_health.get());
            ((TankEntity) entity).getAttribute(
                    Attributes.MOVEMENT_SPEED).setBaseValue(TankModConfig.light_tank_speed.get());
        }
        if (entity instanceof HeavyTankEntity) {
            ((HeavyTankEntity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.heavy_tank_health.get());
            ((HeavyTankEntity) entity).getAttribute(
                    Attributes.MOVEMENT_SPEED).setBaseValue(TankModConfig.heavy_tank_speed.get());
        }
        if (entity instanceof ArtilleryEntity) {
            ((ArtilleryEntity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.mounted_gun_health.get());
        }
    }
}
