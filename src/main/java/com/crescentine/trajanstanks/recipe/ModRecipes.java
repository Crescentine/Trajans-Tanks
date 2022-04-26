package com.crescentine.trajanstanks.recipe;

import com.crescentine.trajanstanks.TankMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final RecipeType<TankCrafterRecipe> CRAFTER_RECIPE_TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return TankMod.MOD_ID + ":crafter";
        }
    };
    public static final RecipeType<TankCrafterRecipe> PLATING_PRESS_RECIPE_TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return TankMod.MOD_ID + ":plating_press";
        }
    };
    public static final RecipeType<TankCrafterRecipe> ENGINE_FABRICATOR_RECIPE_TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return TankMod.MOD_ID + ":engine_fabricator";
        }
    };
    public static final RecipeType<TankCrafterRecipe> STEEL_MANUFACTURER_RECIPE_TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return TankMod.MOD_ID + ":steel_manufacturer";
        }
    };
    public static final RecipeType<TankCrafterRecipe> TURRET_FACTORY_RECIPE_TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return TankMod.MOD_ID + ":turret_factory";
        }
    };


        public static void init() {
            FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(RecipeSerializer.class, ModRecipes::registerRecipeSerializers);
        }

        public static void registerRecipeSerializers(RegistryEvent.Register<RecipeSerializer<?>> event) {
            Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(CRAFTER_RECIPE_TYPE.toString()), CRAFTER_RECIPE_TYPE);
            event.getRegistry().register(TankCrafterRecipe.Serializer.INSTANCE);
            Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(PLATING_PRESS_RECIPE_TYPE.toString()), PLATING_PRESS_RECIPE_TYPE);
            event.getRegistry().register(PlatingPressRecipe.Serializer.INSTANCE);
            Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(ENGINE_FABRICATOR_RECIPE_TYPE.toString()), ENGINE_FABRICATOR_RECIPE_TYPE);
            event.getRegistry().register(EngineFabricatorRecipe.Serializer.INSTANCE);
            Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(STEEL_MANUFACTURER_RECIPE_TYPE.toString()), STEEL_MANUFACTURER_RECIPE_TYPE);
            event.getRegistry().register(SteelManufacturerRecipe.Serializer.INSTANCE);
            Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(TURRET_FACTORY_RECIPE_TYPE.toString()), TURRET_FACTORY_RECIPE_TYPE);
            event.getRegistry().register(TurretFactoryRecipe.Serializer.INSTANCE);
        }
}