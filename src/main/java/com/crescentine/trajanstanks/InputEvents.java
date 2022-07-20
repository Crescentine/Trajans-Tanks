package com.crescentine.trajanstanks;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.packet.*;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TankMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class InputEvents {
    @SubscribeEvent
    public static void onKeyPress(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc == null || mc.screen != null || mc.level == null) return;
        onInput(mc, event.getKey(), event.getAction());
    }

    private static void onInput(Minecraft mc, int key, int action) {
        if (mc.screen == null && TankModClient.SHOOT_KEY.consumeClick()) {
            TankModNetwork.TANK.sendToServer(new TankPacket(key));
            TankModNetwork.ARTILLERY.sendToServer(new ArtilleryPacket(key));
        }
        if (mc.screen == null && TankModClient.FUEL_CHECK.consumeClick()) {
            TankModNetwork.FUEL_REMAINING.sendToServer(new FuelRemainingPacket(key));
        }
    }
}
