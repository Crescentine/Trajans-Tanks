package com.crescentine.trajanstanks.container;

import com.crescentine.trajanstanks.blockentity.CrafterBlockEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class CrafterContainer extends AbstractContainerMenu {
    private static CrafterBlockEntity blockEntity;
    private final ContainerLevelAccess containerAccess;

    public  CrafterContainer(int id, Inventory playerInv) {
        this(id, playerInv, new ItemStackHandler(9), BlockPos.ZERO);
    }
    public CrafterContainer(int id, Inventory playerInv, IItemHandler slot, BlockPos pos) {
        super(TankModContainers.CRAFTER_CONTAINER.get(), id);
        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, pos);
        //Top Row
        addSlot(new SlotItemHandler(slot, 0, 44, 17));
        //Row 2
        addSlot(new SlotItemHandler(slot, 1, 26, 35));
        addSlot(new SlotItemHandler(slot, 2, 44, 35));
        addSlot(new SlotItemHandler(slot, 3, 62, 35));
        //Row 3
        addSlot(new SlotItemHandler(slot, 4, 26, 53));
        addSlot(new SlotItemHandler(slot, 5, 44, 53));
        addSlot(new SlotItemHandler(slot, 6, 62, 53));
        //Blueprint Slot
        addSlot(new SlotItemHandler(slot, 7, 98, 53));
        //Output Slot
        addSlot(new SlotItemHandler(slot, 8, 134, 35));


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
    public boolean stillValid(Player player) {
        return stillValid(this.containerAccess, player, TankModItems.CRAFTER_BLOCK.get());
    }


    public static MenuConstructor getServerContainer(CrafterBlockEntity crafter, BlockPos pos) {
        return (id, playerInv, player) -> new CrafterContainer(id, playerInv, crafter.inventory, pos);
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
