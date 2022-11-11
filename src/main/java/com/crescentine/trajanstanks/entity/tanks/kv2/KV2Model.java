package com.crescentine.trajanstanks.entity.tanks.kv2;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KV2Model extends AnimatedGeoModel<KV2Entity>
{
    public ResourceLocation getModelResource(KV2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/kv2.geo.json");
    }

    public ResourceLocation getTextureResource(KV2Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/kv2.png");
    }

    public ResourceLocation getAnimationResource(KV2Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/kv2.json");
    }
}