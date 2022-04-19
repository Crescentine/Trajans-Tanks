package com.crescentine.trajanstanks.block.platingpress;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.block.InventoryBlockEntity;
import com.crescentine.trajanstanks.block.TankModBlockEntities;
import com.crescentine.trajanstanks.container.PlatingPressContainer;
import com.crescentine.trajanstanks.recipe.PlatingPressRecipe;
import com.crescentine.trajanstanks.recipe.TankCrafterRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PlatingPressBlockEntity extends InventoryBlockEntity  {
    public static final Component TITLE = new TranslatableComponent(
            "container." + TankMod.MOD_ID + ".plating_press");

    public PlatingPressBlockEntity(BlockPos pos, BlockState state) {
        super(TankModBlockEntities.PLATING_PRESS.get(), pos, state, 5);
    }

    public static void tick(Level world, PlatingPressBlockEntity entity) {
        if (hasRecipe(entity)) {
            craftItem(entity);
        }
    }
    private static boolean hasRecipe(PlatingPressBlockEntity entity) {
        Level world = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.inventory.getSlots());
        for (int i = 0; i < entity.inventory.getSlots(); i++) {
            inventory.setItem(i, entity.getItemInSlot(i));
        }

        Optional<PlatingPressRecipe> match = world.getRecipeManager()
                .getRecipeFor(PlatingPressRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent()
                && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());

    }


    private static void craftItem(PlatingPressBlockEntity entity) {
        Level world = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.inventory.getSlots());
        for (int i = 0; i < entity.inventory.getSlots(); i++) {
            inventory.setItem(i, entity.inventory.getStackInSlot(i));
        }

        Optional<PlatingPressRecipe> match = world.getRecipeManager()
                .getRecipeFor(PlatingPressRecipe.Type.INSTANCE, inventory, world);

        if (match.isPresent()) {
            entity.extractItem(0);
            entity.extractItem(1);
            entity.extractItem(2);
            entity.extractItem(3);

            entity.insertItem(4, new ItemStack(match.get().getResultItem().getItem(),
                    1));
        }
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(4).getItem() == output.getItem() || inventory.getItem(4).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(4).getMaxStackSize() > inventory.getItem(4).getCount();
    }

}