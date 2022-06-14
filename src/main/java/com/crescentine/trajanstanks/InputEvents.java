package com.crescentine.trajanstanks;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanstanks.packet.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
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
            TankModNetwork.TANK.sendToServer(new TankPacket(key));
            TankModNetwork.ARTILLERY.sendToServer(new ArtilleryPacket(key));
        }
    }
}
