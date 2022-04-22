package com.crescentine.trajanstanks.container;

import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class PlatingPressContainer extends AbstractContainerMenu {
    private final BlockEntity blockEntity;
    private final Level level;
    private final ContainerLevelAccess containerAccess;


    public PlatingPressContainer(int id, Level level, BlockPos pos,
                                 Inventory playerInv, Player player) {
        super(TankModContainers.PLATING_PRESS_CONTAINER.get(), id);
        this.blockEntity = level.getBlockEntity(pos);
        this.level = playerInv.player.level;
        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, pos);

        if (blockEntity != null) {
            blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                //Row 1
                addSlot(new SlotItemHandler(h, 0, 43, 30));
                addSlot(new SlotItemHandler(h, 1, 62, 30));
                //Row 2
                addSlot(new SlotItemHandler(h, 2, 44, 48));
                addSlot(new SlotItemHandler(h, 3, 62, 48));
                //Output Slot
                addSlot(new SlotItemHandler(h, 4, 118, 37));
            });
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
            }
        }
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
        }
    }
    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, TankModItems.PLATE_PRESS_BLOCK.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = getSlot(index);
        if (slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if (index < 27) {
                if (!moveItemStackTo(item, 27, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(item, 0, 27, false))
                return ItemStack.EMPTY;

            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return retStack;
    }
}