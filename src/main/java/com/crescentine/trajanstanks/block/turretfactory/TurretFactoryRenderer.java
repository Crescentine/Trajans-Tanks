package com.crescentine.trajanstanks.block.turretfactory;

import com.crescentine.trajanstanks.block.platingpress.PlatingPressBlockEntity;
import com.crescentine.trajanstanks.block.platingpress.PlatingPressModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class TurretFactoryRenderer extends GeoBlockRenderer<TurretFactoryBlockEntity> {
    public TurretFactoryRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(rendererDispatcherIn, new TurretFactoryModel());
    }

}