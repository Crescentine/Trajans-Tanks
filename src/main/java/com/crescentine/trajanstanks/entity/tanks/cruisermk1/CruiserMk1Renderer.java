package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanstanks.entity.tanks.archer.ArcherEntity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CruiserMk1Renderer extends GeoEntityRenderer<CruiserMk1Entity> {
    public CruiserMk1Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new CruiserMk1Model());
        this.shadowRadius = 0.7F;
    }
}