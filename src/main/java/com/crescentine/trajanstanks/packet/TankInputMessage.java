package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.entity.tank.panzer2.Panzer2Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TankInputMessage {
    public int key;

    public TankInputMessage(int key) {
        this.key = key;
    }
    public TankInputMessage(FriendlyByteBuf buffer) {
        key = buffer.readInt();
    }
    public static TankInputMessage decode(FriendlyByteBuf buffer) {
        return new TankInputMessage(buffer.readInt());
    }
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeInt(this.key);
    }
    public static void handle(TankInputMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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