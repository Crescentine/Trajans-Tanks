package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ArtilleryInputMessage {
    public int key;

    public ArtilleryInputMessage(int key) {
        this.key = key;
    }
    public ArtilleryInputMessage(FriendlyByteBuf buffer) {
        key = buffer.readInt();
    }
    public static ArtilleryInputMessage decode(FriendlyByteBuf buffer) {
        return new ArtilleryInputMessage(buffer.readInt());
    }
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeInt(this.key);
    }
    public static void handle(ArtilleryInputMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
                    Player player = context.getSender();
                    if (player == null || !player.isAlive()) return;
                    if (player.getVehicle() instanceof ArtilleryEntity) {
                        ArtilleryEntity artilleryEntity = (ArtilleryEntity) player.getVehicle();
                        artilleryEntity.shoot(player, player.level);
                    }
                }
        );
        context.setPacketHandled(true);
    }
}
