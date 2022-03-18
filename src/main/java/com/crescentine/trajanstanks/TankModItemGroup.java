package com.crescentine.trajanstanks;

import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TankModItemGroup extends CreativeModeTab {

    public static final TankModItemGroup TANK_MOD_ITEM_GROUP = new TankModItemGroup(CreativeModeTab.TABS.length,
            "trajanstanks");

    public TankModItemGroup(int index, String label) {
        super(index, label);
    }
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(TankModItems.TANK_ITEM.get());
    }
}