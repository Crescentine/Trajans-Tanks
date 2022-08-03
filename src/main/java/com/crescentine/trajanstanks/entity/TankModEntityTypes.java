package com.crescentine.trajanstanks.entity;

import com.crescentine.trajanscore.TrajansCoreMod;
import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntity;
import com.crescentine.trajanstanks.entity.shell.ArtilleryShell;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Entity;
import com.crescentine.trajanstanks.entity.tanks.m4sherman.M4ShermanEntity;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankEntity;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Entity;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Entity;
import com.crescentine.trajanstanks.entity.tankshells.apcr.APCRShell;
import com.crescentine.trajanstanks.entity.tankshells.armorpiercing.ArmorPiercingShell;
import com.crescentine.trajanstanks.entity.tankshells.heat.HeatShell;
import com.crescentine.trajanstanks.entity.tankshells.highexplosive.HighExplosiveShell;
import com.crescentine.trajanstanks.entity.tankshells.standard.StandardShell;
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
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TankMod.MOD_ID);

    public static final RegistryObject<EntityType<ArtilleryEntity>> ARTILLERY_ENTITY_TYPE = ENTITY_TYPES.register("artillery_entity_type",
            () -> EntityType.Builder.of(ArtilleryEntity:: new, MobCategory.MISC).sized(1.65F, 1.0F)
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
            () -> EntityType.Builder.<CruiserMk1Entity>of(CruiserMk1Entity::new, MobCategory.MISC).sized(3.8F, 2.3f)
                    .clientTrackingRange(10).build("cruisermk1_entity_type"));

    public static final RegistryObject<EntityType<StandardShell>> STANDARD_SHELL = ENTITY_TYPES.register("standard_shell",
            () -> EntityType.Builder.<StandardShell>of(StandardShell::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(8).updateInterval(10)
                    .build(new ResourceLocation(TankMod.MOD_ID, "heat_shell").toString()));

    public static final RegistryObject<EntityType<HighExplosiveShell>> HIGH_EXPLOSIVE_SHELL = ENTITY_TYPES.register("high_explosive_shell",
            () -> EntityType.Builder.<HighExplosiveShell>of(HighExplosiveShell::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(8).updateInterval(10)
                    .build(new ResourceLocation(TankMod.MOD_ID, "heat_shell").toString()));

    public static final RegistryObject<EntityType<HeatShell>> HEAT_SHELL = ENTITY_TYPES.register("heat_shell",
            () -> EntityType.Builder.<HeatShell>of(HeatShell::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(8).updateInterval(10)
                    .build(new ResourceLocation(TankMod.MOD_ID, "heat_shell").toString()));

    public static final RegistryObject<EntityType<ArmorPiercingShell>> ARMOR_PIERCING_SHELL = ENTITY_TYPES.register("armor_piercing_shell",
            () -> EntityType.Builder.<ArmorPiercingShell>of(ArmorPiercingShell::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(8).updateInterval(10)
                    .build(new ResourceLocation(TankMod.MOD_ID, "armor_piercing_shell").toString()));

    public static final RegistryObject<EntityType<APCRShell>> APCR_SHELL = ENTITY_TYPES.register("apcr_shell",
            () -> EntityType.Builder.<APCRShell>of(APCRShell::new, MobCategory.MISC).sized(0.25f, 0.25f)
                    .clientTrackingRange(8).updateInterval(10)
                    .build(new ResourceLocation(TankMod.MOD_ID, "apcr_shell").toString()));



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
        event.put(CRUISERMK1_ENTITY_TYPE.get(), CruiserMk1Entity.createAttributes().build());
        event.put(M4SHERMAN_ENTITY_TYPE.get(), M4ShermanEntity.createAttributes().build());

    }

}
