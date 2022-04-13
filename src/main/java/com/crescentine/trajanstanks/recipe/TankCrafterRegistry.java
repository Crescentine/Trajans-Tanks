package com.crescentine.trajanstanks.recipe;

import net.minecraft.world.level.Level;

import java.util.List;
import java.util.stream.Collectors;

public class TankCrafterRegistry {
    private static List<TankCrafterRecipe> recipes = null;

    public static List<TankCrafterRecipe> getRecipes(Level world) {
        if (recipes == null) {
            recipes = world.getRecipeManager().getRecipes().stream()
                    .filter(x -> x.getType() == ModRecipes.CRAFTER_RECIPE_TYPE)
                    .map(x -> (TankCrafterRecipe) x)
                    .collect(Collectors.toList());
        }
        return recipes;
    }
}
