package com.crescentine.trajanstanks.integration.jei_compat;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.item.TankModItems;
import com.crescentine.trajanstanks.recipe.TankCrafterRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;


@JeiPlugin
public class TankModJei implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TankMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(VanillaTypes.ITEM, new ItemStack(TankModItems.CRAFTER_BLOCK.get()), TankCrafterRecipeCategory.UID);

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                TankCrafterRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<TankCrafterRecipe> recipes = rm.getAllRecipesFor(TankCrafterRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(TankCrafterRecipeCategory.UID, TankCrafterRecipe.class), recipes);
    }
}