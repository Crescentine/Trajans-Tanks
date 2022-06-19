package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntity;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FuelRemainingPacket {
    public int key;
    public FuelRemainingPacket(int key) {
        this.key = key;
    }
    public FuelRemainingPacket(FriendlyByteBuf buffer) {
        key = buffer.readInt();
    }
    public static FuelRemainingPacket decode(FriendlyByteBuf buffer) {
        return new FuelRemainingPacket(buffer.readInt());
    }
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeInt(this.key);
    }
    public static void handle(FuelRemainingPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
                    Player player = context.getSender();
                    if (player == null || !player.isAlive()) return;
                    if (player.getVehicle() instanceof BaseTankEntity) {
                        BaseTankEntity tankEntity = (BaseTankEntity) player.getVehicle();
                        tankEntity.fuelLeft(player);
                    }
                }
        );
        context.setPacketHandled(true);
    }
}