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
            return TankMod.MOD_ID + ":crafter";
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
    }
}