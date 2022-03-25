package com.crescentine.trajanstanks.container;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class TankModContainers {
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, TankMod.MOD_ID);

    public static final RegistryObject<MenuType<CrafterContainer>> CRAFTER_CONTAINER = CONTAINERS.register("crafter_container",
            () -> new MenuType<>(CrafterContainer::new));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
