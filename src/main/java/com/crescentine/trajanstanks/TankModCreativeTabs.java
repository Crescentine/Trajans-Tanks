package com.crescentine.trajanstanks;

import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TankModCreativeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS
            = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TankMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TANK_MOD_ITEMGROUP = CREATIVE_TABS.register("trajanstanks", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
        .icon(() -> new ItemStack(TankModItems.PANZER2_ITEM.get()))
            .title(Component.translatable("itemgroup.trajanstanks"))
            .displayItems((parameters, output) -> {
                output.accept(TankModItems.PANZER2_ITEM.get());
                output.accept(TankModItems.TIGER_ITEM.get());
                output.accept(TankModItems.T34_ITEM.get());
                output.accept(TankModItems.CRUISER_MK1_ITEM.get());
                output.accept(TankModItems.M4SHERMAN_ITEM.get());
                output.accept(TankModItems.ARCHER_ITEM.get());
                output.accept(TankModItems.KV2_ITEM.get());
                output.accept(TankModItems.JAGDPANTHER_ITEM.get());
                output.accept(TankModItems.SOMUA_ITEM.get());
                output.accept(TankModItems.LUCHS_ITEM.get());
                //output.accept(TankModItems.QF6_ITEM.get());
                //output.accept(TankModItems.PAK40_ITEM.get());
            }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
