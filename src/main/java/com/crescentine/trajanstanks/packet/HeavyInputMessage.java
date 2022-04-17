package com.crescentine.trajanstanks.packet;

import com.crescentine.trajanstanks.entity.tank.tiger.TigerTankEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class HeavyInputMessage {
    public int key;

    public HeavyInputMessage(int key) {
        this.key = key;
    }
    public HeavyInputMessage(FriendlyByteBuf buffer) {
        key = buffer.readInt();
    }
    public static HeavyInputMessage decode(FriendlyByteBuf buffer) {
        return new HeavyInputMessage(buffer.readInt());
    }
    public void writePacketData(FriendlyByteBuf buf) {
        buf.writeInt(this.key);
    }
    public static void handle(HeavyInputMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
                    Player player = context.getSender();
                    if (player == null || !player.isAlive()) return;
                    if (player.getVehicle() instanceof TigerTankEntity) {
                        TigerTankEntity heavyTank = (TigerTankEntity) player.getVehicle();
                        heavyTank.shoot(player, player.level);
                    }
                }
        );
        context.setPacketHandled(true);
    }
}