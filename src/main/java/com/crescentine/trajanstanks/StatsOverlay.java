package com.crescentine.trajanstanks;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.awt.*;
import java.text.DecimalFormat;

public class StatsOverlay {
    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event)
    {
        Minecraft mc = Minecraft.getInstance();
        if(!mc.isWindowActive() || mc.options.hideGui)
            return;

        Player player = mc.player;
        if(player == null)
            return;

        Entity entity = player.getVehicle();
        if(!(entity instanceof BaseTankEntity))
            return;

        PoseStack matrixStack = new PoseStack();
        BaseTankEntity tank = (BaseTankEntity) entity;
        String health = new DecimalFormat("0.0").format(tank.getHealth());
        mc.font.drawShadow(matrixStack, ChatFormatting.BOLD + "Health: " + ChatFormatting.WHITE + health, 10, 10, Color.CYAN.getRGB());

        if(TankModConfig.fuelSystemEnabled.get()) {
            DecimalFormat format = new DecimalFormat("0.0");
            String fuel = format.format(tank.getFuelAmount()) + "/" + format.format(tank.maxFuel);
            mc.font.drawShadow(matrixStack, ChatFormatting.BOLD + "Fuel Remaining: " + ChatFormatting.WHITE + fuel, 10, 20, Color.CYAN.getRGB());
        }
    }
}
