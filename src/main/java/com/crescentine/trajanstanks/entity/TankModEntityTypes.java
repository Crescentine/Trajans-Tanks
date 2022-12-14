package com.crescentine.trajanstanks.entity;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.artillery.pak40.Pak40Entity;
import com.crescentine.trajanstanks.entity.artillery.qf6.QF6Entity;
import com.crescentine.trajanstanks.entity.tanks.archer.ArcherEntity;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.jagdpanther.JagdpantherEntity;
import com.crescentine.trajanstanks.entity.tanks.kv2.KV2Entity;
import com.crescentine.trajanstanks.entity.tanks.m4sherman.M4ShermanEntity;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankEntity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
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
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TankMod.MOD_ID);

    public static final RegistryObject<EntityType<Pak40Entity>> ARTILLERY_ENTITY_TYPE = ENTITY_TYPES.register("artillery_entity_type",
            () -> EntityType.Builder.of(Pak40Entity:: new, MobCategory.MISC).sized(1.65F, 1.0F)
                    .clientTrackingRange(10).build("artillery_entity_type"));

    public static final RegistryObject<EntityType<Panzer2Entity>> PANZER_TWO_ENTITY_TYPE = ENTITY_TYPES.register("panzer_two_entity_type",
            () -> EntityType.Builder.<Panzer2Entity>of(Panzer2Entity::new, MobCategory.MISC).sized(4.0F, 2.3F)
                    .clientTrackingRange(10).build("panzer_two_entity_type"));

    public static final RegistryObject<EntityType<TigerTankEntity>> TIGER_ENTITY_TYPE = ENTITY_TYPES.register("tiger_tank_entity_type",
            () -> EntityType.Builder.<TigerTankEntity>of(TigerTankEntity::new, MobCategory.MISC).sized(4.5F, 2.2F)
                    .clientTrackingRange(10).build("tiger_tank_entity_type"));

    public static final RegistryObject<EntityType<M4ShermanEntity>> M4SHERMAN_ENTITY_TYPE = ENTITY_TYPES.register("m4sherman_entity_type",
            () -> EntityType.Builder.<M4ShermanEntity>of(M4ShermanEntity::new, MobCategory.MISC).sized(4.5F, 2.4F)
                    .clientTrackingRange(10).build("m4sherman_entity_type"));

    public static final RegistryObject<EntityType<T34Entity>> T34_ENTITY_TYPE = ENTITY_TYPES.register("t34_entity_type",
            () -> EntityType.Builder.<T34Entity>of(T34Entity::new, MobCategory.MISC).sized(3.8F, 2.1f)
                    .clientTrackingRange(10).build("t34_entity_type"));

    public static final RegistryObject<EntityType<CruiserMk1Entity>> CRUISERMK1_ENTITY_TYPE = ENTITY_TYPES.register("cruisermk1_entity_type",
            () -> EntityType.Builder.<CruiserMk1Entity>of(CruiserMk1Entity::new, MobCategory.MISC).sized(3.8F, 2.8f)
                    .clientTrackingRange(10).build("cruisermk1_entity_type"));

    public static final RegistryObject<EntityType<ArcherEntity>> ARCHER_ENTITY_TYPE = ENTITY_TYPES.register("archer_entity_type",
            () -> EntityType.Builder.<ArcherEntity>of(ArcherEntity::new, MobCategory.MISC).sized(5.0F, 2.5f)
                    .clientTrackingRange(10).build("archer_entity_type"));

    public static final RegistryObject<EntityType<KV2Entity>> KV2_ENTITY_TYPE = ENTITY_TYPES.register("kv2_entity_type",
            () -> EntityType.Builder.<KV2Entity>of(KV2Entity::new, MobCategory.MISC).sized(6.0F, 3.2f)
                    .clientTrackingRange(10).build("kv2_entity_type"));

    public static final RegistryObject<EntityType<QF6Entity>> QF6_ENTITY_TYPE = ENTITY_TYPES.register("qf6_entity_type",
            () -> EntityType.Builder.<QF6Entity>of(QF6Entity::new, MobCategory.MISC).sized(1.65f, 1.0f)
                    .clientTrackingRange(10).build("qf6_entity_type"));

    public static final RegistryObject<EntityType<JagdpantherEntity>> JAGDPANTHER_ENTITY_TYPE = ENTITY_TYPES.register("jagdpanther_entity_type",
            () -> EntityType.Builder.<JagdpantherEntity>of(JagdpantherEntity::new, MobCategory.MISC).sized(7.0f, 2.3f)
                    .clientTrackingRange(10).build("qf6_entity_type"));

    public static void register(IEventBus eventBus) {
                ENTITY_TYPES.register(eventBus);
            }
    @SubscribeEvent
    public static void entityAttributesInit(EntityAttributeCreationEvent event) {
        event.put(PANZER_TWO_ENTITY_TYPE.get(), Panzer2Entity.createAttributes().build());
        event.put(TIGER_ENTITY_TYPE.get(), TigerTankEntity.createAttributes().build());
        event.put(ARTILLERY_ENTITY_TYPE.get(), Pak40Entity.createAttributes().build());
        event.put(T34_ENTITY_TYPE.get(), T34Entity.createAttributes().build());
        event.put(CRUISERMK1_ENTITY_TYPE.get(), CruiserMk1Entity.createAttributes().build());
        event.put(M4SHERMAN_ENTITY_TYPE.get(), M4ShermanEntity.createAttributes().build());
        event.put(ARCHER_ENTITY_TYPE.get(), ArcherEntity.createAttributes().build());
        event.put(KV2_ENTITY_TYPE.get(), KV2Entity.createAttributes().build());
        event.put(QF6_ENTITY_TYPE.get(), QF6Entity.createAttributes().build());
        event.put(JAGDPANTHER_ENTITY_TYPE.get(), JagdpantherEntity.createAttributes().build());
    }
}
