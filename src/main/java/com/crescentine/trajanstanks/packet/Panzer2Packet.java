package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class Panzer2Packet {
    public int key;

    public Panzer2Packet(int key) {
        this.key = key;
    }
    public Panzer2Packet(FriendlyByteBuf buffer) {
        key = buffer.readInt();
    }
    public static Panzer2Packet decode(FriendlyByteBuf buffer) {
        return new Panzer2Packet(buffer.readInt());
    }
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeInt(this.key);
    }
    public static void handle(Panzer2Packet message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
                    Player player = context.getSender();
                    if (player == null || !player.isAlive()) return;
                    if (player.getVehicle() instanceof Panzer2Entity) {
                        Panzer2Entity Tank = (Panzer2Entity) player.getVehicle();
                        Tank.shoot(player, Tank, player.level);
                    }
                }
        );
        context.setPacketHandled(true);
    }
}