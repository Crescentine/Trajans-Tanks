package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.entity.tank.heavy_tank.HeavyTankEntity;
import com.crescentine.trajanstanks.entity.tank.medium_tank.MediumTankEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MediumTankInputMessage {
    public int key;

    public MediumTankInputMessage(int key) {
        this.key = key;
    }
    public MediumTankInputMessage(FriendlyByteBuf buffer) {
        key = buffer.readInt();
    }
    public static MediumTankInputMessage decode(FriendlyByteBuf buffer) {
        return new MediumTankInputMessage(buffer.readInt());
    }
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeInt(this.key);
    }
    public static void handle(MediumTankInputMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
                    Player player = context.getSender();
                    if (player == null || !player.isAlive()) return;
                    if (player.getVehicle() instanceof MediumTankEntity) {
                        MediumTankEntity mediumTank = (MediumTankEntity) player.getVehicle();
                        mediumTank.shoot(player, player.level);
                    }
                }
        );
        context.setPacketHandled(true);
    }
}