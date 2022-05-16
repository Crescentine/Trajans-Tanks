package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class T34Packet {
    public int key;

    public T34Packet(int key) {
        this.key = key;
    }
    public T34Packet(FriendlyByteBuf buffer) {
        key = buffer.readInt();
    }
    public static T34Packet decode(FriendlyByteBuf buffer) {
        return new T34Packet(buffer.readInt());
    }
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeInt(this.key);
    }
    public static void handle(T34Packet message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
                    Player player = context.getSender();
                    if (player == null || !player.isAlive()) return;
                    if (player.getVehicle() instanceof T34Entity) {
                        T34Entity mediumTank = (T34Entity) player.getVehicle();
                        mediumTank.shoot(player, mediumTank, player.level);
                    }
                }
        );
        context.setPacketHandled(true);
    }
}