package com.crescentine.trajanstanks.item.machines.plating_press;

import com.crescentine.trajanstanks.block.platingpress.PlatingPressBlockEntity;
import com.crescentine.trajanstanks.block.platingpress.PlatingPressModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class PlatingPressItemRenderer extends GeoItemRenderer<PlatingPressItem> {
    public PlatingPressItemRenderer() {
        super(new PlatingPressItemModel());
    }

}
