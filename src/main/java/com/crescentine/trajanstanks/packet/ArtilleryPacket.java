package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntity;
import com.crescentine.trajanstanks.entity.tanks.basetank.BaseTankEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ArtilleryPacket {
    public int key;
    public ArtilleryPacket(int key) {
        this.key = key;
    }
    public ArtilleryPacket(FriendlyByteBuf buffer) {
        key = buffer.readInt();
    }
    public static ArtilleryPacket decode(FriendlyByteBuf buffer) {
        return new ArtilleryPacket(buffer.readInt());
    }
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeInt(this.key);
    }
    public static void handle(ArtilleryPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
                    Player player = context.getSender();
                    if (player == null || !player.isAlive()) return;
                    if (player.getVehicle() instanceof ArtilleryEntity) {
                        BaseTankEntity artilleryEntity = (ArtilleryEntity) player.getVehicle();
                        artilleryEntity.shoot(player, artilleryEntity, player.level);
                    }
                }
        );
        context.setPacketHandled(true);
    }
}
