package com.crescentine.trajanstanks.container;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.blockentity.CrafterBlockEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class CrafterContainer extends AbstractContainerMenu {
    private final BlockEntity blockEntity;
    private final ContainerLevelAccess containerAccess;

    public CrafterContainer(int id, Level level, BlockPos pos,
                            Inventory playerInv, Player player) {
        super(TankModContainers.CRAFTER_CONTAINER.get(), id);
        this.blockEntity = level.getBlockEntity(pos);
        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, pos);

        if(blockEntity != null) {
            blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                //Top Row
                addSlot(new SlotItemHandler(h, 0, 44, 17));
                //Row 2
                addSlot(new SlotItemHandler(h, 1, 26, 35));
                addSlot(new SlotItemHandler(h, 2, 44, 35));
                addSlot(new SlotItemHandler(h, 3, 62, 35));
                //Row 3
                addSlot(new SlotItemHandler(h, 4, 26, 53));
                addSlot(new SlotItemHandler(h, 5, 44, 53));
                addSlot(new SlotItemHandler(h, 6, 62, 53));
                //Blueprint Slot
                addSlot(new SlotItemHandler(h, 7, 98, 53));
                //Output Slot
                addSlot(new SlotItemHandler(h, 8, 134, 35));
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
    public boolean stillValid(Player player) {
        return stillValid(this.containerAccess, player, TankModItems.CRAFTER_BLOCK.get());
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