package com.crescentine.trajanstanks.item.machines.turret_factory;

import com.crescentine.trajanstanks.item.machines.plating_press.PlatingPressItem;
import com.crescentine.trajanstanks.item.machines.plating_press.PlatingPressItemModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class TurretFactoryItemRenderer extends GeoItemRenderer<TurretFactoryItem> {
    public TurretFactoryItemRenderer() {
        super(new TurretFactoryItemModel());
    }

}