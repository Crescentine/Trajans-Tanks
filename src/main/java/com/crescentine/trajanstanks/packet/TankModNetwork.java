package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class TankModNetwork {

    public static final String NETWORK_VERSION = "0.1.0";
    private static int channel_id = 0;

    public static final SimpleChannel TANK = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "tank"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static final SimpleChannel ARTILLERY = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "artillery"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static void init() {
        ARTILLERY.registerMessage(++channel_id, ArtilleryPacket.class, ArtilleryPacket::writePacketData, ArtilleryPacket::decode, ArtilleryPacket::handle);
        TANK.registerMessage(++channel_id, TankPacket.class, TankPacket::writePacketData, TankPacket::decode, TankPacket::handle);
    }
}
