package com.crescentine.trajanstanks.item;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.TankModEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TankModItems {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TankMod.MOD_ID);
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TankMod.MOD_ID);

    //Vehicle Items
    public static final RegistryObject<Item> PANZER2_ITEM = ITEMS.register("panzer2_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.PANZER_TWO_ENTITY_TYPE::get, true, false, false, false, false, false));
    public static final RegistryObject<Item> TIGER_ITEM = ITEMS.register("tiger_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.TIGER_ENTITY_TYPE::get, true, false, true, true, false, true));
    public static final RegistryObject<Item> T34_ITEM = ITEMS.register("t34_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.T34_ENTITY_TYPE::get, true, false, false, true, false, true));
    public static final RegistryObject<Item> CRUISER_MK1_ITEM = ITEMS.register("cruiser_mk1_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.CRUISERMK1_ENTITY_TYPE::get, true, false, false, false, false, false));
    public static final RegistryObject<Item> M4SHERMAN_ITEM = ITEMS.register("m4sherman_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.M4SHERMAN_ENTITY_TYPE::get, true, false, true, true, false, true));
    public static final RegistryObject<Item> ARCHER_ITEM = ITEMS.register("archer_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.ARCHER_ENTITY_TYPE::get, true, false, true, true, false, true));
    public static final RegistryObject<Item> KV2_ITEM = ITEMS.register("kv2_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.KV2_ENTITY_TYPE::get, true, false, true, true, false, true));
    public static final RegistryObject<Item> JAGDPANTHER_ITEM = ITEMS.register("jagdpanther_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.JAGDPANTHER_ENTITY_TYPE::get, false, true, false, false, false, false));
    public static final RegistryObject<Item> LUCHS_ITEM = ITEMS.register("luchs_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.LUCHS_ENTITY_TYPE::get, true, false, false, false, false, false));
    public static final RegistryObject<Item> SOMUA_ITEM = ITEMS.register("somua_item", () -> new TankSpawnEgg(new Item.Properties(), TankModEntityTypes.SOMUA_ENTITY_TYPE::get, true, false, true, true, false, true));


    public static final RegistryObject<Item> PAK40_ITEM = ITEMS.register("pak40_item", () -> new ATSpawnEgg(new Item.Properties(), TankModEntityTypes.ARTILLERY_ENTITY_TYPE::get, false, true, true, false, false, false));
    public static final RegistryObject<Item> QF6_ITEM = ITEMS.register("qf6_item", () -> new ATSpawnEgg(new Item.Properties(), TankModEntityTypes.QF6_ENTITY_TYPE::get, false, true, true, false, false, false));


    public static final RegistryObject<Item> T34_BLUEPRINT = ITEMS.register("t34_blueprint", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARCHER_BLUEPRINT = ITEMS.register("archer_blueprint", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIGER_BLUEPRINT = ITEMS.register("tiger_blueprint", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PANZER_TWO_BLUEPRINT = ITEMS.register("panzer_two_blueprint", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRUISERMK1_BLUEPRINT = ITEMS.register("cruisermk1_blueprint", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> M4SHERMAN_BLUEPRINT = ITEMS.register("m4sherman_blueprint", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KV2_BLUEPRINT = ITEMS.register("kv2_blueprint", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JAG_BLUEPRINT = ITEMS.register("jag_blueprint", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOMUA_BLUEPRINT = ITEMS.register("somua_blueprint", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUCHS_BLUEPRINT = ITEMS.register("luchs_blueprint", () -> new Item(new Item.Properties()));

}
