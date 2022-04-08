package com.crescentine.trajanstanks;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntity;
import com.crescentine.trajanstanks.entity.tank.heavy_tank.TigerTankEntity;
import com.crescentine.trajanstanks.entity.tank.light_tank.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tank.medium_tank.T34Entity;
import com.crescentine.trajanstanks.packet.*;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
            TankNetwork.MEDIUM_TANK.sendToServer(new MediumTankInputMessage(key));
        }
    }
    @SubscribeEvent
    public static void OnTankJoinWorld(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Panzer2Entity) {
            ((Panzer2Entity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.light_tank_health.get());
            ((Panzer2Entity) entity).getAttribute(
                    Attributes.MOVEMENT_SPEED).setBaseValue(TankModConfig.light_tank_speed.get());
        }
        if (entity instanceof TigerTankEntity) {
            ((TigerTankEntity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.heavy_tank_health.get());
            ((TigerTankEntity) entity).getAttribute(
                    Attributes.MOVEMENT_SPEED).setBaseValue(TankModConfig.heavy_tank_speed.get());
        }
        if (entity instanceof ArtilleryEntity) {
            ((ArtilleryEntity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.mounted_gun_health.get());
        }
        if (entity instanceof T34Entity) {
            ((T34Entity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.medium_tank_health.get());
            ((T34Entity) entity).getAttribute(
                    Attributes.MOVEMENT_SPEED).setBaseValue(TankModConfig.medium_tank_speed.get());
        }
    }
}
