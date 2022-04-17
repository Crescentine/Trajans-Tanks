package com.crescentine.trajanstanks.entity;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntity;
import com.crescentine.trajanstanks.entity.shell.ArtilleryShell;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.entity.tank.tiger.TigerTankEntity;
import com.crescentine.trajanstanks.entity.tank.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tank.t34.T34Entity;
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

    public static final RegistryObject<EntityType<ArtilleryEntity>> ARTILLERY_ENTITY_TYPE = ENTITY_TYPES.register("artillery_entity_type",
            () -> EntityType.Builder.of(ArtilleryEntity:: new, MobCategory.MISC).sized(1.65F, 1.0F)
                    .clientTrackingRange(10).build("artillery_entity_type"));

    public static final RegistryObject<EntityType<Panzer2Entity>> PANZER_TWO_ENTITY_TYPE = ENTITY_TYPES.register("panzer_two_entity_type",
            () -> EntityType.Builder.<Panzer2Entity>of(Panzer2Entity::new, MobCategory.MISC).sized(4.0F, 2.0F)
                    .clientTrackingRange(10).build("panzer_two_entity_type"));

    public static final RegistryObject<EntityType<TigerTankEntity>> TIGER_ENTITY_TYPE = ENTITY_TYPES.register("tiger_tank_entity_type",
            () -> EntityType.Builder.<TigerTankEntity>of(TigerTankEntity::new, MobCategory.MISC).sized(4.5F, 2.2F)
                    .clientTrackingRange(10).build("tiger_tank_entity_type"));

    public static final RegistryObject<EntityType<T34Entity>> T34_ENTITY_TYPE = ENTITY_TYPES.register("t34_entity_type",
            () -> EntityType.Builder.<T34Entity>of(T34Entity::new, MobCategory.MISC).sized(3.8F, 2.1f)
                    .clientTrackingRange(10).build("t34_entity_type"));




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
        event.put(PANZER_TWO_ENTITY_TYPE.get(), Panzer2Entity.createAttributes().build());
        event.put(TIGER_ENTITY_TYPE.get(), TigerTankEntity.createAttributes().build());
        event.put(ARTILLERY_ENTITY_TYPE.get(), ArtilleryEntity.createAttributes().build());
        event.put(T34_ENTITY_TYPE.get(), T34Entity.createAttributes().build());

    }

}
