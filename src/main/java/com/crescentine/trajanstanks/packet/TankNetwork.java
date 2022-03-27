package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class TankNetwork {

    public static final String NETWORK_VERSION = "0.1.0";
    private static int channel_id = 0;

    public static final SimpleChannel HEAVY_TANK = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "heavy_tank"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static final SimpleChannel MEDIUM_TANK = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "medium_tank"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static final SimpleChannel TANK = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "tank"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static final SimpleChannel ARTILLERY = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "artillery"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static void init() {
        MEDIUM_TANK.registerMessage(++channel_id, MediumTankInputMessage.class, MediumTankInputMessage::writePacketData, MediumTankInputMessage::decode, MediumTankInputMessage::handle);
        HEAVY_TANK.registerMessage(++channel_id, HeavyInputMessage.class, HeavyInputMessage::writePacketData, HeavyInputMessage::decode, HeavyInputMessage::handle);
        ARTILLERY.registerMessage(++channel_id, ArtilleryInputMessage.class, ArtilleryInputMessage::writePacketData, ArtilleryInputMessage::decode, ArtilleryInputMessage::handle);
        TANK.registerMessage(++channel_id, TankInputMessage.class, TankInputMessage::writePacketData, TankInputMessage::decode, TankInputMessage::handle);
    }
}
