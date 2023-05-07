package com.crescentine.trajanstanks.entity.tanks.m4sherman;

import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Model;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Model;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class M4ShermanRenderer extends GeoEntityRenderer<M4ShermanEntity> {
    public M4ShermanRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new M4ShermanModel());
        this.shadowRadius = 0.7F;
    }
    @Override
    public GeoEntityRenderer<M4ShermanEntity> withScale(float scaleWidth, float scaleHeight) {
        return super.withScale(1.2f, 1.25f);
    }
}