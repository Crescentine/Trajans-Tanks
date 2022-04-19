package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CruiserMk1Packet {
    public int key;

    public CruiserMk1Packet(int key) {
        this.key = key;
    }
    public CruiserMk1Packet(FriendlyByteBuf buffer) {
        key = buffer.readInt();
    }
    public static CruiserMk1Packet decode(FriendlyByteBuf buffer) {
        return new CruiserMk1Packet(buffer.readInt());
    }
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeInt(this.key);
    }
    public static void handle(CruiserMk1Packet message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
                    Player player = context.getSender();
                    if (player == null || !player.isAlive()) return;
                    if (player.getVehicle() instanceof CruiserMk1Entity) {
                        CruiserMk1Entity Tank = (CruiserMk1Entity) player.getVehicle();
                        Tank.shoot(player, Tank, player.level);
                    }
                }
        );
        context.setPacketHandled(true);
    }
}