package com.crescentine.trajanstanks.entity.tanks.tiger;


import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TigerTankRenderer extends GeoEntityRenderer<TigerTankEntity> {
    public TigerTankRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new TigerTankModel());
        this.shadowRadius = 0.7F;
    }
    @Override
    public GeoEntityRenderer<TigerTankEntity> withScale(float scaleWidth, float scaleHeight) {
        return super.withScale(1.1f, 1.1f);
    }
}