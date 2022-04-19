package com.crescentine.trajanstanks.block.crafter;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.block.InventoryBlockEntity;
import com.crescentine.trajanstanks.block.TankModBlockEntities;
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

public class CrafterBlockEntity extends InventoryBlockEntity implements MenuProvider {
    public static final Component TITLE = new TranslatableComponent(
            "container." + TankMod.MOD_ID + ".crafter");

    public CrafterBlockEntity(BlockPos pos, BlockState state) {
        super(TankModBlockEntities.CRAFTER.get(), pos, state, 9);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Tank Crafter");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory p_39955_, Player p_39956_) {
        return null;
    }

    public static void tick(Level world, CrafterBlockEntity entity) {
        if (hasRecipe(entity)) {
            craftItem(entity);
        }
    }


    private static boolean hasRecipe(CrafterBlockEntity entity) {
        Level world = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.inventory.getSlots());
        for (int i = 0; i < entity.inventory.getSlots(); i++) {
            inventory.setItem(i, entity.getItemInSlot(i));
        }

        Optional<TankCrafterRecipe> match = world.getRecipeManager()
                .getRecipeFor(TankCrafterRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent()
                && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());

    }


    private static void craftItem(CrafterBlockEntity entity) {
        Level world = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.inventory.getSlots());
        for (int i = 0; i < entity.inventory.getSlots(); i++) {
            inventory.setItem(i, entity.inventory.getStackInSlot(i));
        }

        Optional<TankCrafterRecipe> match = world.getRecipeManager()
                .getRecipeFor(TankCrafterRecipe.Type.INSTANCE, inventory, world);

        if (match.isPresent()) {
            entity.extractItem(0);
            entity.extractItem(1);
            entity.extractItem(2);
            entity.extractItem(3);
            entity.extractItem(4);
            entity.extractItem(5);
            entity.extractItem(6);
            entity.insertItem(8, new ItemStack(match.get().getResultItem().getItem(),
                    1));
        }
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(8).getItem() == output.getItem() || inventory.getItem(8).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(8).getMaxStackSize() > inventory.getItem(8).getCount();
    }

}
