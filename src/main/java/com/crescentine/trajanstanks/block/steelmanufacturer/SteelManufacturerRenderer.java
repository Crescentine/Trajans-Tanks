package com.crescentine.trajanstanks.block.steelmanufacturer;

import com.crescentine.trajanstanks.block.turretfactory.TurretFactoryBlockEntity;
import com.crescentine.trajanstanks.block.turretfactory.TurretFactoryModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class SteelManufacturerRenderer extends GeoBlockRenderer<SteelManufacturerBlockEntity> {
    public SteelManufacturerRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(rendererDispatcherIn, new SteelManufacturerModel());
    }

}