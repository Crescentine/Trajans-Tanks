package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class TankModNetwork {

    public static final String NETWORK_VERSION = "0.1.0";
    private static int channel_id = 0;

    public static final SimpleChannel TIGER = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "tiger"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static final SimpleChannel T34 = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "t34"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static final SimpleChannel PANZER2 = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "panzer2"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static final SimpleChannel CRUISERMK1 = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "cruisermk1"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static final SimpleChannel ARTILLERY = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TankMod.MOD_ID, "artillery"), () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));

    public static void init() {
        CRUISERMK1.registerMessage(++channel_id, CruiserMk1Packet.class, CruiserMk1Packet::writePacketData, CruiserMk1Packet::decode, CruiserMk1Packet::handle);
        T34.registerMessage(++channel_id, T34Packet.class, T34Packet::writePacketData, T34Packet::decode, T34Packet::handle);
        TIGER.registerMessage(++channel_id, TigerPacket.class, TigerPacket::writePacketData, TigerPacket::decode, TigerPacket::handle);
        ARTILLERY.registerMessage(++channel_id, ArtilleryPacket.class, ArtilleryPacket::writePacketData, ArtilleryPacket::decode, ArtilleryPacket::handle);
        PANZER2.registerMessage(++channel_id, Panzer2Packet.class, Panzer2Packet::writePacketData, Panzer2Packet::decode, Panzer2Packet::handle);
    }
}
