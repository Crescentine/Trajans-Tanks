package com.crescentine.trajanstanks.item;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.blockentity.CrafterBlock;
import com.crescentine.trajanstanks.entity.shell.ShellItem;
import com.crescentine.trajanstanks.entity.TankModEntityTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TankModItems {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TankMod.MOD_ID);
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TankMod.MOD_ID);

    public static final RegistryObject<Item> SHELL_ITEM = ITEMS.register("shell_item",
            () -> new ShellItem(new Item.Properties().tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> ARTILLERY_SHELL_ITEM = ITEMS.register("artillery_shell_item",
            () -> new ShellItem(new Item.Properties().tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> TANK_CONTROLLER = ITEMS.register("tank_controller",
            () -> new Item(new Item.Properties().tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> TANK_ITEM = ITEMS.register("tank_item", () -> new TankSpawnEgg(TankModEntityTypes.TANK_ENTITY_TYPE, 0x757980, 0x959dab, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> ARTILLERY_ITEM = ITEMS.register("artillery_item", () -> new TankSpawnEgg(TankModEntityTypes.ARTILLERY_ENTITY_TYPE, 0x7a7873, 0x66625d, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> HEAVY_TANK_ITEM = ITEMS.register("heavy_tank_item", () -> new TankSpawnEgg(TankModEntityTypes.HEAVY_TANK_ENTITY_TYPE, 0x9D9A82, 0x8a8879, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> MEDIUM_TANK_ITEM = ITEMS.register("medium_tank_item", () -> new TankSpawnEgg(TankModEntityTypes.MEDIUM_TANK_ENTITY_TYPE, 0x9D9A82, 0x8a8879, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));


    public static final RegistryObject<Item> NETHERITE_WHEEL = ITEMS.register("netherite_wheel",
            () -> new Item(new Item.Properties().tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    public static final RegistryObject<Block> CRAFTER_BLOCK = registerBlock("crafter_block",
        () -> new CrafterBlock(BlockBehaviour.Properties.of(Material.METAL)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        TankModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    }
}
