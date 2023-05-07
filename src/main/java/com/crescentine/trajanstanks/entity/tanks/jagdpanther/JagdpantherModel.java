package com.crescentine.trajanstanks.entity.tanks.jagdpanther;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.archer.ArcherEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JagdpantherModel extends GeoModel<JagdpantherEntity> {
    public ResourceLocation getModelResource(JagdpantherEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/jag.geo.json");
    }

    public ResourceLocation getTextureResource(JagdpantherEntity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/jag.png");
    }

    public ResourceLocation getAnimationResource(JagdpantherEntity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/jag.json");
    }
}
