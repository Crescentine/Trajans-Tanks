package com.crescentine.trajanstanks.integration.jei;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.container.CrafterContainer;
import com.crescentine.trajanstanks.item.TankModItems;
import com.crescentine.trajanstanks.recipe.ModRecipes;
import com.crescentine.trajanstanks.recipe.TankCrafterRecipe;
import com.crescentine.trajanstanks.screen.CrafterScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.handlers.IGuiClickableArea;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.*;
import java.util.stream.Collectors;

@JeiPlugin
public class TankModJei implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TankMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new TankCrafterRecipeCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipes.CRAFTER_RECIPE_TYPE), TankCrafterRecipeCategory.UID);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(CrafterContainer.class, TankCrafterRecipeCategory.UID, 0, 8, 9, 36);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(TankModItems.CRAFTER_BLOCK.get()), TankCrafterRecipeCategory.RECIPE_TYPE);
    }

}
