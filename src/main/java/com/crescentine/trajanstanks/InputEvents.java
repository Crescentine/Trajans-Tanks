package com.crescentine.trajanstanks;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntity;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankEntity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
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
        if (mc.screen == null && TankModClient.shootKey.consumeClick()) {
            TankModNetwork.PANZER2.sendToServer(new Panzer2Packet(key));
            TankModNetwork.ARTILLERY.sendToServer(new ArtilleryPacket(key));
            TankModNetwork.TIGER.sendToServer(new TigerPacket(key));
            TankModNetwork.T34.sendToServer(new T34Packet(key));
            TankModNetwork.CRUISERMK1.sendToServer(new CruiserMk1Packet(key));
        }
    }
    @SubscribeEvent
    public static void OnTankJoinWorld(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Panzer2Entity) {
            ((Panzer2Entity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.panzer2_health.get());
        }
        if (entity instanceof TigerTankEntity) {
            ((TigerTankEntity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.tiger_health.get());
        }
        if (entity instanceof ArtilleryEntity) {
            ((ArtilleryEntity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.mounted_gun_health.get());
        }
        if (entity instanceof T34Entity) {
            ((T34Entity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.t34_health.get());
        }
        if (entity instanceof CruiserMk1Entity) {
            ((CruiserMk1Entity) entity).getAttribute
                    (Attributes.MAX_HEALTH).setBaseValue(TankModConfig.cruisermk1_health.get());
        }
    }
}
