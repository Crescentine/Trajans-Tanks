package com.crescentine.trajanstanks.block;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.block.crafter.CrafterBlockEntity;
import com.crescentine.trajanstanks.block.engine_fabricator.EngineFabricatorBlockEntity;
import com.crescentine.trajanstanks.block.platingpress.PlatingPressBlockEntity;
import com.crescentine.trajanstanks.item.TankModItems;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TankModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITIES, TankMod.MOD_ID);

    public static RegistryObject<BlockEntityType<CrafterBlockEntity>> CRAFTER =
            BLOCK_ENTITIES.register("crafter", () -> BlockEntityType.Builder.of
                    (CrafterBlockEntity::new, TankModItems.CRAFTER_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<PlatingPressBlockEntity>> PLATING_PRESS =
            BLOCK_ENTITIES.register("plating_press", () -> BlockEntityType.Builder.of
                    (PlatingPressBlockEntity::new, TankModItems.PLATE_PRESS_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<EngineFabricatorBlockEntity>> ENGINE_FABRICATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("engine_fabricator", () -> BlockEntityType.Builder.of
                    (EngineFabricatorBlockEntity::new, TankModItems.ENGINE_FABRICATOR.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
