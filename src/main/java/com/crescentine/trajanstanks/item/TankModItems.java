package com.crescentine.trajanstanks.item;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.block.crafter.CrafterBlock;
import com.crescentine.trajanstanks.block.engine_fabricator.EngineFabricatorBlock;
import com.crescentine.trajanstanks.block.platingpress.PlatingPressBlock;
import com.crescentine.trajanstanks.item.machines.plating_press.PlatingPressItem;
import com.crescentine.trajanstanks.block.steelmanufacturer.SteelManufacturerBlock;
import com.crescentine.trajanstanks.block.turretfactory.TurretFactoryBlock;
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

    //Vehicle Items
    public static final RegistryObject<Item> TANK_ITEM = ITEMS.register("tank_item", () -> new TankSpawnEgg(TankModEntityTypes.PANZER_TWO_ENTITY_TYPE, 0x757980, 0x959dab, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> HEAVY_TANK_ITEM = ITEMS.register("heavy_tank_item", () -> new TankSpawnEgg(TankModEntityTypes.TIGER_ENTITY_TYPE, 0x989898, 0x949494, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> MEDIUM_TANK_ITEM = ITEMS.register("medium_tank_item", () -> new TankSpawnEgg(TankModEntityTypes.T34_ENTITY_TYPE, 0x444444, 0x4e4e4e, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ARTILLERY_ITEM = ITEMS.register("artillery_item", () -> new TankSpawnEgg(TankModEntityTypes.ARTILLERY_ENTITY_TYPE, 0x7a7873, 0x66625d, (new Item.Properties()).tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    //Shells
    public static final RegistryObject<Item> SHELL_ITEM = ITEMS.register("shell_item",
            () -> new ShellItem(new Item.Properties().tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ARTILLERY_SHELL_ITEM = ITEMS.register("artillery_shell_item",
            () -> new ShellItem(new Item.Properties().tab(TankModItemGroup.TANK_MOD_ITEM_GROUP)));

    //Blocks
    public static final RegistryObject<Block> CRAFTER_BLOCK = registerBlock("crafter_block",
        () -> new CrafterBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1.0f)));
    public static final RegistryObject<Block> PLATE_PRESS_BLOCK = registerBlock("plate_press_block", PlatingPressBlock::new);

    public static final RegistryObject<Item> PLATE_PRESS_BLOCK_ITEM = ITEMS.register("plate_press_block_item",
            () -> new PlatingPressItem(TankModItems.PLATE_PRESS_BLOCK.get(), new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));

    public static final RegistryObject<Block> ENGINE_FABRICATOR = registerBlock("engine_fabricator",
            () -> new EngineFabricatorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1.0f)));
    public static final RegistryObject<Block> STEEL_MANUFACTURER = registerBlock("steel_manufacturer",
            () -> new SteelManufacturerBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1.0f)));
    public static final RegistryObject<Block> TURRET_FACTORY = registerBlock("turret_factory",
            () -> new TurretFactoryBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1.0f)));


    //Parts for Panzer 2
    public static final RegistryObject<Item> LIGHT_TANK_TURRET = ITEMS.register("light_tank_turret", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> PANZER_TWO_ENGINGE = ITEMS.register("panzer_two_engine", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> LIGHT_TANK_PLATING = ITEMS.register("light_tank_plating", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> LIGHT_TANK_TRACKS = ITEMS.register("light_tank_tracks", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> PANZER_TWO_BLUEPRINT = ITEMS.register("panzer_two_blueprint", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));

    public static final RegistryObject<Item> TANK_CONTROLLER = ITEMS.register("steering_crafting_item", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));

    //Parts for Tiger
    public static final RegistryObject<Item> HEAVY_TANK_TURRET = ITEMS.register("heavy_tank_turret", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> TIGER_ENGINE = ITEMS.register("tiger_engine", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> HEAVY_TANK_PLATING = ITEMS.register("heavy_tank_plating", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> HEAVY_TANK_TRACKS = ITEMS.register("heavy_tank_tracks", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> TIGER_BLUEPRINT = ITEMS.register("tiger_blueprint", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));


    //Parts for T34
    public static final RegistryObject<Item> MEDIUM_TANK_TURRET = ITEMS.register("medium_tank_turret", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> T34_ENGINE = ITEMS.register("t34_engine", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> MEDIUM_TANK_PLATING = ITEMS.register("medium_tank_plating", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> MEDIUM_TANK_TRACMS = ITEMS.register("medium_tank_tracks", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    public static final RegistryObject<Item> T34_BLUEPRINT = ITEMS.register("t34_blueprint", () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));

    //Machine Parts
    public static final RegistryObject<Item> BLOWTORCH_TOOL = ITEMS.register("blowtorch_tool",
            () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS).durability(35)));
    public static final RegistryObject<Item> BOLSTER_PLATE = ITEMS.register("bolster_plate",
            () -> new Item(new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS).durability(20)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        TankModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(PartsItemGroup.TANK_MOD_PARTS)));
    }
}
