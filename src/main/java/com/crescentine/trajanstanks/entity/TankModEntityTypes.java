package com.crescentine.trajanstanks.entity;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntity;
import com.crescentine.trajanstanks.entity.shell.ArtilleryShell;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.entity.tank.heavy_tank.HeavyTankEntity;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = TankMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TankModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, TankMod.MOD_ID);

    public static final EntityType<ArtilleryEntity> ARTILLERY_ENTITY_TYPE_RAW = EntityType.Builder.<ArtilleryEntity>of(ArtilleryEntity::new, MobCategory.MISC).sized(1.65F, 1.0F).clientTrackingRange(10).build("artillery_entity_type_raw");
    public static final RegistryObject<EntityType<ArtilleryEntity>> ARTILLERY_ENTITY_TYPE = ENTITY_TYPES.register("artillery_entity_type", () -> ARTILLERY_ENTITY_TYPE_RAW);

    public static final EntityType<TankEntity> TANK_ENTITY_TYPE_RAW = EntityType.Builder.<TankEntity>of(TankEntity::new, MobCategory.MISC).sized(4.0F, 2.0F).clientTrackingRange(10).build("tank_entity_type_raw");
    public static final RegistryObject<EntityType<TankEntity>> TANK_ENTITY_TYPE = ENTITY_TYPES.register("tank_entity_type", () -> TANK_ENTITY_TYPE_RAW);

    public static final EntityType<HeavyTankEntity> HEAVY_TANK_ENTITY_TYPE_RAW = EntityType.Builder.<HeavyTankEntity>of(HeavyTankEntity::new, MobCategory.MISC).sized(4.5F, 2.2F).clientTrackingRange(10).build("heavy_tank_entity_type_raw");
    public static final RegistryObject<EntityType<HeavyTankEntity>> HEAVY_TANK_ENTITY_TYPE = ENTITY_TYPES.register("heavy_tank_entity_type", () -> HEAVY_TANK_ENTITY_TYPE_RAW);



    public static final RegistryObject<EntityType<ShellEntity>> SHELL = ENTITY_TYPES.register("shell",
            () -> EntityType.Builder.<ShellEntity>of(ShellEntity::new, MobCategory.MISC).sized(0.15f, 0.15f)
                    .clientTrackingRange(8).updateInterval(10)
                    .build(new ResourceLocation(TankMod.MOD_ID, "shell").toString()));

    public static final RegistryObject<EntityType<ArtilleryShell>> ARTILLERY_SHELL = ENTITY_TYPES.register("artillery_shell",
            () -> EntityType.Builder.<ArtilleryShell>of(ArtilleryShell::new, MobCategory.MISC).sized(0.15f, 0.15f)
                    .clientTrackingRange(8).updateInterval(10)
                    .build(new ResourceLocation(TankMod.MOD_ID, "artillery_shell").toString()));



    public static void register(IEventBus eventBus) {
                ENTITY_TYPES.register(eventBus);

            }
    @SubscribeEvent
    public static void entityAttributesInit(EntityAttributeCreationEvent event) {
        event.put(TANK_ENTITY_TYPE.get(), TankEntity.createAttributes().build());
        event.put(HEAVY_TANK_ENTITY_TYPE.get(), HeavyTankEntity.createAttributes().build());
        event.put(ARTILLERY_ENTITY_TYPE.get(), ArtilleryEntity.createAttributes().build());
    }

}
