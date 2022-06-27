package com.crescentine.trajanstanks.entity.tanks.tiger;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TigerTankRenderer extends GeoEntityRenderer<TigerTankEntity> {
    public TigerTankRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new TigerTankModel());
        this.shadowRadius = 0.7F;
    }
}