package com.crescentine.trajanstanks.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class PartsItemGroup extends CreativeModeTab {

    public static final PartsItemGroup TANK_MOD_PARTS = new PartsItemGroup(CreativeModeTab.TABS.length,
            "trajanstanks_parts");

    public PartsItemGroup(int index, String label) {
        super(index, label);
    }
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(TankModItems.TANK_CONTROLLER.get());
    }
}