package com.crescentine.trajanstanks.item.machines.steel_manufacturer;

import com.crescentine.trajanstanks.item.machines.turret_factory.TurretFactoryItem;
import com.crescentine.trajanstanks.item.machines.turret_factory.TurretFactoryItemModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class SteelManufacturerItemRenderer extends GeoItemRenderer<SteelManufacturerItem> {
    public SteelManufacturerItemRenderer() {
        super(new SteelManufacturerItemModel());
    }

}